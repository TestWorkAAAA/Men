package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.LearnInfoDto;
import com.cdut.myschool.core.dto.LearnTypeDto;
import com.cdut.myschool.core.manager.LearnInfoManager;
import com.cdut.myschool.core.manager.LearnTypeManager;
import com.cdut.myschool.service.service.LearnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LearnTypeServiceImpl implements LearnTypeService {

    @Autowired
    LearnTypeManager manager;

    @Override
    public int addOne(LearnTypeDto dto) {
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOne(String id) {
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(LearnTypeDto dto) {
        return manager.updateRecordById(dto);
    }

    @Override
    public List<LearnTypeDto> queryByParams(Map<String, Object> params) {
        return manager.queryByParams(params);
    }
}
