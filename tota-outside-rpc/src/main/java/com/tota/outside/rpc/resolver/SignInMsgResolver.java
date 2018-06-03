package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.Message;
import com.tota.outside.rpc.api.model.SignInMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.*;

public class SignInMsgResolver extends Resolver<SignInMessage> {
    public static LinkedHashMap<String, String> fieldsConfig = new LinkedHashMap<>();
    private static Map<String, Method> methods;
    private static Map<String, Field> fields;

    static {
        fieldsConfig.putAll(headerConfigs);
        fieldsConfig.put("unitId", "8");
        fieldsConfig.put("txnMode", "2");
        fieldsConfig.put("samId", "16");
        fieldsConfig.put("samAuthInfo", "16");
        fieldsConfig.put("edAuthInfo", "16");
        fieldsConfig.put("posId", "12");
        fieldsConfig.put("termId", "12");
        fieldsConfig.put("operId", "16");
        fieldsConfig.put("edCardId", "16");
        fieldsConfig.put("settDate", "8");
        fieldsConfig.put("batchNo", "6");
        fieldsConfig.put("sysDateTime", "14");
        fieldsConfig.put("authCode", "24");
        fieldsConfig.put("paramBit", "32");
        fieldsConfig.put("keySet", "32");
        fieldsConfig.put("reserved", "20");
        fieldsConfig.put("responseCode_Body", "5");
        try {
            methods = getFieldGetSetMethods(SignInMessage.class);
            fields = getFields(SignInMessage.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String generateDatagram(SignInMessage signInMessage) {
        try {
            return generate( fieldsConfig, methods, fields,signInMessage);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SignInMessage resolveDatagram(String datagram) {
        try {
            return resolve(fieldsConfig,methods,fields,datagram,SignInMessage.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
