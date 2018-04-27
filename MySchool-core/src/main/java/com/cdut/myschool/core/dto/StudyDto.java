package com.cdut.myschool.core.dto;

import java.util.Date;

public class StudyDto {

    private String id;

    private String name;

    private int type;

    private Date createTime;

    private Date endTime;

    public StudyDto() {
    }

    public StudyDto(String id, String name, int type, Date createTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createTime = createTime;
        this.endTime = endTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
