package com.pcitc.oilmachine.model;

import java.util.Date;

public class AdInfoTags {
    private String adinfotagsid;

    private String tenantid;

    private String adtagcode;

    private String tagname;

    private String adinfoid;

    private String adname;

    private Byte status;

    private Long sorts;

    private String creator;

    private String updateuser;

    private Date updatetime;

    private Date createdate;

    public String getAdinfotagsid() {
        return adinfotagsid;
    }

    public void setAdinfotagsid(String adinfotagsid) {
        this.adinfotagsid = adinfotagsid == null ? null : adinfotagsid.trim();
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid == null ? null : tenantid.trim();
    }

    public String getAdtagcode() {
        return adtagcode;
    }

    public void setAdtagcode(String adtagcode) {
        this.adtagcode = adtagcode == null ? null : adtagcode.trim();
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }

    public String getAdinfoid() {
        return adinfoid;
    }

    public void setAdinfoid(String adinfoid) {
        this.adinfoid = adinfoid == null ? null : adinfoid.trim();
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname == null ? null : adname.trim();
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