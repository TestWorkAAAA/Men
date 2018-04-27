package com.cdut.myschool.core.dto;

import java.util.Date;
import java.util.List;

public class ZoneDto {
    private String id;

    private String userId;

    private String location;

    private String mind;

    private String context;

    private List<String> picUrls;

    private Date dateTime;

    public ZoneDto(String id, String userId, String location, String mind, String context, List<String> picUrls, Date dateTime) {
        this.id = id;
        this.userId = userId;
        this.location = location;
        this.mind = mind;
        this.context = context;
        this.picUrls = picUrls;
        this.dateTime = dateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ZoneDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMind() {
        return mind;
    }

    public void setMind(String mind) {
        this.mind = mind;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
