package com.afs.tupeasy.session;

public class SessionMessage {
	
	private String clientId;
	private String serverName;
	
	//0增加，1删除
	private int addOrRemove = 0;
	
	public int getAddOrRemove() {
		return addOrRemove;
	}

	public void setAddOrRemove(int addOrRemove) {
		this.addOrRemove = addOrRemove;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}



}
