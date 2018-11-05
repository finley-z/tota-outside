package com.tota.outside.rpc.socket;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SocketConnection {

    private static final org.apache.commons.logging.Log log = LogFactory.getLog(SocketConnection.class);

    private String host;
    private int port;
    private int timeout = 4000;
    private boolean idle = false;
    private boolean keepAlive = true;
    private int bufferSize = 32;
    private boolean isBreak = false;

    private SocketChannel channel;
    private Selector selector;
    private ByteBuffer buffer;


    public SocketConnection(String host, int port, int timeout, boolean keepAlive, int bufferSize) throws IOException {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
        this.keepAlive = keepAlive;
        this.bufferSize = bufferSize;

        selector = Selector.open();
        channel = SocketChannel.open();
        channel.configureBlocking(false);
        buffer = ByteBuffer.allocate(bufferSize);
    }

    public String processRequest(String datagram) throws IOException {
        StringBuffer readMsg = new StringBuffer("");

        if (StringUtils.isEmpty(datagram)) {
            return readMsg.toString();
        }

        if (!channel.isConnected()) {
            channel.connect(new InetSocketAddress(host, port));
            channel.register(selector, SelectionKey.OP_CONNECT);
        } else {
            channel.write(ByteBuffer.wrap(datagram.getBytes("UTF-8")));
            channel.register(selector, SelectionKey.OP_READ);
        }

        while (selector.select(timeout) > 0) {
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isConnectable()) {
                    openConnect(key);
                } else if (key.isWritable()) {
                    doWrite(key, datagram);
                } else if (key.isReadable()) {
                    readMsg.append(doRead(key));
                    return readMsg.toString();
                }
            }
        }
        return readMsg.toString();
    }


    public void openConnect(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        if (clientChannel.isConnectionPending()) {
            clientChannel.finishConnect();
        }
        log.info("[SocketConnection]  Client Connected Socket!");
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
        StringBuilder str = new StringBuilder();
        SocketChannel clientChannel = (SocketChannel) key.channel();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
//        int count = clientChannel.read(byteBuffer);
        long length = 0;
        while ((length = clientChannel.read(buffer)) > 0) {
            buffer.flip();
            if (buffer.hasRemaining()) {
                str.append(new String(buffer.array()));
            }
            buffer.clear();
        }

        return str.toString().trim();
    }

    public void closeConnect() {
        try {
            if (channel != null) {
                channel.close();
            }
            if (selector != null) {
                selector.close();
            }
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
