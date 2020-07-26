package jp.matrix.dao.poko;

import java.util.ArrayList;
import java.util.List;

public class GroupinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupinfoExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andGPIDIsNull() {
            addCriterion("GPID is null");
            return (Criteria) this;
        }

        public Criteria andGPIDIsNotNull() {
            addCriterion("GPID is not null");
            return (Criteria) this;
        }

        public Criteria andGPIDEqualTo(Integer value) {
            addCriterion("GPID =", value, "GPID");
            return (Criteria) this;
        }

        public Criteria andGPIDNotEqualTo(Integer value) {
            addCriterion("GPID <>", value, "GPID");
            return (Criteria) this;
        }

        public Criteria andGPIDGreaterThan(Integer value) {
            addCriterion("GPID >", value, "GPID");
            return (Criteria) this;
        }

        public Criteria andGPIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("GPID >=", value, "GPID");
            return (Criteria) this;
        }

        public Criteria andGPIDLessThan(Integer value) {
            addCriterion("GPID <", value, "GPID");
            return (Criteria) this;
        }

        public Criteria andGPIDLessThanOrEqualTo(Integer value) {
            addCriterion("GPID <=", value, "GPID");
            return (Criteria) this;
        }

        public Criteria andGPIDIn(List<Integer> values) {
            addCriterion("GPID in", values, "GPID");
            return (Criteria) this;
        }

        public Criteria andGPIDNotIn(List<Integer> values) {
            addCriterion("GPID not in", values, "GPID");
            return (Criteria) this;
        }

        public Criteria andGPIDBetween(Integer value1, Integer value2) {
            addCriterion("GPID between", value1, value2, "GPID");
            return (Criteria) this;
        }

        public Criteria andGPIDNotBetween(Integer value1, Integer value2) {
            addCriterion("GPID not between", value1, value2, "GPID");
            return (Criteria) this;
        }

        public Criteria andGPNAMEIsNull() {
            addCriterion("GPNAME is null");
            return (Criteria) this;
        }

        public Criteria andGPNAMEIsNotNull() {
            addCriterion("GPNAME is not null");
            return (Criteria) this;
        }

        public Criteria andGPNAMEEqualTo(String value) {
            addCriterion("GPNAME =", value, "GPNAME");
            return (Criteria) this;
        }

        public Criteria andGPNAMENotEqualTo(String value) {
            addCriterion("GPNAME <>", value, "GPNAME");
            return (Criteria) this;
        }

        public Criteria andGPNAMEGreaterThan(String value) {
            addCriterion("GPNAME >", value, "GPNAME");
            return (Criteria) this;
        }

        public Criteria andGPNAMEGreaterThanOrEqualTo(String value) {
            addCriterion("GPNAME >=", value, "GPNAME");
            return (Criteria) this;
        }

        public Criteria andGPNAMELessThan(String value) {
            addCriterion("GPNAME <", value, "GPNAME");
            return (Criteria) this;
        }

        public Criteria andGPNAMELessThanOrEqualTo(String value) {
            addCriterion("GPNAME <=", value, "GPNAME");
            return (Criteria) this;
        }

        public Criteria andGPNAMELike(String value) {
            addCriterion("GPNAME like", value, "GPNAME");
            return (Criteria) this;
        }

        public Criteria andGPNAMENotLike(String value) {
            addCriterion("GPNAME not like", value, "GPNAME");
            return (Criteria) this;
        }

        public Criteria andGPNAMEIn(List<String> values) {
            addCriterion("GPNAME in", values, "GPNAME");
            return (Criteria) this;
        }

        public Criteria andGPNAMENotIn(List<String> values) {
            addCriterion("GPNAME not in", values, "GPNAME");
            return (Criteria) this;
        }

        public Criteria andGPNAMEBetween(String value1, String value2) {
            addCriterion("GPNAME between", value1, value2, "GPNAME");
            return (Criteria) this;
        }

        public Criteria andGPNAMENotBetween(String value1, String value2) {
            addCriterion("GPNAME not between", value1, value2, "GPNAME");
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