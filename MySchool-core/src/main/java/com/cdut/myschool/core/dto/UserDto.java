package com.cdut.myschool.core.dto;

public class UserDto {

    private String id;

    private String userName;

    private String headPicUrl;

    private int coin;

    public UserDto(String id, String userName, String headPicUrl, int coin) {
        this.id = id;
        this.userName = userName;
        this.headPicUrl = headPicUrl;
        this.coin = coin;
    }

    public UserDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
