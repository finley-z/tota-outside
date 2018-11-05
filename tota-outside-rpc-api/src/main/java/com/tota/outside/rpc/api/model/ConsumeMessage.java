package com.tota.outside.rpc.api.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ConsumeMessage extends Message {

    private Integer unitId;
    private Long localSequence;
    private Short transType;
    private Long posId;
    private Long samId;
    private Integer posSequence;
    private Long termId;
    private Long operId;
    private Long edCardId;
    private Long cardId;
    private Integer cardCnt;
    private Short cardMKnd;
    private Short cardSKind;
    private Short cardModel;
    private Integer befBalance;
    private Integer txnAmt;
    private Integer origAmt;
    private Integer cardValDate;
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date txnDate;
    @DateTimeFormat(pattern="HHmmss")
    private Date txnTime;
    private Short cityCode;
    private Short cardVerNo;
    @DateTimeFormat(pattern="yyyyMMdd")
    private Date settDate;
    private Integer batchNo;
    private Long authSeq;
    private String reserved;
    private String TAC;
    private String responseCode_Body;

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Long getLocalSequence() {
        return localSequence;
    }

    public void setLocalSequence(Long localSequence) {
        this.localSequence = localSequence;
    }

    public Short getTransType() {
        return transType;
    }

    public void setTransType(Short transType) {
        this.transType = transType;
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

    public Integer getPosSequence() {
        return posSequence;
    }

    public void setPosSequence(Integer posSequence) {
        this.posSequence = posSequence;
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

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Integer getCardCnt() {
        return cardCnt;
    }

    public void setCardCnt(Integer cardCnt) {
        this.cardCnt = cardCnt;
    }

    public Short getCardMKnd() {
        return cardMKnd;
    }

    public void setCardMKnd(Short cardMKnd) {
        this.cardMKnd = cardMKnd;
    }

    public Short getCardSKind() {
        return cardSKind;
    }

    public void setCardSKind(Short cardSKind) {
        this.cardSKind = cardSKind;
    }

    public Short getCardModel() {
        return cardModel;
    }

    public void setCardModel(Short cardModel) {
        this.cardModel = cardModel;
    }

    public Integer getBefBalance() {
        return befBalance;
    }

    public void setBefBalance(Integer befBalance) {
        this.befBalance = befBalance;
    }

    public Integer getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(Integer txnAmt) {
        this.txnAmt = txnAmt;
    }

    public Integer getOrigAmt() {
        return origAmt;
    }

    public void setOrigAmt(Integer origAmt) {
        this.origAmt = origAmt;
    }

    public Integer getCardValDate() {
        return cardValDate;
    }

    public void setCardValDate(Integer cardValDate) {
        this.cardValDate = cardValDate;
    }

    public Date getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    public Date getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(Date txnTime) {
        this.txnTime = txnTime;
    }

    public Short getCityCode() {
        return cityCode;
    }

    public void setCityCode(Short cityCode) {
        this.cityCode = cityCode;
    }

    public Short getCardVerNo() {
        return cardVerNo;
    }

    public void setCardVerNo(Short cardVerNo) {
        this.cardVerNo = cardVerNo;
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

    public Long getAuthSeq() {
        return authSeq;
    }

    public void setAuthSeq(Long authSeq) {
        this.authSeq = authSeq;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getTAC() {
        return TAC;
    }

    public void setTAC(String TAC) {
        this.TAC = TAC;
    }

    public String getResponseCode_Body() {
        return responseCode_Body;
    }

    public void setResponseCode_Body(String responseCode_Body) {
        this.responseCode_Body = responseCode_Body;
    }
}
