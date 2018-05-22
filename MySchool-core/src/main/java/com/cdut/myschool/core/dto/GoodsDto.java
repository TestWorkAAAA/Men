package com.cdut.myschool.core.dto;

import java.math.BigDecimal;

public class GoodsDto {

    private String id;

    private String tipId;

    private BigDecimal price;

    private String location;

    private String userId;

    private String name;

    private String introduce;

    private String userName;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public GoodsDto() {
    }

    public GoodsDto(String id, String tipId, BigDecimal price, String location, String userId, String name, String introduce, String userName, Integer status) {
        this.id = id;
        this.tipId = tipId;
        this.price = price;
        this.location = location;
        this.userId = userId;
        this.name = name;
        this.introduce = introduce;
        this.userName = userName;
        this.status = status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTipId() {
        return tipId;
    }

    public void setTipId(String tipId) {
        this.tipId = tipId == null ? null : tipId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}