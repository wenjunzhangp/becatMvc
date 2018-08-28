package com.baozi.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaobaoCouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaobaoCouponExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNull() {
            addCriterion("goodsname is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("goodsname is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("goodsname =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("goodsname <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("goodsname >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsname >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("goodsname <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("goodsname <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("goodsname like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("goodsname not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("goodsname in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("goodsname not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("goodsname between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("goodsname not between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkIsNull() {
            addCriterion("goodsremark is null");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkIsNotNull() {
            addCriterion("goodsremark is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkEqualTo(String value) {
            addCriterion("goodsremark =", value, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkNotEqualTo(String value) {
            addCriterion("goodsremark <>", value, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkGreaterThan(String value) {
            addCriterion("goodsremark >", value, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkGreaterThanOrEqualTo(String value) {
            addCriterion("goodsremark >=", value, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkLessThan(String value) {
            addCriterion("goodsremark <", value, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkLessThanOrEqualTo(String value) {
            addCriterion("goodsremark <=", value, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkLike(String value) {
            addCriterion("goodsremark like", value, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkNotLike(String value) {
            addCriterion("goodsremark not like", value, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkIn(List<String> values) {
            addCriterion("goodsremark in", values, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkNotIn(List<String> values) {
            addCriterion("goodsremark not in", values, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkBetween(String value1, String value2) {
            addCriterion("goodsremark between", value1, value2, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andGoodsremarkNotBetween(String value1, String value2) {
            addCriterion("goodsremark not between", value1, value2, "goodsremark");
            return (Criteria) this;
        }

        public Criteria andTotalcountIsNull() {
            addCriterion("totalcount is null");
            return (Criteria) this;
        }

        public Criteria andTotalcountIsNotNull() {
            addCriterion("totalcount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalcountEqualTo(String value) {
            addCriterion("totalcount =", value, "totalcount");
            return (Criteria) this;
        }

        public Criteria andTotalcountNotEqualTo(String value) {
            addCriterion("totalcount <>", value, "totalcount");
            return (Criteria) this;
        }

        public Criteria andTotalcountGreaterThan(String value) {
            addCriterion("totalcount >", value, "totalcount");
            return (Criteria) this;
        }

        public Criteria andTotalcountGreaterThanOrEqualTo(String value) {
            addCriterion("totalcount >=", value, "totalcount");
            return (Criteria) this;
        }

        public Criteria andTotalcountLessThan(String value) {
            addCriterion("totalcount <", value, "totalcount");
            return (Criteria) this;
        }

        public Criteria andTotalcountLessThanOrEqualTo(String value) {
            addCriterion("totalcount <=", value, "totalcount");
            return (Criteria) this;
        }

        public Criteria andTotalcountLike(String value) {
            addCriterion("totalcount like", value, "totalcount");
            return (Criteria) this;
        }

        public Criteria andTotalcountNotLike(String value) {
            addCriterion("totalcount not like", value, "totalcount");
            return (Criteria) this;
        }

        public Criteria andTotalcountIn(List<String> values) {
            addCriterion("totalcount in", values, "totalcount");
            return (Criteria) this;
        }

        public Criteria andTotalcountNotIn(List<String> values) {
            addCriterion("totalcount not in", values, "totalcount");
            return (Criteria) this;
        }

        public Criteria andTotalcountBetween(String value1, String value2) {
            addCriterion("totalcount between", value1, value2, "totalcount");
            return (Criteria) this;
        }

        public Criteria andTotalcountNotBetween(String value1, String value2) {
            addCriterion("totalcount not between", value1, value2, "totalcount");
            return (Criteria) this;
        }

        public Criteria andBuynumIsNull() {
            addCriterion("buynum is null");
            return (Criteria) this;
        }

        public Criteria andBuynumIsNotNull() {
            addCriterion("buynum is not null");
            return (Criteria) this;
        }

        public Criteria andBuynumEqualTo(String value) {
            addCriterion("buynum =", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumNotEqualTo(String value) {
            addCriterion("buynum <>", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumGreaterThan(String value) {
            addCriterion("buynum >", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumGreaterThanOrEqualTo(String value) {
            addCriterion("buynum >=", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumLessThan(String value) {
            addCriterion("buynum <", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumLessThanOrEqualTo(String value) {
            addCriterion("buynum <=", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumLike(String value) {
            addCriterion("buynum like", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumNotLike(String value) {
            addCriterion("buynum not like", value, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumIn(List<String> values) {
            addCriterion("buynum in", values, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumNotIn(List<String> values) {
            addCriterion("buynum not in", values, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumBetween(String value1, String value2) {
            addCriterion("buynum between", value1, value2, "buynum");
            return (Criteria) this;
        }

        public Criteria andBuynumNotBetween(String value1, String value2) {
            addCriterion("buynum not between", value1, value2, "buynum");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceIsNull() {
            addCriterion("onlineprice is null");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceIsNotNull() {
            addCriterion("onlineprice is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceEqualTo(String value) {
            addCriterion("onlineprice =", value, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceNotEqualTo(String value) {
            addCriterion("onlineprice <>", value, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceGreaterThan(String value) {
            addCriterion("onlineprice >", value, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceGreaterThanOrEqualTo(String value) {
            addCriterion("onlineprice >=", value, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceLessThan(String value) {
            addCriterion("onlineprice <", value, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceLessThanOrEqualTo(String value) {
            addCriterion("onlineprice <=", value, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceLike(String value) {
            addCriterion("onlineprice like", value, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceNotLike(String value) {
            addCriterion("onlineprice not like", value, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceIn(List<String> values) {
            addCriterion("onlineprice in", values, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceNotIn(List<String> values) {
            addCriterion("onlineprice not in", values, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceBetween(String value1, String value2) {
            addCriterion("onlineprice between", value1, value2, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andOnlinepriceNotBetween(String value1, String value2) {
            addCriterion("onlineprice not between", value1, value2, "onlineprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceIsNull() {
            addCriterion("couponprice is null");
            return (Criteria) this;
        }

        public Criteria andCouponpriceIsNotNull() {
            addCriterion("couponprice is not null");
            return (Criteria) this;
        }

        public Criteria andCouponpriceEqualTo(String value) {
            addCriterion("couponprice =", value, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceNotEqualTo(String value) {
            addCriterion("couponprice <>", value, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceGreaterThan(String value) {
            addCriterion("couponprice >", value, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceGreaterThanOrEqualTo(String value) {
            addCriterion("couponprice >=", value, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceLessThan(String value) {
            addCriterion("couponprice <", value, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceLessThanOrEqualTo(String value) {
            addCriterion("couponprice <=", value, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceLike(String value) {
            addCriterion("couponprice like", value, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceNotLike(String value) {
            addCriterion("couponprice not like", value, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceIn(List<String> values) {
            addCriterion("couponprice in", values, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceNotIn(List<String> values) {
            addCriterion("couponprice not in", values, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceBetween(String value1, String value2) {
            addCriterion("couponprice between", value1, value2, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCouponpriceNotBetween(String value1, String value2) {
            addCriterion("couponprice not between", value1, value2, "couponprice");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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