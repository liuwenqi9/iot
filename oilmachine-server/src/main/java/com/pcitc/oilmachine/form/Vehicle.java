package com.pcitc.oilmachine.form;

import java.io.Serializable;

/**
 * 
 */
public class Vehicle implements Serializable{

	private static final long serialVersionUID = 9051600877985045586L;
	private String carcolor;
    private String cartype;
    private String carcolorname;
    private String cartypename;
    private String left;
    private String top;
    private String right;
    private String bottom;
    private String carstatus;  //0静止 1运动
    private String carnum;
    private String cameraid;
    private String userid;//用户ID
    private String username;//用户名
    private String accountid;//电子账户ID
    private String amount;//电子账户余额
    private String useableamount;//本次加油最大可用金额
    private String areacode;//所属区域号
    private String oilconnid;
    private String isVeriFace;//0未开通；1已开通
    private String oiltypecode;//油品型号
    private String pwtype;
    /*
	     * 0:默认人脸,支持密码,验证码
	1: 默认人脸,支持密码,不支持验证码
	2: 默认密码,支持人脸,验证码
	3:默认密码,支持人脸,
	不支持验证码
	4: 默认密码,不支持人脸,支持验证码
	5: 默认密码,不支持人脸,不支持验证码
	     */
    private String lefttopx;
    private String lefttopy;
    private String rightbottomx;
    private String rightbottomy;
    
    public String getLefttopx() {
		return lefttopx;
	}
	public void setLefttopx(String lefttopx) {
		this.lefttopx = lefttopx;
	}
	public String getLefttopy() {
		return lefttopy;
	}
	public void setLefttopy(String lefttopy) {
		this.lefttopy = lefttopy;
	}
	public String getRightbottomx() {
		return rightbottomx;
	}
	public void setRightbottomx(String rightbottomx) {
		this.rightbottomx = rightbottomx;
	}
	public String getRightbottomy() {
		return rightbottomy;
	}
	public void setRightbottomy(String rightbottomy) {
		this.rightbottomy = rightbottomy;
	}
	private String gasstatus;//加油状态:0:未加油 1:加油中
    
    public String getCarcolorname() {
		return carcolorname;
	}
	public void setCarcolorname(String carcolorname) {
		this.carcolorname = carcolorname;
	}
	public String getCartypename() {
		return cartypename;
	}
	public void setCartypename(String cartypename) {
		this.cartypename = cartypename;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUseableamount() {
		return useableamount;
	}
	public void setUseableamount(String useableamount) {
		this.useableamount = useableamount;
	}
	private String needpassword;
	public String getCameraid() {
		return cameraid;
	}
	public void setCameraid(String cameraid) {
		this.cameraid = cameraid;
	}
	public String getNeedpassword() {
		return needpassword;
	}
	public void setNeedpassword(String needpassword) {
		this.needpassword = needpassword;
	}
	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
	public String getBottom() {
		return bottom;
	}
	public void setBottom(String bottom) {
		this.bottom = bottom;
	}
	public String getCarstatus() {
		return carstatus;
	}
	public void setCarstatus(String carstatus) {
		this.carstatus = carstatus;
	}
	public String getCarnum() {
		return carnum;
	}
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getOilconnid() {
		return oilconnid;
	}
	public void setOilconnid(String oilconnid) {
		this.oilconnid = oilconnid;
	}
	public String getIsVeriFace() {
		return isVeriFace;
	}
	public void setIsVeriFace(String isVeriFace) {
		this.isVeriFace = isVeriFace;
	}
	public String getOiltypecode() {
		return oiltypecode;
	}
	public void setOiltypecode(String oiltypecode) {
		this.oiltypecode = oiltypecode;
	}
	public String getPwtype() {
		return pwtype;
	}
	public void setPwtype(String pwtype) {
		this.pwtype = pwtype;
	}
	public String getGasstatus() {
		return gasstatus;
	}
	public void setGasstatus(String gasstatus) {
		this.gasstatus = gasstatus;
	}
}

