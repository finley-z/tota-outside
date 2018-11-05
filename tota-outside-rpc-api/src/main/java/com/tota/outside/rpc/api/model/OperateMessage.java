package com.tota.outside.rpc.api.model;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OperateMessage extends Message {

    private Integer unitId;
    private Long posId;
    private Long samId;
    private Long posSequence;
    private Long termId;
    private Long operId;
    private Long edCardId;
    private Short cardOprType;
    private Short cityCode;
    private Long cardId;
    private Byte cardMKnd;
    private Byte cardSKnd;
    private Byte cardModel;
    private Byte transType;
    private String cardCSN;
    private String cardMac;
    @DateTimeFormat(pattern="yyyyMMddHHmmss")
    private Date sysDatetime;
    private Byte keyCnt;
    private String sectorID;
    private String keySet;
    private String tacKeySet;
    private Long deposit;
    private Long origAmt;
    private Long reloadBal;
    private Long cardValDate;
    private String mac2;
    private Long srcBal;
    private Integer cardSeq;
    private Byte keyVer;
    private Integer algInd;
    private String cardRand;
    private String mac1;
    private Short commandLen;
    private String command;
    private String dicMac;
    private String divData;
    @DateTimeFormat(pattern="yyyyMMdd")
    private Date settDate;
    private Integer batchNo;
    private Long authSeq;
    private Long limitedAuthSeql;

    private String reserved;
    private String responseCode_Body;

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
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

    public Short getCardOprType() {
        return cardOprType;
    }

    public void setCardOprType(Short cardOprType) {
        this.cardOprType = cardOprType;
    }

    public Short getCityCode() {
        return cityCode;
    }

    public void setCityCode(Short cityCode) {
        this.cityCode = cityCode;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
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

    public Byte getTransType() {
        return transType;
    }

    public void setTransType(Byte transType) {
        this.transType = transType;
    }

    public String getCardCSN() {
        return cardCSN;
    }

    public void setCardCSN(String cardCSN) {
        this.cardCSN = cardCSN;
    }

    public String getCardMac() {
        return cardMac;
    }

    public void setCardMac(String cardMac) {
        this.cardMac = cardMac;
    }

    public Date getSysDatetime() {
        return sysDatetime;
    }

    public void setSysDatetime(Date sysDatetime) {
        this.sysDatetime = sysDatetime;
    }

    public Byte getKeyCnt() {
        return keyCnt;
    }

    public void setKeyCnt(Byte keyCnt) {
        this.keyCnt = keyCnt;
    }

    public String getSectorID() {
        return sectorID;
    }

    public void setSectorID(String sectorID) {
        this.sectorID = sectorID;
    }

    public String getKeySet() {
        return keySet;
    }

    public void setKeySet(String keySet) {
        this.keySet = keySet;
    }

    public String getTacKeySet() {
        return tacKeySet;
    }

    public void setTacKeySet(String tacKeySet) {
        this.tacKeySet = tacKeySet;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Long getOrigAmt() {
        return origAmt;
    }

    public void setOrigAmt(Long origAmt) {
        this.origAmt = origAmt;
    }

    public Long getReloadBal() {
        return reloadBal;
    }

    public void setReloadBal(Long reloadBal) {
        this.reloadBal = reloadBal;
    }

    public Long getCardValDate() {
        return cardValDate;
    }

    public void setCardValDate(Long cardValDate) {
        this.cardValDate = cardValDate;
    }

    public String getMac2() {
        return mac2;
    }

    public void setMac2(String mac2) {
        this.mac2 = mac2;
    }

    public Long getSrcBal() {
        return srcBal;
    }

    public void setSrcBal(Long srcBal) {
        this.srcBal = srcBal;
    }

    public Integer getCardSeq() {
        return cardSeq;
    }

    public void setCardSeq(Integer cardSeq) {
        this.cardSeq = cardSeq;
    }

    public Byte getKeyVer() {
        return keyVer;
    }

    public void setKeyVer(Byte keyVer) {
        this.keyVer = keyVer;
    }

    public Integer getAlgInd() {
        return algInd;
    }

    public void setAlgInd(Integer algInd) {
        this.algInd = algInd;
    }

    public String getCardRand() {
        return cardRand;
    }

    public void setCardRand(String cardRand) {
        this.cardRand = cardRand;
    }

    public String getMac1() {
        return mac1;
    }

    public void setMac1(String mac1) {
        this.mac1 = mac1;
    }

    public Short getCommandLen() {
        return commandLen;
    }

    public void setCommandLen(Short commandLen) {
        this.commandLen = commandLen;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDicMac() {
        return dicMac;
    }

    public void setDicMac(String dicMac) {
        this.dicMac = dicMac;
    }

    public String getDivData() {
        return divData;
    }

    public void setDivData(String divData) {
        this.divData = divData;
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

    public Long getLimitedAuthSeql() {
        return limitedAuthSeql;
    }

    public void setLimitedAuthSeql(Long limitedAuthSeql) {
        this.limitedAuthSeql = limitedAuthSeql;
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
