package com.tota.outside.rpc.api.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RechargeMessage extends Message {

    private Integer unitId;
    private Long localSequence;
    private Byte transType;
    private Long posId;
    private Long samId;
    private Long posSequence;
    private Long termId;
    private Long operId;
    private Long edCardId;

    private Long    cardId;
    private String  cardAuthCode;
    private Integer cardCnt;
    private Byte    cardMKnd;
    private Byte    cardSKnd;
    private Byte    cardModel;
    private Short   reloadCnt;
    private Long    befBalance;
    private Long    origAmt;
    private Long    txnAmt;
    private Long    handingCharge;
    private Long    deposit;
    private Long    cardValDate;
    private Long    tradeBeginDate;
    private Long    tradeEndDate;

    @DateTimeFormat(pattern="yyyyMMdd")
    private Date    txnDate;

    @DateTimeFormat(pattern="HHmmss")
    private Date    txnTime;
    private Short   cityCode;
    private Byte    cardVerNo;

    @DateTimeFormat(pattern="yyyyMMdd")
    private Date    settDate;
    private Integer batchNo;
    private String  authSeq;
    private Long    limitedAuthSeql;
    private Long    lastPosSvSeq;
    private Short   lastTxnType;
    private Long    lastPosId;
    private Long    LastTxnAmt;
    private Integer lastCrdCnt;
    private Integer lastTxnTime;
    private Integer lastaftamt;
    private Integer lasttac;
    private String  reserved;
    private String  tac;
    private Integer txnResponse;

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

    public Byte getTransType() {
        return transType;
    }

    public void setTransType(Byte transType) {
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

    public Long getPosSequence() {
        return posSequence;
    }

    public void setPosSequence(Long posSequence) {
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

    public String getCardAuthCode() {
        return cardAuthCode;
    }

    public void setCardAuthCode(String cardAuthCode) {
        this.cardAuthCode = cardAuthCode;
    }

    public Integer getCardCnt() {
        return cardCnt;
    }

    public void setCardCnt(Integer cardCnt) {
        this.cardCnt = cardCnt;
    }

    public Byte getCardMKnd() {
        return cardMKnd;
    }

    public void setCardMKnd(Byte cardMKnd) {
        this.cardMKnd = cardMKnd;
    }

    public Byte getCardSKnd() {
        return cardSKnd;
    }

    public void setCardSKnd(Byte cardSKnd) {
        this.cardSKnd = cardSKnd;
    }

    public Byte getCardModel() {
        return cardModel;
    }

    public void setCardModel(Byte cardModel) {
        this.cardModel = cardModel;
    }

    public Short getReloadCnt() {
        return reloadCnt;
    }

    public void setReloadCnt(Short reloadCnt) {
        this.reloadCnt = reloadCnt;
    }

    public Long getBefBalance() {
        return befBalance;
    }

    public void setBefBalance(Long befBalance) {
        this.befBalance = befBalance;
    }

    public Long getOrigAmt() {
        return origAmt;
    }

    public void setOrigAmt(Long origAmt) {
        this.origAmt = origAmt;
    }

    public Long getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(Long txnAmt) {
        this.txnAmt = txnAmt;
    }

    public Long getHandingCharge() {
        return handingCharge;
    }

    public void setHandingCharge(Long handingCharge) {
        this.handingCharge = handingCharge;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Long getCardValDate() {
        return cardValDate;
    }

    public void setCardValDate(Long cardValDate) {
        this.cardValDate = cardValDate;
    }

    public Long getTradeBeginDate() {
        return tradeBeginDate;
    }

    public void setTradeBeginDate(Long tradeBeginDate) {
        this.tradeBeginDate = tradeBeginDate;
    }

    public Long getTradeEndDate() {
        return tradeEndDate;
    }

    public void setTradeEndDate(Long tradeEndDate) {
        this.tradeEndDate = tradeEndDate;
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

    public Byte getCardVerNo() {
        return cardVerNo;
    }

    public void setCardVerNo(Byte cardVerNo) {
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

    public String getAuthSeq() {
        return authSeq;
    }

    public void setAuthSeq(String authSeq) {
        this.authSeq = authSeq;
    }

    public Long getLimitedAuthSeql() {
        return limitedAuthSeql;
    }

    public void setLimitedAuthSeql(Long limitedAuthSeql) {
        this.limitedAuthSeql = limitedAuthSeql;
    }

    public Long getLastPosSvSeq() {
        return lastPosSvSeq;
    }

    public void setLastPosSvSeq(Long lastPosSvSeq) {
        this.lastPosSvSeq = lastPosSvSeq;
    }

    public Short getLastTxnType() {
        return lastTxnType;
    }

    public void setLastTxnType(Short lastTxnType) {
        this.lastTxnType = lastTxnType;
    }

    public Long getLastPosId() {
        return lastPosId;
    }

    public void setLastPosId(Long lastPosId) {
        this.lastPosId = lastPosId;
    }

    public Long getLastTxnAmt() {
        return LastTxnAmt;
    }

    public void setLastTxnAmt(Long lastTxnAmt) {
        LastTxnAmt = lastTxnAmt;
    }

    public Integer getLastCrdCnt() {
        return lastCrdCnt;
    }

    public void setLastCrdCnt(Integer lastCrdCnt) {
        this.lastCrdCnt = lastCrdCnt;
    }

    public Integer getLastTxnTime() {
        return lastTxnTime;
    }

    public void setLastTxnTime(Integer lastTxnTime) {
        this.lastTxnTime = lastTxnTime;
    }

    public Integer getLastaftamt() {
        return lastaftamt;
    }

    public void setLastaftamt(Integer lastaftamt) {
        this.lastaftamt = lastaftamt;
    }

    public Integer getLasttac() {
        return lasttac;
    }

    public void setLasttac(Integer lasttac) {
        this.lasttac = lasttac;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    public Integer getTxnResponse() {
        return txnResponse;
    }

    public void setTxnResponse(Integer txnResponse) {
        this.txnResponse = txnResponse;
    }
}
