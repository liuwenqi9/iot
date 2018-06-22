package com.afs.base.model;

import java.util.Date;

public class MqQueuedata {
    private String queuedataid;

    private String queueid;

    private String matchkey;

    private Byte matchtype;

    private String matchvalue;

    private String rangelowvalue;

    private Byte status;

    private Short sorts;

    private String creator;

    private String updateuser;

    private Date updatetime;

    private Date createdate;

    private String accountid;

    public String getQueuedataid() {
        return queuedataid;
    }

    public void setQueuedataid(String queuedataid) {
        this.queuedataid = queuedataid == null ? null : queuedataid.trim();
    }

    public String getQueueid() {
        return queueid;
    }

    public void setQueueid(String queueid) {
        this.queueid = queueid == null ? null : queueid.trim();
    }

    public String getMatchkey() {
        return matchkey;
    }

    public void setMatchkey(String matchkey) {
        this.matchkey = matchkey == null ? null : matchkey.trim();
    }

    public Byte getMatchtype() {
        return matchtype;
    }

    public void setMatchtype(Byte matchtype) {
        this.matchtype = matchtype;
    }

    public String getMatchvalue() {
        return matchvalue;
    }

    public void setMatchvalue(String matchvalue) {
        this.matchvalue = matchvalue == null ? null : matchvalue.trim();
    }

    public String getRangelowvalue() {
        return rangelowvalue;
    }

    public void setRangelowvalue(String rangelowvalue) {
        this.rangelowvalue = rangelowvalue == null ? null : rangelowvalue.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Short getSorts() {
        return sorts;
    }

    public void setSorts(Short sorts) {
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

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid == null ? null : accountid.trim();
    }
}