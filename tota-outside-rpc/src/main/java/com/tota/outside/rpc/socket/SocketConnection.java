package com.tota.outside.rpc.socket;

import java.net.Socket;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;

public class SocketConnection {
    private String host;
    private int port = 6379;

    private SocketChannel channel;
    private Buffer buffer;

    private int timeout = 2000;
    private boolean broken = false;


    public String processRequest(String datagram){

        return null;
    }

}
