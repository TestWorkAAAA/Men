package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.ZoneDto;
import com.cdut.myschool.core.manager.ZoneManager;
import com.cdut.myschool.service.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    ZoneManager manager;

    @Override
    public int addOne(ZoneDto dto) {
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOne(String id) {
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(ZoneDto dto) {
        return manager.updateRecordById(dto);
    }

    @Override
    public List<ZoneDto> queryByParams(Map<String, Object> params) {
        return manager.queryByParams(params);
    }
}
