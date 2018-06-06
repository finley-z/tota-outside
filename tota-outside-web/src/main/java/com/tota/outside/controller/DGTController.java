package com.tota.outside.controller;


import com.tota.outside.rpc.api.model.SignInMessage;
import com.tota.outside.rpc.api.service.DGTService;
import com.tota.outside.rpc.api.service.DubboTestService;
import com.tota.se.common.domain.Result;
import com.tota.se.rpc.dubbo.client.DubboClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/dgt")
public class DGTController {

    @Autowired
    private DubboClientFactory clientFactory;

    public DGTService getCallbackRpcService() {
       return clientFactory.getDubboClient("dGTService");
    }

    @ResponseBody
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public Result test(SignInMessage signInMessage) {
        return getCallbackRpcService().signIn(signInMessage);
    }
}
