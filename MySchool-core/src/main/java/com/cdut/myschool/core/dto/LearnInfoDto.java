package com.cdut.myschool.core.dto;

public class LearnInfoDto {
    private String id;

    private String userId;

    private String typeId;

    private String name;

    private String url;

    public LearnInfoDto() {
    }

    public LearnInfoDto(String id, String userId, String typeId, String name, String url) {
        this.id = id;
        this.userId = userId;
        this.typeId = typeId;
        this.name = name;
        this.url = url;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
