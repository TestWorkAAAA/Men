package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.GoodsDto;
import com.cdut.myschool.core.manager.GoodsManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.Goods;
import com.cdut.myschool.persist.entity.GoodsExample;
import com.cdut.myschool.persist.mapper.GoodsMapper;
import com.cdut.myschool.persist.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodManagerImpl implements GoodsManager {

    @Autowired
    GoodsMapper mapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<GoodsDto> queryByParams(Map<String, Object> params) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        if (params.get(KEY_ID) != null) {
            criteria.andIdEqualTo(params.get(KEY_ID).toString());
        }
        if (params.get(KEY_USER_ID) != null) {
            criteria.andUserIdEqualTo(params.get(KEY_USER_ID).toString());
        }
        if (params.get(KEY_HIGH_PRICE) != null) {
            criteria.andPriceLessThanOrEqualTo(new BigDecimal(params.get(KEY_HIGH_PRICE).toString()));
        }
        if (params.get(KEY_LOW_PRICE) != null) {
            criteria.andPriceGreaterThanOrEqualTo(new BigDecimal(params.get(KEY_LOW_PRICE).toString()));
        }
        if (params.get(KEY_STATUS) != null) {
            criteria.andStatusEqualTo(Integer.parseInt(params.get(KEY_STATUS).toString()));
        }
        if (params.get(KEY_NAME) != null) {
            criteria.andNameLike(params.get(KEY_NAME).toString());
        }
        List<Goods> temp = mapper.selectByExample(example);
        List<GoodsDto> result = new ArrayList<>(temp.size());

        for (int i = 0; i < temp.size(); i++) {
            Goods entity = temp.get(i);
            GoodsDto dto = new GoodsDto();
            BeanUtils.copyProperties(entity, dto);
            dto.setUserName(userInfoMapper.selectByPrimaryKey(entity.getUserId()).getUserName());
            result.add(dto);
        }

        return result;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(GoodsDto dto) {
        return 0;
    }

    @Override
    public GoodsDto getByPrimaryKey(String id) {
        Goods goods = mapper.selectByPrimaryKey(id);
        GoodsDto dto = new GoodsDto();
        BeanUtils.copyProperties(goods,dto);
        dto.setUserName(userInfoMapper.selectByPrimaryKey(dto.getUserId()).getUserName());
        return dto;
    }

    @Override
    public int insertOneRecord(GoodsDto dto) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(dto, goods);
        goods.setId(UID.next());
        return mapper.insert(goods);
    }

    @Override
    public int updateRecordById(GoodsDto dto) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(dto, goods);
        return mapper.updateByPrimaryKey(goods);
    }
}
