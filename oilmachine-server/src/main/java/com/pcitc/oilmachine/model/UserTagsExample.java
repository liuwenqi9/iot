package com.pcitc.oilmachine.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTagsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserTagsExample() {
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

        public Criteria andUsertagsidIsNull() {
            addCriterion("userTagsId is null");
            return (Criteria) this;
        }

        public Criteria andUsertagsidIsNotNull() {
            addCriterion("userTagsId is not null");
            return (Criteria) this;
        }

        public Criteria andUsertagsidEqualTo(String value) {
            addCriterion("userTagsId =", value, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsidNotEqualTo(String value) {
            addCriterion("userTagsId <>", value, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsidGreaterThan(String value) {
            addCriterion("userTagsId >", value, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsidGreaterThanOrEqualTo(String value) {
            addCriterion("userTagsId >=", value, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsidLessThan(String value) {
            addCriterion("userTagsId <", value, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsidLessThanOrEqualTo(String value) {
            addCriterion("userTagsId <=", value, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsidLike(String value) {
            addCriterion("userTagsId like", value, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsidNotLike(String value) {
            addCriterion("userTagsId not like", value, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsidIn(List<String> values) {
            addCriterion("userTagsId in", values, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsidNotIn(List<String> values) {
            addCriterion("userTagsId not in", values, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsidBetween(String value1, String value2) {
            addCriterion("userTagsId between", value1, value2, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsidNotBetween(String value1, String value2) {
            addCriterion("userTagsId not between", value1, value2, "usertagsid");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameIsNull() {
            addCriterion("userTagsName is null");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameIsNotNull() {
            addCriterion("userTagsName is not null");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameEqualTo(String value) {
            addCriterion("userTagsName =", value, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameNotEqualTo(String value) {
            addCriterion("userTagsName <>", value, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameGreaterThan(String value) {
            addCriterion("userTagsName >", value, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameGreaterThanOrEqualTo(String value) {
            addCriterion("userTagsName >=", value, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameLessThan(String value) {
            addCriterion("userTagsName <", value, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameLessThanOrEqualTo(String value) {
            addCriterion("userTagsName <=", value, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameLike(String value) {
            addCriterion("userTagsName like", value, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameNotLike(String value) {
            addCriterion("userTagsName not like", value, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameIn(List<String> values) {
            addCriterion("userTagsName in", values, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameNotIn(List<String> values) {
            addCriterion("userTagsName not in", values, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameBetween(String value1, String value2) {
            addCriterion("userTagsName between", value1, value2, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagsnameNotBetween(String value1, String value2) {
            addCriterion("userTagsName not between", value1, value2, "usertagsname");
            return (Criteria) this;
        }

        public Criteria andUsertagIsNull() {
            addCriterion("usertag is null");
            return (Criteria) this;
        }

        public Criteria andUsertagIsNotNull() {
            addCriterion("usertag is not null");
            return (Criteria) this;
        }

        public Criteria andUsertagEqualTo(String value) {
            addCriterion("usertag =", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagNotEqualTo(String value) {
            addCriterion("usertag <>", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagGreaterThan(String value) {
            addCriterion("usertag >", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagGreaterThanOrEqualTo(String value) {
            addCriterion("usertag >=", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagLessThan(String value) {
            addCriterion("usertag <", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagLessThanOrEqualTo(String value) {
            addCriterion("usertag <=", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagLike(String value) {
            addCriterion("usertag like", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagNotLike(String value) {
            addCriterion("usertag not like", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagIn(List<String> values) {
            addCriterion("usertag in", values, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagNotIn(List<String> values) {
            addCriterion("usertag not in", values, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagBetween(String value1, String value2) {
            addCriterion("usertag between", value1, value2, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagNotBetween(String value1, String value2) {
            addCriterion("usertag not between", value1, value2, "usertag");
            return (Criteria) this;
        }

        public Criteria andTagvalueIsNull() {
            addCriterion("tagValue is null");
            return (Criteria) this;
        }

        public Criteria andTagvalueIsNotNull() {
            addCriterion("tagValue is not null");
            return (Criteria) this;
        }

        public Criteria andTagvalueEqualTo(String value) {
            addCriterion("tagValue =", value, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvalueNotEqualTo(String value) {
            addCriterion("tagValue <>", value, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvalueGreaterThan(String value) {
            addCriterion("tagValue >", value, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvalueGreaterThanOrEqualTo(String value) {
            addCriterion("tagValue >=", value, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvalueLessThan(String value) {
            addCriterion("tagValue <", value, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvalueLessThanOrEqualTo(String value) {
            addCriterion("tagValue <=", value, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvalueLike(String value) {
            addCriterion("tagValue like", value, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvalueNotLike(String value) {
            addCriterion("tagValue not like", value, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvalueIn(List<String> values) {
            addCriterion("tagValue in", values, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvalueNotIn(List<String> values) {
            addCriterion("tagValue not in", values, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvalueBetween(String value1, String value2) {
            addCriterion("tagValue between", value1, value2, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvalueNotBetween(String value1, String value2) {
            addCriterion("tagValue not between", value1, value2, "tagvalue");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeIsNull() {
            addCriterion("tagValueType is null");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeIsNotNull() {
            addCriterion("tagValueType is not null");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeEqualTo(Long value) {
            addCriterion("tagValueType =", value, "tagvaluetype");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeNotEqualTo(Long value) {
            addCriterion("tagValueType <>", value, "tagvaluetype");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeGreaterThan(Long value) {
            addCriterion("tagValueType >", value, "tagvaluetype");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeGreaterThanOrEqualTo(Long value) {
            addCriterion("tagValueType >=", value, "tagvaluetype");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeLessThan(Long value) {
            addCriterion("tagValueType <", value, "tagvaluetype");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeLessThanOrEqualTo(Long value) {
            addCriterion("tagValueType <=", value, "tagvaluetype");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeIn(List<Long> values) {
            addCriterion("tagValueType in", values, "tagvaluetype");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeNotIn(List<Long> values) {
            addCriterion("tagValueType not in", values, "tagvaluetype");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeBetween(Long value1, Long value2) {
            addCriterion("tagValueType between", value1, value2, "tagvaluetype");
            return (Criteria) this;
        }

        public Criteria andTagvaluetypeNotBetween(Long value1, Long value2) {
            addCriterion("tagValueType not between", value1, value2, "tagvaluetype");
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