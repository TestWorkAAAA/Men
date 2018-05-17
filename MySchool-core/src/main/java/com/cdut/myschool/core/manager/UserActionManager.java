package com.cdut.myschool.core.manager;

import com.cdut.myschool.core.dto.UserActionDto;

public interface UserActionManager extends BaseManager<UserActionDto> {
    String KEY_ID = "id";
    String KEY_USER_ID = "userId";
    String KEY_TYPE = "type";

    int TYPE_BUY = 0x10;
    int TYPE_SELL = 0x11;
    int TYPE_COLLECTION = 0x12;
}
