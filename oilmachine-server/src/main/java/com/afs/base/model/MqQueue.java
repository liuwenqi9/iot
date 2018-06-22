package com.afs.base.model;

import java.util.Date;

public class MqQueue {
    private String queueid;

    private String queuename;

    private String configid;

    private Long channelnum;

    private String method;

    private Byte status;

    private Short sorts;

    private String creator;

    private String updateuser;

    private Date updatetime;

    private Date createdate;

    private String templatetype;

    private Byte isstart;

    private String tenantid;

    private String queuedesc;

    private String startip;

    private String mail;

    private String telephone;

    private Long messagesReady;

    private Long messagesUnacknowledged;

    private Byte isjson;

    private String starttime;

    private String closetime;

    private Integer rannum;

    public String getQueueid() {
        return queueid;
    }

    public void setQueueid(String queueid) {
        this.queueid = queueid == null ? null : queueid.trim();
    }

    public String getQueuename() {
        return queuename;
    }

    public void setQueuename(String queuename) {
        this.queuename = queuename == null ? null : queuename.trim();
    }

    public String getConfigid() {
        return configid;
    }

    public void setConfigid(String configid) {
        this.configid = configid == null ? null : configid.trim();
    }

    public Long getChannelnum() {
        return channelnum;
    }

    public void setChannelnum(Long channelnum) {
        this.channelnum = channelnum;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
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

    public String getTemplatetype() {
        return templatetype;
    }

    public void setTemplatetype(String templatetype) {
        this.templatetype = templatetype == null ? null : templatetype.trim();
    }

    public Byte getIsstart() {
        return isstart;
    }

    public void setIsstart(Byte isstart) {
        this.isstart = isstart;
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid == null ? null : tenantid.trim();
    }

    public String getQueuedesc() {
        return queuedesc;
    }

    public void setQueuedesc(String queuedesc) {
        this.queuedesc = queuedesc == null ? null : queuedesc.trim();
    }

    public String getStartip() {
        return startip;
    }

    public void setStartip(String startip) {
        this.startip = startip == null ? null : startip.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Long getMessagesReady() {
        return messagesReady;
    }

    public void setMessagesReady(Long messagesReady) {
        this.messagesReady = messagesReady;
    }

    public Long getMessagesUnacknowledged() {
        return messagesUnacknowledged;
    }

    public void setMessagesUnacknowledged(Long messagesUnacknowledged) {
        this.messagesUnacknowledged = messagesUnacknowledged;
    }

    public Byte getIsjson() {
        return isjson;
    }

    public void setIsjson(Byte isjson) {
        this.isjson = isjson;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getClosetime() {
        return closetime;
    }

    public void setClosetime(String closetime) {
        this.closetime = closetime == null ? null : closetime.trim();
    }

    public Integer getRannum() {
        return rannum;
    }

    public void setRannum(Integer rannum) {
        this.rannum = rannum;
    }
}