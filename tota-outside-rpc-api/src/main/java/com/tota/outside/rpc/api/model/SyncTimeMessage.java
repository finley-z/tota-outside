package com.tota.outside.rpc.api.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SyncTimeMessage extends Message {

    @DateTimeFormat(pattern="yyyyMMddHHmmss")
    private Date locDateTime;
    private Long posId;
    private Long samId;
    private Long operId;
    private String reserved;
    private Integer responseCode_Body;

    public Date getLocDateTime() {
        return locDateTime;
    }

    public void setLocDateTime(Date locDateTime) {
        this.locDateTime = locDateTime;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public Long getSamId() {
        return samId;
    }

    public void setSamId(Long samId) {
        this.samId = samId;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
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
}
