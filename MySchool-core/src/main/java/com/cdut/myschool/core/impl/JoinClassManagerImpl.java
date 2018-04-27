package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.JoinClassDto;
import com.cdut.myschool.core.manager.JoinClassManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.JoinClass;
import com.cdut.myschool.persist.entity.JoinClassExample;
import com.cdut.myschool.persist.mapper.JoinClassMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JoinClassManagerImpl implements JoinClassManager {

    @Autowired
    private JoinClassMapper mapper;

    @Override
    public List<JoinClassDto> queryByParams( Map<String, Object> params) {
        JoinClassExample example = new JoinClassExample();
        JoinClassExample.Criteria criteria = example.createCriteria();
        if (params != null && params.size() != 0) {
            if (params.containsKey(KEY_USER_ID) && params.get(KEY_USER_ID) != null) {
                criteria.andUserIdEqualTo(params.get(KEY_USER_ID).toString());
            }
            if (params.containsKey(KEY_CLASS_ID) && params.get(KEY_CLASS_ID) != null) {
                criteria.andStudyIdEqualTo(params.get(KEY_CLASS_ID).toString());
            }
            List<JoinClass> temp = mapper.selectByExample(example);
            List<JoinClassDto> result = new ArrayList<>(temp.size());
            for (JoinClass entity : temp) {
                JoinClassDto dto = new JoinClassDto();
                BeanUtils.copyProperties(entity,dto);
                result.add(dto);
            }
            return result;
        }
        return null;
    }

    @Override
    @Deprecated
    public int deleteByPrimaryKey(String id) {
        throw new IllegalArgumentException("this method can't be used, Please use deleteByKeys");
    }

    @Override
    public int insertSelective(JoinClassDto dto) {
        JoinClass temp = new JoinClass();
        BeanUtils.copyProperties(dto,temp);
        return mapper.insert(temp);
    }

    @Override
    public JoinClassDto getByPrimaryKey(String id) {
        JoinClassDto dto = new JoinClassDto();
        BeanUtils.copyProperties(mapper.selectByPrimaryKey(id),dto);
        return dto;
    }

    @Override
    public int insertOneRecord(JoinClassDto dto) {
        JoinClass temp = new JoinClass();
        BeanUtils.copyProperties(dto, temp);
        temp.setId(UID.next());
        return mapper.insert(temp);
    }

    @Override
    public int updateRecordById(JoinClassDto dto) {
        return 0;
    }
}
