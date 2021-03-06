package com.group.music.qymusic.pojo;

import java.util.ArrayList;
import java.util.List;

public class MusicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MusicExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andSingerIdIsNull() {
            addCriterion("singer_id is null");
            return (Criteria) this;
        }

        public Criteria andSingerIdIsNotNull() {
            addCriterion("singer_id is not null");
            return (Criteria) this;
        }

        public Criteria andSingerIdEqualTo(Integer value) {
            addCriterion("singer_id =", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdNotEqualTo(Integer value) {
            addCriterion("singer_id <>", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdGreaterThan(Integer value) {
            addCriterion("singer_id >", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("singer_id >=", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdLessThan(Integer value) {
            addCriterion("singer_id <", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdLessThanOrEqualTo(Integer value) {
            addCriterion("singer_id <=", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdIn(List<Integer> values) {
            addCriterion("singer_id in", values, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdNotIn(List<Integer> values) {
            addCriterion("singer_id not in", values, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdBetween(Integer value1, Integer value2) {
            addCriterion("singer_id between", value1, value2, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("singer_id not between", value1, value2, "singerId");
            return (Criteria) this;
        }

        public Criteria andSlbumUdIsNull() {
            addCriterion("slbum_ud is null");
            return (Criteria) this;
        }

        public Criteria andSlbumUdIsNotNull() {
            addCriterion("slbum_ud is not null");
            return (Criteria) this;
        }

        public Criteria andSlbumUdEqualTo(Integer value) {
            addCriterion("slbum_ud =", value, "slbumUd");
            return (Criteria) this;
        }

        public Criteria andSlbumUdNotEqualTo(Integer value) {
            addCriterion("slbum_ud <>", value, "slbumUd");
            return (Criteria) this;
        }

        public Criteria andSlbumUdGreaterThan(Integer value) {
            addCriterion("slbum_ud >", value, "slbumUd");
            return (Criteria) this;
        }

        public Criteria andSlbumUdGreaterThanOrEqualTo(Integer value) {
            addCriterion("slbum_ud >=", value, "slbumUd");
            return (Criteria) this;
        }

        public Criteria andSlbumUdLessThan(Integer value) {
            addCriterion("slbum_ud <", value, "slbumUd");
            return (Criteria) this;
        }

        public Criteria andSlbumUdLessThanOrEqualTo(Integer value) {
            addCriterion("slbum_ud <=", value, "slbumUd");
            return (Criteria) this;
        }

        public Criteria andSlbumUdIn(List<Integer> values) {
            addCriterion("slbum_ud in", values, "slbumUd");
            return (Criteria) this;
        }

        public Criteria andSlbumUdNotIn(List<Integer> values) {
            addCriterion("slbum_ud not in", values, "slbumUd");
            return (Criteria) this;
        }

        public Criteria andSlbumUdBetween(Integer value1, Integer value2) {
            addCriterion("slbum_ud between", value1, value2, "slbumUd");
            return (Criteria) this;
        }

        public Criteria andSlbumUdNotBetween(Integer value1, Integer value2) {
            addCriterion("slbum_ud not between", value1, value2, "slbumUd");
            return (Criteria) this;
        }

        public Criteria andClickvolumeIsNull() {
            addCriterion("clickvolume is null");
            return (Criteria) this;
        }

        public Criteria andClickvolumeIsNotNull() {
            addCriterion("clickvolume is not null");
            return (Criteria) this;
        }

        public Criteria andClickvolumeEqualTo(Integer value) {
            addCriterion("clickvolume =", value, "clickvolume");
            return (Criteria) this;
        }

        public Criteria andClickvolumeNotEqualTo(Integer value) {
            addCriterion("clickvolume <>", value, "clickvolume");
            return (Criteria) this;
        }

        public Criteria andClickvolumeGreaterThan(Integer value) {
            addCriterion("clickvolume >", value, "clickvolume");
            return (Criteria) this;
        }

        public Criteria andClickvolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("clickvolume >=", value, "clickvolume");
            return (Criteria) this;
        }

        public Criteria andClickvolumeLessThan(Integer value) {
            addCriterion("clickvolume <", value, "clickvolume");
            return (Criteria) this;
        }

        public Criteria andClickvolumeLessThanOrEqualTo(Integer value) {
            addCriterion("clickvolume <=", value, "clickvolume");
            return (Criteria) this;
        }

        public Criteria andClickvolumeIn(List<Integer> values) {
            addCriterion("clickvolume in", values, "clickvolume");
            return (Criteria) this;
        }

        public Criteria andClickvolumeNotIn(List<Integer> values) {
            addCriterion("clickvolume not in", values, "clickvolume");
            return (Criteria) this;
        }

        public Criteria andClickvolumeBetween(Integer value1, Integer value2) {
            addCriterion("clickvolume between", value1, value2, "clickvolume");
            return (Criteria) this;
        }

        public Criteria andClickvolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("clickvolume not between", value1, value2, "clickvolume");
            return (Criteria) this;
        }

        public Criteria andLyricIsNull() {
            addCriterion("lyric is null");
            return (Criteria) this;
        }

        public Criteria andLyricIsNotNull() {
            addCriterion("lyric is not null");
            return (Criteria) this;
        }

        public Criteria andLyricEqualTo(String value) {
            addCriterion("lyric =", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotEqualTo(String value) {
            addCriterion("lyric <>", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricGreaterThan(String value) {
            addCriterion("lyric >", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricGreaterThanOrEqualTo(String value) {
            addCriterion("lyric >=", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLessThan(String value) {
            addCriterion("lyric <", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLessThanOrEqualTo(String value) {
            addCriterion("lyric <=", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLike(String value) {
            addCriterion("lyric like", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotLike(String value) {
            addCriterion("lyric not like", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricIn(List<String> values) {
            addCriterion("lyric in", values, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotIn(List<String> values) {
            addCriterion("lyric not in", values, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricBetween(String value1, String value2) {
            addCriterion("lyric between", value1, value2, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotBetween(String value1, String value2) {
            addCriterion("lyric not between", value1, value2, "lyric");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(String value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("duration like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("duration not like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<String> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<String> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andMusicpicIsNull() {
            addCriterion("musicpic is null");
            return (Criteria) this;
        }

        public Criteria andMusicpicIsNotNull() {
            addCriterion("musicpic is not null");
            return (Criteria) this;
        }

        public Criteria andMusicpicEqualTo(String value) {
            addCriterion("musicpic =", value, "musicpic");
            return (Criteria) this;
        }

        public Criteria andMusicpicNotEqualTo(String value) {
            addCriterion("musicpic <>", value, "musicpic");
            return (Criteria) this;
        }

        public Criteria andMusicpicGreaterThan(String value) {
            addCriterion("musicpic >", value, "musicpic");
            return (Criteria) this;
        }

        public Criteria andMusicpicGreaterThanOrEqualTo(String value) {
            addCriterion("musicpic >=", value, "musicpic");
            return (Criteria) this;
        }

        public Criteria andMusicpicLessThan(String value) {
            addCriterion("musicpic <", value, "musicpic");
            return (Criteria) this;
        }

        public Criteria andMusicpicLessThanOrEqualTo(String value) {
            addCriterion("musicpic <=", value, "musicpic");
            return (Criteria) this;
        }

        public Criteria andMusicpicLike(String value) {
            addCriterion("musicpic like", value, "musicpic");
            return (Criteria) this;
        }

        public Criteria andMusicpicNotLike(String value) {
            addCriterion("musicpic not like", value, "musicpic");
            return (Criteria) this;
        }

        public Criteria andMusicpicIn(List<String> values) {
            addCriterion("musicpic in", values, "musicpic");
            return (Criteria) this;
        }

        public Criteria andMusicpicNotIn(List<String> values) {
            addCriterion("musicpic not in", values, "musicpic");
            return (Criteria) this;
        }

        public Criteria andMusicpicBetween(String value1, String value2) {
            addCriterion("musicpic between", value1, value2, "musicpic");
            return (Criteria) this;
        }

        public Criteria andMusicpicNotBetween(String value1, String value2) {
            addCriterion("musicpic not between", value1, value2, "musicpic");
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