package com.pcitc.oilmachine.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DevicesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DevicesExample() {
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

        public Criteria andDevicesidIsNull() {
            addCriterion("devicesID is null");
            return (Criteria) this;
        }

        public Criteria andDevicesidIsNotNull() {
            addCriterion("devicesID is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesidEqualTo(String value) {
            addCriterion("devicesID =", value, "devicesid");
            return (Criteria) this;
        }

        public Criteria andDevicesidNotEqualTo(String value) {
            addCriterion("devicesID <>", value, "devicesid");
            return (Criteria) this;
        }

        public Criteria andDevicesidGreaterThan(String value) {
            addCriterion("devicesID >", value, "devicesid");
            return (Criteria) this;
        }

        public Criteria andDevicesidGreaterThanOrEqualTo(String value) {
            addCriterion("devicesID >=", value, "devicesid");
            return (Criteria) this;
        }

        public Criteria andDevicesidLessThan(String value) {
            addCriterion("devicesID <", value, "devicesid");
            return (Criteria) this;
        }

        public Criteria andDevicesidLessThanOrEqualTo(String value) {
            addCriterion("devicesID <=", value, "devicesid");
            return (Criteria) this;
        }

        public Criteria andDevicesidLike(String value) {
            addCriterion("devicesID like", value, "devicesid");
            return (Criteria) this;
        }

        public Criteria andDevicesidNotLike(String value) {
            addCriterion("devicesID not like", value, "devicesid");
            return (Criteria) this;
        }

        public Criteria andDevicesidIn(List<String> values) {
            addCriterion("devicesID in", values, "devicesid");
            return (Criteria) this;
        }

        public Criteria andDevicesidNotIn(List<String> values) {
            addCriterion("devicesID not in", values, "devicesid");
            return (Criteria) this;
        }

        public Criteria andDevicesidBetween(String value1, String value2) {
            addCriterion("devicesID between", value1, value2, "devicesid");
            return (Criteria) this;
        }

        public Criteria andDevicesidNotBetween(String value1, String value2) {
            addCriterion("devicesID not between", value1, value2, "devicesid");
            return (Criteria) this;
        }

        public Criteria andNodecodeIsNull() {
            addCriterion("nodecode is null");
            return (Criteria) this;
        }

        public Criteria andNodecodeIsNotNull() {
            addCriterion("nodecode is not null");
            return (Criteria) this;
        }

        public Criteria andNodecodeEqualTo(String value) {
            addCriterion("nodecode =", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotEqualTo(String value) {
            addCriterion("nodecode <>", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeGreaterThan(String value) {
            addCriterion("nodecode >", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeGreaterThanOrEqualTo(String value) {
            addCriterion("nodecode >=", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLessThan(String value) {
            addCriterion("nodecode <", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLessThanOrEqualTo(String value) {
            addCriterion("nodecode <=", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLike(String value) {
            addCriterion("nodecode like", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotLike(String value) {
            addCriterion("nodecode not like", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeIn(List<String> values) {
            addCriterion("nodecode in", values, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotIn(List<String> values) {
            addCriterion("nodecode not in", values, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeBetween(String value1, String value2) {
            addCriterion("nodecode between", value1, value2, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotBetween(String value1, String value2) {
            addCriterion("nodecode not between", value1, value2, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodetagIsNull() {
            addCriterion("nodetag is null");
            return (Criteria) this;
        }

        public Criteria andNodetagIsNotNull() {
            addCriterion("nodetag is not null");
            return (Criteria) this;
        }

        public Criteria andNodetagEqualTo(String value) {
            addCriterion("nodetag =", value, "nodetag");
            return (Criteria) this;
        }

        public Criteria andNodetagNotEqualTo(String value) {
            addCriterion("nodetag <>", value, "nodetag");
            return (Criteria) this;
        }

        public Criteria andNodetagGreaterThan(String value) {
            addCriterion("nodetag >", value, "nodetag");
            return (Criteria) this;
        }

        public Criteria andNodetagGreaterThanOrEqualTo(String value) {
            addCriterion("nodetag >=", value, "nodetag");
            return (Criteria) this;
        }

        public Criteria andNodetagLessThan(String value) {
            addCriterion("nodetag <", value, "nodetag");
            return (Criteria) this;
        }

        public Criteria andNodetagLessThanOrEqualTo(String value) {
            addCriterion("nodetag <=", value, "nodetag");
            return (Criteria) this;
        }

        public Criteria andNodetagLike(String value) {
            addCriterion("nodetag like", value, "nodetag");
            return (Criteria) this;
        }

        public Criteria andNodetagNotLike(String value) {
            addCriterion("nodetag not like", value, "nodetag");
            return (Criteria) this;
        }

        public Criteria andNodetagIn(List<String> values) {
            addCriterion("nodetag in", values, "nodetag");
            return (Criteria) this;
        }

        public Criteria andNodetagNotIn(List<String> values) {
            addCriterion("nodetag not in", values, "nodetag");
            return (Criteria) this;
        }

        public Criteria andNodetagBetween(String value1, String value2) {
            addCriterion("nodetag between", value1, value2, "nodetag");
            return (Criteria) this;
        }

        public Criteria andNodetagNotBetween(String value1, String value2) {
            addCriterion("nodetag not between", value1, value2, "nodetag");
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

        public Criteria andDevicestypecodeIsNull() {
            addCriterion("devicestypecode is null");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeIsNotNull() {
            addCriterion("devicestypecode is not null");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeEqualTo(String value) {
            addCriterion("devicestypecode =", value, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeNotEqualTo(String value) {
            addCriterion("devicestypecode <>", value, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeGreaterThan(String value) {
            addCriterion("devicestypecode >", value, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeGreaterThanOrEqualTo(String value) {
            addCriterion("devicestypecode >=", value, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeLessThan(String value) {
            addCriterion("devicestypecode <", value, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeLessThanOrEqualTo(String value) {
            addCriterion("devicestypecode <=", value, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeLike(String value) {
            addCriterion("devicestypecode like", value, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeNotLike(String value) {
            addCriterion("devicestypecode not like", value, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeIn(List<String> values) {
            addCriterion("devicestypecode in", values, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeNotIn(List<String> values) {
            addCriterion("devicestypecode not in", values, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeBetween(String value1, String value2) {
            addCriterion("devicestypecode between", value1, value2, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypecodeNotBetween(String value1, String value2) {
            addCriterion("devicestypecode not between", value1, value2, "devicestypecode");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameIsNull() {
            addCriterion("devicestypename is null");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameIsNotNull() {
            addCriterion("devicestypename is not null");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameEqualTo(String value) {
            addCriterion("devicestypename =", value, "devicestypename");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameNotEqualTo(String value) {
            addCriterion("devicestypename <>", value, "devicestypename");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameGreaterThan(String value) {
            addCriterion("devicestypename >", value, "devicestypename");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameGreaterThanOrEqualTo(String value) {
            addCriterion("devicestypename >=", value, "devicestypename");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameLessThan(String value) {
            addCriterion("devicestypename <", value, "devicestypename");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameLessThanOrEqualTo(String value) {
            addCriterion("devicestypename <=", value, "devicestypename");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameLike(String value) {
            addCriterion("devicestypename like", value, "devicestypename");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameNotLike(String value) {
            addCriterion("devicestypename not like", value, "devicestypename");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameIn(List<String> values) {
            addCriterion("devicestypename in", values, "devicestypename");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameNotIn(List<String> values) {
            addCriterion("devicestypename not in", values, "devicestypename");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameBetween(String value1, String value2) {
            addCriterion("devicestypename between", value1, value2, "devicestypename");
            return (Criteria) this;
        }

        public Criteria andDevicestypenameNotBetween(String value1, String value2) {
            addCriterion("devicestypename not between", value1, value2, "devicestypename");
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
            addCriterion("BUCODE is null");
            return (Criteria) this;
        }

        public Criteria andBucodeIsNotNull() {
            addCriterion("BUCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBucodeEqualTo(String value) {
            addCriterion("BUCODE =", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeNotEqualTo(String value) {
            addCriterion("BUCODE <>", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeGreaterThan(String value) {
            addCriterion("BUCODE >", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeGreaterThanOrEqualTo(String value) {
            addCriterion("BUCODE >=", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeLessThan(String value) {
            addCriterion("BUCODE <", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeLessThanOrEqualTo(String value) {
            addCriterion("BUCODE <=", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeLike(String value) {
            addCriterion("BUCODE like", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeNotLike(String value) {
            addCriterion("BUCODE not like", value, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeIn(List<String> values) {
            addCriterion("BUCODE in", values, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeNotIn(List<String> values) {
            addCriterion("BUCODE not in", values, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeBetween(String value1, String value2) {
            addCriterion("BUCODE between", value1, value2, "bucode");
            return (Criteria) this;
        }

        public Criteria andBucodeNotBetween(String value1, String value2) {
            addCriterion("BUCODE not between", value1, value2, "bucode");
            return (Criteria) this;
        }

        public Criteria andBunameIsNull() {
            addCriterion("BUNAME is null");
            return (Criteria) this;
        }

        public Criteria andBunameIsNotNull() {
            addCriterion("BUNAME is not null");
            return (Criteria) this;
        }

        public Criteria andBunameEqualTo(String value) {
            addCriterion("BUNAME =", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameNotEqualTo(String value) {
            addCriterion("BUNAME <>", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameGreaterThan(String value) {
            addCriterion("BUNAME >", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameGreaterThanOrEqualTo(String value) {
            addCriterion("BUNAME >=", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameLessThan(String value) {
            addCriterion("BUNAME <", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameLessThanOrEqualTo(String value) {
            addCriterion("BUNAME <=", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameLike(String value) {
            addCriterion("BUNAME like", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameNotLike(String value) {
            addCriterion("BUNAME not like", value, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameIn(List<String> values) {
            addCriterion("BUNAME in", values, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameNotIn(List<String> values) {
            addCriterion("BUNAME not in", values, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameBetween(String value1, String value2) {
            addCriterion("BUNAME between", value1, value2, "buname");
            return (Criteria) this;
        }

        public Criteria andBunameNotBetween(String value1, String value2) {
            addCriterion("BUNAME not between", value1, value2, "buname");
            return (Criteria) this;
        }

        public Criteria andConnstatusIsNull() {
            addCriterion("connstatus is null");
            return (Criteria) this;
        }

        public Criteria andConnstatusIsNotNull() {
            addCriterion("connstatus is not null");
            return (Criteria) this;
        }

        public Criteria andConnstatusEqualTo(Byte value) {
            addCriterion("connstatus =", value, "connstatus");
            return (Criteria) this;
        }

        public Criteria andConnstatusNotEqualTo(Byte value) {
            addCriterion("connstatus <>", value, "connstatus");
            return (Criteria) this;
        }

        public Criteria andConnstatusGreaterThan(Byte value) {
            addCriterion("connstatus >", value, "connstatus");
            return (Criteria) this;
        }

        public Criteria andConnstatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("connstatus >=", value, "connstatus");
            return (Criteria) this;
        }

        public Criteria andConnstatusLessThan(Byte value) {
            addCriterion("connstatus <", value, "connstatus");
            return (Criteria) this;
        }

        public Criteria andConnstatusLessThanOrEqualTo(Byte value) {
            addCriterion("connstatus <=", value, "connstatus");
            return (Criteria) this;
        }

        public Criteria andConnstatusIn(List<Byte> values) {
            addCriterion("connstatus in", values, "connstatus");
            return (Criteria) this;
        }

        public Criteria andConnstatusNotIn(List<Byte> values) {
            addCriterion("connstatus not in", values, "connstatus");
            return (Criteria) this;
        }

        public Criteria andConnstatusBetween(Byte value1, Byte value2) {
            addCriterion("connstatus between", value1, value2, "connstatus");
            return (Criteria) this;
        }

        public Criteria andConnstatusNotBetween(Byte value1, Byte value2) {
            addCriterion("connstatus not between", value1, value2, "connstatus");
            return (Criteria) this;
        }

        public Criteria andSelfserviceIsNull() {
            addCriterion("selfservice is null");
            return (Criteria) this;
        }

        public Criteria andSelfserviceIsNotNull() {
            addCriterion("selfservice is not null");
            return (Criteria) this;
        }

        public Criteria andSelfserviceEqualTo(Byte value) {
            addCriterion("selfservice =", value, "selfservice");
            return (Criteria) this;
        }

        public Criteria andSelfserviceNotEqualTo(Byte value) {
            addCriterion("selfservice <>", value, "selfservice");
            return (Criteria) this;
        }

        public Criteria andSelfserviceGreaterThan(Byte value) {
            addCriterion("selfservice >", value, "selfservice");
            return (Criteria) this;
        }

        public Criteria andSelfserviceGreaterThanOrEqualTo(Byte value) {
            addCriterion("selfservice >=", value, "selfservice");
            return (Criteria) this;
        }

        public Criteria andSelfserviceLessThan(Byte value) {
            addCriterion("selfservice <", value, "selfservice");
            return (Criteria) this;
        }

        public Criteria andSelfserviceLessThanOrEqualTo(Byte value) {
            addCriterion("selfservice <=", value, "selfservice");
            return (Criteria) this;
        }

        public Criteria andSelfserviceIn(List<Byte> values) {
            addCriterion("selfservice in", values, "selfservice");
            return (Criteria) this;
        }

        public Criteria andSelfserviceNotIn(List<Byte> values) {
            addCriterion("selfservice not in", values, "selfservice");
            return (Criteria) this;
        }

        public Criteria andSelfserviceBetween(Byte value1, Byte value2) {
            addCriterion("selfservice between", value1, value2, "selfservice");
            return (Criteria) this;
        }

        public Criteria andSelfserviceNotBetween(Byte value1, Byte value2) {
            addCriterion("selfservice not between", value1, value2, "selfservice");
            return (Criteria) this;
        }

        public Criteria andReceivedataIsNull() {
            addCriterion("receivedata is null");
            return (Criteria) this;
        }

        public Criteria andReceivedataIsNotNull() {
            addCriterion("receivedata is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedataEqualTo(String value) {
            addCriterion("receivedata =", value, "receivedata");
            return (Criteria) this;
        }

        public Criteria andReceivedataNotEqualTo(String value) {
            addCriterion("receivedata <>", value, "receivedata");
            return (Criteria) this;
        }

        public Criteria andReceivedataGreaterThan(String value) {
            addCriterion("receivedata >", value, "receivedata");
            return (Criteria) this;
        }

        public Criteria andReceivedataGreaterThanOrEqualTo(String value) {
            addCriterion("receivedata >=", value, "receivedata");
            return (Criteria) this;
        }

        public Criteria andReceivedataLessThan(String value) {
            addCriterion("receivedata <", value, "receivedata");
            return (Criteria) this;
        }

        public Criteria andReceivedataLessThanOrEqualTo(String value) {
            addCriterion("receivedata <=", value, "receivedata");
            return (Criteria) this;
        }

        public Criteria andReceivedataLike(String value) {
            addCriterion("receivedata like", value, "receivedata");
            return (Criteria) this;
        }

        public Criteria andReceivedataNotLike(String value) {
            addCriterion("receivedata not like", value, "receivedata");
            return (Criteria) this;
        }

        public Criteria andReceivedataIn(List<String> values) {
            addCriterion("receivedata in", values, "receivedata");
            return (Criteria) this;
        }

        public Criteria andReceivedataNotIn(List<String> values) {
            addCriterion("receivedata not in", values, "receivedata");
            return (Criteria) this;
        }

        public Criteria andReceivedataBetween(String value1, String value2) {
            addCriterion("receivedata between", value1, value2, "receivedata");
            return (Criteria) this;
        }

        public Criteria andReceivedataNotBetween(String value1, String value2) {
            addCriterion("receivedata not between", value1, value2, "receivedata");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumIsNull() {
            addCriterion("deviceareanum is null");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumIsNotNull() {
            addCriterion("deviceareanum is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumEqualTo(Byte value) {
            addCriterion("deviceareanum =", value, "deviceareanum");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumNotEqualTo(Byte value) {
            addCriterion("deviceareanum <>", value, "deviceareanum");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumGreaterThan(Byte value) {
            addCriterion("deviceareanum >", value, "deviceareanum");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumGreaterThanOrEqualTo(Byte value) {
            addCriterion("deviceareanum >=", value, "deviceareanum");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumLessThan(Byte value) {
            addCriterion("deviceareanum <", value, "deviceareanum");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumLessThanOrEqualTo(Byte value) {
            addCriterion("deviceareanum <=", value, "deviceareanum");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumIn(List<Byte> values) {
            addCriterion("deviceareanum in", values, "deviceareanum");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumNotIn(List<Byte> values) {
            addCriterion("deviceareanum not in", values, "deviceareanum");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumBetween(Byte value1, Byte value2) {
            addCriterion("deviceareanum between", value1, value2, "deviceareanum");
            return (Criteria) this;
        }

        public Criteria andDeviceareanumNotBetween(Byte value1, Byte value2) {
            addCriterion("deviceareanum not between", value1, value2, "deviceareanum");
            return (Criteria) this;
        }

        public Criteria andConnidIsNull() {
            addCriterion("connid is null");
            return (Criteria) this;
        }

        public Criteria andConnidIsNotNull() {
            addCriterion("connid is not null");
            return (Criteria) this;
        }

        public Criteria andConnidEqualTo(String value) {
            addCriterion("connid =", value, "connid");
            return (Criteria) this;
        }

        public Criteria andConnidNotEqualTo(String value) {
            addCriterion("connid <>", value, "connid");
            return (Criteria) this;
        }

        public Criteria andConnidGreaterThan(String value) {
            addCriterion("connid >", value, "connid");
            return (Criteria) this;
        }

        public Criteria andConnidGreaterThanOrEqualTo(String value) {
            addCriterion("connid >=", value, "connid");
            return (Criteria) this;
        }

        public Criteria andConnidLessThan(String value) {
            addCriterion("connid <", value, "connid");
            return (Criteria) this;
        }

        public Criteria andConnidLessThanOrEqualTo(String value) {
            addCriterion("connid <=", value, "connid");
            return (Criteria) this;
        }

        public Criteria andConnidLike(String value) {
            addCriterion("connid like", value, "connid");
            return (Criteria) this;
        }

        public Criteria andConnidNotLike(String value) {
            addCriterion("connid not like", value, "connid");
            return (Criteria) this;
        }

        public Criteria andConnidIn(List<String> values) {
            addCriterion("connid in", values, "connid");
            return (Criteria) this;
        }

        public Criteria andConnidNotIn(List<String> values) {
            addCriterion("connid not in", values, "connid");
            return (Criteria) this;
        }

        public Criteria andConnidBetween(String value1, String value2) {
            addCriterion("connid between", value1, value2, "connid");
            return (Criteria) this;
        }

        public Criteria andConnidNotBetween(String value1, String value2) {
            addCriterion("connid not between", value1, value2, "connid");
            return (Criteria) this;
        }

        public Criteria andConnameIsNull() {
            addCriterion("conname is null");
            return (Criteria) this;
        }

        public Criteria andConnameIsNotNull() {
            addCriterion("conname is not null");
            return (Criteria) this;
        }

        public Criteria andConnameEqualTo(String value) {
            addCriterion("conname =", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotEqualTo(String value) {
            addCriterion("conname <>", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameGreaterThan(String value) {
            addCriterion("conname >", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameGreaterThanOrEqualTo(String value) {
            addCriterion("conname >=", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLessThan(String value) {
            addCriterion("conname <", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLessThanOrEqualTo(String value) {
            addCriterion("conname <=", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLike(String value) {
            addCriterion("conname like", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotLike(String value) {
            addCriterion("conname not like", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameIn(List<String> values) {
            addCriterion("conname in", values, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotIn(List<String> values) {
            addCriterion("conname not in", values, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameBetween(String value1, String value2) {
            addCriterion("conname between", value1, value2, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotBetween(String value1, String value2) {
            addCriterion("conname not between", value1, value2, "conname");
            return (Criteria) this;
        }

        public Criteria andXlengthIsNull() {
            addCriterion("xlength is null");
            return (Criteria) this;
        }

        public Criteria andXlengthIsNotNull() {
            addCriterion("xlength is not null");
            return (Criteria) this;
        }

        public Criteria andXlengthEqualTo(BigDecimal value) {
            addCriterion("xlength =", value, "xlength");
            return (Criteria) this;
        }

        public Criteria andXlengthNotEqualTo(BigDecimal value) {
            addCriterion("xlength <>", value, "xlength");
            return (Criteria) this;
        }

        public Criteria andXlengthGreaterThan(BigDecimal value) {
            addCriterion("xlength >", value, "xlength");
            return (Criteria) this;
        }

        public Criteria andXlengthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("xlength >=", value, "xlength");
            return (Criteria) this;
        }

        public Criteria andXlengthLessThan(BigDecimal value) {
            addCriterion("xlength <", value, "xlength");
            return (Criteria) this;
        }

        public Criteria andXlengthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("xlength <=", value, "xlength");
            return (Criteria) this;
        }

        public Criteria andXlengthIn(List<BigDecimal> values) {
            addCriterion("xlength in", values, "xlength");
            return (Criteria) this;
        }

        public Criteria andXlengthNotIn(List<BigDecimal> values) {
            addCriterion("xlength not in", values, "xlength");
            return (Criteria) this;
        }

        public Criteria andXlengthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xlength between", value1, value2, "xlength");
            return (Criteria) this;
        }

        public Criteria andXlengthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xlength not between", value1, value2, "xlength");
            return (Criteria) this;
        }

        public Criteria andYlengthIsNull() {
            addCriterion("ylength is null");
            return (Criteria) this;
        }

        public Criteria andYlengthIsNotNull() {
            addCriterion("ylength is not null");
            return (Criteria) this;
        }

        public Criteria andYlengthEqualTo(BigDecimal value) {
            addCriterion("ylength =", value, "ylength");
            return (Criteria) this;
        }

        public Criteria andYlengthNotEqualTo(BigDecimal value) {
            addCriterion("ylength <>", value, "ylength");
            return (Criteria) this;
        }

        public Criteria andYlengthGreaterThan(BigDecimal value) {
            addCriterion("ylength >", value, "ylength");
            return (Criteria) this;
        }

        public Criteria andYlengthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ylength >=", value, "ylength");
            return (Criteria) this;
        }

        public Criteria andYlengthLessThan(BigDecimal value) {
            addCriterion("ylength <", value, "ylength");
            return (Criteria) this;
        }

        public Criteria andYlengthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ylength <=", value, "ylength");
            return (Criteria) this;
        }

        public Criteria andYlengthIn(List<BigDecimal> values) {
            addCriterion("ylength in", values, "ylength");
            return (Criteria) this;
        }

        public Criteria andYlengthNotIn(List<BigDecimal> values) {
            addCriterion("ylength not in", values, "ylength");
            return (Criteria) this;
        }

        public Criteria andYlengthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ylength between", value1, value2, "ylength");
            return (Criteria) this;
        }

        public Criteria andYlengthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ylength not between", value1, value2, "ylength");
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

        public Criteria andPublickeyIsNull() {
            addCriterion("publickey is null");
            return (Criteria) this;
        }

        public Criteria andPublickeyIsNotNull() {
            addCriterion("publickey is not null");
            return (Criteria) this;
        }

        public Criteria andPublickeyEqualTo(String value) {
            addCriterion("publickey =", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyNotEqualTo(String value) {
            addCriterion("publickey <>", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyGreaterThan(String value) {
            addCriterion("publickey >", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyGreaterThanOrEqualTo(String value) {
            addCriterion("publickey >=", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyLessThan(String value) {
            addCriterion("publickey <", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyLessThanOrEqualTo(String value) {
            addCriterion("publickey <=", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyLike(String value) {
            addCriterion("publickey like", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyNotLike(String value) {
            addCriterion("publickey not like", value, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyIn(List<String> values) {
            addCriterion("publickey in", values, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyNotIn(List<String> values) {
            addCriterion("publickey not in", values, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyBetween(String value1, String value2) {
            addCriterion("publickey between", value1, value2, "publickey");
            return (Criteria) this;
        }

        public Criteria andPublickeyNotBetween(String value1, String value2) {
            addCriterion("publickey not between", value1, value2, "publickey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyIsNull() {
            addCriterion("privatekey is null");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyIsNotNull() {
            addCriterion("privatekey is not null");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyEqualTo(String value) {
            addCriterion("privatekey =", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyNotEqualTo(String value) {
            addCriterion("privatekey <>", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyGreaterThan(String value) {
            addCriterion("privatekey >", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyGreaterThanOrEqualTo(String value) {
            addCriterion("privatekey >=", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyLessThan(String value) {
            addCriterion("privatekey <", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyLessThanOrEqualTo(String value) {
            addCriterion("privatekey <=", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyLike(String value) {
            addCriterion("privatekey like", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyNotLike(String value) {
            addCriterion("privatekey not like", value, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyIn(List<String> values) {
            addCriterion("privatekey in", values, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyNotIn(List<String> values) {
            addCriterion("privatekey not in", values, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyBetween(String value1, String value2) {
            addCriterion("privatekey between", value1, value2, "privatekey");
            return (Criteria) this;
        }

        public Criteria andPrivatekeyNotBetween(String value1, String value2) {
            addCriterion("privatekey not between", value1, value2, "privatekey");
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