package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.Message;
import com.tota.se.common.exception.BusinessException;
import com.tota.se.common.util.date.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.*;

public abstract class Resolver<T> {
    protected static LinkedHashMap<String, String> headerConfigs = new LinkedHashMap<>();

    /**
     * 请求头配置初始化
     */
    static {
        headerConfigs.put("dataLength", "4");
        headerConfigs.put("packageSyncMsg", "12");
        headerConfigs.put("packageCompress", "1");
        headerConfigs.put("packageEncrypt", "1");
        headerConfigs.put("packageVersion", "2");
        headerConfigs.put("packageMsgType", "4");
        headerConfigs.put("txVersion", "2");
        headerConfigs.put("txMsgType", "4");
        headerConfigs.put("txMsgDateTime", "14");
        headerConfigs.put("mac", "8");
        headerConfigs.put("responseCode", "2");
    }

    //报文生成  class -- string
    public abstract String generateDatagram(T t) throws InvocationTargetException, IllegalAccessException, Exception;

    //报文解析   string --class
    public abstract T resolveDatagram(String datagram) throws InvocationTargetException, InstantiationException, ParseException, IllegalAccessException, Exception;


    /***
     * 解析javabean属性中的值到报文域
     * @return
     */
    protected String generate(LinkedHashMap<String, String> fieldsConfig, Map<String, Method> methods, Map<String, Field> fields, T t) throws InvocationTargetException, IllegalAccessException {
        StringBuffer buffer = new StringBuffer();
        Set<String> filedSet = fieldsConfig.keySet();
        Iterator<String> it = filedSet.iterator();

        while (it.hasNext()) {
            String fieldName = it.next();
            String getMethodName = fieldName + "_g";
            Method getMethod = methods.get(getMethodName);
            Field field = fields.get(fieldName);
            int valLen = Integer.parseInt(fieldsConfig.get(fieldName));
            Object val = getMethod.invoke(t);
            String resolvedVal = getFieldValue(val, field, valLen);
            buffer.append(resolvedVal);
        }

        return buffer.toString();
    }
    //获取javabean属性值，转换成字符串
    private String getFieldValue(Object value, Field field, int length) {
        String val = "";
        if(field.getType().equals(Date.class)){
            DateTimeFormat format=field.getAnnotation(DateTimeFormat.class);
            String pattern=format.pattern();
            if(value!=null){
                val= DateUtil.formatDate((Date) value, pattern);
            }
        }else if (value != null) {
            val += value.toString();
        }

        if (val.length() < length) {
            Class fieldType = field.getType();
            if (fieldType.equals(Byte.class) || fieldType.equals(Short.class) || fieldType.equals(Integer.class) || fieldType.equals(Long.class)) {
                val = fixZero(val, length, true);
            } else if (fieldType.equals(String.class)||fieldType.equals(Date.class)) {
                val = fixZero(val, length, false);
            }
        }

        return val;
    }

    /***
     * 将报文数据解析成javabean属性中的值
     * @return
     */
    protected T resolve(LinkedHashMap<String, String> fieldsConfig, Map<String, Method> methods, Map<String, Field> fields, String datagram, Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException, ParseException {
        T result = clazz.newInstance();
        Set<String> filedSet = fieldsConfig.keySet();
        Iterator<String> it = filedSet.iterator();
        int position = 0;

        while (it.hasNext()) {
            String fieldName = it.next();
            Field field = fields.get(fieldName);
            int valLen = Integer.parseInt(fieldsConfig.get(fieldName));
            String val = datagram.substring(position, position + valLen);
            Object valObj=getDatagramValue(val,field);
            String getMethodName = fieldName + "_s";
            Method setMethod = methods.get(getMethodName);
            setMethod.invoke(result,valObj);
            position+=valLen;
        }

        return result;
    }

    //获取报文中的字符串值，转换成javabean属性值
    private Object getDatagramValue(String valueStr, Field field) throws ParseException {
        Object value = null;
        if (StringUtils.isNotEmpty(valueStr)) {
            Class fieldType = field.getType();
            if (fieldType.equals(Byte.class)) {
                value = Byte.valueOf(valueStr);
            } else if (fieldType.equals(Short.class)) {
                value = Short.valueOf(valueStr);
            } else if (fieldType.equals(Integer.class)) {
                value = Integer.valueOf(valueStr);
            } else if (fieldType.equals(Long.class)) {
                value = Long.valueOf(valueStr);
            }else if(fieldType.equals(String.class)){
                value=valueStr;
            }else if(fieldType.equals(Date.class)){
                DateTimeFormat format=field.getAnnotation(DateTimeFormat.class);
                String pattern=format.pattern();
                DateUtil.parserStringToDate(valueStr, pattern);
            }
        }
        return value;
    }


    /***
     * 获取javabean属性的get  set 方法
     * @param clazz
     * @return
     * @throws IntrospectionException
     */
    protected static Map<String, Method> getFieldGetSetMethods(Class clazz) throws IntrospectionException {
        Map<String, Method> methods = new HashMap<>();
        Class superClazz = clazz.getSuperclass();
        getMethods(superClazz, methods);
        getMethods(clazz, methods);
        return methods;
    }

    /***
     * 获取 javabean的属性
     * @param clazz
     * @return
     * @throws IntrospectionException
     */
    protected static Map<String, Field> getFields(Class clazz) throws IntrospectionException {
        Map<String, Field> fields = new HashMap<>();
        List<Field> filedList = new ArrayList<>();
        Class parentClazz = clazz.getSuperclass();
        filedList.addAll(Arrays.asList(parentClazz.getDeclaredFields()));
        filedList.addAll(Arrays.asList(clazz.getDeclaredFields()));
        Iterator<Field> it = filedList.iterator();

        while (it.hasNext()) {
            Field field = it.next();
            fields.put(field.getName(), field);
        }
        return fields;
    }

    private static void getMethods(Class clazz, Map<String, Method> methods) throws IntrospectionException {
        List<Field> filedList = Arrays.asList(clazz.getDeclaredFields());
        Iterator<Field> it = filedList.iterator();
        while (it.hasNext()) {
            String filedName = it.next().getName();
            PropertyDescriptor pd = new PropertyDescriptor(filedName, clazz);
            Method getMethod = pd.getReadMethod();
            methods.put(filedName + "_g", getMethod);
            Method setMethod = pd.getWriteMethod();
            methods.put(filedName + "_s", setMethod);
        }
    }


    /***
     * 报文补零
     * @return
     */
    protected String fixZero(String value, int length, boolean isLeft) {
        if (value.length() > length) {
            throw new BusinessException("值的长度超出限制");
        }
        if (value.length() == length) {
            return value;
        }
        String zeros = intArrToString(new int[length-value.length()]);
        if (isLeft) {
            return zeros + value;
        } else {
            return value + zeros;
        }
    }

    private String intArrToString(int a[]) {
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
}
