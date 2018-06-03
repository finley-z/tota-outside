package com.tota.outside.rpc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static ClassPathXmlApplicationContext context;

    private static String configPath = "classpath*:spring-config.xml";

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext(new String[]{configPath});
        context.start();
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
