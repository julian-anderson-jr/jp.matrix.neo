package jp.matrix.dao.poko;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserinfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSIDIsNull() {
            addCriterion("SID is null");
            return (Criteria) this;
        }

        public Criteria andSIDIsNotNull() {
            addCriterion("SID is not null");
            return (Criteria) this;
        }

        public Criteria andSIDEqualTo(String value) {
            addCriterion("SID =", value, "SID");
            return (Criteria) this;
        }

        public Criteria andSIDNotEqualTo(String value) {
            addCriterion("SID <>", value, "SID");
            return (Criteria) this;
        }

        public Criteria andSIDGreaterThan(String value) {
            addCriterion("SID >", value, "SID");
            return (Criteria) this;
        }

        public Criteria andSIDGreaterThanOrEqualTo(String value) {
            addCriterion("SID >=", value, "SID");
            return (Criteria) this;
        }

        public Criteria andSIDLessThan(String value) {
            addCriterion("SID <", value, "SID");
            return (Criteria) this;
        }

        public Criteria andSIDLessThanOrEqualTo(String value) {
            addCriterion("SID <=", value, "SID");
            return (Criteria) this;
        }

        public Criteria andSIDLike(String value) {
            addCriterion("SID like", value, "SID");
            return (Criteria) this;
        }

        public Criteria andSIDNotLike(String value) {
            addCriterion("SID not like", value, "SID");
            return (Criteria) this;
        }

        public Criteria andSIDIn(List<String> values) {
            addCriterion("SID in", values, "SID");
            return (Criteria) this;
        }

        public Criteria andSIDNotIn(List<String> values) {
            addCriterion("SID not in", values, "SID");
            return (Criteria) this;
        }

        public Criteria andSIDBetween(String value1, String value2) {
            addCriterion("SID between", value1, value2, "SID");
            return (Criteria) this;
        }

        public Criteria andSIDNotBetween(String value1, String value2) {
            addCriterion("SID not between", value1, value2, "SID");
            return (Criteria) this;
        }

        public Criteria andPWDIsNull() {
            addCriterion("PWD is null");
            return (Criteria) this;
        }

        public Criteria andPWDIsNotNull() {
            addCriterion("PWD is not null");
            return (Criteria) this;
        }

        public Criteria andPWDEqualTo(String value) {
            addCriterion("PWD =", value, "PWD");
            return (Criteria) this;
        }

        public Criteria andPWDNotEqualTo(String value) {
            addCriterion("PWD <>", value, "PWD");
            return (Criteria) this;
        }

        public Criteria andPWDGreaterThan(String value) {
            addCriterion("PWD >", value, "PWD");
            return (Criteria) this;
        }

        public Criteria andPWDGreaterThanOrEqualTo(String value) {
            addCriterion("PWD >=", value, "PWD");
            return (Criteria) this;
        }

        public Criteria andPWDLessThan(String value) {
            addCriterion("PWD <", value, "PWD");
            return (Criteria) this;
        }

        public Criteria andPWDLessThanOrEqualTo(String value) {
            addCriterion("PWD <=", value, "PWD");
            return (Criteria) this;
        }

        public Criteria andPWDLike(String value) {
            addCriterion("PWD like", value, "PWD");
            return (Criteria) this;
        }

        public Criteria andPWDNotLike(String value) {
            addCriterion("PWD not like", value, "PWD");
            return (Criteria) this;
        }

        public Criteria andPWDIn(List<String> values) {
            addCriterion("PWD in", values, "PWD");
            return (Criteria) this;
        }

        public Criteria andPWDNotIn(List<String> values) {
            addCriterion("PWD not in", values, "PWD");
            return (Criteria) this;
        }

        public Criteria andPWDBetween(String value1, String value2) {
            addCriterion("PWD between", value1, value2, "PWD");
            return (Criteria) this;
        }

        public Criteria andPWDNotBetween(String value1, String value2) {
            addCriterion("PWD not between", value1, value2, "PWD");
            return (Criteria) this;
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

        public Criteria andLVLIsNull() {
            addCriterion("LVL is null");
            return (Criteria) this;
        }

        public Criteria andLVLIsNotNull() {
            addCriterion("LVL is not null");
            return (Criteria) this;
        }

        public Criteria andLVLEqualTo(Short value) {
            addCriterion("LVL =", value, "LVL");
            return (Criteria) this;
        }

        public Criteria andLVLNotEqualTo(Short value) {
            addCriterion("LVL <>", value, "LVL");
            return (Criteria) this;
        }

        public Criteria andLVLGreaterThan(Short value) {
            addCriterion("LVL >", value, "LVL");
            return (Criteria) this;
        }

        public Criteria andLVLGreaterThanOrEqualTo(Short value) {
            addCriterion("LVL >=", value, "LVL");
            return (Criteria) this;
        }

        public Criteria andLVLLessThan(Short value) {
            addCriterion("LVL <", value, "LVL");
            return (Criteria) this;
        }

        public Criteria andLVLLessThanOrEqualTo(Short value) {
            addCriterion("LVL <=", value, "LVL");
            return (Criteria) this;
        }

        public Criteria andLVLIn(List<Short> values) {
            addCriterion("LVL in", values, "LVL");
            return (Criteria) this;
        }

        public Criteria andLVLNotIn(List<Short> values) {
            addCriterion("LVL not in", values, "LVL");
            return (Criteria) this;
        }

        public Criteria andLVLBetween(Short value1, Short value2) {
            addCriterion("LVL between", value1, value2, "LVL");
            return (Criteria) this;
        }

        public Criteria andLVLNotBetween(Short value1, Short value2) {
            addCriterion("LVL not between", value1, value2, "LVL");
            return (Criteria) this;
        }

        public Criteria andLOCKINGIsNull() {
            addCriterion("LOCKING is null");
            return (Criteria) this;
        }

        public Criteria andLOCKINGIsNotNull() {
            addCriterion("LOCKING is not null");
            return (Criteria) this;
        }

        public Criteria andLOCKINGEqualTo(Short value) {
            addCriterion("LOCKING =", value, "LOCKING");
            return (Criteria) this;
        }

        public Criteria andLOCKINGNotEqualTo(Short value) {
            addCriterion("LOCKING <>", value, "LOCKING");
            return (Criteria) this;
        }

        public Criteria andLOCKINGGreaterThan(Short value) {
            addCriterion("LOCKING >", value, "LOCKING");
            return (Criteria) this;
        }

        public Criteria andLOCKINGGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCKING >=", value, "LOCKING");
            return (Criteria) this;
        }

        public Criteria andLOCKINGLessThan(Short value) {
            addCriterion("LOCKING <", value, "LOCKING");
            return (Criteria) this;
        }

        public Criteria andLOCKINGLessThanOrEqualTo(Short value) {
            addCriterion("LOCKING <=", value, "LOCKING");
            return (Criteria) this;
        }

        public Criteria andLOCKINGIn(List<Short> values) {
            addCriterion("LOCKING in", values, "LOCKING");
            return (Criteria) this;
        }

        public Criteria andLOCKINGNotIn(List<Short> values) {
            addCriterion("LOCKING not in", values, "LOCKING");
            return (Criteria) this;
        }

        public Criteria andLOCKINGBetween(Short value1, Short value2) {
            addCriterion("LOCKING between", value1, value2, "LOCKING");
            return (Criteria) this;
        }

        public Criteria andLOCKINGNotBetween(Short value1, Short value2) {
            addCriterion("LOCKING not between", value1, value2, "LOCKING");
            return (Criteria) this;
        }

        public Criteria andUPDTIsNull() {
            addCriterion("UPDT is null");
            return (Criteria) this;
        }

        public Criteria andUPDTIsNotNull() {
            addCriterion("UPDT is not null");
            return (Criteria) this;
        }

        public Criteria andUPDTEqualTo(Date value) {
            addCriterionForJDBCDate("UPDT =", value, "UPDT");
            return (Criteria) this;
        }

        public Criteria andUPDTNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDT <>", value, "UPDT");
            return (Criteria) this;
        }

        public Criteria andUPDTGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDT >", value, "UPDT");
            return (Criteria) this;
        }

        public Criteria andUPDTGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDT >=", value, "UPDT");
            return (Criteria) this;
        }

        public Criteria andUPDTLessThan(Date value) {
            addCriterionForJDBCDate("UPDT <", value, "UPDT");
            return (Criteria) this;
        }

        public Criteria andUPDTLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDT <=", value, "UPDT");
            return (Criteria) this;
        }

        public Criteria andUPDTIn(List<Date> values) {
            addCriterionForJDBCDate("UPDT in", values, "UPDT");
            return (Criteria) this;
        }

        public Criteria andUPDTNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDT not in", values, "UPDT");
            return (Criteria) this;
        }

        public Criteria andUPDTBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDT between", value1, value2, "UPDT");
            return (Criteria) this;
        }

        public Criteria andUPDTNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDT not between", value1, value2, "UPDT");
            return (Criteria) this;
        }

        public Criteria andCRDTIsNull() {
            addCriterion("CRDT is null");
            return (Criteria) this;
        }

        public Criteria andCRDTIsNotNull() {
            addCriterion("CRDT is not null");
            return (Criteria) this;
        }

        public Criteria andCRDTEqualTo(Date value) {
            addCriterionForJDBCDate("CRDT =", value, "CRDT");
            return (Criteria) this;
        }

        public Criteria andCRDTNotEqualTo(Date value) {
            addCriterionForJDBCDate("CRDT <>", value, "CRDT");
            return (Criteria) this;
        }

        public Criteria andCRDTGreaterThan(Date value) {
            addCriterionForJDBCDate("CRDT >", value, "CRDT");
            return (Criteria) this;
        }

        public Criteria andCRDTGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CRDT >=", value, "CRDT");
            return (Criteria) this;
        }

        public Criteria andCRDTLessThan(Date value) {
            addCriterionForJDBCDate("CRDT <", value, "CRDT");
            return (Criteria) this;
        }

        public Criteria andCRDTLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CRDT <=", value, "CRDT");
            return (Criteria) this;
        }

        public Criteria andCRDTIn(List<Date> values) {
            addCriterionForJDBCDate("CRDT in", values, "CRDT");
            return (Criteria) this;
        }

        public Criteria andCRDTNotIn(List<Date> values) {
            addCriterionForJDBCDate("CRDT not in", values, "CRDT");
            return (Criteria) this;
        }

        public Criteria andCRDTBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CRDT between", value1, value2, "CRDT");
            return (Criteria) this;
        }

        public Criteria andCRDTNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CRDT not between", value1, value2, "CRDT");
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