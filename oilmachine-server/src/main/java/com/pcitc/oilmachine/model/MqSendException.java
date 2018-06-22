package com.pcitc.oilmachine.model;

import java.util.Date;

import com.pcitc.oilmachine.view.Page;

public class MqSendException extends Page<MqSendException>{
    private String mqsendexceptionid;

    private String userid;

    private String foreignkeyid;

    private String tenantid;

    private String typecode;

    private String sendmsg;

    private String exmsg;

    private String methodname;

    private Byte status;

    private Byte sorts;

    private String creator;

    private String updateuser;

    private Date updatetime;

    private Date createdate;

    public String getMqsendexceptionid() {
        return mqsendexceptionid;
    }

    public void setMqsendexceptionid(String mqsendexceptionid) {
        this.mqsendexceptionid = mqsendexceptionid == null ? null : mqsendexceptionid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getForeignkeyid() {
        return foreignkeyid;
    }

    public void setForeignkeyid(String foreignkeyid) {
        this.foreignkeyid = foreignkeyid == null ? null : foreignkeyid.trim();
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid == null ? null : tenantid.trim();
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode == null ? null : typecode.trim();
    }

    public String getSendmsg() {
        return sendmsg;
    }

    public void setSendmsg(String sendmsg) {
        this.sendmsg = sendmsg == null ? null : sendmsg.trim();
    }

    public String getExmsg() {
        return exmsg;
    }

    public void setExmsg(String exmsg) {
        this.exmsg = exmsg == null ? null : exmsg.trim();
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname == null ? null : methodname.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getSorts() {
        return sorts;
    }

    public void setSorts(Byte sorts) {
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