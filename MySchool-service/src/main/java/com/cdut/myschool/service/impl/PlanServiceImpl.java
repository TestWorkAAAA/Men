package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.PlanDto;
import com.cdut.myschool.core.manager.PlanManager;
import com.cdut.myschool.service.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanManager manager;

    @Override
    public int addOne(PlanDto dto) {
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOne(String id) {
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(PlanDto dto) {
        return manager.updateRecordById(dto);
    }

    @Override
    public List<PlanDto> queryByParams(Map<String, Object> params) {
        return manager.queryByParams(params);
    }
}
