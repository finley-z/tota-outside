package com.tota.outside.rpc.socket;

import java.net.Socket;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;

public class SocketConnection {
    private String host;
    private int port ;
    private int timeout = 2000;
    private boolean idle = true;
    private boolean keepAlive = true;

    private SocketChannel channel;
    private Buffer buffer;

    public SocketConnection(){

    }

    public SocketConnection(String host,int port,int timeout,boolean keepAlive){
         this.host=host;
         this.port=port;
         this.timeout=timeout;
         this.keepAlive=keepAlive;
    }



    public String processRequest(String datagram){

        return null;
    }


}
