package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.SignInMessage;
import com.tota.outside.rpc.api.model.SignOutMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class SignOutMsgResolver extends Resolver<SignOutMessage> {
    public static LinkedHashMap<String, String> fieldsConfig = new LinkedHashMap<>();
    private static Map<String, Method> methods;
    private static Map<String, Field> fields;

    static {
        fieldsConfig.putAll(headerConfigs);
        fieldsConfig.put("unitId", "8");
        fieldsConfig.put("txnMode", "2");
        fieldsConfig.put("samId", "16");
        fieldsConfig.put("posId", "12");
        fieldsConfig.put("termId", "12");
        fieldsConfig.put("operId", "16");
        fieldsConfig.put("edCardId", "16");
        fieldsConfig.put("settDate", "8");
        fieldsConfig.put("batchNo", "6");
        fieldsConfig.put("totalSvNum", "10");
        fieldsConfig.put("totalSvAmt", "10");
        fieldsConfig.put("totalSaleDep", "10");
        fieldsConfig.put("reserved", "20");
        fieldsConfig.put("responseCode_Body", "5");
        try {
            methods = getFieldGetSetMethods(SignOutMessage.class);
            fields = getFields(SignOutMessage.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String generateDatagram(SignOutMessage signOutMessage) throws Exception {
        return generate( fieldsConfig, methods, fields,signOutMessage);
    }

    @Override
    public SignOutMessage resolveDatagram(String datagram) throws Exception{
        return resolve(fieldsConfig,methods,fields,datagram,SignOutMessage.class);
    }
}
