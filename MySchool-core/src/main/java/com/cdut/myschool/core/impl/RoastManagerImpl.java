package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.RoastDto;
import com.cdut.myschool.core.manager.RoastManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.Roast;
import com.cdut.myschool.persist.entity.RoastExample;
import com.cdut.myschool.persist.mapper.RoastMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RoastManagerImpl implements RoastManager {

    @Autowired
    RoastMapper mapper;

    @Override
    public List<RoastDto> queryByParams(Map<String, Object> params) {
        RoastExample example = new RoastExample();
        RoastExample.Criteria criteria = example.createCriteria();
        if (params != null && params.size() != 0) {
            if (params.get(KEY_COGNATEID) != null) {
                criteria.andCognateIdEqualTo(params.get(KEY_COGNATEID).toString());
            }
            if (params.get(KEY_ID) != null) {
                criteria.andIdEqualTo(params.get(KEY_ID).toString());
            }
            if (params.get(KEY_CONTEXT) != null) {
                criteria.andContextEqualTo((String) params.get(KEY_CONTEXT));
            }
            if (params.get(KEY_TOPIC_ID) != null) {
                criteria.andTopicIdEqualTo((String) params.get(KEY_TOPIC_ID));
            }
            if (params.get(KEY_TYPE) != null) {
                criteria.andTypeEqualTo((Integer) params.get(KEY_TYPE));
            }
            if (params.get(KEY_TIME) != null) {
                if (params.get(KEY_TIME) instanceof Date) {
                    criteria.andTimeGreaterThan((Date) params.get(KEY_TIME));
                } else {
                    throw new IllegalArgumentException("Time value must to java.util.Date");
                }
            }
            List<Roast> temp = mapper.selectByExample(example);
            List<RoastDto> result = new ArrayList<>(temp.size());
            for (Roast entity : temp) {
                RoastDto dto = new RoastDto();
                BeanUtils.copyProperties(entity, dto);
                result.add(dto);
            }
            return result;
        }
        return null;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(RoastDto dto) {
        return 0;
    }

    @Override
    public RoastDto getByPrimaryKey(String id) {
        return null;
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
        return 0;
    }
}
