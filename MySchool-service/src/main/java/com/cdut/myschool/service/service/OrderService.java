package com.cdut.myschool.service.service;

import com.cdut.myschool.core.dto.OrderDto;

public interface OrderService extends BaseService<OrderDto> {

    boolean cancelOneOrder(String id, String userId);

    boolean finishOrder (String id, String userId);
}
