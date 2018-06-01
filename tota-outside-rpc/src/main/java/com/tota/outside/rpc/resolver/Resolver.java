package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.Message;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public abstract class Resolver<T> {
    public static LinkedHashMap<String, String> headerConfigs=new LinkedHashMap<>();

    static {
        headerConfigs.put("version", "2");
        headerConfigs.put("messageType", "4");
        headerConfigs.put("messageDateTime", "14");
        headerConfigs.put("mac", "8");
        headerConfigs.put("responseCode", "2");
    }

    protected abstract String generateDatagram(T t);

    protected abstract T resolveDatagram(String datagram);


    protected String interpolateZero() {
        return "";
    }


    public static Map<String, Method> getFieldGetSetMethods(Class clazz) throws IntrospectionException {
        Map<String, Method> methods = new HashMap<>();
        Class superClazz = clazz.getSuperclass();
        getMethods(superClazz,methods);
        getMethods(clazz,methods);
        return methods;
    }


    private static void getMethods(Class clazz,Map<String,Method> methods) throws IntrospectionException {
        List<Field> filedList = new ArrayList<>();
        filedList.addAll(Arrays.asList(clazz.getDeclaredFields()));
        Iterator<Field> it = filedList.iterator();
        while (it.hasNext()) {
            String filedName = it.next().getName();
            PropertyDescriptor pd = new PropertyDescriptor(filedName, clazz);
            Method getMethod = pd.getReadMethod();
            methods.put(filedName + "_g", getMethod);
            Method setMethod = pd.getWriteMethod();
            methods.put(filedName + "_s", getMethod);
        }
    }
}
