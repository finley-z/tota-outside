package com.tota.outside.test;

import com.tota.outside.rpc.api.service.DubboTestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    private static ClassPathXmlApplicationContext context;

    private static String configPath = "classpath*:spring-config.xml";

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext(new String[] { configPath });
        DubboTestService dubboTestService=context.getBean(DubboTestService.class);
        System.out.println(dubboTestService.testDubbo());
    }

}
