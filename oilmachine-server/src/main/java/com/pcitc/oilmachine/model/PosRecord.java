package com.pcitc.oilmachine.model;

import java.util.Date;

public class PosRecord {
    private String id;

    private String tenantid;

    private String userid;

    private String saleno;

    private String deviceconnid;

    private Long posttc;

    private String ttype;

    private Long time;

    private Long asn;

    private Long bal;

    private Long amn;

    private Long ctc;

    private Long tac;

    private Long gmac;

    private Long psamtac;

    private String psamasn;

    private Long psamtid;

    private Long psamttc;

    private Long ds;

    private String unit;

    private String ctype;

    private String ver;

    private Long nzn;

    private String gcode;

    private Long vol;

    private Long prc;

    private Long emp;

    private Long vtot;

    private Long rfu;

    private Long tmac;

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

    public String getSaleno() {
        return saleno;
    }

    public void setSaleno(String saleno) {
        this.saleno = saleno == null ? null : saleno.trim();
    }

    public String getDeviceconnid() {
        return deviceconnid;
    }

    public void setDeviceconnid(String deviceconnid) {
        this.deviceconnid = deviceconnid == null ? null : deviceconnid.trim();
    }

    public Long getPosttc() {
        return posttc;
    }

    public void setPosttc(Long posttc) {
        this.posttc = posttc;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype == null ? null : ttype.trim();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getAsn() {
        return asn;
    }

    public void setAsn(Long asn) {
        this.asn = asn;
    }

    public Long getBal() {
        return bal;
    }

    public void setBal(Long bal) {
        this.bal = bal;
    }

    public Long getAmn() {
        return amn;
    }

    public void setAmn(Long amn) {
        this.amn = amn;
    }

    public Long getCtc() {
        return ctc;
    }

    public void setCtc(Long ctc) {
        this.ctc = ctc;
    }

    public Long getTac() {
        return tac;
    }

    public void setTac(Long tac) {
        this.tac = tac;
    }

    public Long getGmac() {
        return gmac;
    }

    public void setGmac(Long gmac) {
        this.gmac = gmac;
    }

    public Long getPsamtac() {
        return psamtac;
    }

    public void setPsamtac(Long psamtac) {
        this.psamtac = psamtac;
    }

    public String getPsamasn() {
        return psamasn;
    }

    public void setPsamasn(String psamasn) {
        this.psamasn = psamasn == null ? null : psamasn.trim();
    }

    public Long getPsamtid() {
        return psamtid;
    }

    public void setPsamtid(Long psamtid) {
        this.psamtid = psamtid;
    }

    public Long getPsamttc() {
        return psamttc;
    }

    public void setPsamttc(Long psamttc) {
        this.psamttc = psamttc;
    }

    public Long getDs() {
        return ds;
    }

    public void setDs(Long ds) {
        this.ds = ds;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype == null ? null : ctype.trim();
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver == null ? null : ver.trim();
    }

    public Long getNzn() {
        return nzn;
    }

    public void setNzn(Long nzn) {
        this.nzn = nzn;
    }

    public String getGcode() {
        return gcode;
    }

    public void setGcode(String gcode) {
        this.gcode = gcode == null ? null : gcode.trim();
    }

    public Long getVol() {
        return vol;
    }

    public void setVol(Long vol) {
        this.vol = vol;
    }

    public Long getPrc() {
        return prc;
    }

    public void setPrc(Long prc) {
        this.prc = prc;
    }

    public Long getEmp() {
        return emp;
    }

    public void setEmp(Long emp) {
        this.emp = emp;
    }

    public Long getVtot() {
        return vtot;
    }

    public void setVtot(Long vtot) {
        this.vtot = vtot;
    }

    public Long getRfu() {
        return rfu;
    }

    public void setRfu(Long rfu) {
        this.rfu = rfu;
    }

    public Long getTmac() {
        return tmac;
    }

    public void setTmac(Long tmac) {
        this.tmac = tmac;
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