package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.LearnInfoDto;
import com.cdut.myschool.core.manager.LearnInfoManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.LearnInfo;
import com.cdut.myschool.persist.entity.LearnInfoExample;
import com.cdut.myschool.persist.mapper.LearnInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LearnInfoManagerImpl implements LearnInfoManager {

    @Autowired
    LearnInfoMapper mapper;

    @Override
    public List<LearnInfoDto> queryByParams(Map<String, Object> params) {
        LearnInfoExample example = new LearnInfoExample();
        LearnInfoExample.Criteria criteria = example.createCriteria();
        if (params != null && params.size() != 0) {
            if (params.get(KEY_USER_ID) != null) {
                criteria.andUserIdEqualTo(params.get(KEY_USER_ID).toString());
            } else {
                throw new IllegalArgumentException("Null User ID");
            }
            if (params.get(KEY_TYPE_ID) != null) {
                criteria.andTypeIdEqualTo(params.get(KEY_TYPE_ID).toString());
            }
            if (params.get(KEY_NAME) != null) {
                criteria.andNameEqualTo(params.get(KEY_NAME).toString());
            }
            List<LearnInfo> temp = mapper.selectByExample(example);
            List<LearnInfoDto> result = new ArrayList<>(temp.size());
            for (LearnInfo entity : temp) {
                LearnInfoDto dto = new LearnInfoDto();
                BeanUtils.copyProperties(entity, dto);
                // TODO: 2018/4/26 添加链接头部
                result.add(dto);
            }
            return result;
        } else {
            throw new IllegalArgumentException("Null User ID");
        }
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(LearnInfoDto dto) {
        return 0;
    }

    @Override
    public LearnInfoDto getByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int insertOneRecord(LearnInfoDto dto) {
        LearnInfo temp = new LearnInfo();
        BeanUtils.copyProperties(dto,temp);
        temp.setId(UID.next());
        return mapper.insert(temp);
    }

    @Override
    public int updateRecordById(LearnInfoDto dto) {
        return 0;
    }
}
