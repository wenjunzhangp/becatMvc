package com.baozi.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysSettingExample() {
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

        public Criteria andCurrentVersionIsNull() {
            addCriterion("current_version is null");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionIsNotNull() {
            addCriterion("current_version is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionEqualTo(String value) {
            addCriterion("current_version =", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotEqualTo(String value) {
            addCriterion("current_version <>", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionGreaterThan(String value) {
            addCriterion("current_version >", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionGreaterThanOrEqualTo(String value) {
            addCriterion("current_version >=", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionLessThan(String value) {
            addCriterion("current_version <", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionLessThanOrEqualTo(String value) {
            addCriterion("current_version <=", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionLike(String value) {
            addCriterion("current_version like", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotLike(String value) {
            addCriterion("current_version not like", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionIn(List<String> values) {
            addCriterion("current_version in", values, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotIn(List<String> values) {
            addCriterion("current_version not in", values, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionBetween(String value1, String value2) {
            addCriterion("current_version between", value1, value2, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotBetween(String value1, String value2) {
            addCriterion("current_version not between", value1, value2, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andDomainUrlIsNull() {
            addCriterion("domain_url is null");
            return (Criteria) this;
        }

        public Criteria andDomainUrlIsNotNull() {
            addCriterion("domain_url is not null");
            return (Criteria) this;
        }

        public Criteria andDomainUrlEqualTo(String value) {
            addCriterion("domain_url =", value, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andDomainUrlNotEqualTo(String value) {
            addCriterion("domain_url <>", value, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andDomainUrlGreaterThan(String value) {
            addCriterion("domain_url >", value, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andDomainUrlGreaterThanOrEqualTo(String value) {
            addCriterion("domain_url >=", value, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andDomainUrlLessThan(String value) {
            addCriterion("domain_url <", value, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andDomainUrlLessThanOrEqualTo(String value) {
            addCriterion("domain_url <=", value, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andDomainUrlLike(String value) {
            addCriterion("domain_url like", value, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andDomainUrlNotLike(String value) {
            addCriterion("domain_url not like", value, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andDomainUrlIn(List<String> values) {
            addCriterion("domain_url in", values, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andDomainUrlNotIn(List<String> values) {
            addCriterion("domain_url not in", values, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andDomainUrlBetween(String value1, String value2) {
            addCriterion("domain_url between", value1, value2, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andDomainUrlNotBetween(String value1, String value2) {
            addCriterion("domain_url not between", value1, value2, "domainUrl");
            return (Criteria) this;
        }

        public Criteria andServerConfigIsNull() {
            addCriterion("server_config is null");
            return (Criteria) this;
        }

        public Criteria andServerConfigIsNotNull() {
            addCriterion("server_config is not null");
            return (Criteria) this;
        }

        public Criteria andServerConfigEqualTo(String value) {
            addCriterion("server_config =", value, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andServerConfigNotEqualTo(String value) {
            addCriterion("server_config <>", value, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andServerConfigGreaterThan(String value) {
            addCriterion("server_config >", value, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andServerConfigGreaterThanOrEqualTo(String value) {
            addCriterion("server_config >=", value, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andServerConfigLessThan(String value) {
            addCriterion("server_config <", value, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andServerConfigLessThanOrEqualTo(String value) {
            addCriterion("server_config <=", value, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andServerConfigLike(String value) {
            addCriterion("server_config like", value, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andServerConfigNotLike(String value) {
            addCriterion("server_config not like", value, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andServerConfigIn(List<String> values) {
            addCriterion("server_config in", values, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andServerConfigNotIn(List<String> values) {
            addCriterion("server_config not in", values, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andServerConfigBetween(String value1, String value2) {
            addCriterion("server_config between", value1, value2, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andServerConfigNotBetween(String value1, String value2) {
            addCriterion("server_config not between", value1, value2, "serverConfig");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionIsNull() {
            addCriterion("database_version is null");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionIsNotNull() {
            addCriterion("database_version is not null");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionEqualTo(String value) {
            addCriterion("database_version =", value, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionNotEqualTo(String value) {
            addCriterion("database_version <>", value, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionGreaterThan(String value) {
            addCriterion("database_version >", value, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionGreaterThanOrEqualTo(String value) {
            addCriterion("database_version >=", value, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionLessThan(String value) {
            addCriterion("database_version <", value, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionLessThanOrEqualTo(String value) {
            addCriterion("database_version <=", value, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionLike(String value) {
            addCriterion("database_version like", value, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionNotLike(String value) {
            addCriterion("database_version not like", value, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionIn(List<String> values) {
            addCriterion("database_version in", values, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionNotIn(List<String> values) {
            addCriterion("database_version not in", values, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionBetween(String value1, String value2) {
            addCriterion("database_version between", value1, value2, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andDatabaseVersionNotBetween(String value1, String value2) {
            addCriterion("database_version not between", value1, value2, "databaseVersion");
            return (Criteria) this;
        }

        public Criteria andMaxFileIsNull() {
            addCriterion("max_file is null");
            return (Criteria) this;
        }

        public Criteria andMaxFileIsNotNull() {
            addCriterion("max_file is not null");
            return (Criteria) this;
        }

        public Criteria andMaxFileEqualTo(String value) {
            addCriterion("max_file =", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileNotEqualTo(String value) {
            addCriterion("max_file <>", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileGreaterThan(String value) {
            addCriterion("max_file >", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileGreaterThanOrEqualTo(String value) {
            addCriterion("max_file >=", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileLessThan(String value) {
            addCriterion("max_file <", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileLessThanOrEqualTo(String value) {
            addCriterion("max_file <=", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileLike(String value) {
            addCriterion("max_file like", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileNotLike(String value) {
            addCriterion("max_file not like", value, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileIn(List<String> values) {
            addCriterion("max_file in", values, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileNotIn(List<String> values) {
            addCriterion("max_file not in", values, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileBetween(String value1, String value2) {
            addCriterion("max_file between", value1, value2, "maxFile");
            return (Criteria) this;
        }

        public Criteria andMaxFileNotBetween(String value1, String value2) {
            addCriterion("max_file not between", value1, value2, "maxFile");
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