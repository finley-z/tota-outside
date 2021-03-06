package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.RollbackConsumeMessage;
import com.tota.outside.rpc.util.MacCodeGenerator;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class RollbackConsumeMsgResolver extends Resolver<RollbackConsumeMessage> {
    public static LinkedHashMap<String, String> fieldsConfig = new LinkedHashMap<>();
    private static Map<String, Method> methods;
    private static Map<String, Field> fields;
    private static String[] macFields={"transType","txMsgDateTime","posId","localSequence","cardId"};


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
            methods = getFieldGetSetMethods(RollbackConsumeMessage.class);
            fields = getFields(RollbackConsumeMessage.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String generateDatagram(RollbackConsumeMessage rollbackConsumeMessage) throws Exception {
        String mac=generateMac(rollbackConsumeMessage);
        mac= MacCodeGenerator.computeMac("",mac);
        rollbackConsumeMessage.setMac(mac);
        return generate(fieldsConfig, methods, fields, rollbackConsumeMessage);
    }

    @Override
    public String generateMac(RollbackConsumeMessage rollbackConsumeMessage) throws InvocationTargetException, IllegalAccessException {
        String mac= getMacCodeStr(macFields,fieldsConfig,methods,fields,rollbackConsumeMessage);
        mac+=getFieldValue(rollbackConsumeMessage.getTxnAmt(),fields.get("txnAmt"),10);
        return mac;
    }


    @Override
    public RollbackConsumeMessage resolveDatagram(String datagram) throws Exception {
        return resolve(fieldsConfig, methods, fields, datagram, RollbackConsumeMessage.class);
    }

}
