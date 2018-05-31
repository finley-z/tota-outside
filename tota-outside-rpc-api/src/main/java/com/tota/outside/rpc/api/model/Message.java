package com.tota.outside.rpc.api.model;

import java.util.Date;

public  class Message {
    private Byte version;
    private Short messageType;
    private Date messageDateTime;
    private String mac;
    private String responseCode;

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    public Short getMessageType() {
        return messageType;
    }

    public void setMessageType(Short messageType) {
        this.messageType = messageType;
    }

    public Date getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(Date messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public  String generateDatagram(){
        return null;
    }

    public  Message resolveDatagram(String msg){
        return null;
    }
}
