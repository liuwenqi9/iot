package com.pcitc.oilmachine.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLoginfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserLoginfoExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andStncodeIsNull() {
            addCriterion("stncode is null");
            return (Criteria) this;
        }

        public Criteria andStncodeIsNotNull() {
            addCriterion("stncode is not null");
            return (Criteria) this;
        }

        public Criteria andStncodeEqualTo(String value) {
            addCriterion("stncode =", value, "stncode");
            return (Criteria) this;
        }

        public Criteria andStncodeNotEqualTo(String value) {
            addCriterion("stncode <>", value, "stncode");
            return (Criteria) this;
        }

        public Criteria andStncodeGreaterThan(String value) {
            addCriterion("stncode >", value, "stncode");
            return (Criteria) this;
        }

        public Criteria andStncodeGreaterThanOrEqualTo(String value) {
            addCriterion("stncode >=", value, "stncode");
            return (Criteria) this;
        }

        public Criteria andStncodeLessThan(String value) {
            addCriterion("stncode <", value, "stncode");
            return (Criteria) this;
        }

        public Criteria andStncodeLessThanOrEqualTo(String value) {
            addCriterion("stncode <=", value, "stncode");
            return (Criteria) this;
        }

        public Criteria andStncodeLike(String value) {
            addCriterion("stncode like", value, "stncode");
            return (Criteria) this;
        }

        public Criteria andStncodeNotLike(String value) {
            addCriterion("stncode not like", value, "stncode");
            return (Criteria) this;
        }

        public Criteria andStncodeIn(List<String> values) {
            addCriterion("stncode in", values, "stncode");
            return (Criteria) this;
        }

        public Criteria andStncodeNotIn(List<String> values) {
            addCriterion("stncode not in", values, "stncode");
            return (Criteria) this;
        }

        public Criteria andStncodeBetween(String value1, String value2) {
            addCriterion("stncode between", value1, value2, "stncode");
            return (Criteria) this;
        }

        public Criteria andStncodeNotBetween(String value1, String value2) {
            addCriterion("stncode not between", value1, value2, "stncode");
            return (Criteria) this;
        }

        public Criteria andStnnameIsNull() {
            addCriterion("stnname is null");
            return (Criteria) this;
        }

        public Criteria andStnnameIsNotNull() {
            addCriterion("stnname is not null");
            return (Criteria) this;
        }

        public Criteria andStnnameEqualTo(String value) {
            addCriterion("stnname =", value, "stnname");
            return (Criteria) this;
        }

        public Criteria andStnnameNotEqualTo(String value) {
            addCriterion("stnname <>", value, "stnname");
            return (Criteria) this;
        }

        public Criteria andStnnameGreaterThan(String value) {
            addCriterion("stnname >", value, "stnname");
            return (Criteria) this;
        }

        public Criteria andStnnameGreaterThanOrEqualTo(String value) {
            addCriterion("stnname >=", value, "stnname");
            return (Criteria) this;
        }

        public Criteria andStnnameLessThan(String value) {
            addCriterion("stnname <", value, "stnname");
            return (Criteria) this;
        }

        public Criteria andStnnameLessThanOrEqualTo(String value) {
            addCriterion("stnname <=", value, "stnname");
            return (Criteria) this;
        }

        public Criteria andStnnameLike(String value) {
            addCriterion("stnname like", value, "stnname");
            return (Criteria) this;
        }

        public Criteria andStnnameNotLike(String value) {
            addCriterion("stnname not like", value, "stnname");
            return (Criteria) this;
        }

        public Criteria andStnnameIn(List<String> values) {
            addCriterion("stnname in", values, "stnname");
            return (Criteria) this;
        }

        public Criteria andStnnameNotIn(List<String> values) {
            addCriterion("stnname not in", values, "stnname");
            return (Criteria) this;
        }

        public Criteria andStnnameBetween(String value1, String value2) {
            addCriterion("stnname between", value1, value2, "stnname");
            return (Criteria) this;
        }

        public Criteria andStnnameNotBetween(String value1, String value2) {
            addCriterion("stnname not between", value1, value2, "stnname");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
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

        public Criteria andAreacodeIsNull() {
            addCriterion("areacode is null");
            return (Criteria) this;
        }

        public Criteria andAreacodeIsNotNull() {
            addCriterion("areacode is not null");
            return (Criteria) this;
        }

        public Criteria andAreacodeEqualTo(String value) {
            addCriterion("areacode =", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotEqualTo(String value) {
            addCriterion("areacode <>", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThan(String value) {
            addCriterion("areacode >", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThanOrEqualTo(String value) {
            addCriterion("areacode >=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThan(String value) {
            addCriterion("areacode <", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThanOrEqualTo(String value) {
            addCriterion("areacode <=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLike(String value) {
            addCriterion("areacode like", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotLike(String value) {
            addCriterion("areacode not like", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeIn(List<String> values) {
            addCriterion("areacode in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotIn(List<String> values) {
            addCriterion("areacode not in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeBetween(String value1, String value2) {
            addCriterion("areacode between", value1, value2, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotBetween(String value1, String value2) {
            addCriterion("areacode not between", value1, value2, "areacode");
            return (Criteria) this;
        }

        public Criteria andOilcodeIsNull() {
            addCriterion("oilcode is null");
            return (Criteria) this;
        }

        public Criteria andOilcodeIsNotNull() {
            addCriterion("oilcode is not null");
            return (Criteria) this;
        }

        public Criteria andOilcodeEqualTo(String value) {
            addCriterion("oilcode =", value, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilcodeNotEqualTo(String value) {
            addCriterion("oilcode <>", value, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilcodeGreaterThan(String value) {
            addCriterion("oilcode >", value, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilcodeGreaterThanOrEqualTo(String value) {
            addCriterion("oilcode >=", value, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilcodeLessThan(String value) {
            addCriterion("oilcode <", value, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilcodeLessThanOrEqualTo(String value) {
            addCriterion("oilcode <=", value, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilcodeLike(String value) {
            addCriterion("oilcode like", value, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilcodeNotLike(String value) {
            addCriterion("oilcode not like", value, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilcodeIn(List<String> values) {
            addCriterion("oilcode in", values, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilcodeNotIn(List<String> values) {
            addCriterion("oilcode not in", values, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilcodeBetween(String value1, String value2) {
            addCriterion("oilcode between", value1, value2, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilcodeNotBetween(String value1, String value2) {
            addCriterion("oilcode not between", value1, value2, "oilcode");
            return (Criteria) this;
        }

        public Criteria andOilnoIsNull() {
            addCriterion("oilno is null");
            return (Criteria) this;
        }

        public Criteria andOilnoIsNotNull() {
            addCriterion("oilno is not null");
            return (Criteria) this;
        }

        public Criteria andOilnoEqualTo(String value) {
            addCriterion("oilno =", value, "oilno");
            return (Criteria) this;
        }

        public Criteria andOilnoNotEqualTo(String value) {
            addCriterion("oilno <>", value, "oilno");
            return (Criteria) this;
        }

        public Criteria andOilnoGreaterThan(String value) {
            addCriterion("oilno >", value, "oilno");
            return (Criteria) this;
        }

        public Criteria andOilnoGreaterThanOrEqualTo(String value) {
            addCriterion("oilno >=", value, "oilno");
            return (Criteria) this;
        }

        public Criteria andOilnoLessThan(String value) {
            addCriterion("oilno <", value, "oilno");
            return (Criteria) this;
        }

        public Criteria andOilnoLessThanOrEqualTo(String value) {
            addCriterion("oilno <=", value, "oilno");
            return (Criteria) this;
        }

        public Criteria andOilnoLike(String value) {
            addCriterion("oilno like", value, "oilno");
            return (Criteria) this;
        }

        public Criteria andOilnoNotLike(String value) {
            addCriterion("oilno not like", value, "oilno");
            return (Criteria) this;
        }

        public Criteria andOilnoIn(List<String> values) {
            addCriterion("oilno in", values, "oilno");
            return (Criteria) this;
        }

        public Criteria andOilnoNotIn(List<String> values) {
            addCriterion("oilno not in", values, "oilno");
            return (Criteria) this;
        }

        public Criteria andOilnoBetween(String value1, String value2) {
            addCriterion("oilno between", value1, value2, "oilno");
            return (Criteria) this;
        }

        public Criteria andOilnoNotBetween(String value1, String value2) {
            addCriterion("oilno not between", value1, value2, "oilno");
            return (Criteria) this;
        }

        public Criteria andCarnumIsNull() {
            addCriterion("carnum is null");
            return (Criteria) this;
        }

        public Criteria andCarnumIsNotNull() {
            addCriterion("carnum is not null");
            return (Criteria) this;
        }

        public Criteria andCarnumEqualTo(String value) {
            addCriterion("carnum =", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumNotEqualTo(String value) {
            addCriterion("carnum <>", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumGreaterThan(String value) {
            addCriterion("carnum >", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumGreaterThanOrEqualTo(String value) {
            addCriterion("carnum >=", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumLessThan(String value) {
            addCriterion("carnum <", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumLessThanOrEqualTo(String value) {
            addCriterion("carnum <=", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumLike(String value) {
            addCriterion("carnum like", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumNotLike(String value) {
            addCriterion("carnum not like", value, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumIn(List<String> values) {
            addCriterion("carnum in", values, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumNotIn(List<String> values) {
            addCriterion("carnum not in", values, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumBetween(String value1, String value2) {
            addCriterion("carnum between", value1, value2, "carnum");
            return (Criteria) this;
        }

        public Criteria andCarnumNotBetween(String value1, String value2) {
            addCriterion("carnum not between", value1, value2, "carnum");
            return (Criteria) this;
        }

        public Criteria andNozzlenoIsNull() {
            addCriterion("nozzleno is null");
            return (Criteria) this;
        }

        public Criteria andNozzlenoIsNotNull() {
            addCriterion("nozzleno is not null");
            return (Criteria) this;
        }

        public Criteria andNozzlenoEqualTo(String value) {
            addCriterion("nozzleno =", value, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andNozzlenoNotEqualTo(String value) {
            addCriterion("nozzleno <>", value, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andNozzlenoGreaterThan(String value) {
            addCriterion("nozzleno >", value, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andNozzlenoGreaterThanOrEqualTo(String value) {
            addCriterion("nozzleno >=", value, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andNozzlenoLessThan(String value) {
            addCriterion("nozzleno <", value, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andNozzlenoLessThanOrEqualTo(String value) {
            addCriterion("nozzleno <=", value, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andNozzlenoLike(String value) {
            addCriterion("nozzleno like", value, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andNozzlenoNotLike(String value) {
            addCriterion("nozzleno not like", value, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andNozzlenoIn(List<String> values) {
            addCriterion("nozzleno in", values, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andNozzlenoNotIn(List<String> values) {
            addCriterion("nozzleno not in", values, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andNozzlenoBetween(String value1, String value2) {
            addCriterion("nozzleno between", value1, value2, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andNozzlenoNotBetween(String value1, String value2) {
            addCriterion("nozzleno not between", value1, value2, "nozzleno");
            return (Criteria) this;
        }

        public Criteria andSessionidIsNull() {
            addCriterion("sessionid is null");
            return (Criteria) this;
        }

        public Criteria andSessionidIsNotNull() {
            addCriterion("sessionid is not null");
            return (Criteria) this;
        }

        public Criteria andSessionidEqualTo(String value) {
            addCriterion("sessionid =", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotEqualTo(String value) {
            addCriterion("sessionid <>", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidGreaterThan(String value) {
            addCriterion("sessionid >", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidGreaterThanOrEqualTo(String value) {
            addCriterion("sessionid >=", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLessThan(String value) {
            addCriterion("sessionid <", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLessThanOrEqualTo(String value) {
            addCriterion("sessionid <=", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLike(String value) {
            addCriterion("sessionid like", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotLike(String value) {
            addCriterion("sessionid not like", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidIn(List<String> values) {
            addCriterion("sessionid in", values, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotIn(List<String> values) {
            addCriterion("sessionid not in", values, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidBetween(String value1, String value2) {
            addCriterion("sessionid between", value1, value2, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotBetween(String value1, String value2) {
            addCriterion("sessionid not between", value1, value2, "sessionid");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(String value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(String value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(String value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(String value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(String value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(String value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLike(String value) {
            addCriterion("step like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotLike(String value) {
            addCriterion("step not like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<String> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<String> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(String value1, String value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(String value1, String value2) {
            addCriterion("step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andFreepwordIsNull() {
            addCriterion("freepword is null");
            return (Criteria) this;
        }

        public Criteria andFreepwordIsNotNull() {
            addCriterion("freepword is not null");
            return (Criteria) this;
        }

        public Criteria andFreepwordEqualTo(String value) {
            addCriterion("freepword =", value, "freepword");
            return (Criteria) this;
        }

        public Criteria andFreepwordNotEqualTo(String value) {
            addCriterion("freepword <>", value, "freepword");
            return (Criteria) this;
        }

        public Criteria andFreepwordGreaterThan(String value) {
            addCriterion("freepword >", value, "freepword");
            return (Criteria) this;
        }

        public Criteria andFreepwordGreaterThanOrEqualTo(String value) {
            addCriterion("freepword >=", value, "freepword");
            return (Criteria) this;
        }

        public Criteria andFreepwordLessThan(String value) {
            addCriterion("freepword <", value, "freepword");
            return (Criteria) this;
        }

        public Criteria andFreepwordLessThanOrEqualTo(String value) {
            addCriterion("freepword <=", value, "freepword");
            return (Criteria) this;
        }

        public Criteria andFreepwordLike(String value) {
            addCriterion("freepword like", value, "freepword");
            return (Criteria) this;
        }

        public Criteria andFreepwordNotLike(String value) {
            addCriterion("freepword not like", value, "freepword");
            return (Criteria) this;
        }

        public Criteria andFreepwordIn(List<String> values) {
            addCriterion("freepword in", values, "freepword");
            return (Criteria) this;
        }

        public Criteria andFreepwordNotIn(List<String> values) {
            addCriterion("freepword not in", values, "freepword");
            return (Criteria) this;
        }

        public Criteria andFreepwordBetween(String value1, String value2) {
            addCriterion("freepword between", value1, value2, "freepword");
            return (Criteria) this;
        }

        public Criteria andFreepwordNotBetween(String value1, String value2) {
            addCriterion("freepword not between", value1, value2, "freepword");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNull() {
            addCriterion("loginTime is null");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNotNull() {
            addCriterion("loginTime is not null");
            return (Criteria) this;
        }

        public Criteria andLogintimeEqualTo(Date value) {
            addCriterion("loginTime =", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotEqualTo(Date value) {
            addCriterion("loginTime <>", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThan(Date value) {
            addCriterion("loginTime >", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("loginTime >=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThan(Date value) {
            addCriterion("loginTime <", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThanOrEqualTo(Date value) {
            addCriterion("loginTime <=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeIn(List<Date> values) {
            addCriterion("loginTime in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotIn(List<Date> values) {
            addCriterion("loginTime not in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeBetween(Date value1, Date value2) {
            addCriterion("loginTime between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotBetween(Date value1, Date value2) {
            addCriterion("loginTime not between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeIsNull() {
            addCriterion("logoutTime is null");
            return (Criteria) this;
        }

        public Criteria andLogouttimeIsNotNull() {
            addCriterion("logoutTime is not null");
            return (Criteria) this;
        }

        public Criteria andLogouttimeEqualTo(Date value) {
            addCriterion("logoutTime =", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeNotEqualTo(Date value) {
            addCriterion("logoutTime <>", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeGreaterThan(Date value) {
            addCriterion("logoutTime >", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("logoutTime >=", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeLessThan(Date value) {
            addCriterion("logoutTime <", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeLessThanOrEqualTo(Date value) {
            addCriterion("logoutTime <=", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeIn(List<Date> values) {
            addCriterion("logoutTime in", values, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeNotIn(List<Date> values) {
            addCriterion("logoutTime not in", values, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeBetween(Date value1, Date value2) {
            addCriterion("logoutTime between", value1, value2, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeNotBetween(Date value1, Date value2) {
            addCriterion("logoutTime not between", value1, value2, "logouttime");
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

        public Criteria andLefttopxEqualTo(Long value) {
            addCriterion("lefttopx =", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxNotEqualTo(Long value) {
            addCriterion("lefttopx <>", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxGreaterThan(Long value) {
            addCriterion("lefttopx >", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxGreaterThanOrEqualTo(Long value) {
            addCriterion("lefttopx >=", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxLessThan(Long value) {
            addCriterion("lefttopx <", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxLessThanOrEqualTo(Long value) {
            addCriterion("lefttopx <=", value, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxIn(List<Long> values) {
            addCriterion("lefttopx in", values, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxNotIn(List<Long> values) {
            addCriterion("lefttopx not in", values, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxBetween(Long value1, Long value2) {
            addCriterion("lefttopx between", value1, value2, "lefttopx");
            return (Criteria) this;
        }

        public Criteria andLefttopxNotBetween(Long value1, Long value2) {
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

        public Criteria andLefttopyEqualTo(Long value) {
            addCriterion("lefttopy =", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyNotEqualTo(Long value) {
            addCriterion("lefttopy <>", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyGreaterThan(Long value) {
            addCriterion("lefttopy >", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyGreaterThanOrEqualTo(Long value) {
            addCriterion("lefttopy >=", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyLessThan(Long value) {
            addCriterion("lefttopy <", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyLessThanOrEqualTo(Long value) {
            addCriterion("lefttopy <=", value, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyIn(List<Long> values) {
            addCriterion("lefttopy in", values, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyNotIn(List<Long> values) {
            addCriterion("lefttopy not in", values, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyBetween(Long value1, Long value2) {
            addCriterion("lefttopy between", value1, value2, "lefttopy");
            return (Criteria) this;
        }

        public Criteria andLefttopyNotBetween(Long value1, Long value2) {
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

        public Criteria andRightbottomxEqualTo(Long value) {
            addCriterion("rightbottomx =", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxNotEqualTo(Long value) {
            addCriterion("rightbottomx <>", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxGreaterThan(Long value) {
            addCriterion("rightbottomx >", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxGreaterThanOrEqualTo(Long value) {
            addCriterion("rightbottomx >=", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxLessThan(Long value) {
            addCriterion("rightbottomx <", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxLessThanOrEqualTo(Long value) {
            addCriterion("rightbottomx <=", value, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxIn(List<Long> values) {
            addCriterion("rightbottomx in", values, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxNotIn(List<Long> values) {
            addCriterion("rightbottomx not in", values, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxBetween(Long value1, Long value2) {
            addCriterion("rightbottomx between", value1, value2, "rightbottomx");
            return (Criteria) this;
        }

        public Criteria andRightbottomxNotBetween(Long value1, Long value2) {
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

        public Criteria andRightbottomyEqualTo(Long value) {
            addCriterion("rightbottomy =", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyNotEqualTo(Long value) {
            addCriterion("rightbottomy <>", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyGreaterThan(Long value) {
            addCriterion("rightbottomy >", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyGreaterThanOrEqualTo(Long value) {
            addCriterion("rightbottomy >=", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyLessThan(Long value) {
            addCriterion("rightbottomy <", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyLessThanOrEqualTo(Long value) {
            addCriterion("rightbottomy <=", value, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyIn(List<Long> values) {
            addCriterion("rightbottomy in", values, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyNotIn(List<Long> values) {
            addCriterion("rightbottomy not in", values, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyBetween(Long value1, Long value2) {
            addCriterion("rightbottomy between", value1, value2, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andRightbottomyNotBetween(Long value1, Long value2) {
            addCriterion("rightbottomy not between", value1, value2, "rightbottomy");
            return (Criteria) this;
        }

        public Criteria andCarcolorIsNull() {
            addCriterion("carcolor is null");
            return (Criteria) this;
        }

        public Criteria andCarcolorIsNotNull() {
            addCriterion("carcolor is not null");
            return (Criteria) this;
        }

        public Criteria andCarcolorEqualTo(String value) {
            addCriterion("carcolor =", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorNotEqualTo(String value) {
            addCriterion("carcolor <>", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorGreaterThan(String value) {
            addCriterion("carcolor >", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorGreaterThanOrEqualTo(String value) {
            addCriterion("carcolor >=", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorLessThan(String value) {
            addCriterion("carcolor <", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorLessThanOrEqualTo(String value) {
            addCriterion("carcolor <=", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorLike(String value) {
            addCriterion("carcolor like", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorNotLike(String value) {
            addCriterion("carcolor not like", value, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorIn(List<String> values) {
            addCriterion("carcolor in", values, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorNotIn(List<String> values) {
            addCriterion("carcolor not in", values, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorBetween(String value1, String value2) {
            addCriterion("carcolor between", value1, value2, "carcolor");
            return (Criteria) this;
        }

        public Criteria andCarcolorNotBetween(String value1, String value2) {
            addCriterion("carcolor not between", value1, value2, "carcolor");
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

        public Criteria andCartypeIsNull() {
            addCriterion("cartype is null");
            return (Criteria) this;
        }

        public Criteria andCartypeIsNotNull() {
            addCriterion("cartype is not null");
            return (Criteria) this;
        }

        public Criteria andCartypeEqualTo(String value) {
            addCriterion("cartype =", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotEqualTo(String value) {
            addCriterion("cartype <>", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeGreaterThan(String value) {
            addCriterion("cartype >", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeGreaterThanOrEqualTo(String value) {
            addCriterion("cartype >=", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLessThan(String value) {
            addCriterion("cartype <", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLessThanOrEqualTo(String value) {
            addCriterion("cartype <=", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLike(String value) {
            addCriterion("cartype like", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotLike(String value) {
            addCriterion("cartype not like", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeIn(List<String> values) {
            addCriterion("cartype in", values, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotIn(List<String> values) {
            addCriterion("cartype not in", values, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeBetween(String value1, String value2) {
            addCriterion("cartype between", value1, value2, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotBetween(String value1, String value2) {
            addCriterion("cartype not between", value1, value2, "cartype");
            return (Criteria) this;
        }

        public Criteria andCleftIsNull() {
            addCriterion("cleft is null");
            return (Criteria) this;
        }

        public Criteria andCleftIsNotNull() {
            addCriterion("cleft is not null");
            return (Criteria) this;
        }

        public Criteria andCleftEqualTo(Long value) {
            addCriterion("cleft =", value, "cleft");
            return (Criteria) this;
        }

        public Criteria andCleftNotEqualTo(Long value) {
            addCriterion("cleft <>", value, "cleft");
            return (Criteria) this;
        }

        public Criteria andCleftGreaterThan(Long value) {
            addCriterion("cleft >", value, "cleft");
            return (Criteria) this;
        }

        public Criteria andCleftGreaterThanOrEqualTo(Long value) {
            addCriterion("cleft >=", value, "cleft");
            return (Criteria) this;
        }

        public Criteria andCleftLessThan(Long value) {
            addCriterion("cleft <", value, "cleft");
            return (Criteria) this;
        }

        public Criteria andCleftLessThanOrEqualTo(Long value) {
            addCriterion("cleft <=", value, "cleft");
            return (Criteria) this;
        }

        public Criteria andCleftIn(List<Long> values) {
            addCriterion("cleft in", values, "cleft");
            return (Criteria) this;
        }

        public Criteria andCleftNotIn(List<Long> values) {
            addCriterion("cleft not in", values, "cleft");
            return (Criteria) this;
        }

        public Criteria andCleftBetween(Long value1, Long value2) {
            addCriterion("cleft between", value1, value2, "cleft");
            return (Criteria) this;
        }

        public Criteria andCleftNotBetween(Long value1, Long value2) {
            addCriterion("cleft not between", value1, value2, "cleft");
            return (Criteria) this;
        }

        public Criteria andCtopIsNull() {
            addCriterion("ctop is null");
            return (Criteria) this;
        }

        public Criteria andCtopIsNotNull() {
            addCriterion("ctop is not null");
            return (Criteria) this;
        }

        public Criteria andCtopEqualTo(Long value) {
            addCriterion("ctop =", value, "ctop");
            return (Criteria) this;
        }

        public Criteria andCtopNotEqualTo(Long value) {
            addCriterion("ctop <>", value, "ctop");
            return (Criteria) this;
        }

        public Criteria andCtopGreaterThan(Long value) {
            addCriterion("ctop >", value, "ctop");
            return (Criteria) this;
        }

        public Criteria andCtopGreaterThanOrEqualTo(Long value) {
            addCriterion("ctop >=", value, "ctop");
            return (Criteria) this;
        }

        public Criteria andCtopLessThan(Long value) {
            addCriterion("ctop <", value, "ctop");
            return (Criteria) this;
        }

        public Criteria andCtopLessThanOrEqualTo(Long value) {
            addCriterion("ctop <=", value, "ctop");
            return (Criteria) this;
        }

        public Criteria andCtopIn(List<Long> values) {
            addCriterion("ctop in", values, "ctop");
            return (Criteria) this;
        }

        public Criteria andCtopNotIn(List<Long> values) {
            addCriterion("ctop not in", values, "ctop");
            return (Criteria) this;
        }

        public Criteria andCtopBetween(Long value1, Long value2) {
            addCriterion("ctop between", value1, value2, "ctop");
            return (Criteria) this;
        }

        public Criteria andCtopNotBetween(Long value1, Long value2) {
            addCriterion("ctop not between", value1, value2, "ctop");
            return (Criteria) this;
        }

        public Criteria andCrightIsNull() {
            addCriterion("cright is null");
            return (Criteria) this;
        }

        public Criteria andCrightIsNotNull() {
            addCriterion("cright is not null");
            return (Criteria) this;
        }

        public Criteria andCrightEqualTo(Long value) {
            addCriterion("cright =", value, "cright");
            return (Criteria) this;
        }

        public Criteria andCrightNotEqualTo(Long value) {
            addCriterion("cright <>", value, "cright");
            return (Criteria) this;
        }

        public Criteria andCrightGreaterThan(Long value) {
            addCriterion("cright >", value, "cright");
            return (Criteria) this;
        }

        public Criteria andCrightGreaterThanOrEqualTo(Long value) {
            addCriterion("cright >=", value, "cright");
            return (Criteria) this;
        }

        public Criteria andCrightLessThan(Long value) {
            addCriterion("cright <", value, "cright");
            return (Criteria) this;
        }

        public Criteria andCrightLessThanOrEqualTo(Long value) {
            addCriterion("cright <=", value, "cright");
            return (Criteria) this;
        }

        public Criteria andCrightIn(List<Long> values) {
            addCriterion("cright in", values, "cright");
            return (Criteria) this;
        }

        public Criteria andCrightNotIn(List<Long> values) {
            addCriterion("cright not in", values, "cright");
            return (Criteria) this;
        }

        public Criteria andCrightBetween(Long value1, Long value2) {
            addCriterion("cright between", value1, value2, "cright");
            return (Criteria) this;
        }

        public Criteria andCrightNotBetween(Long value1, Long value2) {
            addCriterion("cright not between", value1, value2, "cright");
            return (Criteria) this;
        }

        public Criteria andCbottomIsNull() {
            addCriterion("cbottom is null");
            return (Criteria) this;
        }

        public Criteria andCbottomIsNotNull() {
            addCriterion("cbottom is not null");
            return (Criteria) this;
        }

        public Criteria andCbottomEqualTo(Long value) {
            addCriterion("cbottom =", value, "cbottom");
            return (Criteria) this;
        }

        public Criteria andCbottomNotEqualTo(Long value) {
            addCriterion("cbottom <>", value, "cbottom");
            return (Criteria) this;
        }

        public Criteria andCbottomGreaterThan(Long value) {
            addCriterion("cbottom >", value, "cbottom");
            return (Criteria) this;
        }

        public Criteria andCbottomGreaterThanOrEqualTo(Long value) {
            addCriterion("cbottom >=", value, "cbottom");
            return (Criteria) this;
        }

        public Criteria andCbottomLessThan(Long value) {
            addCriterion("cbottom <", value, "cbottom");
            return (Criteria) this;
        }

        public Criteria andCbottomLessThanOrEqualTo(Long value) {
            addCriterion("cbottom <=", value, "cbottom");
            return (Criteria) this;
        }

        public Criteria andCbottomIn(List<Long> values) {
            addCriterion("cbottom in", values, "cbottom");
            return (Criteria) this;
        }

        public Criteria andCbottomNotIn(List<Long> values) {
            addCriterion("cbottom not in", values, "cbottom");
            return (Criteria) this;
        }

        public Criteria andCbottomBetween(Long value1, Long value2) {
            addCriterion("cbottom between", value1, value2, "cbottom");
            return (Criteria) this;
        }

        public Criteria andCbottomNotBetween(Long value1, Long value2) {
            addCriterion("cbottom not between", value1, value2, "cbottom");
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

        public Criteria andAccountidIsNull() {
            addCriterion("accountid is null");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNotNull() {
            addCriterion("accountid is not null");
            return (Criteria) this;
        }

        public Criteria andAccountidEqualTo(String value) {
            addCriterion("accountid =", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotEqualTo(String value) {
            addCriterion("accountid <>", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThan(String value) {
            addCriterion("accountid >", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThanOrEqualTo(String value) {
            addCriterion("accountid >=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThan(String value) {
            addCriterion("accountid <", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThanOrEqualTo(String value) {
            addCriterion("accountid <=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLike(String value) {
            addCriterion("accountid like", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotLike(String value) {
            addCriterion("accountid not like", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidIn(List<String> values) {
            addCriterion("accountid in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotIn(List<String> values) {
            addCriterion("accountid not in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidBetween(String value1, String value2) {
            addCriterion("accountid between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotBetween(String value1, String value2) {
            addCriterion("accountid not between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andUseableamountIsNull() {
            addCriterion("useableamount is null");
            return (Criteria) this;
        }

        public Criteria andUseableamountIsNotNull() {
            addCriterion("useableamount is not null");
            return (Criteria) this;
        }

        public Criteria andUseableamountEqualTo(Long value) {
            addCriterion("useableamount =", value, "useableamount");
            return (Criteria) this;
        }

        public Criteria andUseableamountNotEqualTo(Long value) {
            addCriterion("useableamount <>", value, "useableamount");
            return (Criteria) this;
        }

        public Criteria andUseableamountGreaterThan(Long value) {
            addCriterion("useableamount >", value, "useableamount");
            return (Criteria) this;
        }

        public Criteria andUseableamountGreaterThanOrEqualTo(Long value) {
            addCriterion("useableamount >=", value, "useableamount");
            return (Criteria) this;
        }

        public Criteria andUseableamountLessThan(Long value) {
            addCriterion("useableamount <", value, "useableamount");
            return (Criteria) this;
        }

        public Criteria andUseableamountLessThanOrEqualTo(Long value) {
            addCriterion("useableamount <=", value, "useableamount");
            return (Criteria) this;
        }

        public Criteria andUseableamountIn(List<Long> values) {
            addCriterion("useableamount in", values, "useableamount");
            return (Criteria) this;
        }

        public Criteria andUseableamountNotIn(List<Long> values) {
            addCriterion("useableamount not in", values, "useableamount");
            return (Criteria) this;
        }

        public Criteria andUseableamountBetween(Long value1, Long value2) {
            addCriterion("useableamount between", value1, value2, "useableamount");
            return (Criteria) this;
        }

        public Criteria andUseableamountNotBetween(Long value1, Long value2) {
            addCriterion("useableamount not between", value1, value2, "useableamount");
            return (Criteria) this;
        }

        public Criteria andAvoidamountIsNull() {
            addCriterion("avoidamount is null");
            return (Criteria) this;
        }

        public Criteria andAvoidamountIsNotNull() {
            addCriterion("avoidamount is not null");
            return (Criteria) this;
        }

        public Criteria andAvoidamountEqualTo(Long value) {
            addCriterion("avoidamount =", value, "avoidamount");
            return (Criteria) this;
        }

        public Criteria andAvoidamountNotEqualTo(Long value) {
            addCriterion("avoidamount <>", value, "avoidamount");
            return (Criteria) this;
        }

        public Criteria andAvoidamountGreaterThan(Long value) {
            addCriterion("avoidamount >", value, "avoidamount");
            return (Criteria) this;
        }

        public Criteria andAvoidamountGreaterThanOrEqualTo(Long value) {
            addCriterion("avoidamount >=", value, "avoidamount");
            return (Criteria) this;
        }

        public Criteria andAvoidamountLessThan(Long value) {
            addCriterion("avoidamount <", value, "avoidamount");
            return (Criteria) this;
        }

        public Criteria andAvoidamountLessThanOrEqualTo(Long value) {
            addCriterion("avoidamount <=", value, "avoidamount");
            return (Criteria) this;
        }

        public Criteria andAvoidamountIn(List<Long> values) {
            addCriterion("avoidamount in", values, "avoidamount");
            return (Criteria) this;
        }

        public Criteria andAvoidamountNotIn(List<Long> values) {
            addCriterion("avoidamount not in", values, "avoidamount");
            return (Criteria) this;
        }

        public Criteria andAvoidamountBetween(Long value1, Long value2) {
            addCriterion("avoidamount between", value1, value2, "avoidamount");
            return (Criteria) this;
        }

        public Criteria andAvoidamountNotBetween(Long value1, Long value2) {
            addCriterion("avoidamount not between", value1, value2, "avoidamount");
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