package com.cdut.myschool.service.service;

import com.cdut.myschool.core.dto.ReplayDto;

public interface ReplayService extends BaseService<ReplayDto> {

    int deleteById(String id, String userId);

}
