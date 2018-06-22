package com.pcitc.oilmachine.model;

import java.util.Date;

import com.pcitc.oilmachine.view.Page;

public class UserTags extends Page<UserTags>{
    private String usertagsid;

    private String usertagsname;

    private String usertag;

    private String tagvalue;

    private Long tagvaluetype;

    private Byte status;

    private Long sorts;

    private String creator;

    private String updateuser;

    private Date updatetime;

    private Date createdate;

    public String getUsertagsid() {
        return usertagsid;
    }

    public void setUsertagsid(String usertagsid) {
        this.usertagsid = usertagsid == null ? null : usertagsid.trim();
    }

    public String getUsertagsname() {
        return usertagsname;
    }

    public void setUsertagsname(String usertagsname) {
        this.usertagsname = usertagsname == null ? null : usertagsname.trim();
    }

    public String getUsertag() {
        return usertag;
    }

    public void setUsertag(String usertag) {
        this.usertag = usertag == null ? null : usertag.trim();
    }

    public String getTagvalue() {
        return tagvalue;
    }

    public void setTagvalue(String tagvalue) {
        this.tagvalue = tagvalue == null ? null : tagvalue.trim();
    }

    public Long getTagvaluetype() {
        return tagvaluetype;
    }

    public void setTagvaluetype(Long tagvaluetype) {
        this.tagvaluetype = tagvaluetype;
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