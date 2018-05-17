package com.cdut.myschool.service.service;

import com.cdut.myschool.core.dto.ComplanDto;
import com.cdut.myschool.persist.entity.Complan;

import java.util.List;

public interface ComplanService extends BaseService<ComplanDto> {

    List<ComplanDto> getByUserId(String id);

    List<ComplanDto> getByTargetId(String id);

    ComplanDto getById(String id);
}
