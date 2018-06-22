package com.pcitc.oilmachine.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellRefundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellRefundExample() {
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

        public Criteria andSellsubscribeidIsNull() {
            addCriterion("sellsubscribeid is null");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidIsNotNull() {
            addCriterion("sellsubscribeid is not null");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidEqualTo(String value) {
            addCriterion("sellsubscribeid =", value, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidNotEqualTo(String value) {
            addCriterion("sellsubscribeid <>", value, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidGreaterThan(String value) {
            addCriterion("sellsubscribeid >", value, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidGreaterThanOrEqualTo(String value) {
            addCriterion("sellsubscribeid >=", value, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidLessThan(String value) {
            addCriterion("sellsubscribeid <", value, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidLessThanOrEqualTo(String value) {
            addCriterion("sellsubscribeid <=", value, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidLike(String value) {
            addCriterion("sellsubscribeid like", value, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidNotLike(String value) {
            addCriterion("sellsubscribeid not like", value, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidIn(List<String> values) {
            addCriterion("sellsubscribeid in", values, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidNotIn(List<String> values) {
            addCriterion("sellsubscribeid not in", values, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidBetween(String value1, String value2) {
            addCriterion("sellsubscribeid between", value1, value2, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andSellsubscribeidNotBetween(String value1, String value2) {
            addCriterion("sellsubscribeid not between", value1, value2, "sellsubscribeid");
            return (Criteria) this;
        }

        public Criteria andRefundnoIsNull() {
            addCriterion("refundno is null");
            return (Criteria) this;
        }

        public Criteria andRefundnoIsNotNull() {
            addCriterion("refundno is not null");
            return (Criteria) this;
        }

        public Criteria andRefundnoEqualTo(String value) {
            addCriterion("refundno =", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoNotEqualTo(String value) {
            addCriterion("refundno <>", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoGreaterThan(String value) {
            addCriterion("refundno >", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoGreaterThanOrEqualTo(String value) {
            addCriterion("refundno >=", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoLessThan(String value) {
            addCriterion("refundno <", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoLessThanOrEqualTo(String value) {
            addCriterion("refundno <=", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoLike(String value) {
            addCriterion("refundno like", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoNotLike(String value) {
            addCriterion("refundno not like", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoIn(List<String> values) {
            addCriterion("refundno in", values, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoNotIn(List<String> values) {
            addCriterion("refundno not in", values, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoBetween(String value1, String value2) {
            addCriterion("refundno between", value1, value2, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoNotBetween(String value1, String value2) {
            addCriterion("refundno not between", value1, value2, "refundno");
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

        public Criteria andPaytypecodeIsNull() {
            addCriterion("paytypecode is null");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeIsNotNull() {
            addCriterion("paytypecode is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeEqualTo(String value) {
            addCriterion("paytypecode =", value, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeNotEqualTo(String value) {
            addCriterion("paytypecode <>", value, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeGreaterThan(String value) {
            addCriterion("paytypecode >", value, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeGreaterThanOrEqualTo(String value) {
            addCriterion("paytypecode >=", value, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeLessThan(String value) {
            addCriterion("paytypecode <", value, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeLessThanOrEqualTo(String value) {
            addCriterion("paytypecode <=", value, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeLike(String value) {
            addCriterion("paytypecode like", value, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeNotLike(String value) {
            addCriterion("paytypecode not like", value, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeIn(List<String> values) {
            addCriterion("paytypecode in", values, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeNotIn(List<String> values) {
            addCriterion("paytypecode not in", values, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeBetween(String value1, String value2) {
            addCriterion("paytypecode between", value1, value2, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypecodeNotBetween(String value1, String value2) {
            addCriterion("paytypecode not between", value1, value2, "paytypecode");
            return (Criteria) this;
        }

        public Criteria andPaytypenameIsNull() {
            addCriterion("paytypename is null");
            return (Criteria) this;
        }

        public Criteria andPaytypenameIsNotNull() {
            addCriterion("paytypename is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypenameEqualTo(String value) {
            addCriterion("paytypename =", value, "paytypename");
            return (Criteria) this;
        }

        public Criteria andPaytypenameNotEqualTo(String value) {
            addCriterion("paytypename <>", value, "paytypename");
            return (Criteria) this;
        }

        public Criteria andPaytypenameGreaterThan(String value) {
            addCriterion("paytypename >", value, "paytypename");
            return (Criteria) this;
        }

        public Criteria andPaytypenameGreaterThanOrEqualTo(String value) {
            addCriterion("paytypename >=", value, "paytypename");
            return (Criteria) this;
        }

        public Criteria andPaytypenameLessThan(String value) {
            addCriterion("paytypename <", value, "paytypename");
            return (Criteria) this;
        }

        public Criteria andPaytypenameLessThanOrEqualTo(String value) {
            addCriterion("paytypename <=", value, "paytypename");
            return (Criteria) this;
        }

        public Criteria andPaytypenameLike(String value) {
            addCriterion("paytypename like", value, "paytypename");
            return (Criteria) this;
        }

        public Criteria andPaytypenameNotLike(String value) {
            addCriterion("paytypename not like", value, "paytypename");
            return (Criteria) this;
        }

        public Criteria andPaytypenameIn(List<String> values) {
            addCriterion("paytypename in", values, "paytypename");
            return (Criteria) this;
        }

        public Criteria andPaytypenameNotIn(List<String> values) {
            addCriterion("paytypename not in", values, "paytypename");
            return (Criteria) this;
        }

        public Criteria andPaytypenameBetween(String value1, String value2) {
            addCriterion("paytypename between", value1, value2, "paytypename");
            return (Criteria) this;
        }

        public Criteria andPaytypenameNotBetween(String value1, String value2) {
            addCriterion("paytypename not between", value1, value2, "paytypename");
            return (Criteria) this;
        }

        public Criteria andOpetimeIsNull() {
            addCriterion("opetime is null");
            return (Criteria) this;
        }

        public Criteria andOpetimeIsNotNull() {
            addCriterion("opetime is not null");
            return (Criteria) this;
        }

        public Criteria andOpetimeEqualTo(Date value) {
            addCriterion("opetime =", value, "opetime");
            return (Criteria) this;
        }

        public Criteria andOpetimeNotEqualTo(Date value) {
            addCriterion("opetime <>", value, "opetime");
            return (Criteria) this;
        }

        public Criteria andOpetimeGreaterThan(Date value) {
            addCriterion("opetime >", value, "opetime");
            return (Criteria) this;
        }

        public Criteria andOpetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("opetime >=", value, "opetime");
            return (Criteria) this;
        }

        public Criteria andOpetimeLessThan(Date value) {
            addCriterion("opetime <", value, "opetime");
            return (Criteria) this;
        }

        public Criteria andOpetimeLessThanOrEqualTo(Date value) {
            addCriterion("opetime <=", value, "opetime");
            return (Criteria) this;
        }

        public Criteria andOpetimeIn(List<Date> values) {
            addCriterion("opetime in", values, "opetime");
            return (Criteria) this;
        }

        public Criteria andOpetimeNotIn(List<Date> values) {
            addCriterion("opetime not in", values, "opetime");
            return (Criteria) this;
        }

        public Criteria andOpetimeBetween(Date value1, Date value2) {
            addCriterion("opetime between", value1, value2, "opetime");
            return (Criteria) this;
        }

        public Criteria andOpetimeNotBetween(Date value1, Date value2) {
            addCriterion("opetime not between", value1, value2, "opetime");
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