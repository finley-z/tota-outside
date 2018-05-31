package com.tota.outside.rpc.api.service;


import com.tota.se.common.domain.Result;
import com.tota.outside.rpc.api.model.*;

public interface DGTService {

    //签到接口
    public Result signIn(SignInMessage signInMessage);

    //签退接口
    public Result signOut(SignOutMessage signOutMessage);

    // 时间同步接口
    public Result syncTime(SyncTimeMessage syncTimeMessage);

    //卡操作接口
    public Result operate(OperateMessage operateMessage);

    //充值接口
    public Result recharge(RechargeMessage rechargeMessage);

    //卡消费接口
    public Result consume(ConsumeMessage consumeMessage);

    //退货接口
    public Result refund(RefundMessage refundMessage);

    //撤销交易接口
    public Result rollbackConsume(RollbackConsumeMessage rollbackConsumeMessage);
}
