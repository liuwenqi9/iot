package com.pcitc.oilmachine.form;

import com.pcitc.oilmachine.view.Page;

public class SystemLog extends Page<SystemLog> {

	private Integer logtype;//0普通日志,1错误日志
	private Integer logmodule;//0摄像头采集数据日志  1:用户认证日志  3:..
	private String remark;//备注
	private String logmsg;//日志内容
	private long createdate;
	private String creator;
	public long getCreatedate() {
		return createdate;
	}
	public void setCreatedate(long createdate) {
		this.createdate = createdate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Integer getLogtype() {
		return logtype;
	}
	public void setLogtype(Integer logtype) {
		this.logtype = logtype;
	}
	public Integer getLogmodule() {
		return logmodule;
	}
	public void setLogmodule(Integer logmodule) {
		this.logmodule = logmodule;
	}
	public String getLogmsg() {
		return logmsg;
	}
	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
