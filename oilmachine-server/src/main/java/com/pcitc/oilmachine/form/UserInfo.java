package com.pcitc.oilmachine.form;

public class UserInfo {
	private String userid;
	private String username;
	private String mobilephone;
	private String certtype;
	private String certnum;
	private String sex;
	private String carnum;
	private String tenantid;
	private String photourl;
	private String orgid;
	private String memcardnum;
	private Long preamount;
	private Integer isFreePwd;//是否免密
	private Long freeAmount;//免密金额
	private String gasaccid;//加油预授权账户
	private int isVeriFace;//是否开通人脸 1 开通  其它 未开通
	private String oiltypecode;//油品型号
	
	private EaccountInfo eaccountInfo;
	
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getTenantid() {
		return tenantid;
	}
	public String getPhotourl() {
		return photourl;
	}
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}
	public String getUserid() {
		return userid;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getCerttype() {
		return certtype;
	}
	public void setCerttype(String certtype) {
		this.certtype = certtype;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCertnum() {
		return certnum;
	}
	public void setCertnum(String certnum) {
		this.certnum = certnum;
	}
	private String syssource;
	
	private boolean isadmin;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSyssource() {
		return syssource;
	}
	public void setSyssource(String syssource) {
		this.syssource = syssource;
	}
	public boolean isIsadmin() {
		return isadmin;
	}
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
	public EaccountInfo getEaccountInfo() {
		return eaccountInfo;
	}
	public void setEaccountInfo(EaccountInfo eaccountInfo) {
		this.eaccountInfo = eaccountInfo;
	}
	public String getCarnum() {
		return carnum;
	}
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	public String getMemcardnum() {
		return memcardnum;
	}
	public void setMemcardnum(String memcardnum) {
		this.memcardnum = memcardnum;
	}
	public Long getPreamount() {
		return preamount;
	}
	public void setPreamount(Long preamount) {
		this.preamount = preamount;
	}
	public Integer getIsFreePwd() {
		return isFreePwd;
	}
	public void setIsFreePwd(Integer isFreePwd) {
		this.isFreePwd = isFreePwd;
	}
	public Long getFreeAmount() {
		return freeAmount;
	}
	public void setFreeAmount(Long freeAmount) {
		this.freeAmount = freeAmount;
	}
	public String getGasaccid() {
		return gasaccid;
	}
	public void setGasaccid(String gasaccid) {
		this.gasaccid = gasaccid;
	}
	public int getIsVeriFace() {
		return isVeriFace;
	}
	public void setIsVeriFace(int isVeriFace) {
		this.isVeriFace = isVeriFace;
	}
	public String getOiltypecode() {
		return oiltypecode;
	}
	public void setOiltypecode(String oiltypecode) {
		this.oiltypecode = oiltypecode;
	}
	
	
	
}
