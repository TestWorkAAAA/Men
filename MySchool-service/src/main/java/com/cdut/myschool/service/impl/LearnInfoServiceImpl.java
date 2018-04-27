package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.LearnInfoDto;
import com.cdut.myschool.core.manager.LearnInfoManager;
import com.cdut.myschool.persist.mapper.LearnInfoMapper;
import com.cdut.myschool.service.service.LearnInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LearnInfoServiceImpl implements LearnInfoService {

    @Autowired
    LearnInfoManager manager;

    @Override
    public List<LearnInfoDto> queryInfo(Map<String, Object> params) {
        return manager.queryByParams(params);
    }

    @Override
    public int addOneInfo(LearnInfoDto dto) {
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOneInfo(String id) {
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int editOneInfo(LearnInfoDto dto) {
        return manager.updateRecordById(dto);
    }
}
