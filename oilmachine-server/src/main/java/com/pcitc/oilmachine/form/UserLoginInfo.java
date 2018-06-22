package com.pcitc.oilmachine.form;

import java.math.BigDecimal;
import com.pcitc.oilmachine.view.Page;

/**
 * 用户登录信息及订单产生的环境信息
 */
public class UserLoginInfo extends Page<UserLoginInfo> {

	//初始化识别用户时的信息
	private String userLoginId; //主键 
	private String userid;//用户ID
	private String tenantId; //租户ID
	private String userName; //用户名
	private String ip; //登录ip
	private String devicesid;
	private String areacode;//所属区域号
	private String carnum;//车牌号
	private String stncode;//网点编码
	private int needpassword;//0:需要  1:不需要
		
	//识别用户后,电子钱包支付密码较验通过,签发会话标识
	private String oilcode;//油品编码
	private String oilno;//油品名称
	private String nozzleno;//枪号
	private String sessionid;//会话ID
	private String price;//油品价格
	private String step;//步骤
	private long times;//本次登录时长:用户本次登录到退出系统的时间，单位：秒
	private long loginTime; //登录时间
	private long logoutTime; //退出时间
	private Integer status; //记录删除标志（0-未删除，1-删除）默认0
	private String creator; //创建人
	private String updateUser; //修改人
	private long updateTime; //修改时间
	private long createDate; //创建时间
	
	//加油时车辆所在的安全加油区域信息
    private BigDecimal lefttopx;
    private BigDecimal lefttopy;
    private BigDecimal rightbottomx;
    private BigDecimal rightbottomy;
	
	//加油时车辆所在的区域信息
	private String carcolor;
    private String cameraid;
    private String cartype;
    private String left;
    private String top;
    private String right;
    private String bottom;
    private String saleno;
    
    //电子钱包信息
    private String accountid;//账户标识
	private long amount;//余额
	private long useableamount;//冻结金额
	private long avoidamount;//免密金额

	public String getOilcode() {
		return oilcode;
	}

	public void setOilcode(String oilcode) {
		this.oilcode = oilcode;
	}

	public String getOilno() {
		return oilno;
	}

	public void setOilno(String oilno) {
		this.oilno = oilno;
	}

	public String getStncode() {
		return stncode;
	}

	public void setStncode(String stncode) {
		this.stncode = stncode;
	}

	//标记定义表生成策略的具体设置
	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public long getTimes() {
		return times;
	}

	public void setTimes(long times) {
		this.times = times;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNozzleno() {
		return nozzleno;
	}

	public void setNozzleno(String nozzleno) {
		this.nozzleno = nozzleno;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}

	public long getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(long logoutTime) {
		this.logoutTime = logoutTime;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
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

	public String getCameraid() {
		return cameraid;
	}

	public void setCameraid(String cameraid) {
		this.cameraid = cameraid;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getDevicesid() {
		return devicesid;
	}

	public void setDevicesid(String devicesid) {
		this.devicesid = devicesid;
	}

	public BigDecimal getLefttopx() {
		return lefttopx;
	}

	public void setLefttopx(BigDecimal lefttopx) {
		this.lefttopx = lefttopx;
	}

	public BigDecimal getLefttopy() {
		return lefttopy;
	}

	public void setLefttopy(BigDecimal lefttopy) {
		this.lefttopy = lefttopy;
	}

	public BigDecimal getRightbottomx() {
		return rightbottomx;
	}

	public void setRightbottomx(BigDecimal rightbottomx) {
		this.rightbottomx = rightbottomx;
	}

	public BigDecimal getRightbottomy() {
		return rightbottomy;
	}

	public void setRightbottomy(BigDecimal rightbottomy) {
		this.rightbottomy = rightbottomy;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}


	public int getNeedpassword() {
		return needpassword;
	}

	public void setNeedpassword(int needpassword) {
		this.needpassword = needpassword;
	}

	public String getSaleno() {
		return saleno;
	}

	public void setSaleno(String saleno) {
		this.saleno = saleno;
	}
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

}