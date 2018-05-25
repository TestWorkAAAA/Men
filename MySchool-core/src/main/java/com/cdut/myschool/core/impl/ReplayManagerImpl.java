package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.ReplayDto;
import com.cdut.myschool.core.manager.ReplayManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.Replay;
import com.cdut.myschool.persist.entity.ReplayExample;
import com.cdut.myschool.persist.entity.UserInfo;
import com.cdut.myschool.persist.mapper.ReplayMapper;
import com.cdut.myschool.persist.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public class ReplayManagerImpl implements ReplayManager {

    @Autowired
    ReplayMapper replayMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<ReplayDto> queryByParams(Map<String, Object> params) {
        checkNotNull(params);
        ReplayExample example = new ReplayExample();
        ReplayExample.Criteria criteria = example.createCriteria();
        if (params.get(KEY_ID) != null) {
            criteria.andIdEqualTo(params.get(KEY_ID).toString());
        }
        if (params.get(KEY_TIP_ID) != null) {
            criteria.andTipIdEqualTo(params.get(KEY_TIP_ID).toString());
        }
        if (params.get(KEY_USER_ID) != null) {
            criteria.andUserIdEqualTo(params.get(KEY_USER_ID).toString());
        }
        example.setOrderByClause("time desc");
        List<Replay> temp = replayMapper.selectByExample(example);
        List<ReplayDto> result = new ArrayList<>(temp.size());
        for (Replay entity : temp) {
            ReplayDto dto = new ReplayDto();
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
        return replayMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ReplayDto dto) {
        checkNotNull(dto);
        Replay replay = new Replay();
        BeanUtils.copyProperties(dto,replay);
        replay.setId(UID.next());
        return replayMapper.insertSelective(replay);
    }

    @Override
    public ReplayDto getByPrimaryKey(String id) {
        checkNotNull(id);
        ReplayDto dto = new ReplayDto();
        Replay replay = replayMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(replay, dto);
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(replay.getUserId());
        dto.setUserName(userInfo.getUserName());
        return dto;
    }

    @Override
    public int insertOneRecord(ReplayDto dto) {
        checkNotNull(dto);
        Replay replay = new Replay();
        BeanUtils.copyProperties(dto, replay);
        replay.setId(UID.next());
        return replayMapper.insert(replay);
    }

    @Override
    public int updateRecordById(ReplayDto dto) {
        checkNotNull(dto);
        Replay replay = new Replay();
        BeanUtils.copyProperties(dto, replay);
        return replayMapper.updateByPrimaryKey(replay);
    }
}
