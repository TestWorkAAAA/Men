package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.RoastDto;
import com.cdut.myschool.core.impl.RoastManagerImpl;
import com.cdut.myschool.core.manager.LearnTypeManager;
import com.cdut.myschool.core.manager.RoastManager;
import com.cdut.myschool.service.service.RoastService;
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
@RequestMapping("/roast")
public class RoastController {

    @Autowired
    RoastService service;

    @RequestMapping(method = RequestMethod.POST, value = "/getRoast")
    @ResponseBody
    public ResultVO roastSearch(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();

        String topicId = request.getParameter("topicId");
        String id = request.getParameter("id");
        String context = request.getParameter("context");
        String type = request.getParameter("type");
        String cognateId = request.getParameter("cognateId");

        if (null != topicId) {
            map.put(RoastManager.KEY_TOPIC_ID, topicId);
        }
        if (null != id) {
            map.put(RoastManager.KEY_ID,id);
        }
        if (null != context) {
            map.put(RoastManager.KEY_CONTEXT, context);
        }
        if (type != null) {
            int typeNumber = Integer.parseInt(type);
            if (typeNumber == RoastManager.TYPE_CLASS || typeNumber == RoastManager.TYPE_STUDY) {
                map.put(RoastManager.KEY_TYPE, typeNumber);
            } else {
                return ResultUtil.failure(CodeUtils.FAIL_ROAST_TYPE_ERROR, CodeUtils.MSG_ROAST_TYPE_ERROR);
            }
        }
        if (null != cognateId) {
            map.put(RoastManager.KEY_COGNATEID, cognateId);
        }

        List<RoastDto> ls = service.queryByParams(map);
        if (ls != null) {
            return ResultUtil.success(ls,0,0, null);
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_UNKNOWN, CodeUtils.MSG_UNKNOWN);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/removeType")
    @ResponseBody
    public ResultVO removeType(String id) {
        int result = 0;

        if (null != id) {
            result = service.removeOne(id);
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }
        if (result > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_NO_SUCH_LINE, CodeUtils.MSG_NO_SUCH_LINE);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editRoast")
    @ResponseBody
    public ResultVO editRoast(String id, String topicId, String context, String type, String cognateId, String time)  {
        int result = 0;

        RoastDto dto = new RoastDto(id, topicId, context, Integer.parseInt(type),cognateId, new Date(Long.parseLong(time)));

        if (null != id) {
            result = service.updateOne(dto);
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }
        if (result > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_NO_SUCH_LINE, CodeUtils.MSG_NO_SUCH_LINE);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addOneRoast")
    @ResponseBody
    public ResultVO addRoast (String topicId, String context, String type, String cognateId, String time) {

        RoastDto dto = new RoastDto(null, topicId, context, Integer.parseInt(type),cognateId, new Date(Long.parseLong(time)));
        int result = service.addOne(dto);
        if (result > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_NO_SUCH_LINE, CodeUtils.MSG_NO_SUCH_LINE);
        }
    }
}
