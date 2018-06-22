package com.pcitc.oilmachine.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PreAuthorizationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PreAuthorizationExample() {
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

        public Criteria andMemcardnumIsNull() {
            addCriterion("memcardnum is null");
            return (Criteria) this;
        }

        public Criteria andMemcardnumIsNotNull() {
            addCriterion("memcardnum is not null");
            return (Criteria) this;
        }

        public Criteria andMemcardnumEqualTo(String value) {
            addCriterion("memcardnum =", value, "memcardnum");
            return (Criteria) this;
        }

        public Criteria andMemcardnumNotEqualTo(String value) {
            addCriterion("memcardnum <>", value, "memcardnum");
            return (Criteria) this;
        }

        public Criteria andMemcardnumGreaterThan(String value) {
            addCriterion("memcardnum >", value, "memcardnum");
            return (Criteria) this;
        }

        public Criteria andMemcardnumGreaterThanOrEqualTo(String value) {
            addCriterion("memcardnum >=", value, "memcardnum");
            return (Criteria) this;
        }

        public Criteria andMemcardnumLessThan(String value) {
            addCriterion("memcardnum <", value, "memcardnum");
            return (Criteria) this;
        }

        public Criteria andMemcardnumLessThanOrEqualTo(String value) {
            addCriterion("memcardnum <=", value, "memcardnum");
            return (Criteria) this;
        }

        public Criteria andMemcardnumLike(String value) {
            addCriterion("memcardnum like", value, "memcardnum");
            return (Criteria) this;
        }

        public Criteria andMemcardnumNotLike(String value) {
            addCriterion("memcardnum not like", value, "memcardnum");
            return (Criteria) this;
        }

        public Criteria andMemcardnumIn(List<String> values) {
            addCriterion("memcardnum in", values, "memcardnum");
            return (Criteria) this;
        }

        public Criteria andMemcardnumNotIn(List<String> values) {
            addCriterion("memcardnum not in", values, "memcardnum");
            return (Criteria) this;
        }

        public Criteria andMemcardnumBetween(String value1, String value2) {
            addCriterion("memcardnum between", value1, value2, "memcardnum");
            return (Criteria) this;
        }

        public Criteria andMemcardnumNotBetween(String value1, String value2) {
            addCriterion("memcardnum not between", value1, value2, "memcardnum");
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

        public Criteria andApproveidIsNull() {
            addCriterion("approveId is null");
            return (Criteria) this;
        }

        public Criteria andApproveidIsNotNull() {
            addCriterion("approveId is not null");
            return (Criteria) this;
        }

        public Criteria andApproveidEqualTo(String value) {
            addCriterion("approveId =", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidNotEqualTo(String value) {
            addCriterion("approveId <>", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidGreaterThan(String value) {
            addCriterion("approveId >", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidGreaterThanOrEqualTo(String value) {
            addCriterion("approveId >=", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidLessThan(String value) {
            addCriterion("approveId <", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidLessThanOrEqualTo(String value) {
            addCriterion("approveId <=", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidLike(String value) {
            addCriterion("approveId like", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidNotLike(String value) {
            addCriterion("approveId not like", value, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidIn(List<String> values) {
            addCriterion("approveId in", values, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidNotIn(List<String> values) {
            addCriterion("approveId not in", values, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidBetween(String value1, String value2) {
            addCriterion("approveId between", value1, value2, "approveid");
            return (Criteria) this;
        }

        public Criteria andApproveidNotBetween(String value1, String value2) {
            addCriterion("approveId not between", value1, value2, "approveid");
            return (Criteria) this;
        }

        public Criteria andPresqnoIsNull() {
            addCriterion("presqno is null");
            return (Criteria) this;
        }

        public Criteria andPresqnoIsNotNull() {
            addCriterion("presqno is not null");
            return (Criteria) this;
        }

        public Criteria andPresqnoEqualTo(String value) {
            addCriterion("presqno =", value, "presqno");
            return (Criteria) this;
        }

        public Criteria andPresqnoNotEqualTo(String value) {
            addCriterion("presqno <>", value, "presqno");
            return (Criteria) this;
        }

        public Criteria andPresqnoGreaterThan(String value) {
            addCriterion("presqno >", value, "presqno");
            return (Criteria) this;
        }

        public Criteria andPresqnoGreaterThanOrEqualTo(String value) {
            addCriterion("presqno >=", value, "presqno");
            return (Criteria) this;
        }

        public Criteria andPresqnoLessThan(String value) {
            addCriterion("presqno <", value, "presqno");
            return (Criteria) this;
        }

        public Criteria andPresqnoLessThanOrEqualTo(String value) {
            addCriterion("presqno <=", value, "presqno");
            return (Criteria) this;
        }

        public Criteria andPresqnoLike(String value) {
            addCriterion("presqno like", value, "presqno");
            return (Criteria) this;
        }

        public Criteria andPresqnoNotLike(String value) {
            addCriterion("presqno not like", value, "presqno");
            return (Criteria) this;
        }

        public Criteria andPresqnoIn(List<String> values) {
            addCriterion("presqno in", values, "presqno");
            return (Criteria) this;
        }

        public Criteria andPresqnoNotIn(List<String> values) {
            addCriterion("presqno not in", values, "presqno");
            return (Criteria) this;
        }

        public Criteria andPresqnoBetween(String value1, String value2) {
            addCriterion("presqno between", value1, value2, "presqno");
            return (Criteria) this;
        }

        public Criteria andPresqnoNotBetween(String value1, String value2) {
            addCriterion("presqno not between", value1, value2, "presqno");
            return (Criteria) this;
        }

        public Criteria andPreamountIsNull() {
            addCriterion("preamount is null");
            return (Criteria) this;
        }

        public Criteria andPreamountIsNotNull() {
            addCriterion("preamount is not null");
            return (Criteria) this;
        }

        public Criteria andPreamountEqualTo(Long value) {
            addCriterion("preamount =", value, "preamount");
            return (Criteria) this;
        }

        public Criteria andPreamountNotEqualTo(Long value) {
            addCriterion("preamount <>", value, "preamount");
            return (Criteria) this;
        }

        public Criteria andPreamountGreaterThan(Long value) {
            addCriterion("preamount >", value, "preamount");
            return (Criteria) this;
        }

        public Criteria andPreamountGreaterThanOrEqualTo(Long value) {
            addCriterion("preamount >=", value, "preamount");
            return (Criteria) this;
        }

        public Criteria andPreamountLessThan(Long value) {
            addCriterion("preamount <", value, "preamount");
            return (Criteria) this;
        }

        public Criteria andPreamountLessThanOrEqualTo(Long value) {
            addCriterion("preamount <=", value, "preamount");
            return (Criteria) this;
        }

        public Criteria andPreamountIn(List<Long> values) {
            addCriterion("preamount in", values, "preamount");
            return (Criteria) this;
        }

        public Criteria andPreamountNotIn(List<Long> values) {
            addCriterion("preamount not in", values, "preamount");
            return (Criteria) this;
        }

        public Criteria andPreamountBetween(Long value1, Long value2) {
            addCriterion("preamount between", value1, value2, "preamount");
            return (Criteria) this;
        }

        public Criteria andPreamountNotBetween(Long value1, Long value2) {
            addCriterion("preamount not between", value1, value2, "preamount");
            return (Criteria) this;
        }

        public Criteria andPrewcnoIsNull() {
            addCriterion("prewcno is null");
            return (Criteria) this;
        }

        public Criteria andPrewcnoIsNotNull() {
            addCriterion("prewcno is not null");
            return (Criteria) this;
        }

        public Criteria andPrewcnoEqualTo(String value) {
            addCriterion("prewcno =", value, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcnoNotEqualTo(String value) {
            addCriterion("prewcno <>", value, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcnoGreaterThan(String value) {
            addCriterion("prewcno >", value, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcnoGreaterThanOrEqualTo(String value) {
            addCriterion("prewcno >=", value, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcnoLessThan(String value) {
            addCriterion("prewcno <", value, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcnoLessThanOrEqualTo(String value) {
            addCriterion("prewcno <=", value, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcnoLike(String value) {
            addCriterion("prewcno like", value, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcnoNotLike(String value) {
            addCriterion("prewcno not like", value, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcnoIn(List<String> values) {
            addCriterion("prewcno in", values, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcnoNotIn(List<String> values) {
            addCriterion("prewcno not in", values, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcnoBetween(String value1, String value2) {
            addCriterion("prewcno between", value1, value2, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcnoNotBetween(String value1, String value2) {
            addCriterion("prewcno not between", value1, value2, "prewcno");
            return (Criteria) this;
        }

        public Criteria andPrewcqxIsNull() {
            addCriterion("prewcqx is null");
            return (Criteria) this;
        }

        public Criteria andPrewcqxIsNotNull() {
            addCriterion("prewcqx is not null");
            return (Criteria) this;
        }

        public Criteria andPrewcqxEqualTo(String value) {
            addCriterion("prewcqx =", value, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andPrewcqxNotEqualTo(String value) {
            addCriterion("prewcqx <>", value, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andPrewcqxGreaterThan(String value) {
            addCriterion("prewcqx >", value, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andPrewcqxGreaterThanOrEqualTo(String value) {
            addCriterion("prewcqx >=", value, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andPrewcqxLessThan(String value) {
            addCriterion("prewcqx <", value, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andPrewcqxLessThanOrEqualTo(String value) {
            addCriterion("prewcqx <=", value, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andPrewcqxLike(String value) {
            addCriterion("prewcqx like", value, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andPrewcqxNotLike(String value) {
            addCriterion("prewcqx not like", value, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andPrewcqxIn(List<String> values) {
            addCriterion("prewcqx in", values, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andPrewcqxNotIn(List<String> values) {
            addCriterion("prewcqx not in", values, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andPrewcqxBetween(String value1, String value2) {
            addCriterion("prewcqx between", value1, value2, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andPrewcqxNotBetween(String value1, String value2) {
            addCriterion("prewcqx not between", value1, value2, "prewcqx");
            return (Criteria) this;
        }

        public Criteria andSqopetimeIsNull() {
            addCriterion("sqopetime is null");
            return (Criteria) this;
        }

        public Criteria andSqopetimeIsNotNull() {
            addCriterion("sqopetime is not null");
            return (Criteria) this;
        }

        public Criteria andSqopetimeEqualTo(Date value) {
            addCriterion("sqopetime =", value, "sqopetime");
            return (Criteria) this;
        }

        public Criteria andSqopetimeNotEqualTo(Date value) {
            addCriterion("sqopetime <>", value, "sqopetime");
            return (Criteria) this;
        }

        public Criteria andSqopetimeGreaterThan(Date value) {
            addCriterion("sqopetime >", value, "sqopetime");
            return (Criteria) this;
        }

        public Criteria andSqopetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sqopetime >=", value, "sqopetime");
            return (Criteria) this;
        }

        public Criteria andSqopetimeLessThan(Date value) {
            addCriterion("sqopetime <", value, "sqopetime");
            return (Criteria) this;
        }

        public Criteria andSqopetimeLessThanOrEqualTo(Date value) {
            addCriterion("sqopetime <=", value, "sqopetime");
            return (Criteria) this;
        }

        public Criteria andSqopetimeIn(List<Date> values) {
            addCriterion("sqopetime in", values, "sqopetime");
            return (Criteria) this;
        }

        public Criteria andSqopetimeNotIn(List<Date> values) {
            addCriterion("sqopetime not in", values, "sqopetime");
            return (Criteria) this;
        }

        public Criteria andSqopetimeBetween(Date value1, Date value2) {
            addCriterion("sqopetime between", value1, value2, "sqopetime");
            return (Criteria) this;
        }

        public Criteria andSqopetimeNotBetween(Date value1, Date value2) {
            addCriterion("sqopetime not between", value1, value2, "sqopetime");
            return (Criteria) this;
        }

        public Criteria andWcopetimeIsNull() {
            addCriterion("wcopetime is null");
            return (Criteria) this;
        }

        public Criteria andWcopetimeIsNotNull() {
            addCriterion("wcopetime is not null");
            return (Criteria) this;
        }

        public Criteria andWcopetimeEqualTo(Date value) {
            addCriterion("wcopetime =", value, "wcopetime");
            return (Criteria) this;
        }

        public Criteria andWcopetimeNotEqualTo(Date value) {
            addCriterion("wcopetime <>", value, "wcopetime");
            return (Criteria) this;
        }

        public Criteria andWcopetimeGreaterThan(Date value) {
            addCriterion("wcopetime >", value, "wcopetime");
            return (Criteria) this;
        }

        public Criteria andWcopetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wcopetime >=", value, "wcopetime");
            return (Criteria) this;
        }

        public Criteria andWcopetimeLessThan(Date value) {
            addCriterion("wcopetime <", value, "wcopetime");
            return (Criteria) this;
        }

        public Criteria andWcopetimeLessThanOrEqualTo(Date value) {
            addCriterion("wcopetime <=", value, "wcopetime");
            return (Criteria) this;
        }

        public Criteria andWcopetimeIn(List<Date> values) {
            addCriterion("wcopetime in", values, "wcopetime");
            return (Criteria) this;
        }

        public Criteria andWcopetimeNotIn(List<Date> values) {
            addCriterion("wcopetime not in", values, "wcopetime");
            return (Criteria) this;
        }

        public Criteria andWcopetimeBetween(Date value1, Date value2) {
            addCriterion("wcopetime between", value1, value2, "wcopetime");
            return (Criteria) this;
        }

        public Criteria andWcopetimeNotBetween(Date value1, Date value2) {
            addCriterion("wcopetime not between", value1, value2, "wcopetime");
            return (Criteria) this;
        }

        public Criteria andQxopetimeIsNull() {
            addCriterion("qxopetime is null");
            return (Criteria) this;
        }

        public Criteria andQxopetimeIsNotNull() {
            addCriterion("qxopetime is not null");
            return (Criteria) this;
        }

        public Criteria andQxopetimeEqualTo(Date value) {
            addCriterion("qxopetime =", value, "qxopetime");
            return (Criteria) this;
        }

        public Criteria andQxopetimeNotEqualTo(Date value) {
            addCriterion("qxopetime <>", value, "qxopetime");
            return (Criteria) this;
        }

        public Criteria andQxopetimeGreaterThan(Date value) {
            addCriterion("qxopetime >", value, "qxopetime");
            return (Criteria) this;
        }

        public Criteria andQxopetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("qxopetime >=", value, "qxopetime");
            return (Criteria) this;
        }

        public Criteria andQxopetimeLessThan(Date value) {
            addCriterion("qxopetime <", value, "qxopetime");
            return (Criteria) this;
        }

        public Criteria andQxopetimeLessThanOrEqualTo(Date value) {
            addCriterion("qxopetime <=", value, "qxopetime");
            return (Criteria) this;
        }

        public Criteria andQxopetimeIn(List<Date> values) {
            addCriterion("qxopetime in", values, "qxopetime");
            return (Criteria) this;
        }

        public Criteria andQxopetimeNotIn(List<Date> values) {
            addCriterion("qxopetime not in", values, "qxopetime");
            return (Criteria) this;
        }

        public Criteria andQxopetimeBetween(Date value1, Date value2) {
            addCriterion("qxopetime between", value1, value2, "qxopetime");
            return (Criteria) this;
        }

        public Criteria andQxopetimeNotBetween(Date value1, Date value2) {
            addCriterion("qxopetime not between", value1, value2, "qxopetime");
            return (Criteria) this;
        }

        public Criteria andSqresultIsNull() {
            addCriterion("sqresult is null");
            return (Criteria) this;
        }

        public Criteria andSqresultIsNotNull() {
            addCriterion("sqresult is not null");
            return (Criteria) this;
        }

        public Criteria andSqresultEqualTo(String value) {
            addCriterion("sqresult =", value, "sqresult");
            return (Criteria) this;
        }

        public Criteria andSqresultNotEqualTo(String value) {
            addCriterion("sqresult <>", value, "sqresult");
            return (Criteria) this;
        }

        public Criteria andSqresultGreaterThan(String value) {
            addCriterion("sqresult >", value, "sqresult");
            return (Criteria) this;
        }

        public Criteria andSqresultGreaterThanOrEqualTo(String value) {
            addCriterion("sqresult >=", value, "sqresult");
            return (Criteria) this;
        }

        public Criteria andSqresultLessThan(String value) {
            addCriterion("sqresult <", value, "sqresult");
            return (Criteria) this;
        }

        public Criteria andSqresultLessThanOrEqualTo(String value) {
            addCriterion("sqresult <=", value, "sqresult");
            return (Criteria) this;
        }

        public Criteria andSqresultLike(String value) {
            addCriterion("sqresult like", value, "sqresult");
            return (Criteria) this;
        }

        public Criteria andSqresultNotLike(String value) {
            addCriterion("sqresult not like", value, "sqresult");
            return (Criteria) this;
        }

        public Criteria andSqresultIn(List<String> values) {
            addCriterion("sqresult in", values, "sqresult");
            return (Criteria) this;
        }

        public Criteria andSqresultNotIn(List<String> values) {
            addCriterion("sqresult not in", values, "sqresult");
            return (Criteria) this;
        }

        public Criteria andSqresultBetween(String value1, String value2) {
            addCriterion("sqresult between", value1, value2, "sqresult");
            return (Criteria) this;
        }

        public Criteria andSqresultNotBetween(String value1, String value2) {
            addCriterion("sqresult not between", value1, value2, "sqresult");
            return (Criteria) this;
        }

        public Criteria andQxresultIsNull() {
            addCriterion("qxresult is null");
            return (Criteria) this;
        }

        public Criteria andQxresultIsNotNull() {
            addCriterion("qxresult is not null");
            return (Criteria) this;
        }

        public Criteria andQxresultEqualTo(String value) {
            addCriterion("qxresult =", value, "qxresult");
            return (Criteria) this;
        }

        public Criteria andQxresultNotEqualTo(String value) {
            addCriterion("qxresult <>", value, "qxresult");
            return (Criteria) this;
        }

        public Criteria andQxresultGreaterThan(String value) {
            addCriterion("qxresult >", value, "qxresult");
            return (Criteria) this;
        }

        public Criteria andQxresultGreaterThanOrEqualTo(String value) {
            addCriterion("qxresult >=", value, "qxresult");
            return (Criteria) this;
        }

        public Criteria andQxresultLessThan(String value) {
            addCriterion("qxresult <", value, "qxresult");
            return (Criteria) this;
        }

        public Criteria andQxresultLessThanOrEqualTo(String value) {
            addCriterion("qxresult <=", value, "qxresult");
            return (Criteria) this;
        }

        public Criteria andQxresultLike(String value) {
            addCriterion("qxresult like", value, "qxresult");
            return (Criteria) this;
        }

        public Criteria andQxresultNotLike(String value) {
            addCriterion("qxresult not like", value, "qxresult");
            return (Criteria) this;
        }

        public Criteria andQxresultIn(List<String> values) {
            addCriterion("qxresult in", values, "qxresult");
            return (Criteria) this;
        }

        public Criteria andQxresultNotIn(List<String> values) {
            addCriterion("qxresult not in", values, "qxresult");
            return (Criteria) this;
        }

        public Criteria andQxresultBetween(String value1, String value2) {
            addCriterion("qxresult between", value1, value2, "qxresult");
            return (Criteria) this;
        }

        public Criteria andQxresultNotBetween(String value1, String value2) {
            addCriterion("qxresult not between", value1, value2, "qxresult");
            return (Criteria) this;
        }

        public Criteria andWcresultIsNull() {
            addCriterion("wcresult is null");
            return (Criteria) this;
        }

        public Criteria andWcresultIsNotNull() {
            addCriterion("wcresult is not null");
            return (Criteria) this;
        }

        public Criteria andWcresultEqualTo(String value) {
            addCriterion("wcresult =", value, "wcresult");
            return (Criteria) this;
        }

        public Criteria andWcresultNotEqualTo(String value) {
            addCriterion("wcresult <>", value, "wcresult");
            return (Criteria) this;
        }

        public Criteria andWcresultGreaterThan(String value) {
            addCriterion("wcresult >", value, "wcresult");
            return (Criteria) this;
        }

        public Criteria andWcresultGreaterThanOrEqualTo(String value) {
            addCriterion("wcresult >=", value, "wcresult");
            return (Criteria) this;
        }

        public Criteria andWcresultLessThan(String value) {
            addCriterion("wcresult <", value, "wcresult");
            return (Criteria) this;
        }

        public Criteria andWcresultLessThanOrEqualTo(String value) {
            addCriterion("wcresult <=", value, "wcresult");
            return (Criteria) this;
        }

        public Criteria andWcresultLike(String value) {
            addCriterion("wcresult like", value, "wcresult");
            return (Criteria) this;
        }

        public Criteria andWcresultNotLike(String value) {
            addCriterion("wcresult not like", value, "wcresult");
            return (Criteria) this;
        }

        public Criteria andWcresultIn(List<String> values) {
            addCriterion("wcresult in", values, "wcresult");
            return (Criteria) this;
        }

        public Criteria andWcresultNotIn(List<String> values) {
            addCriterion("wcresult not in", values, "wcresult");
            return (Criteria) this;
        }

        public Criteria andWcresultBetween(String value1, String value2) {
            addCriterion("wcresult between", value1, value2, "wcresult");
            return (Criteria) this;
        }

        public Criteria andWcresultNotBetween(String value1, String value2) {
            addCriterion("wcresult not between", value1, value2, "wcresult");
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