package com.cdut.myschool.service.service;

import com.cdut.myschool.core.dto.JoinClassDto;

import java.util.List;

public interface JoinClassService {

    List<JoinClassDto> getListByKeys(String userKey, String studyKey);

    int joinNewClass(String userId, String classId);

    int exitClass(String id);
}
