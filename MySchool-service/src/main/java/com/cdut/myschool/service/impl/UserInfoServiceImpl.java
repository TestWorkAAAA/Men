package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.UserInfoDto;
import com.cdut.myschool.core.manager.UserInfoManager;
import com.cdut.myschool.service.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoManager manager;

    @Override
    public int addOne(UserInfoDto dto) {
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOne(String id) {
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(UserInfoDto dto) {
        return manager.updateRecordById(dto);
    }

    @Override
    public List<UserInfoDto> queryByParams(Map<String, Object> params) {
        return manager.queryByParams(params);
    }

    @Override
    public boolean checkExist(String name) {
        return manager.checkNameExist(name);
    }

    @Override
    public boolean checkNumberExist(String phoneNumber) {
        return manager.checkPhoneExist(phoneNumber);
    }
}
