package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.StudyDto;
import com.cdut.myschool.core.manager.StudyManager;
import com.cdut.myschool.service.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    StudyManager manager;

    @Override
    public int addOne(StudyDto dto) {
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOne(String id) {
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(StudyDto dto) {
        return manager.updateRecordById(dto);
    }

    @Override
    public List<StudyDto> queryByParams(Map<String, Object> params) {
        return manager.queryByParams(params);
    }
}
