package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.ComplanDto;
import com.cdut.myschool.core.manager.ComplanManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.Complan;
import com.cdut.myschool.persist.entity.ComplanExample;
import com.cdut.myschool.persist.mapper.ComplanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public class ComplanManagerImpl implements ComplanManager {

    @Autowired
    ComplanMapper mapper;

    @Override
    public List<ComplanDto> queryByParams(Map<String, Object> params) {
        checkNotNull(params);
        ComplanExample example = new ComplanExample();
        ComplanExample.Criteria criteria = example.createCriteria();
        if (params.get(KEY_ID) != null) {
            criteria.andIdEqualTo(params.get(KEY_ID).toString());
        }
        if (params.get(KEY_TARGET_ID) != null) {
            criteria.andTargetIdEqualTo(params.get(KEY_TARGET_ID).toString());
        }
        if (params.get(KEY_USER_ID) != null) {
            criteria.andUserIdEqualTo(params.get(KEY_USER_ID).toString());
        }
        List<Complan> temp = mapper.selectByExample(example);
        List<ComplanDto> result = new ArrayList<>(temp.size());
        for (Complan entity : temp) {
            ComplanDto dto = new ComplanDto();
            BeanUtils.copyProperties(entity, dto);
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
    public int insertSelective(ComplanDto dto) {
        checkNotNull(dto);
        Complan complan = new Complan();
        BeanUtils.copyProperties(dto,complan);
        complan.setId(UID.next());
        return mapper.insertSelective(complan);
    }

    @Override
    public ComplanDto getByPrimaryKey(String id) {
        checkNotNull(id);
        ComplanDto dto = new ComplanDto();
        Complan complan = mapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(complan,dto);
        return dto;
    }

    @Override
    public int insertOneRecord(ComplanDto dto) {
        checkNotNull(dto);
        Complan complan = new Complan();
        BeanUtils.copyProperties(dto,complan);
        complan.setId(UID.next());
        return mapper.insert(complan);
    }

    @Override
    public int updateRecordById(ComplanDto dto) {
        checkNotNull(dto);
        Complan complan = new Complan();
        BeanUtils.copyProperties(dto,complan);
        return mapper.updateByPrimaryKey(complan);
    }
}
