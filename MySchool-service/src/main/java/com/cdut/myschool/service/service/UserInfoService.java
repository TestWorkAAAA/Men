package com.cdut.myschool.service.service;

import com.cdut.myschool.core.dto.UserInfoDto;

public interface UserInfoService extends BaseService<UserInfoDto> {
    boolean checkExist(String name);

    boolean checkNumberExist(String phoneNumber);
}
