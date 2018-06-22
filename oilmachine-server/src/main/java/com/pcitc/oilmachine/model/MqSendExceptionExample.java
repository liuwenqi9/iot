package com.pcitc.oilmachine.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MqSendExceptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MqSendExceptionExample() {
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

        public Criteria andMqsendexceptionidIsNull() {
            addCriterion("mqsendexceptionid is null");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidIsNotNull() {
            addCriterion("mqsendexceptionid is not null");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidEqualTo(String value) {
            addCriterion("mqsendexceptionid =", value, "mqsendexceptionid");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidNotEqualTo(String value) {
            addCriterion("mqsendexceptionid <>", value, "mqsendexceptionid");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidGreaterThan(String value) {
            addCriterion("mqsendexceptionid >", value, "mqsendexceptionid");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidGreaterThanOrEqualTo(String value) {
            addCriterion("mqsendexceptionid >=", value, "mqsendexceptionid");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidLessThan(String value) {
            addCriterion("mqsendexceptionid <", value, "mqsendexceptionid");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidLessThanOrEqualTo(String value) {
            addCriterion("mqsendexceptionid <=", value, "mqsendexceptionid");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidLike(String value) {
            addCriterion("mqsendexceptionid like", value, "mqsendexceptionid");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidNotLike(String value) {
            addCriterion("mqsendexceptionid not like", value, "mqsendexceptionid");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidIn(List<String> values) {
            addCriterion("mqsendexceptionid in", values, "mqsendexceptionid");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidNotIn(List<String> values) {
            addCriterion("mqsendexceptionid not in", values, "mqsendexceptionid");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidBetween(String value1, String value2) {
            addCriterion("mqsendexceptionid between", value1, value2, "mqsendexceptionid");
            return (Criteria) this;
        }

        public Criteria andMqsendexceptionidNotBetween(String value1, String value2) {
            addCriterion("mqsendexceptionid not between", value1, value2, "mqsendexceptionid");
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

        public Criteria andForeignkeyidIsNull() {
            addCriterion("foreignkeyid is null");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidIsNotNull() {
            addCriterion("foreignkeyid is not null");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidEqualTo(String value) {
            addCriterion("foreignkeyid =", value, "foreignkeyid");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidNotEqualTo(String value) {
            addCriterion("foreignkeyid <>", value, "foreignkeyid");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidGreaterThan(String value) {
            addCriterion("foreignkeyid >", value, "foreignkeyid");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidGreaterThanOrEqualTo(String value) {
            addCriterion("foreignkeyid >=", value, "foreignkeyid");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidLessThan(String value) {
            addCriterion("foreignkeyid <", value, "foreignkeyid");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidLessThanOrEqualTo(String value) {
            addCriterion("foreignkeyid <=", value, "foreignkeyid");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidLike(String value) {
            addCriterion("foreignkeyid like", value, "foreignkeyid");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidNotLike(String value) {
            addCriterion("foreignkeyid not like", value, "foreignkeyid");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidIn(List<String> values) {
            addCriterion("foreignkeyid in", values, "foreignkeyid");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidNotIn(List<String> values) {
            addCriterion("foreignkeyid not in", values, "foreignkeyid");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidBetween(String value1, String value2) {
            addCriterion("foreignkeyid between", value1, value2, "foreignkeyid");
            return (Criteria) this;
        }

        public Criteria andForeignkeyidNotBetween(String value1, String value2) {
            addCriterion("foreignkeyid not between", value1, value2, "foreignkeyid");
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

        public Criteria andTypecodeIsNull() {
            addCriterion("typecode is null");
            return (Criteria) this;
        }

        public Criteria andTypecodeIsNotNull() {
            addCriterion("typecode is not null");
            return (Criteria) this;
        }

        public Criteria andTypecodeEqualTo(String value) {
            addCriterion("typecode =", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeNotEqualTo(String value) {
            addCriterion("typecode <>", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeGreaterThan(String value) {
            addCriterion("typecode >", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeGreaterThanOrEqualTo(String value) {
            addCriterion("typecode >=", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeLessThan(String value) {
            addCriterion("typecode <", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeLessThanOrEqualTo(String value) {
            addCriterion("typecode <=", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeLike(String value) {
            addCriterion("typecode like", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeNotLike(String value) {
            addCriterion("typecode not like", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeIn(List<String> values) {
            addCriterion("typecode in", values, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeNotIn(List<String> values) {
            addCriterion("typecode not in", values, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeBetween(String value1, String value2) {
            addCriterion("typecode between", value1, value2, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeNotBetween(String value1, String value2) {
            addCriterion("typecode not between", value1, value2, "typecode");
            return (Criteria) this;
        }

        public Criteria andSendmsgIsNull() {
            addCriterion("sendmsg is null");
            return (Criteria) this;
        }

        public Criteria andSendmsgIsNotNull() {
            addCriterion("sendmsg is not null");
            return (Criteria) this;
        }

        public Criteria andSendmsgEqualTo(String value) {
            addCriterion("sendmsg =", value, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andSendmsgNotEqualTo(String value) {
            addCriterion("sendmsg <>", value, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andSendmsgGreaterThan(String value) {
            addCriterion("sendmsg >", value, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andSendmsgGreaterThanOrEqualTo(String value) {
            addCriterion("sendmsg >=", value, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andSendmsgLessThan(String value) {
            addCriterion("sendmsg <", value, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andSendmsgLessThanOrEqualTo(String value) {
            addCriterion("sendmsg <=", value, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andSendmsgLike(String value) {
            addCriterion("sendmsg like", value, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andSendmsgNotLike(String value) {
            addCriterion("sendmsg not like", value, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andSendmsgIn(List<String> values) {
            addCriterion("sendmsg in", values, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andSendmsgNotIn(List<String> values) {
            addCriterion("sendmsg not in", values, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andSendmsgBetween(String value1, String value2) {
            addCriterion("sendmsg between", value1, value2, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andSendmsgNotBetween(String value1, String value2) {
            addCriterion("sendmsg not between", value1, value2, "sendmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgIsNull() {
            addCriterion("exmsg is null");
            return (Criteria) this;
        }

        public Criteria andExmsgIsNotNull() {
            addCriterion("exmsg is not null");
            return (Criteria) this;
        }

        public Criteria andExmsgEqualTo(String value) {
            addCriterion("exmsg =", value, "exmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgNotEqualTo(String value) {
            addCriterion("exmsg <>", value, "exmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgGreaterThan(String value) {
            addCriterion("exmsg >", value, "exmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgGreaterThanOrEqualTo(String value) {
            addCriterion("exmsg >=", value, "exmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgLessThan(String value) {
            addCriterion("exmsg <", value, "exmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgLessThanOrEqualTo(String value) {
            addCriterion("exmsg <=", value, "exmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgLike(String value) {
            addCriterion("exmsg like", value, "exmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgNotLike(String value) {
            addCriterion("exmsg not like", value, "exmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgIn(List<String> values) {
            addCriterion("exmsg in", values, "exmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgNotIn(List<String> values) {
            addCriterion("exmsg not in", values, "exmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgBetween(String value1, String value2) {
            addCriterion("exmsg between", value1, value2, "exmsg");
            return (Criteria) this;
        }

        public Criteria andExmsgNotBetween(String value1, String value2) {
            addCriterion("exmsg not between", value1, value2, "exmsg");
            return (Criteria) this;
        }

        public Criteria andMethodnameIsNull() {
            addCriterion("methodname is null");
            return (Criteria) this;
        }

        public Criteria andMethodnameIsNotNull() {
            addCriterion("methodname is not null");
            return (Criteria) this;
        }

        public Criteria andMethodnameEqualTo(String value) {
            addCriterion("methodname =", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotEqualTo(String value) {
            addCriterion("methodname <>", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameGreaterThan(String value) {
            addCriterion("methodname >", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameGreaterThanOrEqualTo(String value) {
            addCriterion("methodname >=", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameLessThan(String value) {
            addCriterion("methodname <", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameLessThanOrEqualTo(String value) {
            addCriterion("methodname <=", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameLike(String value) {
            addCriterion("methodname like", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotLike(String value) {
            addCriterion("methodname not like", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameIn(List<String> values) {
            addCriterion("methodname in", values, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotIn(List<String> values) {
            addCriterion("methodname not in", values, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameBetween(String value1, String value2) {
            addCriterion("methodname between", value1, value2, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotBetween(String value1, String value2) {
            addCriterion("methodname not between", value1, value2, "methodname");
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

        public Criteria andSortsEqualTo(Byte value) {
            addCriterion("SORTS =", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotEqualTo(Byte value) {
            addCriterion("SORTS <>", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThan(Byte value) {
            addCriterion("SORTS >", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThanOrEqualTo(Byte value) {
            addCriterion("SORTS >=", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThan(Byte value) {
            addCriterion("SORTS <", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThanOrEqualTo(Byte value) {
            addCriterion("SORTS <=", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsIn(List<Byte> values) {
            addCriterion("SORTS in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotIn(List<Byte> values) {
            addCriterion("SORTS not in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsBetween(Byte value1, Byte value2) {
            addCriterion("SORTS between", value1, value2, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotBetween(Byte value1, Byte value2) {
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