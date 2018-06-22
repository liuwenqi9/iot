package com.pcitc.oilmachine.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DevicesAreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DevicesAreaExample() {
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

        public Criteria andDevicesareaidIsNull() {
            addCriterion("devicesareaid is null");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidIsNotNull() {
            addCriterion("devicesareaid is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidEqualTo(String value) {
            addCriterion("devicesareaid =", value, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidNotEqualTo(String value) {
            addCriterion("devicesareaid <>", value, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidGreaterThan(String value) {
            addCriterion("devicesareaid >", value, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidGreaterThanOrEqualTo(String value) {
            addCriterion("devicesareaid >=", value, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidLessThan(String value) {
            addCriterion("devicesareaid <", value, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidLessThanOrEqualTo(String value) {
            addCriterion("devicesareaid <=", value, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidLike(String value) {
            addCriterion("devicesareaid like", value, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidNotLike(String value) {
            addCriterion("devicesareaid not like", value, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidIn(List<String> values) {
            addCriterion("devicesareaid in", values, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidNotIn(List<String> values) {
            addCriterion("devicesareaid not in", values, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidBetween(String value1, String value2) {
            addCriterion("devicesareaid between", value1, value2, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andDevicesareaidNotBetween(String value1, String value2) {
            addCriterion("devicesareaid not between", value1, value2, "devicesareaid");
            return (Criteria) this;
        }

        public Criteria andOilidIsNull() {
            addCriterion("oilid is null");
            return (Criteria) this;
        }

        public Criteria andOilidIsNotNull() {
            addCriterion("oilid is not null");
            return (Criteria) this;
        }

        public Criteria andOilidEqualTo(String value) {
            addCriterion("oilid =", value, "oilid");
            return (Criteria) this;
        }

        public Criteria andOilidNotEqualTo(String value) {
            addCriterion("oilid <>", value, "oilid");
            return (Criteria) this;
        }

        public Criteria andOilidGreaterThan(String value) {
            addCriterion("oilid >", value, "oilid");
            return (Criteria) this;
        }

        public Criteria andOilidGreaterThanOrEqualTo(String value) {
            addCriterion("oilid >=", value, "oilid");
            return (Criteria) this;
        }

        public Criteria andOilidLessThan(String value) {
            addCriterion("oilid <", value, "oilid");
            return (Criteria) this;
        }

        public Criteria andOilidLessThanOrEqualTo(String value) {
            addCriterion("oilid <=", value, "oilid");
            return (Criteria) this;
        }

        public Criteria andOilidLike(String value) {
            addCriterion("oilid like", value, "oilid");
            return (Criteria) this;
        }

        public Criteria andOilidNotLike(String value) {
            addCriterion("oilid not like", value, "oilid");
            return (Criteria) this;
        }

        public Criteria andOilidIn(List<String> values) {
            addCriterion("oilid in", values, "oilid");
            return (Criteria) this;
        }

        public Criteria andOilidNotIn(List<String> values) {
            addCriterion("oilid not in", values, "oilid");
            return (Criteria) this;
        }

        public Criteria andOilidBetween(String value1, String value2) {
            addCriterion("oilid between", value1, value2, "oilid");
            return (Criteria) this;
        }

        public Criteria andOilidNotBetween(String value1, String value2) {
            addCriterion("oilid not between", value1, value2, "oilid");
            return (Criteria) this;
        }

        public Criteria andCameraidIsNull() {
            addCriterion("cameraid is null");
            return (Criteria) this;
        }

        public Criteria andCameraidIsNotNull() {
            addCriterion("cameraid is not null");
            return (Criteria) this;
        }

        public Criteria andCameraidEqualTo(String value) {
            addCriterion("cameraid =", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidNotEqualTo(String value) {
            addCriterion("cameraid <>", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidGreaterThan(String value) {
            addCriterion("cameraid >", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidGreaterThanOrEqualTo(String value) {
            addCriterion("cameraid >=", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidLessThan(String value) {
            addCriterion("cameraid <", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidLessThanOrEqualTo(String value) {
            addCriterion("cameraid <=", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidLike(String value) {
            addCriterion("cameraid like", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidNotLike(String value) {
            addCriterion("cameraid not like", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidIn(List<String> values) {
            addCriterion("cameraid in", values, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidNotIn(List<String> values) {
            addCriterion("cameraid not in", values, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidBetween(String value1, String value2) {
            addCriterion("cameraid between", value1, value2, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidNotBetween(String value1, String value2) {
            addCriterion("cameraid not between", value1, value2, "cameraid");
            return (Criteria) this;
        }

        public Criteria andLefttopxIsNull() {
            addCriterion("lefttopx is null");
            return (Criteria) this;
        }

        public Criteria andLefttopxIsNotNull() {
            addCriterion("lefttopx is not null");
            return (Criteria) this;
        }

        public Criteria andLefttopxEqualTo(BigDecimal value) {
            addCriterion("lefttopx =", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxNotEqualTo(BigDecimal value) {
            addCriterion("lefttopx <>", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxGreaterThan(BigDecimal value) {
            addCriterion("lefttopx >", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lefttopx >=", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxLessThan(BigDecimal value) {
            addCriterion("lefttopx <", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lefttopx <=", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxIn(List<BigDecimal> values) {
            addCriterion("lefttopx in", values, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxNotIn(List<BigDecimal> values) {
            addCriterion("lefttopx not in", values, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lefttopx between", value1, value2, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lefttopx not between", value1, value2, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopyIsNull() {
            addCriterion("lefttopy is null");
            return (Criteria) this;
        }

        public Criteria andLefttopyIsNotNull() {
            addCriterion("lefttopy is not null");
            return (Criteria) this;
        }

        public Criteria andLefttopyEqualTo(BigDecimal value) {
            addCriterion("lefttopy =", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyNotEqualTo(BigDecimal value) {
            addCriterion("lefttopy <>", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyGreaterThan(BigDecimal value) {
            addCriterion("lefttopy >", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lefttopy >=", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyLessThan(BigDecimal value) {
            addCriterion("lefttopy <", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lefttopy <=", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyIn(List<BigDecimal> values) {
            addCriterion("lefttopy in", values, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyNotIn(List<BigDecimal> values) {
            addCriterion("lefttopy not in", values, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lefttopy between", value1, value2, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lefttopy not between", value1, value2, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andRightbottomxIsNull() {
            addCriterion("rightbottomx is null");
            return (Criteria) this;
        }

        public Criteria andRightbottomxIsNotNull() {
            addCriterion("rightbottomx is not null");
            return (Criteria) this;
        }

        public Criteria andRightbottomxEqualTo(BigDecimal value) {
            addCriterion("rightbottomx =", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxNotEqualTo(BigDecimal value) {
            addCriterion("rightbottomx <>", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxGreaterThan(BigDecimal value) {
            addCriterion("rightbottomx >", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rightbottomx >=", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxLessThan(BigDecimal value) {
            addCriterion("rightbottomx <", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rightbottomx <=", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxIn(List<BigDecimal> values) {
            addCriterion("rightbottomx in", values, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxNotIn(List<BigDecimal> values) {
            addCriterion("rightbottomx not in", values, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rightbottomx between", value1, value2, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rightbottomx not between", value1, value2, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomyIsNull() {
            addCriterion("rightbottomy is null");
            return (Criteria) this;
        }

        public Criteria andRightbottomyIsNotNull() {
            addCriterion("rightbottomy is not null");
            return (Criteria) this;
        }

        public Criteria andRightbottomyEqualTo(BigDecimal value) {
            addCriterion("rightbottomy =", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyNotEqualTo(BigDecimal value) {
            addCriterion("rightbottomy <>", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyGreaterThan(BigDecimal value) {
            addCriterion("rightbottomy >", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rightbottomy >=", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyLessThan(BigDecimal value) {
            addCriterion("rightbottomy <", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rightbottomy <=", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyIn(List<BigDecimal> values) {
            addCriterion("rightbottomy in", values, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyNotIn(List<BigDecimal> values) {
            addCriterion("rightbottomy not in", values, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rightbottomy between", value1, value2, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rightbottomy not between", value1, value2, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andAreacodeIsNull() {
            addCriterion("areacode is null");
            return (Criteria) this;
        }

        public Criteria andAreacodeIsNotNull() {
            addCriterion("areacode is not null");
            return (Criteria) this;
        }

        public Criteria andAreacodeEqualTo(Byte value) {
            addCriterion("areacode =", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotEqualTo(Byte value) {
            addCriterion("areacode <>", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThan(Byte value) {
            addCriterion("areacode >", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThanOrEqualTo(Byte value) {
            addCriterion("areacode >=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThan(Byte value) {
            addCriterion("areacode <", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThanOrEqualTo(Byte value) {
            addCriterion("areacode <=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeIn(List<Byte> values) {
            addCriterion("areacode in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotIn(List<Byte> values) {
            addCriterion("areacode not in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeBetween(Byte value1, Byte value2) {
            addCriterion("areacode between", value1, value2, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotBetween(Byte value1, Byte value2) {
            addCriterion("areacode not between", value1, value2, "areacode");
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