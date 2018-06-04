package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.RechargeMessage;
import com.tota.outside.rpc.api.model.SignInMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class RechargeMsgResolver extends Resolver<RechargeMessage> {
    public static LinkedHashMap<String, String> fieldsConfig = new LinkedHashMap<>();
    private static Map<String, Method> methods;
    private static Map<String, Field> fields;

    static {
        fieldsConfig.putAll(headerConfigs);
        fieldsConfig.put("unitId", "8");
        fieldsConfig.put("localSequence", "10");
        fieldsConfig.put("transType", "2");
        fieldsConfig.put("posId", "12");
        fieldsConfig.put("samId", "16");
        fieldsConfig.put("posSequence", "9");
        fieldsConfig.put("termId", "12");
        fieldsConfig.put("operId", "16");
        fieldsConfig.put("edCardId", "16");
        fieldsConfig.put("cardId", "16");
        fieldsConfig.put("cardAuthCode", "8");
        fieldsConfig.put("cardCnt", "6");
        fieldsConfig.put("cardMKnd", "2");
        fieldsConfig.put("cardSKnd", "2");
        fieldsConfig.put("cardModel", "1");
        fieldsConfig.put("reloadCnt", "4");
        fieldsConfig.put("befBalance", "8");
        fieldsConfig.put("origAmt", "8");
        fieldsConfig.put("txnAmt", "8");
        fieldsConfig.put("handingCharge", "8");
        fieldsConfig.put("deposit", "8");
        fieldsConfig.put("cardValDate", "8");
        fieldsConfig.put("tradeBeginDate", "8");
        fieldsConfig.put("tradeEndDate", "8");
        fieldsConfig.put("txnDate", "8");
        fieldsConfig.put("txnTime", "6");
        fieldsConfig.put("cityCode", "4");
        fieldsConfig.put("cardVerNo", "2");
        fieldsConfig.put("settDate", "8");
        fieldsConfig.put("batchNo", "6");
        fieldsConfig.put("authSeq", "18");
        fieldsConfig.put("limitedAuthSeql", "10");
        fieldsConfig.put("lastPosSvSeq", "9");
        fieldsConfig.put("lastTxnType", "4");
        fieldsConfig.put("lastPosId", "12");
        fieldsConfig.put("LastTxnAmt", "8");
        fieldsConfig.put("lastCrdCnt", "6");
        fieldsConfig.put("lastTxnTime", "14");
        fieldsConfig.put("lastaftamt", "8");
        fieldsConfig.put("lasttac", "8");
        fieldsConfig.put("reserved", "20");
        fieldsConfig.put("tac", "8");
        fieldsConfig.put("txnResponse", "5");

        try {
            methods = getFieldGetSetMethods(RechargeMessage.class);
            fields = getFields(RechargeMessage.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String generateDatagram(RechargeMessage rechargeMessage) throws Exception {
        return generate(fieldsConfig, methods, fields, rechargeMessage);
    }

    @Override
    public RechargeMessage resolveDatagram(String datagram) throws Exception {
        return resolve(fieldsConfig, methods, fields, datagram, RechargeMessage.class);
    }
}
