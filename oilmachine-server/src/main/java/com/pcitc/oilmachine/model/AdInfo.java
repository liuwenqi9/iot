package com.pcitc.oilmachine.model;

import java.util.Date;

import com.pcitc.oilmachine.view.Page;

public class AdInfo extends Page<AdInfo>{
    private String adinfoid;

    private String tenantid;

    private String buid;

    private String bucode;

    private String buname;

    private String adname;

    private Date expirydate;

    private Byte isuse;

    private Long version;

    private Byte status;

    private Long sorts;

    private String creator;

    private String updateuser;

    private Date updatetime;

    private Date createdate;

    private String sinopecnodeno;

    private Byte isreview;

    private String custtype;

    private String confidence;

    public String getAdinfoid() {
        return adinfoid;
    }

    public void setAdinfoid(String adinfoid) {
        this.adinfoid = adinfoid == null ? null : adinfoid.trim();
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid == null ? null : tenantid.trim();
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

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname == null ? null : adname.trim();
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public Byte getIsuse() {
        return isuse;
    }

    public void setIsuse(Byte isuse) {
        this.isuse = isuse;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public String getSinopecnodeno() {
        return sinopecnodeno;
    }

    public void setSinopecnodeno(String sinopecnodeno) {
        this.sinopecnodeno = sinopecnodeno == null ? null : sinopecnodeno.trim();
    }

    public Byte getIsreview() {
        return isreview;
    }

    public void setIsreview(Byte isreview) {
        this.isreview = isreview;
    }

    public String getCusttype() {
        return custtype;
    }

    public void setCusttype(String custtype) {
        this.custtype = custtype == null ? null : custtype.trim();
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence == null ? null : confidence.trim();
    }
}