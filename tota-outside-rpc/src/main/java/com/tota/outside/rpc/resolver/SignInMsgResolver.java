package com.tota.outside.rpc.resolver;

import com.tota.outside.rpc.api.model.Message;
import com.tota.outside.rpc.api.model.SignInMessage;

import java.util.Map;

public class SignInMsgResolver extends Resolver<SignInMessage>{
    private static Map<String,String> fieldsConfig;

    static{
          fieldsConfig.putAll(headerConfigs);
          fieldsConfig.put("unitid","8");
          fieldsConfig.put("txnMode","2");
          fieldsConfig.put("samId","16");
          fieldsConfig.put("samAuthInfo","16");
          fieldsConfig.put("edAuthInfo","16");
          fieldsConfig.put("posId","12");
          fieldsConfig.put("termId","12");
          fieldsConfig.put("operId","16");
          fieldsConfig.put("edCardId","16");
          fieldsConfig.put("settDate","8");
          fieldsConfig.put("batchNo","6");
          fieldsConfig.put("sysDateTime","14");
          fieldsConfig.put("authCode","24");
          fieldsConfig.put("paramBit","32");
          fieldsConfig.put("keySet","32");
          fieldsConfig.put("reserved","20");
          fieldsConfig.put("responseCode_Body","5");
          getFields(SignInMessage.class);
    }


    @Override
    protected String generateDatagram(SignInMessage signInMessage) {
        return null;
    }

    @Override
    protected SignInMessage resolveDatagram(String datagram) {
        return null;
    }
}
