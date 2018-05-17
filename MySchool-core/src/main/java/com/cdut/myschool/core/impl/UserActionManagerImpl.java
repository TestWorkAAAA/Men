package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.TipDto;
import com.cdut.myschool.core.dto.UserActionDto;
import com.cdut.myschool.core.manager.UserActionManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.UserAction;
import com.cdut.myschool.persist.entity.UserActionExample;
import com.cdut.myschool.persist.mapper.TipMapper;
import com.cdut.myschool.persist.mapper.UserActionMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserActionManagerImpl implements UserActionManager {

    @Autowired
    UserActionMapper mapper;

    @Autowired
    TipMapper tipMapper;

    @Override
    public List<UserActionDto> queryByParams(Map<String, Object> params) {
        checkNotNull(params);
        UserActionExample example = new UserActionExample();
        UserActionExample.Criteria criteria = example.createCriteria();
        if (params.get(KEY_ID) != null) {
            criteria.andIdEqualTo(params.get(KEY_ID).toString());
        }
        if (params.get(KEY_TYPE) != null) {
            criteria.andTypeEqualTo(Integer.parseInt(params.get(KEY_TYPE).toString()));
        }
        if (params.get(KEY_USER_ID) != null) {
            criteria.andUserIdEqualTo(params.get(KEY_USER_ID).toString());
        }
        List<UserAction> temp = mapper.selectByExample(example);
        List<UserActionDto> result = new ArrayList<>(temp.size());
        for (UserAction entity : temp) {
            UserActionDto dto = new UserActionDto();
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
    public int insertSelective(UserActionDto dto) {
        return 0;
    }

    @Override
    public UserActionDto getByPrimaryKey(String id) {
        checkNotNull(id);
        UserActionDto dto = new UserActionDto();
        BeanUtils.copyProperties(mapper.selectByPrimaryKey(id), dto);
        return dto;
    }

    @Override
    public int insertOneRecord(UserActionDto dto) {
        checkNotNull(dto);
        UserAction userAction = new UserAction();
        BeanUtils.copyProperties(dto, userAction);
        userAction.setId(UID.next());
        return mapper.insert(userAction);
    }

    @Override
    public int updateRecordById(UserActionDto dto) {
        checkNotNull(dto);
        UserAction userAction = new UserAction();
        BeanUtils.copyProperties(dto, userAction);
        return mapper.updateByPrimaryKey(userAction);
    }
}
