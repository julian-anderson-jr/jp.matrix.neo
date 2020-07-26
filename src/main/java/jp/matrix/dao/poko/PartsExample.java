package jp.matrix.dao.poko;

import java.util.ArrayList;
import java.util.List;

public class PartsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PartsExample() {
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

        public Criteria andPIDIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria andPIDIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }

        public Criteria andPIDEqualTo(Integer value) {
            addCriterion("PID =", value, "PID");
            return (Criteria) this;
        }

        public Criteria andPIDNotEqualTo(Integer value) {
            addCriterion("PID <>", value, "PID");
            return (Criteria) this;
        }

        public Criteria andPIDGreaterThan(Integer value) {
            addCriterion("PID >", value, "PID");
            return (Criteria) this;
        }

        public Criteria andPIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("PID >=", value, "PID");
            return (Criteria) this;
        }

        public Criteria andPIDLessThan(Integer value) {
            addCriterion("PID <", value, "PID");
            return (Criteria) this;
        }

        public Criteria andPIDLessThanOrEqualTo(Integer value) {
            addCriterion("PID <=", value, "PID");
            return (Criteria) this;
        }

        public Criteria andPIDIn(List<Integer> values) {
            addCriterion("PID in", values, "PID");
            return (Criteria) this;
        }

        public Criteria andPIDNotIn(List<Integer> values) {
            addCriterion("PID not in", values, "PID");
            return (Criteria) this;
        }

        public Criteria andPIDBetween(Integer value1, Integer value2) {
            addCriterion("PID between", value1, value2, "PID");
            return (Criteria) this;
        }

        public Criteria andPIDNotBetween(Integer value1, Integer value2) {
            addCriterion("PID not between", value1, value2, "PID");
            return (Criteria) this;
        }

        public Criteria andPNAMEIsNull() {
            addCriterion("PNAME is null");
            return (Criteria) this;
        }

        public Criteria andPNAMEIsNotNull() {
            addCriterion("PNAME is not null");
            return (Criteria) this;
        }

        public Criteria andPNAMEEqualTo(String value) {
            addCriterion("PNAME =", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMENotEqualTo(String value) {
            addCriterion("PNAME <>", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMEGreaterThan(String value) {
            addCriterion("PNAME >", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMEGreaterThanOrEqualTo(String value) {
            addCriterion("PNAME >=", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMELessThan(String value) {
            addCriterion("PNAME <", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMELessThanOrEqualTo(String value) {
            addCriterion("PNAME <=", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMELike(String value) {
            addCriterion("PNAME like", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMENotLike(String value) {
            addCriterion("PNAME not like", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMEIn(List<String> values) {
            addCriterion("PNAME in", values, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMENotIn(List<String> values) {
            addCriterion("PNAME not in", values, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMEBetween(String value1, String value2) {
            addCriterion("PNAME between", value1, value2, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMENotBetween(String value1, String value2) {
            addCriterion("PNAME not between", value1, value2, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPRICEIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPRICEIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPRICEEqualTo(Integer value) {
            addCriterion("PRICE =", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICENotEqualTo(Integer value) {
            addCriterion("PRICE <>", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICEGreaterThan(Integer value) {
            addCriterion("PRICE >", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICEGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRICE >=", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICELessThan(Integer value) {
            addCriterion("PRICE <", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICELessThanOrEqualTo(Integer value) {
            addCriterion("PRICE <=", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICEIn(List<Integer> values) {
            addCriterion("PRICE in", values, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICENotIn(List<Integer> values) {
            addCriterion("PRICE not in", values, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICEBetween(Integer value1, Integer value2) {
            addCriterion("PRICE between", value1, value2, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICENotBetween(Integer value1, Integer value2) {
            addCriterion("PRICE not between", value1, value2, "PRICE");
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