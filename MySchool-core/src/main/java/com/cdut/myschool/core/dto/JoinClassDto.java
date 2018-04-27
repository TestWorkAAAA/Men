package com.cdut.myschool.core.dto;

import java.util.Date;

public class JoinClassDto {
    String id;

    String studyId;

    String userId;

    Date time;

    public JoinClassDto(){};

    public JoinClassDto(String id, String studyId, String userId, Date time) {
        this.id = id;
        this.studyId = studyId;
        this.userId = userId;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
