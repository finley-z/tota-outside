package com.tota.outside.rpc.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author zyf
 * @date 2017/9/19
 */
public class Server {
    public void handleMsg() {
        ServerSocketChannel severSocketChannel = null;
        try {
            severSocketChannel = ServerSocketChannel.open();
            severSocketChannel.bind(new InetSocketAddress(8484));
            if(severSocketChannel.isOpen()){
                SocketChannel socketChannel=severSocketChannel.accept();
                while(socketChannel.finishConnect()){
                    ByteBuffer buffer=ByteBuffer.allocate(1024);
                    int msgLen=0;
                    while((msgLen=socketChannel.read(buffer))!=-1){
                        buffer.flip();
                        while(buffer.hasRemaining()){
                          CharBuffer content=Charset.forName("GBK").decode(buffer);
                            System.out.println("client msg:"+content);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    public static void main(String[]args){
        new Server().handleMsg();
    }
}