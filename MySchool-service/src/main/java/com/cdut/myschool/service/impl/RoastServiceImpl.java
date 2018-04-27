package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.RoastDto;
import com.cdut.myschool.core.manager.RoastManager;
import com.cdut.myschool.service.service.RoastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoastServiceImpl implements RoastService {

    @Autowired
    RoastManager manager;

    @Override
    public int addOne(RoastDto dto) {
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOne(String id) {
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(RoastDto dto) {
        return manager.updateRecordById(dto);
    }

    @Override
    public List<RoastDto> queryByParams(Map<String, Object> params) {
        return manager.queryByParams(params);
    }
}
