package com.tota.outside.rpc.service;

import com.tota.outside.rpc.api.model.*;
import com.tota.outside.rpc.api.service.DGTService;
import com.tota.outside.rpc.response.ResponseStateParser;
import com.tota.outside.rpc.socket.ConnectionTemplate;
import com.tota.se.common.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dGTServiceImpl")
public class DGTServiceImpl implements DGTService {
    @Autowired
    private ConnectionTemplate connectionTemplate;

    @Override
    public Result signIn(SignInMessage signInMessage) {
        Result result=new Result();
        boolean isSuccess=false;
        try {
            SignInMessage response=connectionTemplate.processRequest(signInMessage,SignInMessage.class);
            if(response!=null){
                ResponseStateParser.Status callRes=ResponseStateParser.getResponseState(response.getResponseCode());
                if(callRes!=null&&callRes.isSuccess()){
                    ResponseStateParser.Status txRes=ResponseStateParser.getResponseState(response.getResponseCode_Body().toString());
                    if(txRes!=null&&txRes.isSuccess()){
                        isSuccess=true;
                        result.setProperty("response",response);
                    }else{
                        result.setDescription(txRes.getResDesc());
                    }
                }else{
                    result.setDescription(callRes.getResDesc());
                }
            }else{
                result.setDescription("请求无响应");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @Override
    public Result signOut(SignOutMessage signOutMessage) {
        Result result=new Result();
        boolean isSuccess=false;
        try {
            SignOutMessage response=connectionTemplate.processRequest(signOutMessage,SignOutMessage.class);
            if(response!=null){
                ResponseStateParser.Status callRes=ResponseStateParser.getResponseState(response.getResponseCode());
                if(callRes!=null&&callRes.isSuccess()){
                    ResponseStateParser.Status txRes=ResponseStateParser.getResponseState(response.getResponseCode_Body().toString());
                    if(txRes!=null&&txRes.isSuccess()){
                        isSuccess=true;
                        result.setProperty("response",response);
                    }else{
                        result.setDescription(txRes.getResDesc());
                    }
                }else{
                    result.setDescription(callRes.getResDesc());
                }
            }else{
                result.setDescription("请求无响应");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @Override
    public Result syncTime(SyncTimeMessage syncTimeMessage) {
        Result result=new Result();
        boolean isSuccess=false;
        try {
            SyncTimeMessage response=connectionTemplate.processRequest(syncTimeMessage,SyncTimeMessage.class);
            if(response!=null){
                ResponseStateParser.Status callRes=ResponseStateParser.getResponseState(response.getResponseCode());
                if(callRes!=null&&callRes.isSuccess()){
                    ResponseStateParser.Status txRes=ResponseStateParser.getResponseState(response.getResponseCode_Body().toString());
                    if(txRes!=null&&txRes.isSuccess()){
                        isSuccess=true;
                        result.setProperty("response",response);
                    }else{
                        result.setDescription(txRes.getResDesc());
                    }
                }else{
                    result.setDescription(callRes.getResDesc());
                }
            }else{
                result.setDescription("请求无响应");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @Override
    public Result operate(OperateMessage operateMessage) {
        Result result=new Result();
        boolean isSuccess=false;
        try {
            OperateMessage response=connectionTemplate.processRequest(operateMessage,OperateMessage.class);
            if(response!=null){
                ResponseStateParser.Status callRes=ResponseStateParser.getResponseState(response.getResponseCode());
                if(callRes!=null&&callRes.isSuccess()){
                    ResponseStateParser.Status txRes=ResponseStateParser.getResponseState(response.getResponseCode_Body().toString());
                    if(txRes!=null&&txRes.isSuccess()){
                        isSuccess=true;
                        result.setProperty("response",response);
                    }else{
                        result.setDescription(txRes.getResDesc());
                    }
                }else{
                    result.setDescription(callRes.getResDesc());
                }
            }else{
                result.setDescription("请求无响应");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @Override
    public Result recharge(RechargeMessage rechargeMessage) {
        Result result=new Result();
        boolean isSuccess=false;
        try {
            RechargeMessage response=connectionTemplate.processRequest(rechargeMessage,RechargeMessage.class);
            if(response!=null){
                ResponseStateParser.Status callRes=ResponseStateParser.getResponseState(response.getResponseCode());
                if(callRes!=null&&callRes.isSuccess()){
                    ResponseStateParser.Status txRes=ResponseStateParser.getResponseState(response.getTxnResponse().toString());
                    if(txRes!=null&&txRes.isSuccess()){
                        isSuccess=true;
                        result.setProperty("response",response);
                    }else{
                        result.setDescription(txRes.getResDesc());
                    }
                }else{
                    result.setDescription(callRes.getResDesc());
                }
            }else{
                result.setDescription("请求无响应");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @Override
    public Result consume(ConsumeMessage consumeMessage) {
        Result result=new Result();
        boolean isSuccess=false;
        try {
            ConsumeMessage response=connectionTemplate.processRequest(consumeMessage,ConsumeMessage.class);
            if(response!=null){
                ResponseStateParser.Status callRes=ResponseStateParser.getResponseState(response.getResponseCode());
                if(callRes!=null&&callRes.isSuccess()){
                    ResponseStateParser.Status txRes=ResponseStateParser.getResponseState(response.getResponseCode_Body().toString());
                    if(txRes!=null&&txRes.isSuccess()){
                        isSuccess=true;
                        result.setProperty("response",response);
                    }else{
                        result.setDescription(txRes.getResDesc());
                    }
                }else{
                    result.setDescription(callRes.getResDesc());
                }
            }else{
                result.setDescription("请求无响应");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @Override
    public Result refund(RefundMessage refundMessage) {
        Result result=new Result();
        boolean isSuccess=false;
        try {
            RefundMessage response=connectionTemplate.processRequest(refundMessage,RefundMessage.class);
            if(response!=null){
                ResponseStateParser.Status callRes=ResponseStateParser.getResponseState(response.getResponseCode());
                if(callRes!=null&&callRes.isSuccess()){
                    ResponseStateParser.Status txRes=ResponseStateParser.getResponseState(response.getTxnResponse().toString());
                    if(txRes!=null&&txRes.isSuccess()){
                        isSuccess=true;
                        result.setProperty("response",response);
                    }else{
                        result.setDescription(txRes.getResDesc());
                    }
                }else{
                    result.setDescription(callRes.getResDesc());
                }
            }else{
                result.setDescription("请求无响应");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @Override
    public Result rollbackConsume(RollbackConsumeMessage rollbackConsumeMessage) {
        Result result=new Result();
        boolean isSuccess=false;
        try {
            RollbackConsumeMessage response=connectionTemplate.processRequest(rollbackConsumeMessage,RollbackConsumeMessage.class);
            if(response!=null){
                ResponseStateParser.Status callRes=ResponseStateParser.getResponseState(response.getResponseCode());
                if(callRes!=null&&callRes.isSuccess()){
                    ResponseStateParser.Status txRes=ResponseStateParser.getResponseState(response.getTxnResponse().toString());
                    if(txRes!=null&&txRes.isSuccess()){
                        isSuccess=true;
                        result.setProperty("response",response);
                    }else{
                        result.setDescription(txRes.getResDesc());
                    }
                }else{
                    result.setDescription(callRes.getResDesc());
                }
            }else{
                result.setDescription("请求无响应");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setSuccess(isSuccess);
        return result;
    }
}
