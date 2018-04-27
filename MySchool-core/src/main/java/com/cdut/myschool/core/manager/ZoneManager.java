package com.cdut.myschool.core.manager;

import com.cdut.myschool.core.dto.ZoneDto;

public interface ZoneManager extends BaseManager<ZoneDto> {
    String KEY_ID = "id";
    String KEY_USER_ID = "userID";
    String KEY_DATE = "date";
    String KEY_LOCATION = "LOCATION";
    String KEY_MIND = "mind";
    String KEY_CONTEXT = "context";
}
