package com.tota.outside.rpc.socket;

import com.tota.outside.util.LogUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

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
        clientChannel.write(ByteBuffer.wrap(new String(datagram).getBytes("UTF-8")));
        clientChannel.register(selector, SelectionKey.OP_READ);
    }

    public String doRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        int count = clientChannel.read(byteBuffer);
        if (count <= 0) {
            clientChannel.close();
            key.cancel();
            LogUtil.log(this.getClass()).info("Received invalide data, close the connection");
            return null;
        }
        byte[] data = byteBuffer.array();
        String msg = new String(data).trim();
//        clientChannel.close();
//        selector.close();
        return msg;
    }
}
