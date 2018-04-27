package com.cdut.myschool.service.impl;

import com.cdut.myschool.core.dto.JoinClassDto;
import com.cdut.myschool.core.manager.JoinClassManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.persist.entity.JoinClass;
import com.cdut.myschool.service.service.JoinClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JoinClassServiceImpl implements JoinClassService {

    @Autowired
    JoinClassManager joinClassManager;

    @Override
    public List<JoinClassDto> getListByKeys(String userKey, String studyKey) {
        Map<String , Object> hashMap = new HashMap<>();
        if (userKey != null) {
            hashMap.put(JoinClassManager.KEY_USER_ID, userKey);
        }
        if (studyKey != null) {
            hashMap.put(JoinClassManager.KEY_CLASS_ID, studyKey);
        }
        return joinClassManager.queryByParams(hashMap);
    }

    @Override
    public int joinNewClass(String userId, String classId) {
        JoinClassDto joinClass = new JoinClassDto();
        joinClass.setTime(new Date());
        joinClass.setStudyId(classId);
        joinClass.setUserId(userId);
        return joinClassManager.insertOneRecord(joinClass);
    }

    @Override
    public int exitClass(String id) {
        return joinClassManager.deleteByPrimaryKey(id);
    }
}
