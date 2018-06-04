package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.OperateMessage;
import com.tota.outside.rpc.api.model.SignInMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class OperateMsgResolver extends Resolver<OperateMessage> {
    public static LinkedHashMap<String, String> fieldsConfig = new LinkedHashMap<>();
    private static Map<String, Method> methods;
    private static Map<String, Field> fields;

    static {
        fieldsConfig.putAll(headerConfigs);
        fieldsConfig.put("unitId", "8");
        fieldsConfig.put("posId", "12");
        fieldsConfig.put("samId", "16");
        fieldsConfig.put("posSequence", "9");
        fieldsConfig.put("termId", "12");
        fieldsConfig.put("operId", "16");
        fieldsConfig.put("edCardId", "16");

        fieldsConfig.put("cardOprType", "4");
        fieldsConfig.put("cityCode", "4");
        fieldsConfig.put("cardId", "16");
        fieldsConfig.put("cardMKnd", "2");
        fieldsConfig.put("cardSKnd", "2");
        fieldsConfig.put("cardModel", "1");
        fieldsConfig.put("transType", "2");
        fieldsConfig.put("cardCSN", "16");
        fieldsConfig.put("cardMac", "8");
        fieldsConfig.put("sysDatetime", "14");
        fieldsConfig.put("keyCnt", "2");
        fieldsConfig.put("sectorID", "4");
        fieldsConfig.put("keySet", "64");
        fieldsConfig.put("tacKeySet", "32");
        fieldsConfig.put("deposit", "8");
        fieldsConfig.put("origAmt", "8");
        fieldsConfig.put("reloadBal", "8");
        fieldsConfig.put("cardValDate", "8");
        fieldsConfig.put("mac2", "8");
        fieldsConfig.put("srcBal", "8");
        fieldsConfig.put("cardSeq", "6");
        fieldsConfig.put("keyVer", "2");
        fieldsConfig.put("algInd", "2");
        fieldsConfig.put("cardRand", "8");
        fieldsConfig.put("mac1", "8");
        fieldsConfig.put("commandLen", "3");
        fieldsConfig.put("command", "3");
        fieldsConfig.put("dicMac", "16");
        fieldsConfig.put("divData", "18");
        fieldsConfig.put("settDate", "8");
        fieldsConfig.put("batchNo", "6");
        fieldsConfig.put("authSeq", "10");
        fieldsConfig.put("limitedAuthSeql", "10");
        fieldsConfig.put("reserved", "20");
        fieldsConfig.put("responseCode_Body", "5");
        try {
            methods = getFieldGetSetMethods(OperateMessage.class);
            fields = getFields(OperateMessage.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String generateDatagram(OperateMessage operateMessage) throws Exception {
        return generate( fieldsConfig, methods, fields,operateMessage);
    }

    @Override
    public OperateMessage resolveDatagram(String datagram) throws Exception{
        return resolve(fieldsConfig,methods,fields,datagram,OperateMessage.class);
    }
}
