package com.cdut.myschool.core.dto;

public class LearnTypeDto {
    private String id;

    private String parent;

    private String userId;

    private String name;

    public LearnTypeDto() {
    }

    public LearnTypeDto(String id, String parent, String userId, String name) {
        this.id = id;
        this.parent = parent;
        this.userId = userId;
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
