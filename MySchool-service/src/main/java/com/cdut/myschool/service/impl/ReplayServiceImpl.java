package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.ReplayDto;
import com.cdut.myschool.core.manager.ReplayManager;
import com.cdut.myschool.service.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReplayServiceImpl implements ReplayService {

    @Autowired
    ReplayManager manager;

    @Override
    public int addOne(ReplayDto dto) {
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOne(String id) {
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(ReplayDto dto) {
        return manager.updateRecordById(dto);
    }

    @Override
    public List<ReplayDto> queryByParams(Map<String, Object> params) {
        return manager.queryByParams(params);
    }

    @Override
    public int deleteById(String id, String userId) {
        if (userId.equals(manager.getByPrimaryKey(id).getUserId())) {
            return manager.deleteByPrimaryKey(id);
        } else {
            return 0;
        }
    }
}
