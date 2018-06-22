package com.pcitc.oilmachine.form;

public class MobileDataInfo {
	
	private String randomcode;
	private String assistdata;
	private String data;
	private String funName;
	private String signid;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getRandomcode() {
		return randomcode;
	}

	public void setRandomcode(String randomcode) {
		this.randomcode = randomcode;
	}

	public String getAssistdata() {
		return assistdata;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public void setAssistdata(String assistdata) {
		this.assistdata = assistdata;
	}

	public String getSignid() {
		return signid;
	}

	public void setSignid(String signid) {
		this.signid = signid;
	}

}
