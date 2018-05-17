package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.RoastDto;
import com.cdut.myschool.core.manager.RoastManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.Roast;
import com.cdut.myschool.persist.entity.RoastExample;
import com.cdut.myschool.persist.mapper.RoastMapper;
import com.cdut.myschool.persist.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public class RoastManagerImpl implements RoastManager {

    @Autowired
    RoastMapper mapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<RoastDto> queryByParams(Map<String, Object> params) {
        checkNotNull(params);
        RoastExample example = new RoastExample();
        RoastExample.Criteria criteria = example.createCriteria();
        if (params.get(KEY_ID) != null) {
            criteria.andIdEqualTo(params.get(KEY_ID).toString());
        }
        if (params.get(KEY_USER_ID) != null) {
            criteria.andUserIdEqualTo(params.get(KEY_USER_ID).toString());
        }
        List<Roast> temp = mapper.selectByExample(example);
        List<RoastDto> result = new ArrayList<>(temp.size());
        for (Roast entity : temp) {
            RoastDto dto = new RoastDto();
            BeanUtils.copyProperties(entity, dto);
            dto.setUserName(userInfoMapper
                    .selectByPrimaryKey(entity.getUserId()).getUserName());
            result.add(dto);
        }
        return result;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        checkNotNull(id);
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(RoastDto dto) {
        Roast roast = new Roast();
        BeanUtils.copyProperties(dto, roast);
        roast.setId(UID.next());
        return mapper.insertSelective(roast);
    }

    @Override
    public RoastDto getByPrimaryKey(String id) {
        RoastDto dto = new RoastDto();
        Roast roast = mapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(roast, dto);
        dto.setUserName(userInfoMapper
                .selectByPrimaryKey(roast.getUserId()).getUserName());
        return dto;
    }

    @Override
    public int insertOneRecord(RoastDto dto) {
        Roast roast = new Roast();
        BeanUtils.copyProperties(dto, roast);
        roast.setId(UID.next());
        return mapper.insert(roast);
    }

    @Override
    public int updateRecordById(RoastDto dto) {
        Roast roast = new Roast();
        BeanUtils.copyProperties(dto, roast);
        return mapper.updateByPrimaryKey(roast);
    }
}
