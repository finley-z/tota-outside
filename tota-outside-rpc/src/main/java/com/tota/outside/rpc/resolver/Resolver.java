package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.Message;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public abstract class Resolver<T> {
    public static LinkedHashMap<String, String> headerConfigs=new LinkedHashMap<>();

    /**
     * 请求头初始化
     */
    static {
        headerConfigs.put("version", "2");
        headerConfigs.put("messageType", "4");
        headerConfigs.put("messageDateTime", "14");
        headerConfigs.put("mac", "8");
        headerConfigs.put("responseCode", "2");
    }

    //报文生成  class -- string
    protected abstract String generateDatagram(T t);

    //报文解析   string --class
    protected abstract T resolveDatagram(String datagram);


    /***
     * 获取javabean属性的get  set 方法
     * @param clazz
     * @return
     * @throws IntrospectionException
     */
    protected static Map<String, Method> getFieldGetSetMethods(Class clazz) throws IntrospectionException {
        Map<String, Method> methods = new HashMap<>();
        Class superClazz = clazz.getSuperclass();
        getMethods(superClazz,methods);
        getMethods(clazz,methods);
        return methods;
    }

    /***
     * 获取 javabean的属性
     * @param clazz
     * @return
     * @throws IntrospectionException
     */
    protected static Map<String,Field> getFields(Class clazz) throws IntrospectionException {
        Map<String, Field> fields = new HashMap<>();
        List<Field> filedList =new ArrayList<>();
        Class parentClazz=clazz.getSuperclass();
        filedList.addAll(Arrays.asList(parentClazz.getDeclaredFields()));
        filedList.addAll(Arrays.asList(clazz.getDeclaredFields()));
        Iterator<Field> it = filedList.iterator();

        while (it.hasNext()) {
            Field field=it.next();
            fields.put(field.getName(),field);
        }
        return fields;
    }

    private static void getMethods(Class clazz,Map<String,Method> methods) throws IntrospectionException {
        List<Field> filedList =Arrays.asList(clazz.getDeclaredFields());
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
     * 解析javabean属性中的值到报文域
     * @return
     */
    protected  String generate(LinkedHashMap<String, String> fieldsConfig,Map<String,Method> methods,Map<String,Field> fields,T t){
        StringBuffer buffer = new StringBuffer();
        Set<String> filedSet = fieldsConfig.keySet();
        Iterator<String> it = filedSet.iterator();
        try {
            while (it.hasNext()) {
                String fieldName=it.next();
                String getMethodName = fieldName + "_g";
                Method getMethod = methods.get(getMethodName);
                Field field =fields.get(fieldName);
                int valLen= Integer.parseInt(fieldsConfig.get(fieldName));
                Object val=getMethod.invoke(t);
                String resolvedVal=resolveFieldValue(val,field,valLen);
                buffer.append(resolvedVal);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String resolveFieldValue(Object value,Field field,int length) {
        String val="";
        if(value!=null){
            val+=val.toString();
        }

        if(val.length()<length){
            Class fieldType=field.getType();
            if(fieldType.equals(Byte.class)||field.equals(Short.class)||field.equals(Integer.class)||field.equals(Long.class)){

            }else if(fieldType.equals(String.class)){

            }
        }

        return val;
    }

    /***
     * 报文左补零
     * @return
     */
    private String interpolateZeroLeft() {
        return "";
    }

    /***
     * 报文右补零
     * @return
     */
    private String interpolateZeroRigth(){
        return "";
    }
}
