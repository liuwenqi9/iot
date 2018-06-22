package com.pcitc.oilmachine.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdInfoTagsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdInfoTagsExample() {
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

        public Criteria andAdinfotagsidIsNull() {
            addCriterion("adInfoTagsId is null");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidIsNotNull() {
            addCriterion("adInfoTagsId is not null");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidEqualTo(String value) {
            addCriterion("adInfoTagsId =", value, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidNotEqualTo(String value) {
            addCriterion("adInfoTagsId <>", value, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidGreaterThan(String value) {
            addCriterion("adInfoTagsId >", value, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidGreaterThanOrEqualTo(String value) {
            addCriterion("adInfoTagsId >=", value, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidLessThan(String value) {
            addCriterion("adInfoTagsId <", value, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidLessThanOrEqualTo(String value) {
            addCriterion("adInfoTagsId <=", value, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidLike(String value) {
            addCriterion("adInfoTagsId like", value, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidNotLike(String value) {
            addCriterion("adInfoTagsId not like", value, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidIn(List<String> values) {
            addCriterion("adInfoTagsId in", values, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidNotIn(List<String> values) {
            addCriterion("adInfoTagsId not in", values, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidBetween(String value1, String value2) {
            addCriterion("adInfoTagsId between", value1, value2, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andAdinfotagsidNotBetween(String value1, String value2) {
            addCriterion("adInfoTagsId not between", value1, value2, "adinfotagsid");
            return (Criteria) this;
        }

        public Criteria andTenantidIsNull() {
            addCriterion("tenantid is null");
            return (Criteria) this;
        }

        public Criteria andTenantidIsNotNull() {
            addCriterion("tenantid is not null");
            return (Criteria) this;
        }

        public Criteria andTenantidEqualTo(String value) {
            addCriterion("tenantid =", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotEqualTo(String value) {
            addCriterion("tenantid <>", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidGreaterThan(String value) {
            addCriterion("tenantid >", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidGreaterThanOrEqualTo(String value) {
            addCriterion("tenantid >=", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidLessThan(String value) {
            addCriterion("tenantid <", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidLessThanOrEqualTo(String value) {
            addCriterion("tenantid <=", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidLike(String value) {
            addCriterion("tenantid like", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotLike(String value) {
            addCriterion("tenantid not like", value, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidIn(List<String> values) {
            addCriterion("tenantid in", values, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotIn(List<String> values) {
            addCriterion("tenantid not in", values, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidBetween(String value1, String value2) {
            addCriterion("tenantid between", value1, value2, "tenantid");
            return (Criteria) this;
        }

        public Criteria andTenantidNotBetween(String value1, String value2) {
            addCriterion("tenantid not between", value1, value2, "tenantid");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeIsNull() {
            addCriterion("adTagCode is null");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeIsNotNull() {
            addCriterion("adTagCode is not null");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeEqualTo(String value) {
            addCriterion("adTagCode =", value, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeNotEqualTo(String value) {
            addCriterion("adTagCode <>", value, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeGreaterThan(String value) {
            addCriterion("adTagCode >", value, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeGreaterThanOrEqualTo(String value) {
            addCriterion("adTagCode >=", value, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeLessThan(String value) {
            addCriterion("adTagCode <", value, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeLessThanOrEqualTo(String value) {
            addCriterion("adTagCode <=", value, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeLike(String value) {
            addCriterion("adTagCode like", value, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeNotLike(String value) {
            addCriterion("adTagCode not like", value, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeIn(List<String> values) {
            addCriterion("adTagCode in", values, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeNotIn(List<String> values) {
            addCriterion("adTagCode not in", values, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeBetween(String value1, String value2) {
            addCriterion("adTagCode between", value1, value2, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andAdtagcodeNotBetween(String value1, String value2) {
            addCriterion("adTagCode not between", value1, value2, "adtagcode");
            return (Criteria) this;
        }

        public Criteria andTagnameIsNull() {
            addCriterion("tagName is null");
            return (Criteria) this;
        }

        public Criteria andTagnameIsNotNull() {
            addCriterion("tagName is not null");
            return (Criteria) this;
        }

        public Criteria andTagnameEqualTo(String value) {
            addCriterion("tagName =", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotEqualTo(String value) {
            addCriterion("tagName <>", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameGreaterThan(String value) {
            addCriterion("tagName >", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameGreaterThanOrEqualTo(String value) {
            addCriterion("tagName >=", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameLessThan(String value) {
            addCriterion("tagName <", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameLessThanOrEqualTo(String value) {
            addCriterion("tagName <=", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameLike(String value) {
            addCriterion("tagName like", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotLike(String value) {
            addCriterion("tagName not like", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameIn(List<String> values) {
            addCriterion("tagName in", values, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotIn(List<String> values) {
            addCriterion("tagName not in", values, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameBetween(String value1, String value2) {
            addCriterion("tagName between", value1, value2, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotBetween(String value1, String value2) {
            addCriterion("tagName not between", value1, value2, "tagname");
            return (Criteria) this;
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