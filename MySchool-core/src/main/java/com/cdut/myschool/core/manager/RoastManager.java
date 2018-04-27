package com.cdut.myschool.core.manager;


import com.cdut.myschool.core.dto.RoastDto;

public interface RoastManager extends BaseManager<RoastDto> {

    String KEY_ID = "id";
    String KEY_TOPIC_ID = "topic";
    String KEY_CONTEXT = "context";
    String KEY_TYPE = "type";
    String KEY_TIME = "time";
    String KEY_COGNATEID = "cognateID";

    int TYPE_CLASS = 0x10;
    int TYPE_STUDY = 0x11;


}
