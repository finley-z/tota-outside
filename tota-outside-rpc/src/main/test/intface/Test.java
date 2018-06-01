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
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test {
    SocketChannel socketChannel = null;

    public void signIn(String msg) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        int numBytesRead;

        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("172.18.1.116", 10001));
            CharsetEncoder encoder = Charset.forName("UTF-8").newEncoder();
            while (!socketChannel.finishConnect()) {
                System.out.println("等待非阻塞连接建立....");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (socketChannel.finishConnect()) {
                    System.out.println("等待非阻塞连接建立....");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   int i = 0;
                    TimeUnit.SECONDS.sleep(1);
                    charBuffer.clear();
                    buffer.clear();
                    charBuffer.put(msg);
                    encoder.encode(charBuffer, buffer, false);
                    charBuffer.flip();
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        System.out.println(charBuffer);
                        socketChannel.write(buffer);
                    }

                while ((numBytesRead = socketChannel.read(buffer)) != -1) {
                    if (numBytesRead == 0) {
                        // 如果没有数据，则稍微等待一下
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    // 转到最开始
                    buffer.flip();
                    while (buffer.remaining() > 0) {
                        System.out.print((char) buffer.get());
                    }
                    // 也可以转化为字符串，不过需要借助第三个变量了。
                    // buf.get(buff, 0, numBytesRead);
                    // System.out.println(new String(buff, 0, numBytesRead, "UTF-8"));
                    // 复位，清空
                    buffer.clear();
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


    public static void main(String[] args) {
        SignInMsgResolver resolver = new SignInMsgResolver();

        String datagram = "03050000000000000001500010205120140819003500000000000054000017010000000000000" +
                "000000000000000000000000000000000001100000008581100000008580000000000000000000000" +
                "000000000000000000000000000000000000000000000000000000000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000000000";
//        SignInMessage msg = resolver.resolveDatagram(datagram);
//        String res=resolver.generateDatagram(msg);
        Date date=new Date();

        SignInMessage msg=new SignInMessage();
        msg.setDataLength(305);
        msg.setPackageSyncMsg("55");
        msg.setPackageSyncMsg("573108440");
        msg.setPackageCompress((byte) 0);
        msg.setPackageEncrypt((byte) 0);
        msg.setTxVersion((byte) 1);
        msg.setPackageMsgType("5000");

        msg.setUnitId(54000028);
        msg.setTxnMode((byte) 1);
        msg.setPosId(540280000001L);
        msg.setTermId(0L);

        msg.setOperId(0L);

        msg.setTxVersion((byte) 10);
        msg.setTxMsgType((short) 2051);
        msg.setTxMsgDateTime(date);

        msg.setTxnMode((byte)0);
        msg.setPosId(10L);
        msg.setSettDate(date);
        msg.setSysDateTime(date);

        String res=resolver.generateDatagram(msg);
        System.out.println("报文："+res);
        new Test().signIn(res);

    }
}
