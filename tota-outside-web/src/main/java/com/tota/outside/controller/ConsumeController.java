package com.tota.outside.controller;

import com.tota.outside.rpc.api.model.ConsumeMessage;
import com.tota.outside.rpc.api.model.OperateMessage;
import com.tota.outside.rpc.api.model.RefundMessage;
import com.tota.outside.rpc.api.model.RollbackConsumeMessage;
import com.tota.outside.rpc.api.service.DGTService;
import com.tota.se.common.domain.Result;
import com.tota.se.rpc.dubbo.client.DubboClientFactory;
import com.tota.se.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 联机消费
 */
@Controller
@RequestMapping("/consume")
public class ConsumeController extends BaseController {

    @Autowired
    private DubboClientFactory clientFactory;

    public DGTService getRpcService() {
        return clientFactory.getDubboClient("dGTService");

    }

    /**
     *  卡操作请求
     */
    @RequestMapping(value = "/operate", method = RequestMethod.GET)
    public Result operate(OperateMessage operateMessage) {
        return  getRpcService().operate(operateMessage);
    }

    /**
     *  消费交易
     */
    @RequestMapping(value = "/consume", method = RequestMethod.GET)
    public Result consume(ConsumeMessage consume) {
        return getRpcService().consume(consume);
    }

    /**
     *  消费撤销
     */
    @RequestMapping(value = "/rollbackConsume", method = RequestMethod.GET)
    public Result rollbackConsume(RollbackConsumeMessage rollbackConsumeMessage) {
        return getRpcService().rollbackConsume(rollbackConsumeMessage);
    }

    /**
     *  退货交易
     */
    @RequestMapping(value = "/refund", method = RequestMethod.GET)
    public Result refund(RefundMessage refundMessage) {
      return  getRpcService().refund(refundMessage);
    }

}
