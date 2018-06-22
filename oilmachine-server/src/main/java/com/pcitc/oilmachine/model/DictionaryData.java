package com.pcitc.oilmachine.model;

import java.util.Date;

import com.pcitc.oilmachine.view.Page;

public class DictionaryData extends Page<DictionaryData>{
    private String dictionarydataid;

    private String dictId;

    private String itemName;

    private String itemCode;

    private String itemValue;

    private Byte status;

    private Byte sorts;

    private String creator;

    private String updateuser;

    private Date updatetime;

    private Date createdate;

    public String getDictionarydataid() {
        return dictionarydataid;
    }

    public void setDictionarydataid(String dictionarydataid) {
        this.dictionarydataid = dictionarydataid == null ? null : dictionarydataid.trim();
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue == null ? null : itemValue.trim();
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