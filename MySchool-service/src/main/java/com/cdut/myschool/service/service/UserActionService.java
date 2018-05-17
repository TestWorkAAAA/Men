package com.cdut.myschool.service.service;

import com.cdut.myschool.core.dto.UserActionDto;

public interface UserActionService extends BaseService<UserActionDto> {

    int delete(String id, String userId);
}
