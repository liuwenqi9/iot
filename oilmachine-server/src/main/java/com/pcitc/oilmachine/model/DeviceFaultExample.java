package com.pcitc.oilmachine.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceFaultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceFaultExample() {
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

        public Criteria andFaulttypecodeIsNull() {
            addCriterion("faultTypecode is null");
            return (Criteria) this;
        }

        public Criteria andFaulttypecodeIsNotNull() {
            addCriterion("faultTypecode is not null");
            return (Criteria) this;
        }

        public Criteria andFaulttypecodeEqualTo(Byte value) {
            addCriterion("faultTypecode =", value, "faulttypecode");
            return (Criteria) this;
        }

        public Criteria andFaulttypecodeNotEqualTo(Byte value) {
            addCriterion("faultTypecode <>", value, "faulttypecode");
            return (Criteria) this;
        }

        public Criteria andFaulttypecodeGreaterThan(Byte value) {
            addCriterion("faultTypecode >", value, "faulttypecode");
            return (Criteria) this;
        }

        public Criteria andFaulttypecodeGreaterThanOrEqualTo(Byte value) {
            addCriterion("faultTypecode >=", value, "faulttypecode");
            return (Criteria) this;
        }

        public Criteria andFaulttypecodeLessThan(Byte value) {
            addCriterion("faultTypecode <", value, "faulttypecode");
            return (Criteria) this;
        }

        public Criteria andFaulttypecodeLessThanOrEqualTo(Byte value) {
            addCriterion("faultTypecode <=", value, "faulttypecode");
            return (Criteria) this;
        }

        public Criteria andFaulttypecodeIn(List<Byte> values) {
            addCriterion("faultTypecode in", values, "faulttypecode");
            return (Criteria) this;
        }

        public Criteria andFaulttypecodeNotIn(List<Byte> values) {
            addCriterion("faultTypecode not in", values, "faulttypecode");
            return (Criteria) this;
        }

        public Criteria andFaulttypecodeBetween(Byte value1, Byte value2) {
            addCriterion("faultTypecode between", value1, value2, "faulttypecode");
            return (Criteria) this;
        }

        public Criteria andFaulttypecodeNotBetween(Byte value1, Byte value2) {
            addCriterion("faultTypecode not between", value1, value2, "faulttypecode");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameIsNull() {
            addCriterion("faultTypename is null");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameIsNotNull() {
            addCriterion("faultTypename is not null");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameEqualTo(String value) {
            addCriterion("faultTypename =", value, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameNotEqualTo(String value) {
            addCriterion("faultTypename <>", value, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameGreaterThan(String value) {
            addCriterion("faultTypename >", value, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameGreaterThanOrEqualTo(String value) {
            addCriterion("faultTypename >=", value, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameLessThan(String value) {
            addCriterion("faultTypename <", value, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameLessThanOrEqualTo(String value) {
            addCriterion("faultTypename <=", value, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameLike(String value) {
            addCriterion("faultTypename like", value, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameNotLike(String value) {
            addCriterion("faultTypename not like", value, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameIn(List<String> values) {
            addCriterion("faultTypename in", values, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameNotIn(List<String> values) {
            addCriterion("faultTypename not in", values, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameBetween(String value1, String value2) {
            addCriterion("faultTypename between", value1, value2, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andFaulttypenameNotBetween(String value1, String value2) {
            addCriterion("faultTypename not between", value1, value2, "faulttypename");
            return (Criteria) this;
        }

        public Criteria andCodenoIsNull() {
            addCriterion("codeno is null");
            return (Criteria) this;
        }

        public Criteria andCodenoIsNotNull() {
            addCriterion("codeno is not null");
            return (Criteria) this;
        }

        public Criteria andCodenoEqualTo(Byte value) {
            addCriterion("codeno =", value, "codeno");
            return (Criteria) this;
        }

        public Criteria andCodenoNotEqualTo(Byte value) {
            addCriterion("codeno <>", value, "codeno");
            return (Criteria) this;
        }

        public Criteria andCodenoGreaterThan(Byte value) {
            addCriterion("codeno >", value, "codeno");
            return (Criteria) this;
        }

        public Criteria andCodenoGreaterThanOrEqualTo(Byte value) {
            addCriterion("codeno >=", value, "codeno");
            return (Criteria) this;
        }

        public Criteria andCodenoLessThan(Byte value) {
            addCriterion("codeno <", value, "codeno");
            return (Criteria) this;
        }

        public Criteria andCodenoLessThanOrEqualTo(Byte value) {
            addCriterion("codeno <=", value, "codeno");
            return (Criteria) this;
        }

        public Criteria andCodenoIn(List<Byte> values) {
            addCriterion("codeno in", values, "codeno");
            return (Criteria) this;
        }

        public Criteria andCodenoNotIn(List<Byte> values) {
            addCriterion("codeno not in", values, "codeno");
            return (Criteria) this;
        }

        public Criteria andCodenoBetween(Byte value1, Byte value2) {
            addCriterion("codeno between", value1, value2, "codeno");
            return (Criteria) this;
        }

        public Criteria andCodenoNotBetween(Byte value1, Byte value2) {
            addCriterion("codeno not between", value1, value2, "codeno");
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