package com.cdut.myschool.service.service;

import com.cdut.myschool.core.dto.GoodsDto;

public interface GoodsService extends  BaseService<GoodsDto> {

    boolean buyOneGood(String id, String userId);

}
