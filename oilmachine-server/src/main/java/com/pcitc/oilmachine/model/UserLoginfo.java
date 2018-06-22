package com.pcitc.oilmachine.model;

import java.util.Date;

import com.pcitc.oilmachine.view.Page;

public class UserLoginfo extends Page<UserLoginfo>{
    private String id;

    private String tenantid;

    private String userid;

    private String username;

    private String stncode;

    private String stnname;

    private String ip;

    private String deviceconnid;

    private String areacode;

    private String oilcode;

    private String oilno;

    private String carnum;

    private String nozzleno;

    private String sessionid;

    private Long price;

    private String step;

    private String freepword;

    private Date logintime;

    private Date logouttime;

    private Long lefttopx;

    private Long lefttopy;

    private Long rightbottomx;

    private Long rightbottomy;

    private String carcolor;

    private String cameraid;

    private String cartype;

    private Long cleft;

    private Long ctop;

    private Long cright;

    private Long cbottom;

    private String saleno;

    private String accountid;

    private Long amount;

    private Long useableamount;

    private Long avoidamount;

    private Byte status;

    private Long sorts;

    private String creator;

    private String updateuser;

    private Date updatetime;

    private Date createdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid == null ? null : tenantid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getStncode() {
        return stncode;
    }

    public void setStncode(String stncode) {
        this.stncode = stncode == null ? null : stncode.trim();
    }

    public String getStnname() {
        return stnname;
    }

    public void setStnname(String stnname) {
        this.stnname = stnname == null ? null : stnname.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getDeviceconnid() {
        return deviceconnid;
    }

    public void setDeviceconnid(String deviceconnid) {
        this.deviceconnid = deviceconnid == null ? null : deviceconnid.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getOilcode() {
        return oilcode;
    }

    public void setOilcode(String oilcode) {
        this.oilcode = oilcode == null ? null : oilcode.trim();
    }

    public String getOilno() {
        return oilno;
    }

    public void setOilno(String oilno) {
        this.oilno = oilno == null ? null : oilno.trim();
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum == null ? null : carnum.trim();
    }

    public String getNozzleno() {
        return nozzleno;
    }

    public void setNozzleno(String nozzleno) {
        this.nozzleno = nozzleno == null ? null : nozzleno.trim();
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid == null ? null : sessionid.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step == null ? null : step.trim();
    }

    public String getFreepword() {
        return freepword;
    }

    public void setFreepword(String freepword) {
        this.freepword = freepword == null ? null : freepword.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getLogouttime() {
        return logouttime;
    }

    public void setLogouttime(Date logouttime) {
        this.logouttime = logouttime;
    }

    public Long getLefttopx() {
        return lefttopx;
    }

    public void setLefttopx(Long lefttopx) {
        this.lefttopx = lefttopx;
    }

    public Long getLefttopy() {
        return lefttopy;
    }

    public void setLefttopy(Long lefttopy) {
        this.lefttopy = lefttopy;
    }

    public Long getRightbottomx() {
        return rightbottomx;
    }

    public void setRightbottomx(Long rightbottomx) {
        this.rightbottomx = rightbottomx;
    }

    public Long getRightbottomy() {
        return rightbottomy;
    }

    public void setRightbottomy(Long rightbottomy) {
        this.rightbottomy = rightbottomy;
    }

    public String getCarcolor() {
        return carcolor;
    }

    public void setCarcolor(String carcolor) {
        this.carcolor = carcolor == null ? null : carcolor.trim();
    }

    public String getCameraid() {
        return cameraid;
    }

    public void setCameraid(String cameraid) {
        this.cameraid = cameraid == null ? null : cameraid.trim();
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }

    public Long getCleft() {
        return cleft;
    }

    public void setCleft(Long cleft) {
        this.cleft = cleft;
    }

    public Long getCtop() {
        return ctop;
    }

    public void setCtop(Long ctop) {
        this.ctop = ctop;
    }

    public Long getCright() {
        return cright;
    }

    public void setCright(Long cright) {
        this.cright = cright;
    }

    public Long getCbottom() {
        return cbottom;
    }

    public void setCbottom(Long cbottom) {
        this.cbottom = cbottom;
    }

    public String getSaleno() {
        return saleno;
    }

    public void setSaleno(String saleno) {
        this.saleno = saleno == null ? null : saleno.trim();
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid == null ? null : accountid.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getUseableamount() {
        return useableamount;
    }

    public void setUseableamount(Long useableamount) {
        this.useableamount = useableamount;
    }

    public Long getAvoidamount() {
        return avoidamount;
    }

    public void setAvoidamount(Long avoidamount) {
        this.avoidamount = avoidamount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getSorts() {
        return sorts;
    }

    public void setSorts(Long sorts) {
        this.sorts = sorts;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}