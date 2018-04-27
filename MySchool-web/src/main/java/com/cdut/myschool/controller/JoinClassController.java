package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.JoinClassDto;
import com.cdut.myschool.service.service.JoinClassService;
import com.cdut.myschool.util.ResultUtil;
import com.cdut.myschool.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/joinClass")
public class JoinClassController {
    @Autowired
    JoinClassService joinClassService;

    @RequestMapping(method = RequestMethod.POST, value = "/getClassByKeys")
    @ResponseBody
    public ResultVO classSearchByKeys(String userId, String classId) {
        List<JoinClassDto> ls = joinClassService.getListByKeys(userId, classId);
        if (ls != null) {
            return ResultUtil.success(ls,0,0, null);
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/joinClass")
    @ResponseBody
    public ResultVO joinClass(String userId, String classId) {
        int result = joinClassService.joinNewClass(userId, classId);
        if (result != 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40002, "加入失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/exitClass")
    @ResponseBody
    public ResultVO exitClass(String id) {
        int result = joinClassService.exitClass(id);
        if (result != 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40003, "退出失败");
        }
    }
}
