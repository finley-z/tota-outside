package com.tota.outside.controller;


import com.tota.outside.rpc.api.service.DubboTestService;
import com.tota.se.common.domain.Result;
import com.tota.se.core.context.SpringContextHolder;
import com.tota.se.rpc.dubbo.client.DubboClient;
import com.tota.se.rpc.dubbo.client.DubboClientFactory;
import com.tota.se.rpc.dubbo.provider.DubboService;
import com.tota.se.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/dubboTest")
public class DubboTestController  extends BaseController {

    @Autowired
    private DubboClientFactory clientFactory;

    public DubboTestService getCallbackRpcService() {
       return clientFactory.getDubboClient("dubboTestService");

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Result test(HttpServletRequest request, HttpServletResponse responsep) {
        System.out.println(getCallbackRpcService().testDubbo());
        return null;
    }
}
