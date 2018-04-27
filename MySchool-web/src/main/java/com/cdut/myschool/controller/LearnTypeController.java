package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.LearnTypeDto;
import com.cdut.myschool.core.manager.LearnTypeManager;
import com.cdut.myschool.service.service.LearnTypeService;
import com.cdut.myschool.util.CodeUtils;
import com.cdut.myschool.util.ResultUtil;
import com.cdut.myschool.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/learnType")
public class LearnTypeController {

    @Autowired
    LearnTypeService service;

    @RequestMapping(method = RequestMethod.POST, value = "/getType")
    @ResponseBody
    public ResultVO typeSearch(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();

        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String parent = request.getParameter("parent");

        if (userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_USER_ID_NULL,CodeUtils.MSG_USER_ID_NULL);
        } else {
            map.put(LearnTypeManager.KEY_USER_ID,userId);
        }
        if (null != name) {
            map.put(LearnTypeManager.KEY_NAME, name);
        }
        if (null != id) {
            map.put(LearnTypeManager.KEY_ID,id);
        }
        if (null != parent) {
            map.put(LearnTypeManager.KEY_PARENT, parent);
        }

        List<LearnTypeDto> ls = service.queryByParams(map);
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

    @RequestMapping(method = RequestMethod.POST, value = "/editType")
    @ResponseBody
    public ResultVO editType(String id, String userId, String parent, String name) {
        int result = 0;

        LearnTypeDto dto = new LearnTypeDto(id, userId,parent, name);

        if (userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_USER_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }

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

    @RequestMapping(method = RequestMethod.POST, value = "/addOneType")
    @ResponseBody
    public ResultVO addType (String userId, String parent, String name) {
        if (userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_USER_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }
        LearnTypeDto dto = new LearnTypeDto(null, userId,parent, name);
        int result = service.addOne(dto);
        if (result > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_NO_SUCH_LINE, CodeUtils.MSG_NO_SUCH_LINE);
        }
    }


}
