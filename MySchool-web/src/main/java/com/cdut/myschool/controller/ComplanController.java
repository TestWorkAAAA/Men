package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.ComplanDto;
import com.cdut.myschool.service.service.ComplanService;
import com.cdut.myschool.util.CodeUtils;
import com.cdut.myschool.util.ResultUtil;
import com.cdut.myschool.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/complain")
public class ComplanController {

    @Autowired
    ComplanService service;

    @RequestMapping(method = RequestMethod.POST, value = "/getComplainByKeys")
    @ResponseBody
    public ResultVO complainSearchByKeys(String userId) {
        if (userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_USER_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }
        List<ComplanDto> ls = service.getByUserId(userId);
        if (ls != null) {
            return ResultUtil.success(ls,0,ls.size(), null);
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getComplainByTargetId")
    @ResponseBody
    public ResultVO complainSearchByTargetId(String targetId) {
        if (targetId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_USER_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }
        List<ComplanDto> ls = service.getByTargetId(targetId);
        if (ls != null) {
            return ResultUtil.success(ls,0,ls.size(), null);
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getComplainById")
    @ResponseBody
    public ResultVO complainSearchById(String id) {
        if (id == null) {
            return ResultUtil.failure(CodeUtils.FAIL_ID_NULL, CodeUtils.MSG_ID_NULL);
        }
        ComplanDto ls = service.getById(id);
        if (ls != null) {
            return ResultUtil.success(ls,0,1, null);
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }
}
