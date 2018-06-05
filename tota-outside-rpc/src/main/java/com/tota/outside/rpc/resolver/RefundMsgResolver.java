package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.RefundMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class RefundMsgResolver extends Resolver<RefundMessage> {

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
        fieldsConfig.put("cardCnt", "6");
        fieldsConfig.put("cardMKnd", "2");
        fieldsConfig.put("cardSKind", "2");
        fieldsConfig.put("cardModel", "1");
        fieldsConfig.put("befBalance", "8");
        fieldsConfig.put("txnAmt", "8");
//        fieldsConfig.put("origAmt", "8");
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
        fieldsConfig.put("origAuthSeq", "18");
        fieldsConfig.put("reserved", "20");
        fieldsConfig.put("TAC", "8");
        fieldsConfig.put("txnResponse", "5");
        try {
            methods = getFieldGetSetMethods(RefundMessage.class);
            fields = getFields(RefundMessage.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generateDatagram(RefundMessage signInMessage) throws Exception {
        return generate(fieldsConfig, methods, fields, signInMessage);
    }

    @Override
    public RefundMessage resolveDatagram(String datagram) throws Exception {
        return resolve(fieldsConfig, methods, fields, datagram, RefundMessage.class);
    }

}
