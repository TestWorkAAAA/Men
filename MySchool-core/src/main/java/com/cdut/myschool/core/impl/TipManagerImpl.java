package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.TipDto;
import com.cdut.myschool.core.manager.TipManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.Tip;
import com.cdut.myschool.persist.entity.TipExample;
import com.cdut.myschool.persist.entity.UserInfo;
import com.cdut.myschool.persist.mapper.TipMapper;
import com.cdut.myschool.persist.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public class TipManagerImpl implements TipManager {

    @Autowired
    TipMapper mapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<TipDto> queryByParams(Map<String, Object> params) {
        checkNotNull(params);
        TipExample example = new TipExample();
        TipExample.Criteria criteria = example.createCriteria();
        if (params.get(KEY_ID) != null) {
            criteria.andIdEqualTo(params.get(KEY_ID).toString());
        }
        if (params.get(KEY_NAME) != null) {
            criteria.andNameLike(params.get(KEY_NAME).toString());
        }
        if (params.get(KEY_USER_ID) != null) {
            criteria.andUserIdEqualTo(params.get(KEY_USER_ID).toString());
        }
        List<Tip> temp = mapper.selectByExample(example);
        List<TipDto> result = new ArrayList<>(temp.size());
        for (Tip entity : temp) {
            TipDto dto = new TipDto();
            BeanUtils.copyProperties(entity, dto);
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(entity.getUserId());
            dto.setUserName(userInfo.getUserName());
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
    public int insertSelective(TipDto dto) {
        return 0;
    }

    @Override
    public TipDto getByPrimaryKey(String id) {
        checkNotNull(id);
        TipDto dto = new TipDto();
        Tip tip = mapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(tip, dto);
        dto.setUserName(userInfoMapper.selectByPrimaryKey(tip.getUserId()).getUserName());
        return dto;
    }

    @Override
    public int insertOneRecord(TipDto dto) {
        Tip tip = new Tip();
        checkNotNull(dto, tip);
        if (tip.getId() == null) {
            tip.setId(UID.next());
        }
        return mapper.insert(tip);
    }

    @Override
    public int updateRecordById(TipDto dto) {
        Tip tip = new Tip();
        checkNotNull(dto, tip);
        return mapper.updateByPrimaryKey(tip);
    }
}
