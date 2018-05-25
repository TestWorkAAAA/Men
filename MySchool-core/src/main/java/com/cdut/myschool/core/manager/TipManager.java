package com.cdut.myschool.core.manager;

import com.cdut.myschool.core.dto.TipDto;

public interface TipManager extends BaseManager<TipDto> {
    String KEY_ID = "id";
    String KEY_USER_ID = "userID";
    String KEY_NAME = "name";

    String KEY_ORDER = "order";
}
