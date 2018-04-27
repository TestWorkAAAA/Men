package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.StudyDto;
import com.cdut.myschool.core.manager.StudyManager;
import com.cdut.myschool.persist.entity.Study;
import com.cdut.myschool.service.service.StudyService;
import com.cdut.myschool.util.CodeUtils;
import com.cdut.myschool.util.ResultUtil;
import com.cdut.myschool.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/study")
public class StudyController {

    @Autowired
    StudyService service;

    @RequestMapping(method = RequestMethod.POST, value = "/getStudy")
    @ResponseBody
    public ResultVO studySearch(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String createTime = request.getParameter("createTime");
        String endTime = request.getParameter("endTime");

        if (null != name) {
            map.put(StudyManager.KEY_NAME, name);
        }
        if (null != id) {
            map.put(StudyManager.KEY_ID,id);
        }
        if (null != type) {
            int typeNumber = Integer.parseInt(type);
            if (typeNumber == StudyManager.TYPE_CLASS || typeNumber == StudyManager.TYPE_STUDY) {
                map.put(StudyManager.KEY_TYPE, typeNumber);
            } else {
                return ResultUtil.failure(CodeUtils.FAIL_ROAST_TYPE_ERROR, CodeUtils.MSG_ROAST_TYPE_ERROR);
            }
        }

        if (null != createTime) {
            int createTimeNumber = Integer.parseInt(createTime);
            map.put(StudyManager.KEY_CREATE_TIME, createTimeNumber);
        }

        if (null != endTime) {
            int endTimeNumber = Integer.parseInt(endTime);
            map.put(StudyManager.KEY_END_TIME, endTimeNumber);
        }

        List<StudyDto> ls = service.queryByParams(map);
        if (ls != null) {
            return ResultUtil.success(ls,0,0, null);
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_UNKNOWN, CodeUtils.MSG_UNKNOWN);
        }
    }


    @RequestMapping(method = RequestMethod.POST, value = "/addOneType")
    @ResponseBody
    public ResultVO addStudy (String name, String type, String createTime, String endTime) {

        StudyDto dto = new StudyDto(null, name, Integer.parseInt(type), new Date(Long.parseLong(createTime)),new Date(Long.parseLong(endTime)));
        int result = service.addOne(dto);
        if (result > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_NO_SUCH_LINE, CodeUtils.MSG_NO_SUCH_LINE);
        }
    }
}
