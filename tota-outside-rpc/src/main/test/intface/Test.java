package intface;

import com.tota.outside.rpc.api.model.SignInMessage;
import com.tota.outside.rpc.resolver.SignInMsgResolver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test {


    public void sendMsg() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("172.18.1.116", 10001));
            CharsetEncoder encoder= Charset.forName("GBK").newEncoder();
            if (socketChannel.finishConnect()) {
                int i = 0;
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    String info = "01 2051 20180531193959 ";
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
//        Integer i=Integer.valueOf("00000110");
        SignInMsgResolver resolver=   new SignInMsgResolver();
        SignInMessage msg=new SignInMessage();
        msg.setAuthCode("34223");
        msg.setKeySet("000");
        msg.setVersion((byte)1);

        String res=resolver.generateDatagram(msg);

//        Set s=SignInMsgResolver.fieldsConfig.keySet();

        new Test().sendMsg();
    }
}
