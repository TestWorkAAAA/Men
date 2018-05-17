package com.cdut.myschool.service.service;

import com.cdut.myschool.core.dto.TipDto;

public interface TipService extends BaseService<TipDto> {

    int deleteById(String id, String userId);
}
