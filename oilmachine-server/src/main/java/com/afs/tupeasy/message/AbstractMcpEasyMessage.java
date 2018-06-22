package com.afs.tupeasy.message;


public abstract  class AbstractMcpEasyMessage implements Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String correspondId;
	private byte messageType;
	private byte[] packageHead;
	
	public byte getMessageType() {
		return messageType;
	}
	public void setMessageType(byte messageType) {
		this.messageType = messageType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCorrespondId() {
		return correspondId;
	}
	public void setCorrespondId(String correspondId) {
		this.correspondId = correspondId;
	}
	
	public byte[] getPackageHead() {
		return packageHead;
	}

	public void setPackageHead(byte[] packageHead) {
		this.packageHead = packageHead;
	}
}
