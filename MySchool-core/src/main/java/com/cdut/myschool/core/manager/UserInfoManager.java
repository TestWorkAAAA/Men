package com.cdut.myschool.core.manager;

import com.cdut.myschool.core.dto.UserInfoDto;

public interface UserInfoManager extends BaseManager<UserInfoDto> {

    String KEY_ID = "id";
    String KEY_USER_NAME = "name";

    boolean checkNameExist(String name);

    boolean checkPhoneExist(String phoneNumber);
}
