package com.cdut.myschool.core.manager;

import com.cdut.myschool.core.dto.OrderDto;

public interface OrderManager extends BaseManager<OrderDto> {
    String KEY_ID = "id";
    String KEY_SELLER_ID = "seller_id";
    String KEY_BUYER_ID = "buyer_id";
    String KEY_STATUS = "status";

    int STATUS_NORMAL = 0x00;
    int STATUS_BUYED = 0x10;
    int STATUS_USER_CANCELED = 0x21;
    int STATUS_SELLER_CANCELED = 0x32;

    int STATUS_SELLER_FINISH = 0x31;
    int STATUS_USER_FINISH = 0x32;

    int STATUS_FINISH = 0x40;
}
