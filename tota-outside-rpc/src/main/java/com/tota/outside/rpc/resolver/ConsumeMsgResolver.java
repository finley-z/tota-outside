package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.ConsumeMessage;
import com.tota.se.common.exception.BusinessException;

import java.beans.IntrospectionException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

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
        fieldsConfig.put("befBalance", "8");
        fieldsConfig.put("txnAmt", "8");
        fieldsConfig.put("origAmt", "8");
        fieldsConfig.put("cardValDate", "8");
        fieldsConfig.put("txnDate", "8");
        fieldsConfig.put("txnTime", "6");
        fieldsConfig.put("cityCode", "4");
        fieldsConfig.put("cardVerNo", "2");
        fieldsConfig.put("settDate", "8");
        fieldsConfig.put("batchNo", "6");
        fieldsConfig.put("authSeq", "18");
        fieldsConfig.put("reserved", "20");
        fieldsConfig.put("TAC", "8");
        fieldsConfig.put("responseCode_Body", "5");
        try {
            methods = getFieldGetSetMethods(ConsumeMessage.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }


    /**
     * 报文组装
     *
     * @param consumeMessage
     * @return
     */
    @Override
    public String generateDatagram(ConsumeMessage consumeMessage) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : fieldsConfig.entrySet()) {
                Object object = methods.get(entry.getKey() + "_g").invoke(consumeMessage);
                sb.append(fixZero((String) object, Integer.valueOf(entry.getValue()), true));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 报文解析
     *
     * @param consumeMessage
     * @return
     */
    @Override
    public ConsumeMessage resolveDatagram(String consumeMessage) {
        char[] c = consumeMessage.toCharArray();
        if (c == null) {
            return null;
        }
        int len = 0;
        Iterator iterator = fieldsConfig.entrySet().iterator();

        ConsumeMessage bean = new ConsumeMessage();
        try {
            for (int i = 0, k=0; i < c.length&&k<fieldsConfig.size(); i = i + len,k++) {

                Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
                len = Integer.valueOf(entry.getValue());
                char[] newChar = new char[len];
                newChar = Arrays.copyOfRange(c, i, i + len);
                Field field =null;
                try {
                field = ConsumeMessage.class.getDeclaredField(entry.getKey());
                }catch (NoSuchFieldException e){
                    field=ConsumeMessage.class.getSuperclass().getDeclaredField(entry.getKey());
                }
                if(null==field){
                    System.out.println("没有该属性"+entry.getKey());
                    throw new BusinessException("没有该属性："+entry.getKey());
                }
                Method fieldSetMet=methods.get(entry.getKey() + "_s");
                String fieldType=field.getType().getSimpleName();
                String value=charToString(newChar);

                if ("String".equals(fieldType)) {
                    fieldSetMet.invoke(bean, value);
                } else if ("Date".equals(fieldType)) {
                    Date temp = parseDate(value);
                    fieldSetMet.invoke(bean, temp);
                } else if ("Byte".equals(fieldType)) {
                    Byte temp = Byte.parseByte(value);
                    fieldSetMet.invoke(bean, temp);
                } else if ("Integer".equals(fieldType)
                        || "int".equals(fieldType)) {
                    Integer intval = Integer.parseInt(value);
                    fieldSetMet.invoke(bean, intval);
                } else if ("Short".equals(fieldType)) {
                    Short intval = Short.parseShort(value);
                    fieldSetMet.invoke(bean, intval);
                }else if ("Long".equalsIgnoreCase(fieldType)) {
                    Long temp = Long.parseLong(value);
                    fieldSetMet.invoke(bean, temp);
                } else if ("Double".equalsIgnoreCase(fieldType)) {
                    Double temp = Double.parseDouble(value);
                    fieldSetMet.invoke(bean, temp);
                } else if ("Boolean".equalsIgnoreCase(fieldType)) {
                    Boolean temp = Boolean.parseBoolean(value);
                    fieldSetMet.invoke(bean, temp);
                } else {
                    System.out.println("not supper type" + fieldType);
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }
        return bean;
    }

    public static String charToString(char[] a) {
        if (a == null)
            return "";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.toString();
        }
    }

    public static Date parseDate(String datestr) {
        if (null == datestr || "".equals(datestr)) {
            return null;
        }
        try {
            String fmtstr = null;
            if (datestr.indexOf(':') > 0) {
                fmtstr = "yyyy-MM-dd HH:mm:ss";
            } else {
                fmtstr = "YYYYMMDDhhmmss";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(fmtstr);
            return sdf.parse(datestr);
        } catch (Exception e) {
            return null;
        }
    }

    public  static  void  main(String[] args){
        try {
            Field   field = ConsumeMessage.class.getDeclaredField("befBalance");
            System.out.println(field.getGenericType());
//            Field   field1 = ConsumeMessage.class.getSuperclass().getDeclaredField("befBalance");
//            System.out.println(field1.getGenericType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
