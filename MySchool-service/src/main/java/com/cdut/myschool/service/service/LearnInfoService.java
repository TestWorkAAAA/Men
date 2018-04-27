package com.cdut.myschool.service.service;

import com.cdut.myschool.core.dto.LearnInfoDto;
import com.cdut.myschool.persist.entity.LearnInfo;

import java.util.List;
import java.util.Map;

public interface LearnInfoService {
    List<LearnInfoDto> queryInfo(Map<String, Object> params);

    int addOneInfo(LearnInfoDto dto);

    int removeOneInfo(String id);

    int editOneInfo(LearnInfoDto dto);


}
