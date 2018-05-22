package com.cdut.myschool.core.manager;

import com.cdut.myschool.core.dto.GoodsDto;

public interface GoodsManager extends BaseManager<GoodsDto> {

    String KEY_ID = "id";
    String KEY_NAME = "name";
    String KEY_USER_ID = "user_id";
    String KEY_HIGH_PRICE = "high_price";
    String KEY_LOW_PRICE = "low_price";
    String KEY_STATUS = "status";

    int STATUS_BUYED = 0x10;
    int STATUS_CANELED = 0x11;
    int STATUS_NORMAL = 0x00;
}
