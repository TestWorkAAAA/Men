package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.UserActionDto;
import com.cdut.myschool.core.manager.TipManager;
import com.cdut.myschool.core.manager.UserActionManager;
import com.cdut.myschool.service.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserActionServiceImpl implements UserActionService {

    @Autowired
    UserActionManager manager;

    @Autowired
    TipManager tipManager;

    @Override
    public int addOne(UserActionDto dto) {
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOne(String id) {
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(UserActionDto dto) {
        return manager.updateRecordById(dto);
    }

    @Override
    public List<UserActionDto> queryByParams(Map<String, Object> params) {
        List<UserActionDto> ls = manager.queryByParams(params);
//        for (UserActionDto dto : ls) {
//            dto.setTip(tipManager.getByPrimaryKey(dto.getTipId()));
//        }
        return ls;
    }

    @Override
    public int delete(String id, String userId) {
        if (userId.equals(manager.getByPrimaryKey(id).getUserId())) {
            return manager.deleteByPrimaryKey(id);
        } else {
            return 0;
        }
    }
}
