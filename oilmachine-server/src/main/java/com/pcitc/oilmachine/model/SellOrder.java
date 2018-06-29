package com.pcitc.oilmachine.model;

import java.util.Date;

import com.pcitc.oilmachine.view.Page;

public class SellOrder extends Page<SellOrder>{
    private String id;

    private String tenantid;

    private String userid;

    private String carnum;

    private String stncode;

    private String stnname;

    private String saleno;

    private Date opetime;

    private String deviceid;

    private String nozzleno;

    private Long ystotal;

    private Long sstotal;

    private Long yhtotal;

    private String paytypecode;

    private String paytypename;

    private String accountid;

    private String payorderno;

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

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum == null ? null : carnum.trim();
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

    public String getSaleno() {
        return saleno;
    }

    public void setSaleno(String saleno) {
        this.saleno = saleno == null ? null : saleno.trim();
    }

    public Date getOpetime() {
        return opetime;
    }

    public void setOpetime(Date opetime) {
        this.opetime = opetime;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid == null ? null : deviceid.trim();
    }

    public String getNozzleno() {
        return nozzleno;
    }

    public void setNozzleno(String nozzleno) {
        this.nozzleno = nozzleno == null ? null : nozzleno.trim();
    }

    public Long getYstotal() {
        return ystotal;
    }

    public void setYstotal(Long ystotal) {
        this.ystotal = ystotal;
    }

    public Long getSstotal() {
        return sstotal;
    }

    public void setSstotal(Long sstotal) {
        this.sstotal = sstotal;
    }

    public Long getYhtotal() {
        return yhtotal;
    }

    public void setYhtotal(Long yhtotal) {
        this.yhtotal = yhtotal;
    }

    public String getPaytypecode() {
        return paytypecode;
    }

    public void setPaytypecode(String paytypecode) {
        this.paytypecode = paytypecode == null ? null : paytypecode.trim();
    }

    public String getPaytypename() {
        return paytypename;
    }

    public void setPaytypename(String paytypename) {
        this.paytypename = paytypename == null ? null : paytypename.trim();
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid == null ? null : accountid.trim();
    }

    public String getPayorderno() {
        return payorderno;
    }

    public void setPayorderno(String payorderno) {
        this.payorderno = payorderno == null ? null : payorderno.trim();
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