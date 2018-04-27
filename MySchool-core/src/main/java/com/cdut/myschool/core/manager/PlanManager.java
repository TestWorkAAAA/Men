package com.cdut.myschool.core.manager;

import com.cdut.myschool.core.dto.PlanDto;


public interface PlanManager extends BaseManager<PlanDto> {
    String KEY_ID = "id";
    String KEY_USER_ID = "userID";
    String KEY_PLANNAME = "planName";
    String KEY_PLANTYPE = "planType";
    String KEY_TIME = "time";
    String KEY_DeadTIme = "dead";
}
