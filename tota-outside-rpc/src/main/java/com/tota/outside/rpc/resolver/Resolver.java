package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.Message;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class Resolver<T> {
    public static Map<String,String> headerConfigs;

    static{
        headerConfigs.put("version","2");
        headerConfigs.put("messageType","4");
        headerConfigs.put("messageDateTime","14");
        headerConfigs.put("mac","8");
        headerConfigs.put("responseCode","2");
    }

    protected abstract String generateDatagram(T t);

    protected abstract T  resolveDatagram(String datagram);


    protected String interpolateZero(){
        return "";
    }


    public static Map<String,Method> getFieldGetSetMethods(Class cls){
        List<Field> fieldList = new ArrayList<>() ;
        Class tempClass = cls;
        while (tempClass != null) {

            //当父类为null的时候说明到达了最上层的父类(Object类).
            fieldList.addAll(Arrays.asList(tempClass .getDeclaredFields()));

            //得到父类,然后赋给自己
            tempClass = tempClass.getSuperclass();
        }
       return null;
    }


    public static void getMethod(String field,Class cls){
        try {
            PropertyDescriptor pd = new PropertyDescriptor(field, cls);


            Method getMethod = pd.getReadMethod();

            Method setMethod = pd.getWriteMethod();

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }


}
