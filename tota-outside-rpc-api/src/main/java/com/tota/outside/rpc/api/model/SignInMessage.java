package com.tota.outside.rpc.api.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SignInMessage  extends  Message{
    private Integer  unitId;
    private Byte     txnMode;
    private Long     samId;
    private Long     samAuthInfo;
    private Long     edAuthInfo;
    private Long     posId;
    private Long     termId;
    private Long     operId;
    private Long     edCardId;

    @DateTimeFormat(pattern="yyyyMMdd")
    private Date     settDate;
    private Integer  batchNo;

    @DateTimeFormat(pattern="yyyyMMddHHmmss")
    private Date     sysDateTime;
    private String   authCode;
    private String   paramBit;
    private String   keySet;
    private String   reserved;
    private Integer  responseCode_Body;

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Byte getTxnMode() {
        return txnMode;
    }

    public void setTxnMode(Byte txnMode) {
        this.txnMode = txnMode;
    }

    public Long getSamId() {
        return samId;
    }

    public void setSamId(Long samId) {
        this.samId = samId;
    }

    public Long getEdAuthInfo() {
        return edAuthInfo;
    }

    public void setEdAuthInfo(Long edAuthInfo) {
        this.edAuthInfo = edAuthInfo;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public Long getEdCardId() {
        return edCardId;
    }

    public void setEdCardId(Long edCardId) {
        this.edCardId = edCardId;
    }

    public Date getSettDate() {
        return settDate;
    }

    public void setSettDate(Date settDate) {
        this.settDate = settDate;
    }

    public Integer getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Integer batchNo) {
        this.batchNo = batchNo;
    }

    public Date getSysDateTime() {
        return sysDateTime;
    }

    public void setSysDateTime(Date sysDateTime) {
        this.sysDateTime = sysDateTime;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getParamBit() {
        return paramBit;
    }

    public void setParamBit(String paramBit) {
        this.paramBit = paramBit;
    }

    public String getKeySet() {
        return keySet;
    }

    public void setKeySet(String keySet) {
        this.keySet = keySet;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public Integer getResponseCode_Body() {
        return responseCode_Body;
    }

    public void setResponseCode_Body(Integer responseCode_Body) {
        this.responseCode_Body = responseCode_Body;
    }

    public Long getSamAuthInfo() {
        return samAuthInfo;
    }

    public void setSamAuthInfo(Long samAuthInfo) {
        this.samAuthInfo = samAuthInfo;
    }
}
