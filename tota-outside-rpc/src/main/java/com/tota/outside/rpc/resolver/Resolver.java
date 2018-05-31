package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.Message;
import org.apache.poi.ss.formula.functions.T;

import java.util.Map;

public abstract class Resolver {
    public static Map<String,String> headerConfigs;

    static{
        headerConfigs.put("version","2");
        headerConfigs.put("messageType","4");
        headerConfigs.put("messageDateTime","14");
        headerConfigs.put("mac","8");
        headerConfigs.put("responseCode","2");
    }

    protected abstract String generateDatagram(Class<T> cls,Message message);

    protected abstract  T resolveDatagram(Class<T> cls,String datagram);

    protected String interpolateZero(){

        return "";
    }

}
