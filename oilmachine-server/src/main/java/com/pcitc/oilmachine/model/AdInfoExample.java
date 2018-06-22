package com.pcitc.oilmachine.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAdinfoidIsNull() {
            addCriterion("adInfoId is null");
            return (Criteria) this;
        }

        public Criteria andAdinfoidIsNotNull() {
            addCriterion("adInfoId is not null");
            return (Criteria) this;
        }

        public Criteria andAdinfoidEqualTo(String value) {
            addCriterion("adInfoId =", value, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andAdinfoidNotEqualTo(String value) {
            addCriterion("adInfoId <>", value, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andAdinfoidGreaterThan(String value) {
            addCriterion("adInfoId >", value, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andAdinfoidGreaterThanOrEqualTo(String value) {
            addCriterion("adInfoId >=", value, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andAdinfoidLessThan(String value) {
            addCriterion("adInfoId <", value, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andAdinfoidLessThanOrEqualTo(String value) {
            addCriterion("adInfoId <=", value, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andAdinfoidLike(String value) {
            addCriterion("adInfoId like", value, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andAdinfoidNotLike(String value) {
            addCriterion("adInfoId not like", value, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andAdinfoidIn(List<String> values) {
            addCriterion("adInfoId in", values, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andAdinfoidNotIn(List<String> values) {
            addCriterion("adInfoId not in", values, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andAdinfoidBetween(String value1, String value2) {
            addCriterion("adInfoId between", value1, value2, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andAdinfoidNotBetween(String value1, String value2) {
            addCriterion("adInfoId not between", value1, value2, "adinfoid");
            return (Criteria) this;
        }

        public Criteria andTenantidIsNull() {
            addCriterion("TENANTID is null");
            return (Criteria) this;
        }

        public Criteria andTenantidIsNotNull() {
            addCriterion("TENANTID is not null");
            return (Criteria) this;
        }

        public Criteria andTenantidEqualTo(String value) {
            addCriterion("TENANTID =", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotEqualTo(String value) {
            addCriterion("TENANTID <>", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidGreaterThan(String value) {
            addCriterion("TENANTID >", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidGreaterThanOrEqualTo(String value) {
            addCriterion("TENANTID >=", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidLessThan(String value) {
            addCriterion("TENANTID <", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidLessThanOrEqualTo(String value) {
            addCriterion("TENANTID <=", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidLike(String value) {
            addCriterion("TENANTID like", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotLike(String value) {
            addCriterion("TENANTID not like", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidIn(List<String> values) {
            addCriterion("TENANTID in", values, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotIn(List<String> values) {
            addCriterion("TENANTID not in", values, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidBetween(String value1, String value2) {
            addCriterion("TENANTID between", value1, value2, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotBetween(String value1, String value2) {
            addCriterion("TENANTID not between", value1, value2, "tenantid");
            return (Criteria) this;
        }

        public Criteria andBuidIsNull() {
            addCriterion("buid is null");
            return (Criteria) this;
        }

        public Criteria andBuidIsNotNull() {
            addCriterion("buid is not null");
            return (Criteria) this;
        }

        public Criteria andBuidEqualTo(String value) {
            addCriterion("buid =", value, "buid");
            return (Criteria) this;
        }

        public Criteria andBuidNotEqualTo(String value) {
            addCriterion("buid <>", value, "buid");
            return (Criteria) this;
        }

        public Criteria andBuidGreaterThan(String value) {
            addCriterion("buid >", value, "buid");
            return (Criteria) this;
        }

        public Criteria andBuidGreaterThanOrEqualTo(String value) {
            addCriterion("buid >=", value, "buid");
            return (Criteria) this;
        }

        public Criteria andBuidLessThan(String value) {
            addCriterion("buid <", value, "buid");
            return (Criteria) this;
        }

        public Criteria andBuidLessThanOrEqualTo(String value) {
            addCriterion("buid <=", value, "buid");
            return (Criteria) this;
        }

        public Criteria andBuidLike(String value) {
            addCriterion("buid like", value, "buid");
            return (Criteria) this;
        }

        public Criteria andBuidNotLike(String value) {
            addCriterion("buid not like", value, "buid");
            return (Criteria) this;
        }

        public Criteria andBuidIn(List<String> values) {
            addCriterion("buid in", values, "buid");
            return (Criteria) this;
        }

        public Criteria andBuidNotIn(List<String> values) {
            addCriterion("buid not in", values, "buid");
            return (Criteria) this;
        }

        public Criteria andBuidBetween(String value1, String value2) {
            addCriterion("buid between", value1, value2, "buid");
            return (Criteria) this;
        }

        public Criteria andBuidNotBetween(String value1, String value2) {
            addCriterion("buid not between", value1, value2, "buid");
            return (Criteria) this;
        }

        public Criteria andBucodeIsNull() {
            addCriterion("bucode is null");
            return (Criteria) this;
        }

        public Criteria andBucodeIsNotNull() {
            addCriterion("bucode is not null");
            return (Criteria) this;
        }

        public Criteria andBucodeEqualTo(String value) {
            addCriterion("bucode =", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeNotEqualTo(String value) {
            addCriterion("bucode <>", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeGreaterThan(String value) {
            addCriterion("bucode >", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeGreaterThanOrEqualTo(String value) {
            addCriterion("bucode >=", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeLessThan(String value) {
            addCriterion("bucode <", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeLessThanOrEqualTo(String value) {
            addCriterion("bucode <=", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeLike(String value) {
            addCriterion("bucode like", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeNotLike(String value) {
            addCriterion("bucode not like", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeIn(List<String> values) {
            addCriterion("bucode in", values, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeNotIn(List<String> values) {
            addCriterion("bucode not in", values, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeBetween(String value1, String value2) {
            addCriterion("bucode between", value1, value2, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeNotBetween(String value1, String value2) {
            addCriterion("bucode not between", value1, value2, "bucode");
            return (Criteria) this;
        }

        public Criteria andBunameIsNull() {
            addCriterion("buname is null");
            return (Criteria) this;
        }

        public Criteria andBunameIsNotNull() {
            addCriterion("buname is not null");
            return (Criteria) this;
        }

        public Criteria andBunameEqualTo(String value) {
            addCriterion("buname =", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameNotEqualTo(String value) {
            addCriterion("buname <>", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameGreaterThan(String value) {
            addCriterion("buname >", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameGreaterThanOrEqualTo(String value) {
            addCriterion("buname >=", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameLessThan(String value) {
            addCriterion("buname <", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameLessThanOrEqualTo(String value) {
            addCriterion("buname <=", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameLike(String value) {
            addCriterion("buname like", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameNotLike(String value) {
            addCriterion("buname not like", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameIn(List<String> values) {
            addCriterion("buname in", values, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameNotIn(List<String> values) {
            addCriterion("buname not in", values, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameBetween(String value1, String value2) {
            addCriterion("buname between", value1, value2, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameNotBetween(String value1, String value2) {
            addCriterion("buname not between", value1, value2, "buname");
            return (Criteria) this;
        }

        public Criteria andAdnameIsNull() {
            addCriterion("adName is null");
            return (Criteria) this;
        }

        public Criteria andAdnameIsNotNull() {
            addCriterion("adName is not null");
            return (Criteria) this;
        }

        public Criteria andAdnameEqualTo(String value) {
            addCriterion("adName =", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotEqualTo(String value) {
            addCriterion("adName <>", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameGreaterThan(String value) {
            addCriterion("adName >", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameGreaterThanOrEqualTo(String value) {
            addCriterion("adName >=", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameLessThan(String value) {
            addCriterion("adName <", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameLessThanOrEqualTo(String value) {
            addCriterion("adName <=", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameLike(String value) {
            addCriterion("adName like", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotLike(String value) {
            addCriterion("adName not like", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameIn(List<String> values) {
            addCriterion("adName in", values, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotIn(List<String> values) {
            addCriterion("adName not in", values, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameBetween(String value1, String value2) {
            addCriterion("adName between", value1, value2, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotBetween(String value1, String value2) {
            addCriterion("adName not between", value1, value2, "adname");
            return (Criteria) this;
        }

        public Criteria andExpirydateIsNull() {
            addCriterion("expiryDate is null");
            return (Criteria) this;
        }

        public Criteria andExpirydateIsNotNull() {
            addCriterion("expiryDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpirydateEqualTo(Date value) {
            addCriterion("expiryDate =", value, "expirydate");
            return (Criteria) this;
        }

        public Criteria andExpirydateNotEqualTo(Date value) {
            addCriterion("expiryDate <>", value, "expirydate");
            return (Criteria) this;
        }

        public Criteria andExpirydateGreaterThan(Date value) {
            addCriterion("expiryDate >", value, "expirydate");
            return (Criteria) this;
        }

        public Criteria andExpirydateGreaterThanOrEqualTo(Date value) {
            addCriterion("expiryDate >=", value, "expirydate");
            return (Criteria) this;
        }

        public Criteria andExpirydateLessThan(Date value) {
            addCriterion("expiryDate <", value, "expirydate");
            return (Criteria) this;
        }

        public Criteria andExpirydateLessThanOrEqualTo(Date value) {
            addCriterion("expiryDate <=", value, "expirydate");
            return (Criteria) this;
        }

        public Criteria andExpirydateIn(List<Date> values) {
            addCriterion("expiryDate in", values, "expirydate");
            return (Criteria) this;
        }

        public Criteria andExpirydateNotIn(List<Date> values) {
            addCriterion("expiryDate not in", values, "expirydate");
            return (Criteria) this;
        }

        public Criteria andExpirydateBetween(Date value1, Date value2) {
            addCriterion("expiryDate between", value1, value2, "expirydate");
            return (Criteria) this;
        }

        public Criteria andExpirydateNotBetween(Date value1, Date value2) {
            addCriterion("expiryDate not between", value1, value2, "expirydate");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNull() {
            addCriterion("isUse is null");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNotNull() {
            addCriterion("isUse is not null");
            return (Criteria) this;
        }

        public Criteria andIsuseEqualTo(Byte value) {
            addCriterion("isUse =", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotEqualTo(Byte value) {
            addCriterion("isUse <>", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThan(Byte value) {
            addCriterion("isUse >", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThanOrEqualTo(Byte value) {
            addCriterion("isUse >=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThan(Byte value) {
            addCriterion("isUse <", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThanOrEqualTo(Byte value) {
            addCriterion("isUse <=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseIn(List<Byte> values) {
            addCriterion("isUse in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotIn(List<Byte> values) {
            addCriterion("isUse not in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseBetween(Byte value1, Byte value2) {
            addCriterion("isUse between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotBetween(Byte value1, Byte value2) {
            addCriterion("isUse not between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSortsIsNull() {
            addCriterion("SORTS is null");
            return (Criteria) this;
        }

        public Criteria andSortsIsNotNull() {
            addCriterion("SORTS is not null");
            return (Criteria) this;
        }

        public Criteria andSortsEqualTo(Long value) {
            addCriterion("SORTS =", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotEqualTo(Long value) {
            addCriterion("SORTS <>", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThan(Long value) {
            addCriterion("SORTS >", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThanOrEqualTo(Long value) {
            addCriterion("SORTS >=", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThan(Long value) {
            addCriterion("SORTS <", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThanOrEqualTo(Long value) {
            addCriterion("SORTS <=", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsIn(List<Long> values) {
            addCriterion("SORTS in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotIn(List<Long> values) {
            addCriterion("SORTS not in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsBetween(Long value1, Long value2) {
            addCriterion("SORTS between", value1, value2, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotBetween(Long value1, Long value2) {
            addCriterion("SORTS not between", value1, value2, "sorts");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("CREATOR =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("CREATOR <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("CREATOR >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("CREATOR <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("CREATOR <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("CREATOR like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("CREATOR not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("CREATOR in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("CREATOR not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNull() {
            addCriterion("UPDATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNotNull() {
            addCriterion("UPDATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserEqualTo(String value) {
            addCriterion("UPDATEUSER =", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotEqualTo(String value) {
            addCriterion("UPDATEUSER <>", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThan(String value) {
            addCriterion("UPDATEUSER >", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATEUSER >=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThan(String value) {
            addCriterion("UPDATEUSER <", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("UPDATEUSER <=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLike(String value) {
            addCriterion("UPDATEUSER like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotLike(String value) {
            addCriterion("UPDATEUSER not like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIn(List<String> values) {
            addCriterion("UPDATEUSER in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotIn(List<String> values) {
            addCriterion("UPDATEUSER not in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserBetween(String value1, String value2) {
            addCriterion("UPDATEUSER between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotBetween(String value1, String value2) {
            addCriterion("UPDATEUSER not between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("CREATEDATE is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("CREATEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("CREATEDATE =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("CREATEDATE <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("CREATEDATE >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("CREATEDATE <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("CREATEDATE in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("CREATEDATE not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoIsNull() {
            addCriterion("SINOPECNODENO is null");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoIsNotNull() {
            addCriterion("SINOPECNODENO is not null");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoEqualTo(String value) {
            addCriterion("SINOPECNODENO =", value, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoNotEqualTo(String value) {
            addCriterion("SINOPECNODENO <>", value, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoGreaterThan(String value) {
            addCriterion("SINOPECNODENO >", value, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoGreaterThanOrEqualTo(String value) {
            addCriterion("SINOPECNODENO >=", value, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoLessThan(String value) {
            addCriterion("SINOPECNODENO <", value, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoLessThanOrEqualTo(String value) {
            addCriterion("SINOPECNODENO <=", value, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoLike(String value) {
            addCriterion("SINOPECNODENO like", value, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoNotLike(String value) {
            addCriterion("SINOPECNODENO not like", value, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoIn(List<String> values) {
            addCriterion("SINOPECNODENO in", values, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoNotIn(List<String> values) {
            addCriterion("SINOPECNODENO not in", values, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoBetween(String value1, String value2) {
            addCriterion("SINOPECNODENO between", value1, value2, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andSinopecnodenoNotBetween(String value1, String value2) {
            addCriterion("SINOPECNODENO not between", value1, value2, "sinopecnodeno");
            return (Criteria) this;
        }

        public Criteria andIsreviewIsNull() {
            addCriterion("ISREVIEW is null");
            return (Criteria) this;
        }

        public Criteria andIsreviewIsNotNull() {
            addCriterion("ISREVIEW is not null");
            return (Criteria) this;
        }

        public Criteria andIsreviewEqualTo(Byte value) {
            addCriterion("ISREVIEW =", value, "isreview");
            return (Criteria) this;
        }

        public Criteria andIsreviewNotEqualTo(Byte value) {
            addCriterion("ISREVIEW <>", value, "isreview");
            return (Criteria) this;
        }

        public Criteria andIsreviewGreaterThan(Byte value) {
            addCriterion("ISREVIEW >", value, "isreview");
            return (Criteria) this;
        }

        public Criteria andIsreviewGreaterThanOrEqualTo(Byte value) {
            addCriterion("ISREVIEW >=", value, "isreview");
            return (Criteria) this;
        }

        public Criteria andIsreviewLessThan(Byte value) {
            addCriterion("ISREVIEW <", value, "isreview");
            return (Criteria) this;
        }

        public Criteria andIsreviewLessThanOrEqualTo(Byte value) {
            addCriterion("ISREVIEW <=", value, "isreview");
            return (Criteria) this;
        }

        public Criteria andIsreviewIn(List<Byte> values) {
            addCriterion("ISREVIEW in", values, "isreview");
            return (Criteria) this;
        }

        public Criteria andIsreviewNotIn(List<Byte> values) {
            addCriterion("ISREVIEW not in", values, "isreview");
            return (Criteria) this;
        }

        public Criteria andIsreviewBetween(Byte value1, Byte value2) {
            addCriterion("ISREVIEW between", value1, value2, "isreview");
            return (Criteria) this;
        }

        public Criteria andIsreviewNotBetween(Byte value1, Byte value2) {
            addCriterion("ISREVIEW not between", value1, value2, "isreview");
            return (Criteria) this;
        }

        public Criteria andCusttypeIsNull() {
            addCriterion("CUSTTYPE is null");
            return (Criteria) this;
        }

        public Criteria andCusttypeIsNotNull() {
            addCriterion("CUSTTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCusttypeEqualTo(String value) {
            addCriterion("CUSTTYPE =", value, "custtype");
            return (Criteria) this;
        }

        public Criteria andCusttypeNotEqualTo(String value) {
            addCriterion("CUSTTYPE <>", value, "custtype");
            return (Criteria) this;
        }

        public Criteria andCusttypeGreaterThan(String value) {
            addCriterion("CUSTTYPE >", value, "custtype");
            return (Criteria) this;
        }

        public Criteria andCusttypeGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTTYPE >=", value, "custtype");
            return (Criteria) this;
        }

        public Criteria andCusttypeLessThan(String value) {
            addCriterion("CUSTTYPE <", value, "custtype");
            return (Criteria) this;
        }

        public Criteria andCusttypeLessThanOrEqualTo(String value) {
            addCriterion("CUSTTYPE <=", value, "custtype");
            return (Criteria) this;
        }

        public Criteria andCusttypeLike(String value) {
            addCriterion("CUSTTYPE like", value, "custtype");
            return (Criteria) this;
        }

        public Criteria andCusttypeNotLike(String value) {
            addCriterion("CUSTTYPE not like", value, "custtype");
            return (Criteria) this;
        }

        public Criteria andCusttypeIn(List<String> values) {
            addCriterion("CUSTTYPE in", values, "custtype");
            return (Criteria) this;
        }

        public Criteria andCusttypeNotIn(List<String> values) {
            addCriterion("CUSTTYPE not in", values, "custtype");
            return (Criteria) this;
        }

        public Criteria andCusttypeBetween(String value1, String value2) {
            addCriterion("CUSTTYPE between", value1, value2, "custtype");
            return (Criteria) this;
        }

        public Criteria andCusttypeNotBetween(String value1, String value2) {
            addCriterion("CUSTTYPE not between", value1, value2, "custtype");
            return (Criteria) this;
        }

        public Criteria andConfidenceIsNull() {
            addCriterion("CONFIDENCE is null");
            return (Criteria) this;
        }

        public Criteria andConfidenceIsNotNull() {
            addCriterion("CONFIDENCE is not null");
            return (Criteria) this;
        }

        public Criteria andConfidenceEqualTo(String value) {
            addCriterion("CONFIDENCE =", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotEqualTo(String value) {
            addCriterion("CONFIDENCE <>", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceGreaterThan(String value) {
            addCriterion("CONFIDENCE >", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIDENCE >=", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceLessThan(String value) {
            addCriterion("CONFIDENCE <", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceLessThanOrEqualTo(String value) {
            addCriterion("CONFIDENCE <=", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceLike(String value) {
            addCriterion("CONFIDENCE like", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotLike(String value) {
            addCriterion("CONFIDENCE not like", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceIn(List<String> values) {
            addCriterion("CONFIDENCE in", values, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotIn(List<String> values) {
            addCriterion("CONFIDENCE not in", values, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceBetween(String value1, String value2) {
            addCriterion("CONFIDENCE between", value1, value2, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotBetween(String value1, String value2) {
            addCriterion("CONFIDENCE not between", value1, value2, "confidence");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}