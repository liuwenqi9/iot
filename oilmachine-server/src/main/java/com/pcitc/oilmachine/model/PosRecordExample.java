package com.pcitc.oilmachine.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PosRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PosRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andSalenoIsNull() {
            addCriterion("saleno is null");
            return (Criteria) this;
        }

        public Criteria andSalenoIsNotNull() {
            addCriterion("saleno is not null");
            return (Criteria) this;
        }

        public Criteria andSalenoEqualTo(String value) {
            addCriterion("saleno =", value, "saleno");
            return (Criteria) this;
        }

        public Criteria andSalenoNotEqualTo(String value) {
            addCriterion("saleno <>", value, "saleno");
            return (Criteria) this;
        }

        public Criteria andSalenoGreaterThan(String value) {
            addCriterion("saleno >", value, "saleno");
            return (Criteria) this;
        }

        public Criteria andSalenoGreaterThanOrEqualTo(String value) {
            addCriterion("saleno >=", value, "saleno");
            return (Criteria) this;
        }

        public Criteria andSalenoLessThan(String value) {
            addCriterion("saleno <", value, "saleno");
            return (Criteria) this;
        }

        public Criteria andSalenoLessThanOrEqualTo(String value) {
            addCriterion("saleno <=", value, "saleno");
            return (Criteria) this;
        }

        public Criteria andSalenoLike(String value) {
            addCriterion("saleno like", value, "saleno");
            return (Criteria) this;
        }

        public Criteria andSalenoNotLike(String value) {
            addCriterion("saleno not like", value, "saleno");
            return (Criteria) this;
        }

        public Criteria andSalenoIn(List<String> values) {
            addCriterion("saleno in", values, "saleno");
            return (Criteria) this;
        }

        public Criteria andSalenoNotIn(List<String> values) {
            addCriterion("saleno not in", values, "saleno");
            return (Criteria) this;
        }

        public Criteria andSalenoBetween(String value1, String value2) {
            addCriterion("saleno between", value1, value2, "saleno");
            return (Criteria) this;
        }

        public Criteria andSalenoNotBetween(String value1, String value2) {
            addCriterion("saleno not between", value1, value2, "saleno");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidIsNull() {
            addCriterion("deviceconnid is null");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidIsNotNull() {
            addCriterion("deviceconnid is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidEqualTo(String value) {
            addCriterion("deviceconnid =", value, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidNotEqualTo(String value) {
            addCriterion("deviceconnid <>", value, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidGreaterThan(String value) {
            addCriterion("deviceconnid >", value, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidGreaterThanOrEqualTo(String value) {
            addCriterion("deviceconnid >=", value, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidLessThan(String value) {
            addCriterion("deviceconnid <", value, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidLessThanOrEqualTo(String value) {
            addCriterion("deviceconnid <=", value, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidLike(String value) {
            addCriterion("deviceconnid like", value, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidNotLike(String value) {
            addCriterion("deviceconnid not like", value, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidIn(List<String> values) {
            addCriterion("deviceconnid in", values, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidNotIn(List<String> values) {
            addCriterion("deviceconnid not in", values, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidBetween(String value1, String value2) {
            addCriterion("deviceconnid between", value1, value2, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andDeviceconnidNotBetween(String value1, String value2) {
            addCriterion("deviceconnid not between", value1, value2, "deviceconnid");
            return (Criteria) this;
        }

        public Criteria andPosttcIsNull() {
            addCriterion("posttc is null");
            return (Criteria) this;
        }

        public Criteria andPosttcIsNotNull() {
            addCriterion("posttc is not null");
            return (Criteria) this;
        }

        public Criteria andPosttcEqualTo(Long value) {
            addCriterion("posttc =", value, "posttc");
            return (Criteria) this;
        }

        public Criteria andPosttcNotEqualTo(Long value) {
            addCriterion("posttc <>", value, "posttc");
            return (Criteria) this;
        }

        public Criteria andPosttcGreaterThan(Long value) {
            addCriterion("posttc >", value, "posttc");
            return (Criteria) this;
        }

        public Criteria andPosttcGreaterThanOrEqualTo(Long value) {
            addCriterion("posttc >=", value, "posttc");
            return (Criteria) this;
        }

        public Criteria andPosttcLessThan(Long value) {
            addCriterion("posttc <", value, "posttc");
            return (Criteria) this;
        }

        public Criteria andPosttcLessThanOrEqualTo(Long value) {
            addCriterion("posttc <=", value, "posttc");
            return (Criteria) this;
        }

        public Criteria andPosttcIn(List<Long> values) {
            addCriterion("posttc in", values, "posttc");
            return (Criteria) this;
        }

        public Criteria andPosttcNotIn(List<Long> values) {
            addCriterion("posttc not in", values, "posttc");
            return (Criteria) this;
        }

        public Criteria andPosttcBetween(Long value1, Long value2) {
            addCriterion("posttc between", value1, value2, "posttc");
            return (Criteria) this;
        }

        public Criteria andPosttcNotBetween(Long value1, Long value2) {
            addCriterion("posttc not between", value1, value2, "posttc");
            return (Criteria) this;
        }

        public Criteria andTtypeIsNull() {
            addCriterion("ttype is null");
            return (Criteria) this;
        }

        public Criteria andTtypeIsNotNull() {
            addCriterion("ttype is not null");
            return (Criteria) this;
        }

        public Criteria andTtypeEqualTo(String value) {
            addCriterion("ttype =", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeNotEqualTo(String value) {
            addCriterion("ttype <>", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeGreaterThan(String value) {
            addCriterion("ttype >", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeGreaterThanOrEqualTo(String value) {
            addCriterion("ttype >=", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeLessThan(String value) {
            addCriterion("ttype <", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeLessThanOrEqualTo(String value) {
            addCriterion("ttype <=", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeLike(String value) {
            addCriterion("ttype like", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeNotLike(String value) {
            addCriterion("ttype not like", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeIn(List<String> values) {
            addCriterion("ttype in", values, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeNotIn(List<String> values) {
            addCriterion("ttype not in", values, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeBetween(String value1, String value2) {
            addCriterion("ttype between", value1, value2, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeNotBetween(String value1, String value2) {
            addCriterion("ttype not between", value1, value2, "ttype");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Long value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Long value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Long value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Long value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Long value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Long> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Long> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Long value1, Long value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Long value1, Long value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andAsnIsNull() {
            addCriterion("asn is null");
            return (Criteria) this;
        }

        public Criteria andAsnIsNotNull() {
            addCriterion("asn is not null");
            return (Criteria) this;
        }

        public Criteria andAsnEqualTo(Long value) {
            addCriterion("asn =", value, "asn");
            return (Criteria) this;
        }

        public Criteria andAsnNotEqualTo(Long value) {
            addCriterion("asn <>", value, "asn");
            return (Criteria) this;
        }

        public Criteria andAsnGreaterThan(Long value) {
            addCriterion("asn >", value, "asn");
            return (Criteria) this;
        }

        public Criteria andAsnGreaterThanOrEqualTo(Long value) {
            addCriterion("asn >=", value, "asn");
            return (Criteria) this;
        }

        public Criteria andAsnLessThan(Long value) {
            addCriterion("asn <", value, "asn");
            return (Criteria) this;
        }

        public Criteria andAsnLessThanOrEqualTo(Long value) {
            addCriterion("asn <=", value, "asn");
            return (Criteria) this;
        }

        public Criteria andAsnIn(List<Long> values) {
            addCriterion("asn in", values, "asn");
            return (Criteria) this;
        }

        public Criteria andAsnNotIn(List<Long> values) {
            addCriterion("asn not in", values, "asn");
            return (Criteria) this;
        }

        public Criteria andAsnBetween(Long value1, Long value2) {
            addCriterion("asn between", value1, value2, "asn");
            return (Criteria) this;
        }

        public Criteria andAsnNotBetween(Long value1, Long value2) {
            addCriterion("asn not between", value1, value2, "asn");
            return (Criteria) this;
        }

        public Criteria andBalIsNull() {
            addCriterion("bal is null");
            return (Criteria) this;
        }

        public Criteria andBalIsNotNull() {
            addCriterion("bal is not null");
            return (Criteria) this;
        }

        public Criteria andBalEqualTo(Long value) {
            addCriterion("bal =", value, "bal");
            return (Criteria) this;
        }

        public Criteria andBalNotEqualTo(Long value) {
            addCriterion("bal <>", value, "bal");
            return (Criteria) this;
        }

        public Criteria andBalGreaterThan(Long value) {
            addCriterion("bal >", value, "bal");
            return (Criteria) this;
        }

        public Criteria andBalGreaterThanOrEqualTo(Long value) {
            addCriterion("bal >=", value, "bal");
            return (Criteria) this;
        }

        public Criteria andBalLessThan(Long value) {
            addCriterion("bal <", value, "bal");
            return (Criteria) this;
        }

        public Criteria andBalLessThanOrEqualTo(Long value) {
            addCriterion("bal <=", value, "bal");
            return (Criteria) this;
        }

        public Criteria andBalIn(List<Long> values) {
            addCriterion("bal in", values, "bal");
            return (Criteria) this;
        }

        public Criteria andBalNotIn(List<Long> values) {
            addCriterion("bal not in", values, "bal");
            return (Criteria) this;
        }

        public Criteria andBalBetween(Long value1, Long value2) {
            addCriterion("bal between", value1, value2, "bal");
            return (Criteria) this;
        }

        public Criteria andBalNotBetween(Long value1, Long value2) {
            addCriterion("bal not between", value1, value2, "bal");
            return (Criteria) this;
        }

        public Criteria andAmnIsNull() {
            addCriterion("amn is null");
            return (Criteria) this;
        }

        public Criteria andAmnIsNotNull() {
            addCriterion("amn is not null");
            return (Criteria) this;
        }

        public Criteria andAmnEqualTo(Long value) {
            addCriterion("amn =", value, "amn");
            return (Criteria) this;
        }

        public Criteria andAmnNotEqualTo(Long value) {
            addCriterion("amn <>", value, "amn");
            return (Criteria) this;
        }

        public Criteria andAmnGreaterThan(Long value) {
            addCriterion("amn >", value, "amn");
            return (Criteria) this;
        }

        public Criteria andAmnGreaterThanOrEqualTo(Long value) {
            addCriterion("amn >=", value, "amn");
            return (Criteria) this;
        }

        public Criteria andAmnLessThan(Long value) {
            addCriterion("amn <", value, "amn");
            return (Criteria) this;
        }

        public Criteria andAmnLessThanOrEqualTo(Long value) {
            addCriterion("amn <=", value, "amn");
            return (Criteria) this;
        }

        public Criteria andAmnIn(List<Long> values) {
            addCriterion("amn in", values, "amn");
            return (Criteria) this;
        }

        public Criteria andAmnNotIn(List<Long> values) {
            addCriterion("amn not in", values, "amn");
            return (Criteria) this;
        }

        public Criteria andAmnBetween(Long value1, Long value2) {
            addCriterion("amn between", value1, value2, "amn");
            return (Criteria) this;
        }

        public Criteria andAmnNotBetween(Long value1, Long value2) {
            addCriterion("amn not between", value1, value2, "amn");
            return (Criteria) this;
        }

        public Criteria andCtcIsNull() {
            addCriterion("ctc is null");
            return (Criteria) this;
        }

        public Criteria andCtcIsNotNull() {
            addCriterion("ctc is not null");
            return (Criteria) this;
        }

        public Criteria andCtcEqualTo(Long value) {
            addCriterion("ctc =", value, "ctc");
            return (Criteria) this;
        }

        public Criteria andCtcNotEqualTo(Long value) {
            addCriterion("ctc <>", value, "ctc");
            return (Criteria) this;
        }

        public Criteria andCtcGreaterThan(Long value) {
            addCriterion("ctc >", value, "ctc");
            return (Criteria) this;
        }

        public Criteria andCtcGreaterThanOrEqualTo(Long value) {
            addCriterion("ctc >=", value, "ctc");
            return (Criteria) this;
        }

        public Criteria andCtcLessThan(Long value) {
            addCriterion("ctc <", value, "ctc");
            return (Criteria) this;
        }

        public Criteria andCtcLessThanOrEqualTo(Long value) {
            addCriterion("ctc <=", value, "ctc");
            return (Criteria) this;
        }

        public Criteria andCtcIn(List<Long> values) {
            addCriterion("ctc in", values, "ctc");
            return (Criteria) this;
        }

        public Criteria andCtcNotIn(List<Long> values) {
            addCriterion("ctc not in", values, "ctc");
            return (Criteria) this;
        }

        public Criteria andCtcBetween(Long value1, Long value2) {
            addCriterion("ctc between", value1, value2, "ctc");
            return (Criteria) this;
        }

        public Criteria andCtcNotBetween(Long value1, Long value2) {
            addCriterion("ctc not between", value1, value2, "ctc");
            return (Criteria) this;
        }

        public Criteria andTacIsNull() {
            addCriterion("tac is null");
            return (Criteria) this;
        }

        public Criteria andTacIsNotNull() {
            addCriterion("tac is not null");
            return (Criteria) this;
        }

        public Criteria andTacEqualTo(Long value) {
            addCriterion("tac =", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacNotEqualTo(Long value) {
            addCriterion("tac <>", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacGreaterThan(Long value) {
            addCriterion("tac >", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacGreaterThanOrEqualTo(Long value) {
            addCriterion("tac >=", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacLessThan(Long value) {
            addCriterion("tac <", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacLessThanOrEqualTo(Long value) {
            addCriterion("tac <=", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacIn(List<Long> values) {
            addCriterion("tac in", values, "tac");
            return (Criteria) this;
        }

        public Criteria andTacNotIn(List<Long> values) {
            addCriterion("tac not in", values, "tac");
            return (Criteria) this;
        }

        public Criteria andTacBetween(Long value1, Long value2) {
            addCriterion("tac between", value1, value2, "tac");
            return (Criteria) this;
        }

        public Criteria andTacNotBetween(Long value1, Long value2) {
            addCriterion("tac not between", value1, value2, "tac");
            return (Criteria) this;
        }

        public Criteria andGmacIsNull() {
            addCriterion("gmac is null");
            return (Criteria) this;
        }

        public Criteria andGmacIsNotNull() {
            addCriterion("gmac is not null");
            return (Criteria) this;
        }

        public Criteria andGmacEqualTo(Long value) {
            addCriterion("gmac =", value, "gmac");
            return (Criteria) this;
        }

        public Criteria andGmacNotEqualTo(Long value) {
            addCriterion("gmac <>", value, "gmac");
            return (Criteria) this;
        }

        public Criteria andGmacGreaterThan(Long value) {
            addCriterion("gmac >", value, "gmac");
            return (Criteria) this;
        }

        public Criteria andGmacGreaterThanOrEqualTo(Long value) {
            addCriterion("gmac >=", value, "gmac");
            return (Criteria) this;
        }

        public Criteria andGmacLessThan(Long value) {
            addCriterion("gmac <", value, "gmac");
            return (Criteria) this;
        }

        public Criteria andGmacLessThanOrEqualTo(Long value) {
            addCriterion("gmac <=", value, "gmac");
            return (Criteria) this;
        }

        public Criteria andGmacIn(List<Long> values) {
            addCriterion("gmac in", values, "gmac");
            return (Criteria) this;
        }

        public Criteria andGmacNotIn(List<Long> values) {
            addCriterion("gmac not in", values, "gmac");
            return (Criteria) this;
        }

        public Criteria andGmacBetween(Long value1, Long value2) {
            addCriterion("gmac between", value1, value2, "gmac");
            return (Criteria) this;
        }

        public Criteria andGmacNotBetween(Long value1, Long value2) {
            addCriterion("gmac not between", value1, value2, "gmac");
            return (Criteria) this;
        }

        public Criteria andPsamtacIsNull() {
            addCriterion("psamtac is null");
            return (Criteria) this;
        }

        public Criteria andPsamtacIsNotNull() {
            addCriterion("psamtac is not null");
            return (Criteria) this;
        }

        public Criteria andPsamtacEqualTo(Long value) {
            addCriterion("psamtac =", value, "psamtac");
            return (Criteria) this;
        }

        public Criteria andPsamtacNotEqualTo(Long value) {
            addCriterion("psamtac <>", value, "psamtac");
            return (Criteria) this;
        }

        public Criteria andPsamtacGreaterThan(Long value) {
            addCriterion("psamtac >", value, "psamtac");
            return (Criteria) this;
        }

        public Criteria andPsamtacGreaterThanOrEqualTo(Long value) {
            addCriterion("psamtac >=", value, "psamtac");
            return (Criteria) this;
        }

        public Criteria andPsamtacLessThan(Long value) {
            addCriterion("psamtac <", value, "psamtac");
            return (Criteria) this;
        }

        public Criteria andPsamtacLessThanOrEqualTo(Long value) {
            addCriterion("psamtac <=", value, "psamtac");
            return (Criteria) this;
        }

        public Criteria andPsamtacIn(List<Long> values) {
            addCriterion("psamtac in", values, "psamtac");
            return (Criteria) this;
        }

        public Criteria andPsamtacNotIn(List<Long> values) {
            addCriterion("psamtac not in", values, "psamtac");
            return (Criteria) this;
        }

        public Criteria andPsamtacBetween(Long value1, Long value2) {
            addCriterion("psamtac between", value1, value2, "psamtac");
            return (Criteria) this;
        }

        public Criteria andPsamtacNotBetween(Long value1, Long value2) {
            addCriterion("psamtac not between", value1, value2, "psamtac");
            return (Criteria) this;
        }

        public Criteria andPsamasnIsNull() {
            addCriterion("psamasn is null");
            return (Criteria) this;
        }

        public Criteria andPsamasnIsNotNull() {
            addCriterion("psamasn is not null");
            return (Criteria) this;
        }

        public Criteria andPsamasnEqualTo(String value) {
            addCriterion("psamasn =", value, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamasnNotEqualTo(String value) {
            addCriterion("psamasn <>", value, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamasnGreaterThan(String value) {
            addCriterion("psamasn >", value, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamasnGreaterThanOrEqualTo(String value) {
            addCriterion("psamasn >=", value, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamasnLessThan(String value) {
            addCriterion("psamasn <", value, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamasnLessThanOrEqualTo(String value) {
            addCriterion("psamasn <=", value, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamasnLike(String value) {
            addCriterion("psamasn like", value, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamasnNotLike(String value) {
            addCriterion("psamasn not like", value, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamasnIn(List<String> values) {
            addCriterion("psamasn in", values, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamasnNotIn(List<String> values) {
            addCriterion("psamasn not in", values, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamasnBetween(String value1, String value2) {
            addCriterion("psamasn between", value1, value2, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamasnNotBetween(String value1, String value2) {
            addCriterion("psamasn not between", value1, value2, "psamasn");
            return (Criteria) this;
        }

        public Criteria andPsamtidIsNull() {
            addCriterion("psamtid is null");
            return (Criteria) this;
        }

        public Criteria andPsamtidIsNotNull() {
            addCriterion("psamtid is not null");
            return (Criteria) this;
        }

        public Criteria andPsamtidEqualTo(Long value) {
            addCriterion("psamtid =", value, "psamtid");
            return (Criteria) this;
        }

        public Criteria andPsamtidNotEqualTo(Long value) {
            addCriterion("psamtid <>", value, "psamtid");
            return (Criteria) this;
        }

        public Criteria andPsamtidGreaterThan(Long value) {
            addCriterion("psamtid >", value, "psamtid");
            return (Criteria) this;
        }

        public Criteria andPsamtidGreaterThanOrEqualTo(Long value) {
            addCriterion("psamtid >=", value, "psamtid");
            return (Criteria) this;
        }

        public Criteria andPsamtidLessThan(Long value) {
            addCriterion("psamtid <", value, "psamtid");
            return (Criteria) this;
        }

        public Criteria andPsamtidLessThanOrEqualTo(Long value) {
            addCriterion("psamtid <=", value, "psamtid");
            return (Criteria) this;
        }

        public Criteria andPsamtidIn(List<Long> values) {
            addCriterion("psamtid in", values, "psamtid");
            return (Criteria) this;
        }

        public Criteria andPsamtidNotIn(List<Long> values) {
            addCriterion("psamtid not in", values, "psamtid");
            return (Criteria) this;
        }

        public Criteria andPsamtidBetween(Long value1, Long value2) {
            addCriterion("psamtid between", value1, value2, "psamtid");
            return (Criteria) this;
        }

        public Criteria andPsamtidNotBetween(Long value1, Long value2) {
            addCriterion("psamtid not between", value1, value2, "psamtid");
            return (Criteria) this;
        }

        public Criteria andPsamttcIsNull() {
            addCriterion("psamttc is null");
            return (Criteria) this;
        }

        public Criteria andPsamttcIsNotNull() {
            addCriterion("psamttc is not null");
            return (Criteria) this;
        }

        public Criteria andPsamttcEqualTo(Long value) {
            addCriterion("psamttc =", value, "psamttc");
            return (Criteria) this;
        }

        public Criteria andPsamttcNotEqualTo(Long value) {
            addCriterion("psamttc <>", value, "psamttc");
            return (Criteria) this;
        }

        public Criteria andPsamttcGreaterThan(Long value) {
            addCriterion("psamttc >", value, "psamttc");
            return (Criteria) this;
        }

        public Criteria andPsamttcGreaterThanOrEqualTo(Long value) {
            addCriterion("psamttc >=", value, "psamttc");
            return (Criteria) this;
        }

        public Criteria andPsamttcLessThan(Long value) {
            addCriterion("psamttc <", value, "psamttc");
            return (Criteria) this;
        }

        public Criteria andPsamttcLessThanOrEqualTo(Long value) {
            addCriterion("psamttc <=", value, "psamttc");
            return (Criteria) this;
        }

        public Criteria andPsamttcIn(List<Long> values) {
            addCriterion("psamttc in", values, "psamttc");
            return (Criteria) this;
        }

        public Criteria andPsamttcNotIn(List<Long> values) {
            addCriterion("psamttc not in", values, "psamttc");
            return (Criteria) this;
        }

        public Criteria andPsamttcBetween(Long value1, Long value2) {
            addCriterion("psamttc between", value1, value2, "psamttc");
            return (Criteria) this;
        }

        public Criteria andPsamttcNotBetween(Long value1, Long value2) {
            addCriterion("psamttc not between", value1, value2, "psamttc");
            return (Criteria) this;
        }

        public Criteria andDsIsNull() {
            addCriterion("ds is null");
            return (Criteria) this;
        }

        public Criteria andDsIsNotNull() {
            addCriterion("ds is not null");
            return (Criteria) this;
        }

        public Criteria andDsEqualTo(Long value) {
            addCriterion("ds =", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsNotEqualTo(Long value) {
            addCriterion("ds <>", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsGreaterThan(Long value) {
            addCriterion("ds >", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsGreaterThanOrEqualTo(Long value) {
            addCriterion("ds >=", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsLessThan(Long value) {
            addCriterion("ds <", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsLessThanOrEqualTo(Long value) {
            addCriterion("ds <=", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsIn(List<Long> values) {
            addCriterion("ds in", values, "ds");
            return (Criteria) this;
        }

        public Criteria andDsNotIn(List<Long> values) {
            addCriterion("ds not in", values, "ds");
            return (Criteria) this;
        }

        public Criteria andDsBetween(Long value1, Long value2) {
            addCriterion("ds between", value1, value2, "ds");
            return (Criteria) this;
        }

        public Criteria andDsNotBetween(Long value1, Long value2) {
            addCriterion("ds not between", value1, value2, "ds");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andCtypeIsNull() {
            addCriterion("ctype is null");
            return (Criteria) this;
        }

        public Criteria andCtypeIsNotNull() {
            addCriterion("ctype is not null");
            return (Criteria) this;
        }

        public Criteria andCtypeEqualTo(String value) {
            addCriterion("ctype =", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotEqualTo(String value) {
            addCriterion("ctype <>", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeGreaterThan(String value) {
            addCriterion("ctype >", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeGreaterThanOrEqualTo(String value) {
            addCriterion("ctype >=", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLessThan(String value) {
            addCriterion("ctype <", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLessThanOrEqualTo(String value) {
            addCriterion("ctype <=", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLike(String value) {
            addCriterion("ctype like", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotLike(String value) {
            addCriterion("ctype not like", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeIn(List<String> values) {
            addCriterion("ctype in", values, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotIn(List<String> values) {
            addCriterion("ctype not in", values, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeBetween(String value1, String value2) {
            addCriterion("ctype between", value1, value2, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotBetween(String value1, String value2) {
            addCriterion("ctype not between", value1, value2, "ctype");
            return (Criteria) this;
        }

        public Criteria andVerIsNull() {
            addCriterion("ver is null");
            return (Criteria) this;
        }

        public Criteria andVerIsNotNull() {
            addCriterion("ver is not null");
            return (Criteria) this;
        }

        public Criteria andVerEqualTo(String value) {
            addCriterion("ver =", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerNotEqualTo(String value) {
            addCriterion("ver <>", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerGreaterThan(String value) {
            addCriterion("ver >", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerGreaterThanOrEqualTo(String value) {
            addCriterion("ver >=", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerLessThan(String value) {
            addCriterion("ver <", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerLessThanOrEqualTo(String value) {
            addCriterion("ver <=", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerLike(String value) {
            addCriterion("ver like", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerNotLike(String value) {
            addCriterion("ver not like", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerIn(List<String> values) {
            addCriterion("ver in", values, "ver");
            return (Criteria) this;
        }

        public Criteria andVerNotIn(List<String> values) {
            addCriterion("ver not in", values, "ver");
            return (Criteria) this;
        }

        public Criteria andVerBetween(String value1, String value2) {
            addCriterion("ver between", value1, value2, "ver");
            return (Criteria) this;
        }

        public Criteria andVerNotBetween(String value1, String value2) {
            addCriterion("ver not between", value1, value2, "ver");
            return (Criteria) this;
        }

        public Criteria andNznIsNull() {
            addCriterion("nzn is null");
            return (Criteria) this;
        }

        public Criteria andNznIsNotNull() {
            addCriterion("nzn is not null");
            return (Criteria) this;
        }

        public Criteria andNznEqualTo(Long value) {
            addCriterion("nzn =", value, "nzn");
            return (Criteria) this;
        }

        public Criteria andNznNotEqualTo(Long value) {
            addCriterion("nzn <>", value, "nzn");
            return (Criteria) this;
        }

        public Criteria andNznGreaterThan(Long value) {
            addCriterion("nzn >", value, "nzn");
            return (Criteria) this;
        }

        public Criteria andNznGreaterThanOrEqualTo(Long value) {
            addCriterion("nzn >=", value, "nzn");
            return (Criteria) this;
        }

        public Criteria andNznLessThan(Long value) {
            addCriterion("nzn <", value, "nzn");
            return (Criteria) this;
        }

        public Criteria andNznLessThanOrEqualTo(Long value) {
            addCriterion("nzn <=", value, "nzn");
            return (Criteria) this;
        }

        public Criteria andNznIn(List<Long> values) {
            addCriterion("nzn in", values, "nzn");
            return (Criteria) this;
        }

        public Criteria andNznNotIn(List<Long> values) {
            addCriterion("nzn not in", values, "nzn");
            return (Criteria) this;
        }

        public Criteria andNznBetween(Long value1, Long value2) {
            addCriterion("nzn between", value1, value2, "nzn");
            return (Criteria) this;
        }

        public Criteria andNznNotBetween(Long value1, Long value2) {
            addCriterion("nzn not between", value1, value2, "nzn");
            return (Criteria) this;
        }

        public Criteria andGcodeIsNull() {
            addCriterion("gcode is null");
            return (Criteria) this;
        }

        public Criteria andGcodeIsNotNull() {
            addCriterion("gcode is not null");
            return (Criteria) this;
        }

        public Criteria andGcodeEqualTo(String value) {
            addCriterion("gcode =", value, "gcode");
            return (Criteria) this;
        }

        public Criteria andGcodeNotEqualTo(String value) {
            addCriterion("gcode <>", value, "gcode");
            return (Criteria) this;
        }

        public Criteria andGcodeGreaterThan(String value) {
            addCriterion("gcode >", value, "gcode");
            return (Criteria) this;
        }

        public Criteria andGcodeGreaterThanOrEqualTo(String value) {
            addCriterion("gcode >=", value, "gcode");
            return (Criteria) this;
        }

        public Criteria andGcodeLessThan(String value) {
            addCriterion("gcode <", value, "gcode");
            return (Criteria) this;
        }

        public Criteria andGcodeLessThanOrEqualTo(String value) {
            addCriterion("gcode <=", value, "gcode");
            return (Criteria) this;
        }

        public Criteria andGcodeLike(String value) {
            addCriterion("gcode like", value, "gcode");
            return (Criteria) this;
        }

        public Criteria andGcodeNotLike(String value) {
            addCriterion("gcode not like", value, "gcode");
            return (Criteria) this;
        }

        public Criteria andGcodeIn(List<String> values) {
            addCriterion("gcode in", values, "gcode");
            return (Criteria) this;
        }

        public Criteria andGcodeNotIn(List<String> values) {
            addCriterion("gcode not in", values, "gcode");
            return (Criteria) this;
        }

        public Criteria andGcodeBetween(String value1, String value2) {
            addCriterion("gcode between", value1, value2, "gcode");
            return (Criteria) this;
        }

        public Criteria andGcodeNotBetween(String value1, String value2) {
            addCriterion("gcode not between", value1, value2, "gcode");
            return (Criteria) this;
        }

        public Criteria andVolIsNull() {
            addCriterion("vol is null");
            return (Criteria) this;
        }

        public Criteria andVolIsNotNull() {
            addCriterion("vol is not null");
            return (Criteria) this;
        }

        public Criteria andVolEqualTo(Long value) {
            addCriterion("vol =", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotEqualTo(Long value) {
            addCriterion("vol <>", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThan(Long value) {
            addCriterion("vol >", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThanOrEqualTo(Long value) {
            addCriterion("vol >=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThan(Long value) {
            addCriterion("vol <", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThanOrEqualTo(Long value) {
            addCriterion("vol <=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolIn(List<Long> values) {
            addCriterion("vol in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotIn(List<Long> values) {
            addCriterion("vol not in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolBetween(Long value1, Long value2) {
            addCriterion("vol between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotBetween(Long value1, Long value2) {
            addCriterion("vol not between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andPrcIsNull() {
            addCriterion("prc is null");
            return (Criteria) this;
        }

        public Criteria andPrcIsNotNull() {
            addCriterion("prc is not null");
            return (Criteria) this;
        }

        public Criteria andPrcEqualTo(Long value) {
            addCriterion("prc =", value, "prc");
            return (Criteria) this;
        }

        public Criteria andPrcNotEqualTo(Long value) {
            addCriterion("prc <>", value, "prc");
            return (Criteria) this;
        }

        public Criteria andPrcGreaterThan(Long value) {
            addCriterion("prc >", value, "prc");
            return (Criteria) this;
        }

        public Criteria andPrcGreaterThanOrEqualTo(Long value) {
            addCriterion("prc >=", value, "prc");
            return (Criteria) this;
        }

        public Criteria andPrcLessThan(Long value) {
            addCriterion("prc <", value, "prc");
            return (Criteria) this;
        }

        public Criteria andPrcLessThanOrEqualTo(Long value) {
            addCriterion("prc <=", value, "prc");
            return (Criteria) this;
        }

        public Criteria andPrcIn(List<Long> values) {
            addCriterion("prc in", values, "prc");
            return (Criteria) this;
        }

        public Criteria andPrcNotIn(List<Long> values) {
            addCriterion("prc not in", values, "prc");
            return (Criteria) this;
        }

        public Criteria andPrcBetween(Long value1, Long value2) {
            addCriterion("prc between", value1, value2, "prc");
            return (Criteria) this;
        }

        public Criteria andPrcNotBetween(Long value1, Long value2) {
            addCriterion("prc not between", value1, value2, "prc");
            return (Criteria) this;
        }

        public Criteria andEmpIsNull() {
            addCriterion("emp is null");
            return (Criteria) this;
        }

        public Criteria andEmpIsNotNull() {
            addCriterion("emp is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEqualTo(Long value) {
            addCriterion("emp =", value, "emp");
            return (Criteria) this;
        }

        public Criteria andEmpNotEqualTo(Long value) {
            addCriterion("emp <>", value, "emp");
            return (Criteria) this;
        }

        public Criteria andEmpGreaterThan(Long value) {
            addCriterion("emp >", value, "emp");
            return (Criteria) this;
        }

        public Criteria andEmpGreaterThanOrEqualTo(Long value) {
            addCriterion("emp >=", value, "emp");
            return (Criteria) this;
        }

        public Criteria andEmpLessThan(Long value) {
            addCriterion("emp <", value, "emp");
            return (Criteria) this;
        }

        public Criteria andEmpLessThanOrEqualTo(Long value) {
            addCriterion("emp <=", value, "emp");
            return (Criteria) this;
        }

        public Criteria andEmpIn(List<Long> values) {
            addCriterion("emp in", values, "emp");
            return (Criteria) this;
        }

        public Criteria andEmpNotIn(List<Long> values) {
            addCriterion("emp not in", values, "emp");
            return (Criteria) this;
        }

        public Criteria andEmpBetween(Long value1, Long value2) {
            addCriterion("emp between", value1, value2, "emp");
            return (Criteria) this;
        }

        public Criteria andEmpNotBetween(Long value1, Long value2) {
            addCriterion("emp not between", value1, value2, "emp");
            return (Criteria) this;
        }

        public Criteria andVtotIsNull() {
            addCriterion("vtot is null");
            return (Criteria) this;
        }

        public Criteria andVtotIsNotNull() {
            addCriterion("vtot is not null");
            return (Criteria) this;
        }

        public Criteria andVtotEqualTo(Long value) {
            addCriterion("vtot =", value, "vtot");
            return (Criteria) this;
        }

        public Criteria andVtotNotEqualTo(Long value) {
            addCriterion("vtot <>", value, "vtot");
            return (Criteria) this;
        }

        public Criteria andVtotGreaterThan(Long value) {
            addCriterion("vtot >", value, "vtot");
            return (Criteria) this;
        }

        public Criteria andVtotGreaterThanOrEqualTo(Long value) {
            addCriterion("vtot >=", value, "vtot");
            return (Criteria) this;
        }

        public Criteria andVtotLessThan(Long value) {
            addCriterion("vtot <", value, "vtot");
            return (Criteria) this;
        }

        public Criteria andVtotLessThanOrEqualTo(Long value) {
            addCriterion("vtot <=", value, "vtot");
            return (Criteria) this;
        }

        public Criteria andVtotIn(List<Long> values) {
            addCriterion("vtot in", values, "vtot");
            return (Criteria) this;
        }

        public Criteria andVtotNotIn(List<Long> values) {
            addCriterion("vtot not in", values, "vtot");
            return (Criteria) this;
        }

        public Criteria andVtotBetween(Long value1, Long value2) {
            addCriterion("vtot between", value1, value2, "vtot");
            return (Criteria) this;
        }

        public Criteria andVtotNotBetween(Long value1, Long value2) {
            addCriterion("vtot not between", value1, value2, "vtot");
            return (Criteria) this;
        }

        public Criteria andRfuIsNull() {
            addCriterion("rfu is null");
            return (Criteria) this;
        }

        public Criteria andRfuIsNotNull() {
            addCriterion("rfu is not null");
            return (Criteria) this;
        }

        public Criteria andRfuEqualTo(Long value) {
            addCriterion("rfu =", value, "rfu");
            return (Criteria) this;
        }

        public Criteria andRfuNotEqualTo(Long value) {
            addCriterion("rfu <>", value, "rfu");
            return (Criteria) this;
        }

        public Criteria andRfuGreaterThan(Long value) {
            addCriterion("rfu >", value, "rfu");
            return (Criteria) this;
        }

        public Criteria andRfuGreaterThanOrEqualTo(Long value) {
            addCriterion("rfu >=", value, "rfu");
            return (Criteria) this;
        }

        public Criteria andRfuLessThan(Long value) {
            addCriterion("rfu <", value, "rfu");
            return (Criteria) this;
        }

        public Criteria andRfuLessThanOrEqualTo(Long value) {
            addCriterion("rfu <=", value, "rfu");
            return (Criteria) this;
        }

        public Criteria andRfuIn(List<Long> values) {
            addCriterion("rfu in", values, "rfu");
            return (Criteria) this;
        }

        public Criteria andRfuNotIn(List<Long> values) {
            addCriterion("rfu not in", values, "rfu");
            return (Criteria) this;
        }

        public Criteria andRfuBetween(Long value1, Long value2) {
            addCriterion("rfu between", value1, value2, "rfu");
            return (Criteria) this;
        }

        public Criteria andRfuNotBetween(Long value1, Long value2) {
            addCriterion("rfu not between", value1, value2, "rfu");
            return (Criteria) this;
        }

        public Criteria andTmacIsNull() {
            addCriterion("tmac is null");
            return (Criteria) this;
        }

        public Criteria andTmacIsNotNull() {
            addCriterion("tmac is not null");
            return (Criteria) this;
        }

        public Criteria andTmacEqualTo(Long value) {
            addCriterion("tmac =", value, "tmac");
            return (Criteria) this;
        }

        public Criteria andTmacNotEqualTo(Long value) {
            addCriterion("tmac <>", value, "tmac");
            return (Criteria) this;
        }

        public Criteria andTmacGreaterThan(Long value) {
            addCriterion("tmac >", value, "tmac");
            return (Criteria) this;
        }

        public Criteria andTmacGreaterThanOrEqualTo(Long value) {
            addCriterion("tmac >=", value, "tmac");
            return (Criteria) this;
        }

        public Criteria andTmacLessThan(Long value) {
            addCriterion("tmac <", value, "tmac");
            return (Criteria) this;
        }

        public Criteria andTmacLessThanOrEqualTo(Long value) {
            addCriterion("tmac <=", value, "tmac");
            return (Criteria) this;
        }

        public Criteria andTmacIn(List<Long> values) {
            addCriterion("tmac in", values, "tmac");
            return (Criteria) this;
        }

        public Criteria andTmacNotIn(List<Long> values) {
            addCriterion("tmac not in", values, "tmac");
            return (Criteria) this;
        }

        public Criteria andTmacBetween(Long value1, Long value2) {
            addCriterion("tmac between", value1, value2, "tmac");
            return (Criteria) this;
        }

        public Criteria andTmacNotBetween(Long value1, Long value2) {
            addCriterion("tmac not between", value1, value2, "tmac");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSortsIsNull() {
            addCriterion("sorts is null");
            return (Criteria) this;
        }

        public Criteria andSortsIsNotNull() {
            addCriterion("sorts is not null");
            return (Criteria) this;
        }

        public Criteria andSortsEqualTo(Long value) {
            addCriterion("sorts =", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotEqualTo(Long value) {
            addCriterion("sorts <>", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThan(Long value) {
            addCriterion("sorts >", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThanOrEqualTo(Long value) {
            addCriterion("sorts >=", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThan(Long value) {
            addCriterion("sorts <", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThanOrEqualTo(Long value) {
            addCriterion("sorts <=", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsIn(List<Long> values) {
            addCriterion("sorts in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotIn(List<Long> values) {
            addCriterion("sorts not in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsBetween(Long value1, Long value2) {
            addCriterion("sorts between", value1, value2, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotBetween(Long value1, Long value2) {
            addCriterion("sorts not between", value1, value2, "sorts");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNull() {
            addCriterion("updateuser is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNotNull() {
            addCriterion("updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserEqualTo(String value) {
            addCriterion("updateuser =", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotEqualTo(String value) {
            addCriterion("updateuser <>", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThan(String value) {
            addCriterion("updateuser >", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("updateuser >=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThan(String value) {
            addCriterion("updateuser <", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("updateuser <=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLike(String value) {
            addCriterion("updateuser like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotLike(String value) {
            addCriterion("updateuser not like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIn(List<String> values) {
            addCriterion("updateuser in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotIn(List<String> values) {
            addCriterion("updateuser not in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserBetween(String value1, String value2) {
            addCriterion("updateuser between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotBetween(String value1, String value2) {
            addCriterion("updateuser not between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
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