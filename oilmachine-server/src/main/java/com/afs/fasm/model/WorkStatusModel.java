package com.afs.fasm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 保存数据库
 * @author zhang
 *
 */
public class WorkStatusModel  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -710197987699050570L;

	private Integer id;
	
	private String equipId;
	
	private int WorkStatus;
	private Date dataReceiveTime;
	private Date crtTime;
	private Date mntTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEquipId() {
		return equipId;
	}
	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}
	public int getWorkStatus() {
		return WorkStatus;
	}
	public void setWorkStatus(int workStatus) {
		WorkStatus = workStatus;
	}
	public Date getCrtTime() {
		return crtTime;
	}
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	public Date getMntTime() {
		return mntTime;
	}
	public void setMntTime(Date mntTime) {
		this.mntTime = mntTime;
	}
	public Date getDataReceiveTime() {
		return dataReceiveTime;
	}
	public void setDataReceiveTime(Date dataReceiveTime) {
		this.dataReceiveTime = dataReceiveTime;
	}
	
	
}
