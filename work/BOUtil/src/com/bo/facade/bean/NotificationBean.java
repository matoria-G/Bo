package com.bo.facade.bean;

public class NotificationBean {
	
	private String messageSubType;
	private	String tranRefNum;
	private	String utrNum;
	private String senderIFSC;
	private String receiverIFSC;	
	private String formatCode;
	private int responseType;
	private String fileInventoryNumber;
	private String fileName;
	
	public int getResponseType() {
		return responseType;
	}
	public void setResponseType(int responseType) {
		this.responseType = responseType;
	}
	public String getFormatCode() {
		return formatCode;
	}
	public void setFormatCode(String formatCode) {
		this.formatCode = formatCode;
	}
	public String getSourceKey() {
		return sourceKey;
	}
	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}
	public String getProcessingCode() {
		return processingCode;
	}
	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}
	private String sourceKey;
	private String processingCode;
	
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
	 * @param tranRefNum the tranRefNum to set
	 */
	public void setTranRefNum(String tranRefNum) {
		this.tranRefNum = tranRefNum;
	}
	/**
	 * @return the tranRefNum
	 */
	public String getTranRefNum() {
		return tranRefNum;
	}
	/**
	 * @param utrNum the utrNum to set
	 */
	public void setUtrNum(String utrNum) {
		this.utrNum = utrNum;
	}
	/**
	 * @return the utrNum
	 */
	public String getUtrNum() {
		return utrNum;
	}
	/**
	 * @param senderIFSC the senderIFSC to set
	 */
	public void setSenderIFSC(String senderIFSC) {
		this.senderIFSC = senderIFSC;
	}
	/**
	 * @return the senderIFSC
	 */
	public String getSenderIFSC() {
		return senderIFSC;
	}
	/**
	 * @param receiverIFSC the receiverIFSC to set
	 */
	public void setReceiverIFSC(String receiverIFSC) {
		this.receiverIFSC = receiverIFSC;
	}
	/**
	 * @return the receiverIFSC
	 */
	
	public String getReceiverIFSC() {
		return receiverIFSC;
	}
	
	public String getFileInventoryNumber() {
		return fileInventoryNumber;
	}
	public void setFileInventoryNumber(String fileInventoryNumber) {
		this.fileInventoryNumber = fileInventoryNumber;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
