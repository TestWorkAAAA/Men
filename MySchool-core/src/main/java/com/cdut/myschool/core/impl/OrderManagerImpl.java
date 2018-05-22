package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.OrderDto;
import com.cdut.myschool.core.manager.OrderManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.Order;
import com.cdut.myschool.persist.entity.OrderExample;
import com.cdut.myschool.persist.mapper.GoodsMapper;
import com.cdut.myschool.persist.mapper.OrderMapper;
import com.cdut.myschool.persist.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderManagerImpl implements OrderManager {

    @Autowired
    OrderMapper mapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<OrderDto> queryByParams(Map<String, Object> params) {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        if (params.get(KEY_ID) != null) {
            criteria.andIdEqualTo(params.get(KEY_ID).toString());
        }
        if (params.get(KEY_BUYER_ID) != null) {
            criteria.andBuyerIdEqualTo(params.get(KEY_BUYER_ID).toString());
        }
        if (params.get(KEY_SELLER_ID) != null) {
            criteria.andSellerIdEqualTo(params.get(KEY_SELLER_ID).toString());
        }
        if (params.get(KEY_STATUS) != null) {
            criteria.andStatusEqualTo(Integer.parseInt(params.get(KEY_STATUS).toString()));
        }
        List<Order> temp = mapper.selectByExample(example);
        List<OrderDto> result = new ArrayList<>(temp.size());

        for (int i = 0; i < temp.size(); i++) {
            Order entity = temp.get(i);
            OrderDto dto = new OrderDto();
            BeanUtils.copyProperties(entity, dto);

            dto.setBuyerName(userInfoMapper.selectByPrimaryKey(entity.getBuyerId()).getUserName());
            dto.setSellerName(userInfoMapper.selectByPrimaryKey(entity.getSellerId()).getUserName());
            dto.setGoodsName(goodsMapper.selectByPrimaryKey(entity.getGoodId()).getName());

            result.add(dto);
        }

        return result;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insertSelective(OrderDto dto) {
        return 0;
    }

    @Override
    public OrderDto getByPrimaryKey(String id) {
        Order goods = mapper.selectByPrimaryKey(id);
        OrderDto dto = new OrderDto();
        BeanUtils.copyProperties(goods,dto);

        dto.setBuyerName(userInfoMapper.selectByPrimaryKey(dto.getBuyerId()).getUserName());
        dto.setSellerName(userInfoMapper.selectByPrimaryKey(dto.getSellerId()).getUserName());
        dto.setGoodsName(goodsMapper.selectByPrimaryKey(dto.getGoodId()).getName());

        return dto;
    }

    @Override
    public int insertOneRecord(OrderDto dto) {
        Order goods = new Order();
        BeanUtils.copyProperties(dto,goods);
        goods.setId(UID.next());

        return mapper.insert(goods);
    }

    @Override
    public int updateRecordById(OrderDto dto) {
        Order goods = new Order();
        BeanUtils.copyProperties(dto,goods);

        return mapper.updateByPrimaryKey(goods);
    }
}
