package com.tota.outside.rpc.api.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public  class Message implements Serializable {
    private Integer dataLength;
    private String  packageSyncMsg;
    private Byte    packageCompress;
    private Byte    packageEncrypt;
    private Byte    packageVersion;
    private String  packageMsgType;

    private Byte    txVersion;
    private Short   txMsgType;

    @DateTimeFormat(pattern="yyyyMMddhhmmss")
    private Date    txMsgDateTime;
    private String  mac;
    private String  responseCode;

    public Integer getDataLength() {
        return dataLength;
    }

    public void setDataLength(Integer dataLength) {
        this.dataLength = dataLength;
    }

    public String getPackageSyncMsg() {
        return packageSyncMsg;
    }

    public void setPackageSyncMsg(String packageSyncMsg) {
        this.packageSyncMsg = packageSyncMsg;
    }

    public Byte getPackageCompress() {
        return packageCompress;
    }

    public void setPackageCompress(Byte packageCompress) {
        this.packageCompress = packageCompress;
    }

    public Byte getPackageEncrypt() {
        return packageEncrypt;
    }

    public void setPackageEncrypt(Byte packageEncrypt) {
        this.packageEncrypt = packageEncrypt;
    }

    public Byte getPackageVersion() {
        return packageVersion;
    }

    public void setPackageVersion(Byte packageVersion) {
        this.packageVersion = packageVersion;
    }

    public String getPackageMsgType() {
        return packageMsgType;
    }

    public void setPackageMsgType(String packageMsgType) {
        this.packageMsgType = packageMsgType;
    }

    public Byte getTxVersion() {
        return txVersion;
    }

    public void setTxVersion(Byte txVersion) {
        this.txVersion = txVersion;
    }

    public Short getTxMsgType() {
        return txMsgType;
    }

    public void setTxMsgType(Short txMsgType) {
        this.txMsgType = txMsgType;
    }

    public Date getTxMsgDateTime() {
        return txMsgDateTime;
    }

    public void setTxMsgDateTime(Date txMsgDateTime) {
        this.txMsgDateTime = txMsgDateTime;
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
}
