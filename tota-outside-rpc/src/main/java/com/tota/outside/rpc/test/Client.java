package com.tota.outside.rpc.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.TimeUnit;

/**
 * @author zyf
 * @date 2017/9/19
 */
public class Client {

    public void sendMsg() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8484));
            CharsetEncoder encoder= Charset.forName("GBK").newEncoder();
            if (socketChannel.finishConnect()) {
                int i = 0;
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    String info = "I'm " + i++ + "-th information from client";
                    charBuffer.clear();
                    buffer.clear();
                    charBuffer.put(info);
                    encoder.encode(charBuffer,buffer,false);
                    charBuffer.flip();
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        System.out.println(charBuffer);
                        socketChannel.write(buffer);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socketChannel != null) {
                    socketChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void  main(String[]args){
        new Client().sendMsg();
    }

}