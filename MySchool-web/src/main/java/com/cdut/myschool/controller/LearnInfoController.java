package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.LearnInfoDto;
import com.cdut.myschool.core.manager.LearnInfoManager;
import com.cdut.myschool.service.service.LearnInfoService;
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
@RequestMapping("/learnInfo")
public class LearnInfoController {

    @Autowired
    LearnInfoService service;

    @RequestMapping(method = RequestMethod.POST, value = "/getInfo")
    @ResponseBody
    public ResultVO infoSearch(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();

        String id = request.getParameter("id");
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String typeId = request.getParameter("typeId");

        if (userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_USER_ID_NULL,CodeUtils.MSG_USER_ID_NULL);
        } else {
            map.put(LearnInfoManager.KEY_USER_ID,userId);
        }
        if (null != name) {
            map.put(LearnInfoManager.KEY_NAME, name);
        }
        if (null != typeId) {
            map.put(LearnInfoManager.KEY_TYPE_ID,typeId);
        }

        List<LearnInfoDto> ls = service.queryInfo(map);
        if (ls != null) {
            return ResultUtil.success(ls,0,0, null);
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_UNKNOWN, CodeUtils.MSG_UNKNOWN);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/removeInfo")
    @ResponseBody
    public ResultVO removeInfo(String id) {
        int result = 0;

        if (null != id) {
            result = service.removeOneInfo(id);
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }
        if (result > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_NO_SUCH_LINE, CodeUtils.MSG_NO_SUCH_LINE);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editInfo")
    @ResponseBody
    public ResultVO editInfo(String id, String userId, String typeId, String name, String url) {
        int result = 0;

        LearnInfoDto dto = new LearnInfoDto(id, userId,typeId, name,url);

        if (userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_USER_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }

        if (null != id) {
            result = service.editOneInfo(dto);
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }
        if (result > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_NO_SUCH_LINE, CodeUtils.MSG_NO_SUCH_LINE);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addOneInfo")
    @ResponseBody
    public ResultVO addInfo (String userId, String typeId, String name, String url) {
        if (userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_USER_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }
        LearnInfoDto dto = new LearnInfoDto(null, userId,typeId, name,url);
        int result = service.addOneInfo(dto);
        if (result > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_NO_SUCH_LINE, CodeUtils.MSG_NO_SUCH_LINE);
        }
    }


}
