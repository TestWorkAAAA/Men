package com.cdut.myschool.service.service;

import com.cdut.myschool.core.dto.TipDto;

public interface TipService extends BaseService<TipDto> {

    int deleteById(String id, String userId);

    TipDto getById (String id);

    boolean look(String id);

    boolean good (String id);
}
