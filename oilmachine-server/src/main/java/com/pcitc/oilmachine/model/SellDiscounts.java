package com.pcitc.oilmachine.model;

import java.util.Date;

import com.pcitc.oilmachine.view.Page;

public class SellDiscounts extends Page<SellDiscounts>{
    private String id;

    private String tenantid;

    private String userid;

    private Byte discountsbody;

    private String saleno;

    private String sellproductid;

    private Byte discountstype;

    private Long discountsamount;

    private String gist;

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

    public Byte getDiscountsbody() {
        return discountsbody;
    }

    public void setDiscountsbody(Byte discountsbody) {
        this.discountsbody = discountsbody;
    }

    public String getSaleno() {
        return saleno;
    }

    public void setSaleno(String saleno) {
        this.saleno = saleno == null ? null : saleno.trim();
    }

    public String getSellproductid() {
        return sellproductid;
    }

    public void setSellproductid(String sellproductid) {
        this.sellproductid = sellproductid == null ? null : sellproductid.trim();
    }

    public Byte getDiscountstype() {
        return discountstype;
    }

    public void setDiscountstype(Byte discountstype) {
        this.discountstype = discountstype;
    }

    public Long getDiscountsamount() {
        return discountsamount;
    }

    public void setDiscountsamount(Long discountsamount) {
        this.discountsamount = discountsamount;
    }

    public String getGist() {
        return gist;
    }

    public void setGist(String gist) {
        this.gist = gist == null ? null : gist.trim();
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