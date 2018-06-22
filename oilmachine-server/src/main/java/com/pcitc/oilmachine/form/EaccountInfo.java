package com.pcitc.oilmachine.form;

public class EaccountInfo {
	
	private String accountid;//账户标识
	private long amount;//余额
	private long useableamount;//冻结金额
	private long avoidamount;//免密金额

	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getUseableamount() {
		return useableamount;
	}
	public void setUseableamount(long useableamount) {
		this.useableamount = useableamount;
	}
	public long getAvoidamount() {
		return avoidamount;
	}
	public void setAvoidamount(long avoidamount) {
		this.avoidamount = avoidamount;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
}
