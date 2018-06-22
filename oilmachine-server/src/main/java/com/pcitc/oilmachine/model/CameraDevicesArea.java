package com.pcitc.oilmachine.model;

import java.math.BigDecimal;
import java.util.Date;

import com.pcitc.oilmachine.view.Page;

public class CameraDevicesArea extends Page<CameraDevicesArea>{
    private String devicesareaid;

    private String oilid;

    private String cameraid;
    
    private String conname;

    private BigDecimal lefttopx;

    private BigDecimal lefttopy;

    private BigDecimal rightbottomx;

    private BigDecimal rightbottomy;

    private Byte areacode;

    private Byte status;

    private Long sorts;

    private String creator;

    private String updateuser;

    private Date updatetime;

    private Date createdate;

    public String getDevicesareaid() {
        return devicesareaid;
    }

    public void setDevicesareaid(String devicesareaid) {
        this.devicesareaid = devicesareaid == null ? null : devicesareaid.trim();
    }

    public String getOilid() {
        return oilid;
    }

    public void setOilid(String oilid) {
        this.oilid = oilid == null ? null : oilid.trim();
    }

    public String getCameraid() {
        return cameraid;
    }

    public void setCameraid(String cameraid) {
        this.cameraid = cameraid == null ? null : cameraid.trim();
    }

    public BigDecimal getLefttopx() {
        return lefttopx;
    }

    public void setLefttopx(BigDecimal lefttopx) {
        this.lefttopx = lefttopx;
    }

    public BigDecimal getLefttopy() {
        return lefttopy;
    }

    public void setLefttopy(BigDecimal lefttopy) {
        this.lefttopy = lefttopy;
    }

    public BigDecimal getRightbottomx() {
        return rightbottomx;
    }

    public void setRightbottomx(BigDecimal rightbottomx) {
        this.rightbottomx = rightbottomx;
    }

    public BigDecimal getRightbottomy() {
        return rightbottomy;
    }

    public void setRightbottomy(BigDecimal rightbottomy) {
        this.rightbottomy = rightbottomy;
    }

    public Byte getAreacode() {
        return areacode;
    }

    public void setAreacode(Byte areacode) {
        this.areacode = areacode;
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

	public String getConname() {
		return conname;
	}

	public void setConname(String conname) {
		this.conname = conname;
	}
}