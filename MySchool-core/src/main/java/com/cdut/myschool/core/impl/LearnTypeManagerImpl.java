package com.cdut.myschool.core.impl;


import com.cdut.myschool.core.dto.LearnTypeDto;
import com.cdut.myschool.core.manager.LearnTypeManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.LearnType;
import com.cdut.myschool.persist.entity.LearnTypeExample;
import com.cdut.myschool.persist.mapper.LearnTypeMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LearnTypeManagerImpl implements LearnTypeManager {

    @Autowired
    LearnTypeMapper mapper;

    @Override
    public List<LearnTypeDto> queryByParams(Map<String, Object> params) {
        LearnTypeExample example = new LearnTypeExample();
        LearnTypeExample.Criteria criteria = example.createCriteria();
        if (params != null && params.size() != 0) {
            if (params.get(KEY_USER_ID) != null) {
                criteria.andUserIdEqualTo(params.get(KEY_USER_ID).toString());
            } else {
                throw new IllegalArgumentException("Null User ID");
            }
            if (params.get(KEY_NAME) != null) {
                criteria.andNameEqualTo(params.get(KEY_NAME).toString());
            }
            if (params.get(KEY_PARENT) != null) {
                criteria.andParentEqualTo(params.get(KEY_PARENT).toString());
            }
            if (params.get(KEY_ID) != null) {
                criteria.andIdEqualTo(params.get(KEY_ID).toString());
            }
            List<LearnType> temp = mapper.selectByExample(example);
            List<LearnTypeDto> result = new ArrayList<>(temp.size());
            for (LearnType entity : temp) {
                LearnTypeDto dto = new LearnTypeDto();
                BeanUtils.copyProperties(entity, dto);
                result.add(dto);
            }
            return result;
        } else {
            throw new IllegalArgumentException("Null User ID");
        }
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(LearnTypeDto dto) {
        return 0;
    }

    @Override
    public LearnTypeDto getByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int insertOneRecord(LearnTypeDto dto) {
        LearnType temp = new LearnType();
        BeanUtils.copyProperties(dto, temp);
        temp.setId(UID.next());
        return mapper.insert(temp);
    }

    @Override
    public int updateRecordById(LearnTypeDto dto) {
        return 0;
    }
}
