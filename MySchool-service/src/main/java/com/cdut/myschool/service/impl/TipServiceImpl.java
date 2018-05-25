package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.TipDto;
import com.cdut.myschool.core.manager.ReplayManager;
import com.cdut.myschool.core.manager.TipManager;
import com.cdut.myschool.persist.entity.Tip;
import com.cdut.myschool.service.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TipServiceImpl implements TipService {

    @Autowired
    TipManager manager;

    @Override
    public int addOne(TipDto dto) {
        return manager.insertOneRecord(dto);
    }

    @Override
    public int removeOne(String id) {
        return manager.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(TipDto dto) {
        return manager.updateRecordById(dto);
    }

    @Override
    public List<TipDto> queryByParams(Map<String, Object> params) {
        return manager.queryByParams(params);
    }

    @Override
    public int deleteById(String id, String userId) {
        if (userId.equals(manager.getByPrimaryKey(id).getUserId())) {
            return manager.deleteByPrimaryKey(id);
        } else {
            return 0;
        }
    }

    @Override
    public TipDto getById(String id) {
        TipDto tip = manager.getByPrimaryKey(id);

        return tip;
    }

    @Override
    public boolean look(String id) {
        TipDto tipDto = manager.getByPrimaryKey(id);
        tipDto.setLookNum(tipDto.getLookNum() + 1);
        return manager.updateRecordById(tipDto) > 0;
    }

    @Override
    public boolean good(String id) {
        TipDto tipDto = manager.getByPrimaryKey(id);
        tipDto.setGoodNum(tipDto.getGoodNum() + 1);
        return manager.updateRecordById(tipDto) > 0;
    }
}
