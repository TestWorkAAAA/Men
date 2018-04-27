package com.cdut.myschool.core.manager;

import com.cdut.myschool.core.dto.UserDto;

public interface UserManager extends BaseManager<UserDto> {
    String KEY_ID = "id";
    String KEY_USER_NAME = "name";
    String KEY_HEAD_PIC_URL = "url";
    String KEY_COIN = "coin";

    public int updateCoinById(String id, int coin);
}
