package com.pcitc.oilmachine.model;

import java.util.Date;

public class PreAuthorization {
    private String id;

    private String tenantid;

    private String userid;

    private String memcardnum;

    private String accountid;

    private String saleno;

    private String approveid;

    private String presqno;

    private Long preamount;

    private String prewcno;

    private String prewcqx;

    private Date sqopetime;

    private Date wcopetime;

    private Date qxopetime;

    private String sqresult;

    private String qxresult;

    private String wcresult;

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

    public String getMemcardnum() {
        return memcardnum;
    }

    public void setMemcardnum(String memcardnum) {
        this.memcardnum = memcardnum == null ? null : memcardnum.trim();
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid == null ? null : accountid.trim();
    }

    public String getSaleno() {
        return saleno;
    }

    public void setSaleno(String saleno) {
        this.saleno = saleno == null ? null : saleno.trim();
    }

    public String getApproveid() {
        return approveid;
    }

    public void setApproveid(String approveid) {
        this.approveid = approveid == null ? null : approveid.trim();
    }

    public String getPresqno() {
        return presqno;
    }

    public void setPresqno(String presqno) {
        this.presqno = presqno == null ? null : presqno.trim();
    }

    public Long getPreamount() {
        return preamount;
    }

    public void setPreamount(Long preamount) {
        this.preamount = preamount;
    }

    public String getPrewcno() {
        return prewcno;
    }

    public void setPrewcno(String prewcno) {
        this.prewcno = prewcno == null ? null : prewcno.trim();
    }

    public String getPrewcqx() {
        return prewcqx;
    }

    public void setPrewcqx(String prewcqx) {
        this.prewcqx = prewcqx == null ? null : prewcqx.trim();
    }

    public Date getSqopetime() {
        return sqopetime;
    }

    public void setSqopetime(Date sqopetime) {
        this.sqopetime = sqopetime;
    }

    public Date getWcopetime() {
        return wcopetime;
    }

    public void setWcopetime(Date wcopetime) {
        this.wcopetime = wcopetime;
    }

    public Date getQxopetime() {
        return qxopetime;
    }

    public void setQxopetime(Date qxopetime) {
        this.qxopetime = qxopetime;
    }

    public String getSqresult() {
        return sqresult;
    }

    public void setSqresult(String sqresult) {
        this.sqresult = sqresult == null ? null : sqresult.trim();
    }

    public String getQxresult() {
        return qxresult;
    }

    public void setQxresult(String qxresult) {
        this.qxresult = qxresult == null ? null : qxresult.trim();
    }

    public String getWcresult() {
        return wcresult;
    }

    public void setWcresult(String wcresult) {
        this.wcresult = wcresult == null ? null : wcresult.trim();
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