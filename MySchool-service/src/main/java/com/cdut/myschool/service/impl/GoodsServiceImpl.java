package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.GoodsDto;
import com.cdut.myschool.core.dto.OrderDto;
import com.cdut.myschool.core.manager.GoodsManager;
import com.cdut.myschool.core.manager.OrderManager;
import com.cdut.myschool.persist.entity.Order;
import com.cdut.myschool.persist.mapper.GoodsMapper;
import com.cdut.myschool.service.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsManager manager;

    @Autowired
    OrderManager orderManager;

    @Override
    public boolean buyOneGood(String id, String userId) {
        GoodsDto dto = manager.getByPrimaryKey(id);
        OrderDto orderDto = new OrderDto();
        synchronized (GoodsServiceImpl.class) {
            if (dto.getStatus() == GoodsManager.STATUS_BUYED) {
                return false;
            }

            dto.setStatus(GoodsManager.STATUS_BUYED);
            manager.updateRecordById(dto);
        }

        orderDto.setGoodsName(dto.getName());
        orderDto.setBuyerId(userId);
        orderDto.setSellerId(dto.getUserId());
        orderDto.setGoodId(dto.getId());
        orderDto.setStatus(OrderManager.STATUS_BUYED);
        orderManager.insertOneRecord(orderDto);


        return true;
    }

    @Override
    public int addOne(GoodsDto dto) {
        dto.setStatus(GoodsManager.STATUS_NORMAL);
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOne(String id) {
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(GoodsDto dto) {
        return manager.updateRecordById(dto);
    }

    @Override
    public List<GoodsDto> queryByParams(Map<String, Object> params) {
        return manager.queryByParams(params);
    }
}
