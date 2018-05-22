package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.GoodsDto;
import com.cdut.myschool.core.dto.OrderDto;
import com.cdut.myschool.core.manager.GoodsManager;
import com.cdut.myschool.core.manager.OrderManager;
import com.cdut.myschool.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderManager manager;

    @Autowired
    GoodsManager goodsManager;

    @Override
    public boolean cancelOneOrder(String id, String userId) {
        OrderDto dto = manager.getByPrimaryKey(id);
        if (userId.equals(dto.getBuyerId())) {
            dto.setStatus(OrderManager.STATUS_USER_CANCELED);
        } else if (userId.equals(dto.getSellerId())) {
            dto.setStatus(OrderManager.STATUS_SELLER_CANCELED);
        } else {
            return false;
        }

        manager.updateRecordById(dto);

        GoodsDto dto1 =  goodsManager.getByPrimaryKey(dto.getGoodId());
        dto1.setStatus(GoodsManager.STATUS_NORMAL);
        goodsManager.updateRecordById(dto1);
        return true;
    }

    @Override
    public boolean finishOrder(String id, String userId) {
        OrderDto dto = manager.getByPrimaryKey(id);
        if (dto.getStatus() == OrderManager.STATUS_USER_FINISH) {
            if (userId.equals(dto.getSellerId())) {
                dto.setStatus(OrderManager.STATUS_FINISH);
            }
        } else if (dto.getStatus() == OrderManager.STATUS_SELLER_FINISH) {
            if (userId.equals(dto.getBuyerId())) {
                dto.setStatus(OrderManager.STATUS_FINISH);
            }
        } else {
            if (userId.equals(dto.getBuyerId())) {
                dto.setStatus(OrderManager.STATUS_USER_FINISH);
            } else if (userId.equals(dto.getSellerId())) {
                dto.setStatus(OrderManager.STATUS_SELLER_FINISH);
            }
        }

        manager.updateRecordById(dto);
        return true;
    }

    @Override
    public int addOne(OrderDto dto) {
        return 0;
    }

    @Override
    public int removeOne(String id) {
        return 0;
    }

    @Override
    public int updateOne(OrderDto dto) {
        return 0;
    }

    @Override
    public List<OrderDto> queryByParams(Map<String, Object> params) {
        return manager.queryByParams(params);
    }
}
