package com.cdut.myschool.core.dto;

import java.util.Date;

public class RoastDto {
    private String id;

    private String topicId;

    private String context;

    private int type;

    private String cognateId;

    private Date time;

    public RoastDto() {
    }

    public RoastDto(String id, String topicId, String context, int type, String cognateId, Date time) {
        this.id = id;
        this.topicId = topicId;
        this.context = context;
        this.type = type;
        this.cognateId = cognateId;
        this.time = time;
    }

    public String getCognateId() {
        return cognateId;
    }

    public void setCognateId(String cognateId) {
        this.cognateId = cognateId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
