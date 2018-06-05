package com.tota.outside.rpc.socket;

import com.tota.outside.util.LogUtil;
import org.apache.commons.logging.LogFactory;

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

    private static final org.apache.commons.logging.Log log = LogFactory.getLog(SocketConnection.class);

    private String host;
    private int port;
    private int timeout = 2000;
    private boolean idle = false;
    private boolean keepAlive = true;
    private int bufferSize = 8192;

    private SocketChannel channel;
    private Selector selector;


    public SocketConnection(String host, int port, int timeout, boolean keepAlive, int bufferSize) throws IOException {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
        this.keepAlive = keepAlive;
        this.bufferSize = bufferSize;

        selector = Selector.open();
        channel = SocketChannel.open();
        channel.configureBlocking(false);
    }

    public String processRequest(String datagram) throws IOException {
        if (!channel.isConnected()) {
            channel.connect(new InetSocketAddress(host, port));
        }

        channel.register(selector, SelectionKey.OP_CONNECT);

        StringBuffer readMsg = new StringBuffer();
        while (selector.select(timeout) > 0) {
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isConnectable()) {
                    openConnect(key);
                }else if (key.isWritable()) {
                    doWrite(key, datagram);
                }else if (key.isReadable()) {
                    readMsg.append(doRead(key));
                }
                iterator.remove();
            }
        }
        return readMsg.toString();
    }


    public void openConnect(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        if (clientChannel.isConnectionPending()) {
            clientChannel.finishConnect();
        }
        clientChannel.register(selector, SelectionKey.OP_WRITE);
    }

    public void doWrite(SelectionKey key, String datagram) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        if (clientChannel.isConnectionPending()) {
            clientChannel.finishConnect();
        }
        clientChannel.write(ByteBuffer.wrap(datagram.getBytes("UTF-8")));
        clientChannel.register(selector, SelectionKey.OP_READ);
    }

    public String doRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
        int count = clientChannel.read(byteBuffer);
        if (count <= 0) {
            log.info("[SocketConnection]  Received invalide data, close the connection");
            return null;
        }
        byte[] data = byteBuffer.array();
        String msg = new String(data).trim();
        return msg;
    }

    public void closeConnect() {
        try {
            channel.close();
            selector.close();
            log.info("[SocketConnection] =================Close Socket Connection==================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }
}
