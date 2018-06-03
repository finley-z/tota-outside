package com.tota.outside.rpc.service;

import com.alibaba.fastjson.JSON;
import com.tota.outside.rpc.api.model.ConsumeMessage;
import com.tota.outside.rpc.api.service.DubboTestService;
import com.tota.outside.rpc.resolver.ConsumeMsgResolver;
import com.tota.outside.rpc.resolver.Resolver;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DubboTestServiceImpl implements DubboTestService {
    @Override
    public String testDubbo() {
        return "dubbo interface is running";
    }


    public static void main(String[] args) {
        String consumeMessage = "029511000000000100015000102461201406251040324A49D0760051000001000000000006110000000001000000000000000000000029111000000000100000000000000000000000000000000523014014444042300000014011000020000000010000000100203412122014062510403252300020140625000362201406250101273055000000000000000000000000000000000";
        Resolver cmr = new ConsumeMsgResolver();
//        ConsumeMessage consumeMsg = (ConsumeMessage) cmr.test(consumeMessage);
//        System.out.println(JSON.toJSONString(consumeMsg));
    }
}






