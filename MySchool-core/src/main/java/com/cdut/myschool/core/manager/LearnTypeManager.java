package com.cdut.myschool.core.manager;

import com.cdut.myschool.core.dto.LearnTypeDto;

public interface LearnTypeManager extends BaseManager<LearnTypeDto> {

    String KEY_ID = "id";
    String KEY_PARENT = "parent";
    String KEY_USER_ID = "userID";
    String KEY_NAME = "name";
}
