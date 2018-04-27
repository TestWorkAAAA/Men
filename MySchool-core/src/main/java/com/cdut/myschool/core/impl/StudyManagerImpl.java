package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.StudyDto;
import com.cdut.myschool.core.manager.StudyManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.Study;
import com.cdut.myschool.persist.entity.StudyExample;
import com.cdut.myschool.persist.mapper.StudyMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StudyManagerImpl implements StudyManager {

    @Autowired
    StudyMapper mapper;

    @Override
    public List<StudyDto> queryByParams(Map<String, Object> params) {
        StudyExample example = new StudyExample();
        StudyExample.Criteria criteria = example.createCriteria();
        if (params != null && params.size() != 0) {
            if (params.get(KEY_NAME) != null) {
                criteria.andNameEqualTo(params.get(KEY_NAME).toString());
            }
            if (params.get(KEY_ID) != null) {
                criteria.andIdEqualTo(params.get(KEY_ID).toString());
            }
            if (params.get(KEY_TYPE) != null) {
                criteria.andTypeEqualTo((Integer) params.get(KEY_TYPE));
            }
            if (params.get(KEY_END_TIME) != null) {
                criteria.andCreateTimeLessThan((Date) params.get(KEY_END_TIME));
            }
            List<Study> temp = mapper.selectByExample(example);
            List<StudyDto> result = new ArrayList<>(temp.size());
            for (Study entity : temp) {
                StudyDto dto = new StudyDto();
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
    public int insertSelective(StudyDto dto) {
        return 0;
    }

    @Override
    public StudyDto getByPrimaryKey(String id) {
        Study study = mapper.selectByPrimaryKey(id);
        StudyDto dto = new StudyDto();
        BeanUtils.copyProperties(study, dto);
        return dto;
    }

    @Override
    public int insertOneRecord(StudyDto dto) {
        Study study = new Study();
        BeanUtils.copyProperties(dto, study);
        study.setId(UID.next());
        return mapper.insert(study);
    }

    @Override
    public int updateRecordById(StudyDto dto) {
        Study study = new Study();
        BeanUtils.copyProperties(dto, study);
        return mapper.updateByPrimaryKey(study);
    }
}
