package com.tota.outside.rpc.api.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SignOutMessage extends Message{

    private Integer unitId;
    private Byte txnMode;
    private Long samId;
    private Long posId;
    private Long termId;
    private Long operId;
    private Long edCardId;

    @DateTimeFormat(pattern="yyyyMMdd")
    private Date settDate;
    private Integer batchNo;

    private Long totalSvNum;
    private Long totalSvAmt;
    private Long totalSaleDep;

    private String reserved;
    private String responseCode_Body;

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

    public Long getTotalSvNum() {
        return totalSvNum;
    }

    public void setTotalSvNum(Long totalSvNum) {
        this.totalSvNum = totalSvNum;
    }

    public Long getTotalSvAmt() {
        return totalSvAmt;
    }

    public void setTotalSvAmt(Long totalSvAmt) {
        this.totalSvAmt = totalSvAmt;
    }

    public Long getTotalSaleDep() {
        return totalSaleDep;
    }

    public void setTotalSaleDep(Long totalSaleDep) {
        this.totalSaleDep = totalSaleDep;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getResponseCode_Body() {
        return responseCode_Body;
    }

    public void setResponseCode_Body(String responseCode_Body) {
        this.responseCode_Body = responseCode_Body;
    }
}
