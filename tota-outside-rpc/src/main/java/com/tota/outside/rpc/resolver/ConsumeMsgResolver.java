package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.ConsumeMessage;
import com.tota.outside.rpc.api.model.SignInMessage;

import java.beans.IntrospectionException;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConsumeMsgResolver extends Resolver<ConsumeMessage> {

    private static LinkedHashMap<String, String> fieldsConfig = new LinkedHashMap<>();
    private static Map<String, Method> methods;

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
        fieldsConfig.put("befBalance ", "8");
        fieldsConfig.put("txnAmt", "8");
        fieldsConfig.put("origAmt", "8");
        fieldsConfig.put("cardValDate", "8");
        fieldsConfig.put("txnDate", "8");
        fieldsConfig.put("txnTime", "6");
        fieldsConfig.put("cityCode ", "4");
        fieldsConfig.put("cardVerNo ", "2");
        fieldsConfig.put("settDate", "8");
        fieldsConfig.put("batchNo", "6");
        fieldsConfig.put("authSeq", "18");
        fieldsConfig.put("reserved", "20");
        fieldsConfig.put("TAC", "8");
        fieldsConfig.put("responseCode_Body ", "5");
        try {
            methods = getFieldGetSetMethods(ConsumeMessage.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String generateDatagram(ConsumeMessage signInMessage) {
        try {
            StringBuilder sb=new StringBuilder();
            for (Map.Entry<String, String> entry : fieldsConfig.entrySet()) {
               Object object=methods.get(entry.getKey() + "_g").invoke(signInMessage);
                sb.append(fixZero((String)object,Integer.valueOf(entry.getValue()),true));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected ConsumeMessage resolveDatagram(String datagram) {
        return null;
    }

    public static void main(String args[]){

    }

}
