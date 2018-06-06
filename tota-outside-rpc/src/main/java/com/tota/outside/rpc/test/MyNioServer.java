package com.tota.outside.rpc.test;

import com.tota.outside.rpc.socket.SocketConnection;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class MyNioServer {
    private Selector selector;          //创建一个选择器
    private final static int port = 8686;

    private final static int BUF_SIZE = 1024;
    private static final int TIMEOUT = 3000;

    private static final org.apache.commons.logging.Log log = LogFactory.getLog(MyNioServer.class);

    private void initServer() throws IOException {
        //创建通道管理器对象selector
        this.selector = Selector.open();
        //创建一个通道对象channel
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);       //将通道设置为非阻塞
        channel.socket().bind(new InetSocketAddress(port));       //将通道绑定在8686端口
        //将上述的通道管理器和通道绑定，并为该通道注册OP_ACCEPT事件
        //注册事件后，当该事件到达时，selector.select()会返回（一个key），如果该事件没到达selector.select()会一直阻塞
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {       //轮询
            if (selector.select(TIMEOUT) == 0) { //这是一个阻塞方法，一直等待直到有数据可读，返回值是key的数量（可以有多个）
                System.out.println("==");
                continue;
            }
            Set<SelectionKey> keys = selector.selectedKeys();         //如果channel有数据了，将生成的key访入keys集合中
            Iterator<SelectionKey> iterator = keys.iterator();        //得到这个keys集合的迭代器
            while (iterator.hasNext()) {             //使用迭代器遍历集合
                SelectionKey key = iterator.next();       //得到集合中的一个key实例
                iterator.remove();          //拿到当前key实例之后记得在迭代器中将这个元素删除，非常重要，否则会出错
                if (key.isAcceptable()) {
                    handleAccept(key);
                }
                if (key.isReadable()) {
                    handleRead(key);
                }
                if (key.isWritable() && key.isValid()) {
                    handleWrite(key);
                }
                if (key.isConnectable()) {
                    System.out.println("isConnectable = true");
                }
            }
        }
    }

    public void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        System.out.println("ServerSocketChannel正在循环监听");
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(BUF_SIZE));
    }

    public void handleRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buf = (ByteBuffer) key.attachment();
        long bytesRead = clientChannel.read(buf);
        System.out.println("*********服务端执行读操作*********");
        String info="";
        if (bytesRead > 0) {
            System.out.println("*********服务端执行读操作*********");
            byte[] data = buf.array();
            info =new String(data);
            log.info("从客户端发送过来的消息是：" + info);
        }
        if (bytesRead == -1) {
            clientChannel.close();
        }
        System.out.println("服务端读到数据："+info);
        key.interestOps(key.interestOps()|SelectionKey.OP_WRITE);
    }

    public void handleWrite(SelectionKey key) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(BUF_SIZE);
        SocketChannel sc = (SocketChannel) key.channel();
        String info = "030500000000000000015000102051201408190035000000000000540000170100000000000000000000000000000000000000000000000011000000085811000000085800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        buf.put(info.getBytes("UTF-8"));
        buf.flip();
        System.out.println("*********服务端执行写操作*********");
        sc.write(buf);
        key.interestOps(key.interestOps()&~SelectionKey.OP_WRITE);
    }

    public static void main(String[] args) throws IOException {
        MyNioServer myNioServer = new MyNioServer();
        myNioServer.initServer();
    }
}