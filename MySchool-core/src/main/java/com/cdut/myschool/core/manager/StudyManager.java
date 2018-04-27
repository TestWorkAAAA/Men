package com.cdut.myschool.core.manager;

import com.cdut.myschool.core.dto.StudyDto;

public interface  StudyManager extends BaseManager<StudyDto> {
    String KEY_ID = "id";
    String KEY_NAME = "name";
    String KEY_TYPE = "type";
    String KEY_CREATE_TIME = "createTime";
    String KEY_END_TIME = "endTime";

    int TYPE_CLASS = 0x10;
    int TYPE_STUDY = 0x11;
}
