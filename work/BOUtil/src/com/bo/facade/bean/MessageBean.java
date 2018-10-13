package com.bo.facade.bean;

import java.io.Serializable;

public class MessageBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9052031323729616475L;
	private int entityNum;
	private String inventoryNo;
	private String systemCode;
	private String utrNo;
	private String tranRefNo;
	private String messageSubType;
	private String senderIfsc;
	private String controller;
	private String tablePrefix;
	private String serviceRefNum;
	private String processingCode;
	private String stageID;
	private String bizMsgIdr;
	private String srcKey;
	private String msgContent;
	private String mtiExp;
	private String sourceQueue;
	private String fmtHandler;
	
	public String getFmtHandler() {
		return fmtHandler;
	}
	public void setFmtHandler(String fmtHandler) {
		this.fmtHandler = fmtHandler;
	}
	
	public String getMtiExp() {
		return mtiExp;
	}
	public void setMtiExp(String mtiExp) {
		this.mtiExp = mtiExp;
	}
	public String getSourceQueue() {
		return sourceQueue;
	}
	public void setSourceQueue(String sourceQueue) {
		this.sourceQueue = sourceQueue;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getBizMsgIdr() {
		return bizMsgIdr;
	}
	public void setBizMsgIdr(String bizMsgIdr) {
		this.bizMsgIdr = bizMsgIdr;
	}
	public String getSrcKey() {
		return srcKey;
	}
	public void setSrcKey(String srcKey) {
		this.srcKey = srcKey;
	}		
	public String getServiceRefNum() {
		return serviceRefNum;
	}
	public void setServiceRefNum(String serviceRefNum) {
		this.serviceRefNum = serviceRefNum;
	}
	public String getTablePrefix() {
		return tablePrefix;
	}
	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public String getSenderIfsc() {
		return senderIfsc;
	}
	public void setSenderIfsc(String senderIfsc) {
		this.senderIfsc = senderIfsc;
	}
	public String getRecvIfsc() {
		return recvIfsc;
	}
	public void setRecvIfsc(String recvIfsc) {
		this.recvIfsc = recvIfsc;
	}
	private String recvIfsc;

	/**
	 * @param entityNum the entityNum to set
	 */
	public void setEntityNum(int entityNum) {
		this.entityNum = entityNum;
	}
	/**
	 * @return the entityNum
	 */
	public int getEntityNum() {
		return entityNum;
	}
	
	/**
	 * @param inventoryNo the inventoryNo to set
	 */
	public void setInventoryNo(String inventoryNo) {
		this.inventoryNo = inventoryNo;
	}
	/**
	 * @return the inventoryNo
	 */
	public String getInventoryNo() {
		return inventoryNo;
	}
	/**
	 * @param systemCode the systemCode to set
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	/**
	 * @return the systemCode
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * @param utrNo the utrNo to set
	 */
	public void setUtrNo(String utrNo) {
		this.utrNo = utrNo;
	}
	/**
	 * @return the utrNo
	 */
	public String getUtrNo() {
		return utrNo;
	}
	/**
	 * @param tranRefNo the tranRefNo to set
	 */
	public void setTranRefNo(String tranRefNo) {
		this.tranRefNo = tranRefNo;
	}
	/**
	 * @return the tranRefNo
	 */
	public String getTranRefNo() {
		return tranRefNo;
	}
	/**
	 * @param messageSubType the messageSubType to set
	 */
	public void setMessageSubType(String messageSubType) {
		this.messageSubType = messageSubType;
	}
	/**
	 * @return the messageSubType
	 */
	public String getMessageSubType() {
		return messageSubType;
	}
	/**
	 * @param processingCode the processingCode to set
	 */
	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}
	/**
	 * @return the processingCode
	 */
	public String getProcessingCode() {
		return processingCode;
	}
	public void setStageID(String stageID) {
		this.stageID = stageID;
	}
	public String getStageID() {
		return stageID;
	}

}
