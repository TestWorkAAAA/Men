package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.ZoneDto;
import com.cdut.myschool.core.manager.ZoneManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.Zone;
import com.cdut.myschool.persist.entity.ZoneExample;
import com.cdut.myschool.persist.mapper.ZoneMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class ZoneManagerImpl implements ZoneManager {

    @Autowired
    ZoneMapper mapper;

    @Override
    public List<ZoneDto> queryByParams(Map<String, Object> params) {
        ZoneExample example = new ZoneExample();
        ZoneExample.Criteria criteria = example.createCriteria();
        if (params != null && params.size() != 0) {
            if (params.get(KEY_USER_ID) != null) {
                criteria.andUserIdEqualTo(params.get(KEY_USER_ID).toString());
            } else {
                throw new IllegalArgumentException("Null User ID");
            }
            if (params.get(KEY_ID) != null) {
                criteria.andIdEqualTo(params.get(KEY_ID).toString());
            }
            if (params.get(KEY_LOCATION) != null) {
                criteria.andLocationEqualTo(params.get(KEY_LOCATION).toString());
            }
            if (params.get(KEY_MIND) != null) {
                criteria.andMindEqualTo(params.get(KEY_MIND).toString());
            }
            if (params.get(KEY_DATE) != null) {
                if (params.get(KEY_DATE) instanceof Date) {
                    criteria.andDateTimeGreaterThan((Date) params.get(KEY_DATE));
                } else {
                    throw new IllegalArgumentException("KEY_DATE's value must be java.util.date");
                }
            }
            List<Zone> temp = mapper.selectByExample(example);
            List<ZoneDto> result = new ArrayList<>(temp.size());
            for (Zone entity : temp) {
                ZoneDto dto = new ZoneDto();
                BeanUtils.copyProperties(entity, dto);
                dto.setPicUrls(Arrays.asList(entity.getPicUrl().split(",")));
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
    public int insertSelective(ZoneDto dto) {
        return 0;
    }

    @Override
    public ZoneDto getByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int insertOneRecord(ZoneDto dto) {
        Zone zone = new Zone();
        BeanUtils.copyProperties(dto, zone);
        zone.setId(UID.next());
        StringBuilder builder = new StringBuilder();
        for (String temp: dto.getPicUrls()) {
            builder.append(temp);
            builder.append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        zone.setPicUrl(builder.toString());
        return mapper.insert(zone);
    }

    @Override
    public int updateRecordById(ZoneDto dto) {
        return 0;
    }
}
