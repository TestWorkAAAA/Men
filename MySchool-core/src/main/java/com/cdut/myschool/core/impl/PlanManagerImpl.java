package com.cdut.myschool.core.impl;

import com.cdut.myschool.core.dto.PlanDto;
import com.cdut.myschool.core.manager.PlanManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.Plan;
import com.cdut.myschool.persist.entity.PlanExample;
import com.cdut.myschool.persist.mapper.PlanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PlanManagerImpl implements PlanManager {

    @Autowired
    PlanMapper mapper;

    @Override
    public List<PlanDto> queryByParams(Map<String, Object> params) {
        PlanExample example = new PlanExample();
        PlanExample.Criteria criteria = example.createCriteria();
        if (params != null && params.size() != 0) {
            if (params.get(KEY_USER_ID) != null) {
                criteria.andUserIdEqualTo(params.get(KEY_USER_ID).toString());
            } else {
                throw new IllegalArgumentException("Null User ID");
            }
            if (params.get(KEY_PLANNAME) != null) {
                criteria.andPlanNameEqualTo(params.get(KEY_PLANNAME).toString());
            }
            if (params.get(KEY_ID) != null) {
                criteria.andIdEqualTo(params.get(KEY_ID).toString());
            }
            if (params.get(KEY_DeadTIme) != null) {
                criteria.andDeadTimeEqualTo((Date) params.get(KEY_DeadTIme));
            }
            List<Plan> temp = mapper.selectByExample(example);
            List<PlanDto> result = new ArrayList<>(temp.size());
            for (Plan entity : temp) {
                PlanDto dto = new PlanDto();
                BeanUtils.copyProperties(entity, dto);
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
    public int insertSelective(PlanDto dto) {
        return 0;
    }

    @Override
    public PlanDto getByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int insertOneRecord(PlanDto dto) {
        Plan plan = new Plan();
        BeanUtils.copyProperties(dto, plan);
        plan.setId(UID.next());
        return mapper.insert(plan);
    }

    @Override
    public int updateRecordById(PlanDto dto) {
        Plan temp = new Plan();
        BeanUtils.copyProperties(dto, temp);
        return mapper.updateByPrimaryKey(temp);
    }
}
