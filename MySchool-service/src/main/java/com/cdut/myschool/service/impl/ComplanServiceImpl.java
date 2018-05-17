package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.ComplanDto;
import com.cdut.myschool.core.manager.ComplanManager;
import com.cdut.myschool.service.service.ComplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cdut.myschool.core.manager.ComplanManager.KEY_TARGET_ID;
import static com.cdut.myschool.core.manager.ComplanManager.KEY_USER_ID;
import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class ComplanServiceImpl implements ComplanService {

    @Autowired
    ComplanManager manager;

    @Override
    public int addOne(ComplanDto dto) {
        checkNotNull(dto);
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOne(String id) {
        checkNotNull(id);
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(ComplanDto dto) {
        checkNotNull(dto);
        return manager.updateRecordById(dto);
    }

    @Override
    public List<ComplanDto> queryByParams(Map<String, Object> params) {
        return manager.queryByParams(params);
    }

    @Override
    public List<ComplanDto> getByUserId(String id) {
        Map<String,Object> map = new HashMap<>();
        map.put(KEY_USER_ID, id);
        return manager.queryByParams(map);
    }

    @Override
    public List<ComplanDto> getByTargetId(String id) {
        Map<String,Object> map = new HashMap<>();
        map.put(KEY_TARGET_ID, id);
        return manager.queryByParams(map);
    }

    @Override
    public ComplanDto getById(String id) {
        return manager.getByPrimaryKey(id);
    }
}
