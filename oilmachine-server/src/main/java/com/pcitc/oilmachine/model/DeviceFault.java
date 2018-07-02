package com.pcitc.oilmachine.model;

import java.util.Date;

public class DeviceFault {
    private String id;

    private String nodecode;

    private String nodetag;

    private String tenantid;

    private String deviceconnid;

    private Byte faulttypecode;

    private String faulttypename;

    private Byte codeno;

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

    public String getDeviceconnid() {
        return deviceconnid;
    }

    public void setDeviceconnid(String deviceconnid) {
        this.deviceconnid = deviceconnid == null ? null : deviceconnid.trim();
    }

    public Byte getFaulttypecode() {
        return faulttypecode;
    }

    public void setFaulttypecode(Byte faulttypecode) {
        this.faulttypecode = faulttypecode;
    }

    public String getFaulttypename() {
        return faulttypename;
    }

    public void setFaulttypename(String faulttypename) {
        this.faulttypename = faulttypename == null ? null : faulttypename.trim();
    }

    public Byte getCodeno() {
        return codeno;
    }

    public void setCodeno(Byte codeno) {
        this.codeno = codeno;
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