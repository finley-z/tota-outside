package com.tota.outside.rpc;

import com.tota.outside.rpc.api.model.SignInMessage;
import com.tota.outside.rpc.resolver.SignInMsgResolver;
import com.tota.outside.rpc.response.ResponseStateParser;
import com.tota.outside.rpc.socket.ConnectionTemplet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Main {

    private static ClassPathXmlApplicationContext context;

    private static String configPath = "classpath*:spring-config.xml";

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext(new String[]{configPath});
        context.start();

        SignInMsgResolver resolver = new SignInMsgResolver();
        SignInMessage msg=new SignInMessage();
        Date date=new Date();
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

        try {
            String res=resolver.generateDatagram(msg);
            System.out.println("报文："+res);
//            ResponseStateParser.Status status= ResponseStateParser.getResponseState("24003");
            ConnectionTemplet templet= (ConnectionTemplet) context.getBean("connectionTemplet");
           String response= templet.processRequest(res);
           SignInMessage responseMsg=resolver.resolveDatagram(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (Main.class) {
            while (true) {
                try {
                    Main.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
