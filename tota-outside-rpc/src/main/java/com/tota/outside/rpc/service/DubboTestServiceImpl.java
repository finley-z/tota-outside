package com.tota.outside.rpc.service;

import com.tota.outside.rpc.api.service.DubboTestService;
import org.springframework.stereotype.Service;

@Service
public class DubboTestServiceImpl implements DubboTestService {
    @Override
    public String testDubbo() {
        return "dubbo interface is running";
    }
}
