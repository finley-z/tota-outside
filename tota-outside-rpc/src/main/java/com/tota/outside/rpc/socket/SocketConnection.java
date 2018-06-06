package com.tota.outside.rpc.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SocketConnection {
    private String host;
    private int port;
    private int timeout = 2000;
    private boolean idle = true;
    private boolean keepAlive = true;

    private SocketChannel channel;
    private Selector selector;

    public SocketConnection() {

    }

    public SocketConnection(String host, int port, int timeout, boolean keepAlive) {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
        this.keepAlive = keepAlive;
    }

    public String processRequest(String datagram) throws IOException {
        selector = Selector.open();
        channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress(host, port));
        channel.register(selector, SelectionKey.OP_CONNECT);
        StringBuffer readMsg = new StringBuffer();
        while (selector.select(10000) > 0) {
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isConnectable()) {
                    doConnect(key, datagram);
                } else if (key.isReadable()) {
                    readMsg.append(doRead(key));
                }
                keys.remove(key);
            }
        }
        return readMsg.toString();
    }


    public void doConnect(SelectionKey key, String datagram) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        if (clientChannel.isConnectionPending()) {
            clientChannel.finishConnect();
        }
        clientChannel.configureBlocking(false);
        System.out.println("*********客户端执行写操作*********");
        clientChannel.write(ByteBuffer.wrap(new String(datagram).getBytes("UTF-8")));
        clientChannel.register(selector, SelectionKey.OP_READ);
    }

    public String doRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int count = clientChannel.read(byteBuffer);
        System.out.println("*********客户端执行读操作*********");
        String info = "";
        if (count > 0) {
            byte[] data = byteBuffer.array();
            info =new String(data);
        }
        if (count == -1) {
            clientChannel.close();
        }
        System.out.println("客户端此时读到的数据："+info);
        return info;
    }
}
