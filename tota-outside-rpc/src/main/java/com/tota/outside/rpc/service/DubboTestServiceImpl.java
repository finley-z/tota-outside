package com.tota.outside.rpc.service;

import com.tota.outside.rpc.api.service.DubboTestService;
import com.tota.outside.rpc.resolver.Resolver;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DubboTestServiceImpl implements DubboTestService {
    @Override
    public String testDubbo() {
        return "dubbo interface is running";
    }
}






