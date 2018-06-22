package com.afs.fasm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 保存数据库
 * @author zhang
 *
 */

public class RunInfoModel  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String equipId;
	private Date dataGatherTime;
	private Date dataReceiveTime;
	
	private Integer workStatus;
	private Integer pm25Flag;
	private Integer pm1;
	private Integer pm25;
	private Integer pm10;
	private Integer co2Flag;
	private Integer co2;
	private Integer indoorFlag;
	private Float temperature;
	private Integer humidity;
	private Integer airIntakeFlag;
	private Float airIntakeTemp;
	private Integer noihUseTime;
	private Integer staticElecUseTime;
	private Integer jadeUseTime;
	private Integer negoUseTime;
	private Integer ledUseTime;
	private Integer heatMode;
	private Long runTime;
	
	private Date crtTime;
	private Date mntTime;
	
	private Integer AirVol;
	
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
	public Date getDataGatherTime() {
		return dataGatherTime;
	}
	public void setDataGatherTime(Date dataGatherTime) {
		this.dataGatherTime = dataGatherTime;
	}
	public Date getDataReceiveTime() {
		return dataReceiveTime;
	}
	public void setDataReceiveTime(Date dataReceiveTime) {
		this.dataReceiveTime = dataReceiveTime;
	}
	public Integer getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(Integer workStatus) {
		this.workStatus = workStatus;
	}
	public Integer getPm25Flag() {
		return pm25Flag;
	}
	public void setPm25Flag(Integer pm25Flag) {
		this.pm25Flag = pm25Flag;
	}
	public Integer getPm1() {
		return pm1;
	}
	public void setPm1(Integer pm1) {
		this.pm1 = pm1;
	}
	public Integer getPm25() {
		return pm25;
	}
	public void setPm25(Integer pm25) {
		this.pm25 = pm25;
	}
	public Integer getPm10() {
		return pm10;
	}
	public void setPm10(Integer pm10) {
		this.pm10 = pm10;
	}
	public Integer getCo2Flag() {
		return co2Flag;
	}
	public void setCo2Flag(Integer co2Flag) {
		this.co2Flag = co2Flag;
	}
	public Integer getIndoorFlag() {
		return indoorFlag;
	}
	public void setIndoorFlag(Integer indoorFlag) {
		this.indoorFlag = indoorFlag;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public Integer getAirIntakeFlag() {
		return airIntakeFlag;
	}
	public void setAirIntakeFlag(Integer airIntakeFlag) {
		this.airIntakeFlag = airIntakeFlag;
	}
	public Integer getStaticElecUseTime() {
		return staticElecUseTime;
	}
	public void setStaticElecUseTime(Integer staticElecUseTime) {
		this.staticElecUseTime = staticElecUseTime;
	}
	public Integer getJadeUseTime() {
		return jadeUseTime;
	}
	public void setJadeUseTime(Integer jadeUseTime) {
		this.jadeUseTime = jadeUseTime;
	}
	public Integer getNegoUseTime() {
		return negoUseTime;
	}
	public void setNegoUseTime(Integer negoUseTime) {
		this.negoUseTime = negoUseTime;
	}
	public Integer getLedUseTime() {
		return ledUseTime;
	}
	public void setLedUseTime(Integer ledUseTime) {
		this.ledUseTime = ledUseTime;
	}
	public Integer getHeatMode() {
		return heatMode;
	}
	public void setHeatMode(Integer heatMode) {
		this.heatMode = heatMode;
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
	public Integer getNoihUseTime() {
		return noihUseTime;
	}
	public void setNoihUseTime(Integer noihUseTime) {
		this.noihUseTime = noihUseTime;
	}
	public Long getRunTime() {
		return runTime;
	}
	public void setRunTime(Long runTime) {
		this.runTime = runTime;
	}
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public Float getAirIntakeTemp() {
		return airIntakeTemp;
	}
	public void setAirIntakeTemp(Float airIntakeTemp) {
		this.airIntakeTemp = airIntakeTemp;
	}
	public Integer getCo2() {
		return co2;
	}
	public void setCo2(Integer co2) {
		this.co2 = co2;
	}
	public Integer getAirVol() {
		return AirVol;
	}
	public void setAirVol(Integer airVol) {
		AirVol = airVol;
	}
}
