package com.pcitc.oilmachine.model;

import java.math.BigDecimal;
import java.util.Date;

import com.pcitc.oilmachine.view.Page;

public class Devices extends Page<Devices>{
    private String devicesid;

    private String nodecode;

    private String nodetag;

    private String tenantid;

    private String devicestypecode;

    private String devicestypename;

    private String buid;

    private String bucode;

    private String buname;

    private Byte connstatus;

    private Byte selfservice;

    private String receivedata;

    private Byte deviceareanum;

    private String connid;

    private String conname;

    private BigDecimal xlength;

    private BigDecimal ylength;

    private Byte status;

    private String publickey;

    private String privatekey;

    private Long sorts;

    private String creator;

    private String updateuser;

    private Date updatetime;

    private Date createdate;

    public String getDevicesid() {
        return devicesid;
    }

    public void setDevicesid(String devicesid) {
        this.devicesid = devicesid == null ? null : devicesid.trim();
    }

    public String getNodecode() {
        return nodecode;
    }

    public void setNodecode(String nodecode) {
        this.nodecode = nodecode == null ? null : nodecode.trim();
    }

    public String getNodetag() {
        return nodetag;
    }

    public void setNodetag(String nodetag) {
        this.nodetag = nodetag == null ? null : nodetag.trim();
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid == null ? null : tenantid.trim();
    }

    public String getDevicestypecode() {
        return devicestypecode;
    }

    public void setDevicestypecode(String devicestypecode) {
        this.devicestypecode = devicestypecode == null ? null : devicestypecode.trim();
    }

    public String getDevicestypename() {
        return devicestypename;
    }

    public void setDevicestypename(String devicestypename) {
        this.devicestypename = devicestypename == null ? null : devicestypename.trim();
    }

    public String getBuid() {
        return buid;
    }

    public void setBuid(String buid) {
        this.buid = buid == null ? null : buid.trim();
    }

    public String getBucode() {
        return bucode;
    }

    public void setBucode(String bucode) {
        this.bucode = bucode == null ? null : bucode.trim();
    }

    public String getBuname() {
        return buname;
    }

    public void setBuname(String buname) {
        this.buname = buname == null ? null : buname.trim();
    }

    public Byte getConnstatus() {
        return connstatus;
    }

    public void setConnstatus(Byte connstatus) {
        this.connstatus = connstatus;
    }

    public Byte getSelfservice() {
        return selfservice;
    }

    public void setSelfservice(Byte selfservice) {
        this.selfservice = selfservice;
    }

    public String getReceivedata() {
        return receivedata;
    }

    public void setReceivedata(String receivedata) {
        this.receivedata = receivedata == null ? null : receivedata.trim();
    }

    public Byte getDeviceareanum() {
        return deviceareanum;
    }

    public void setDeviceareanum(Byte deviceareanum) {
        this.deviceareanum = deviceareanum;
    }

    public String getConnid() {
        return connid;
    }

    public void setConnid(String connid) {
        this.connid = connid == null ? null : connid.trim();
    }

    public String getConname() {
        return conname;
    }

    public void setConname(String conname) {
        this.conname = conname == null ? null : conname.trim();
    }

    public BigDecimal getXlength() {
        return xlength;
    }

    public void setXlength(BigDecimal xlength) {
        this.xlength = xlength;
    }

    public BigDecimal getYlength() {
        return ylength;
    }

    public void setYlength(BigDecimal ylength) {
        this.ylength = ylength;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey == null ? null : publickey.trim();
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey == null ? null : privatekey.trim();
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