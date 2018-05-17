package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.ComplanDto;
import com.cdut.myschool.core.dto.UserInfoDto;
import com.cdut.myschool.core.manager.UserInfoManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.Complan;
import com.cdut.myschool.persist.entity.ComplanExample;
import com.cdut.myschool.persist.entity.UserInfo;
import com.cdut.myschool.persist.entity.UserInfoExample;
import com.cdut.myschool.persist.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserInfoManagerImpl implements UserInfoManager {

    @Autowired
    UserInfoMapper mapper;

    @Override
    public List<UserInfoDto> queryByParams(Map<String, Object> params) {
        checkNotNull(params);
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        if (params.get(KEY_ID) != null) {
            criteria.andIdEqualTo(params.get(KEY_ID).toString());
        }
        if (params.get(KEY_USER_NAME) != null) {
            criteria.andUserNameLike(params.get(KEY_USER_NAME).toString());
        }
        List<UserInfo> temp = mapper.selectByExample(example);
        List<UserInfoDto> result = new ArrayList<>(temp.size());
        for (UserInfo entity : temp) {
            UserInfoDto dto = new UserInfoDto();
            BeanUtils.copyProperties(entity, dto);
            result.add(dto);
        }
        return result;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        checkNotNull(id);
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserInfoDto dto) {
        return 0;
    }

    @Override
    public UserInfoDto getByPrimaryKey(String id) {
        checkNotNull(id);
        UserInfoDto dto = new UserInfoDto();
        BeanUtils.copyProperties(mapper.selectByPrimaryKey(id),dto);
        return dto;
    }

    @Override
    public int insertOneRecord(UserInfoDto dto) {
        checkNotNull(dto);
        UserInfo info = new UserInfo();
        BeanUtils.copyProperties(dto,info);
        info.setId(UID.next());
        return mapper.insert(info);
    }

    @Override
    public int updateRecordById(UserInfoDto dto) {
        checkNotNull(dto);
        UserInfo info = new UserInfo();
        BeanUtils.copyProperties(dto,info);
        return mapper.updateByPrimaryKey(info);
    }

    @Override
    public boolean checkNameExist(String name) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUserNameEqualTo(name);
        List<UserInfo> ls = mapper.selectByExample(example);
        return ls == null || ls.size() == 0;
    }

    @Override
    public boolean checkPhoneExist(String phoneNumber) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andPhoneNumberEqualTo(phoneNumber);
        List<UserInfo> ls = mapper.selectByExample(example);
        return ls == null || ls.size() == 0;
    }
}
