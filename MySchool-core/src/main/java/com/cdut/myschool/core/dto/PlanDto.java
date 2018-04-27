package com.cdut.myschool.core.dto;

import java.util.Date;

public class PlanDto {
    private String id;

    private String userId;

    private String planName;

    private String planType;

    private long time;

    private Date deadTime;

    public PlanDto() {
    }

    public PlanDto(String id, String userId, String planName, String planType, long time, Date deadTime) {
        this.id = id;
        this.userId = userId;
        this.planName = planName;
        this.planType = planType;
        this.time = time;
        this.deadTime = deadTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Date getDeadTime() {
        return deadTime;
    }

    public void setDeadTime(Date deadTime) {
        this.deadTime = deadTime;
    }
}
