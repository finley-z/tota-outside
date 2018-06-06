package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.SignOutMessage;
import com.tota.outside.rpc.api.model.SyncTimeMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class SyncTimeMsgResolver extends Resolver<SyncTimeMessage> {
    public static LinkedHashMap<String, String> fieldsConfig = new LinkedHashMap<>();
    private static Map<String, Method> methods;
    private static Map<String, Field> fields;

    static {
        fieldsConfig.putAll(headerConfigs);
        fieldsConfig.put("locDateTime", "14");
        fieldsConfig.put("posId", "12");
        fieldsConfig.put("samId", "16");
        fieldsConfig.put("operId", "16");
        fieldsConfig.put("reserved", "38");
        fieldsConfig.put("responseCode_Body", "5");
        try {
            methods = getFieldGetSetMethods(SyncTimeMessage.class);
            fields = getFields(SyncTimeMessage.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String generateDatagram(SyncTimeMessage syncTimeMessage) throws Exception {
        return generate( fieldsConfig, methods, fields,syncTimeMessage);
    }

    @Override
    public String generateMac(SyncTimeMessage syncTimeMessage) {
        return null;
    }

    @Override
    public SyncTimeMessage resolveDatagram(String datagram) throws Exception{
        return resolve(fieldsConfig,methods,fields,datagram,SyncTimeMessage.class);
    }
}
