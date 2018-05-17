package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.RoastDto;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/roast")
public class RoastContorller {

    @Autowired
    RoastService service;

    @RequestMapping(method = RequestMethod.POST, value = "/addOneRoast")
    @ResponseBody
    public ResultVO roastAdd(String userId, String content) {
        if (userId == null || content == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }
        RoastDto dto = new RoastDto();
        dto.setContext(content);
        dto.setTime(new Date());
        dto.setUserId(userId);
        if (service.addOne(dto) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getRoastByTipId")
    @ResponseBody
    public ResultVO roastSearchById(String id, String userId) {
        if (id == null && userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }
        Map<String,Object> map = new HashMap<>();
        if (id != null) {
            map.put(RoastManager.KEY_ID, id);
        }

        if (userId != null) {
            map.put(RoastManager.KEY_USER_ID, userId);
        }
        List<RoastDto> ls = service.queryByParams(map);
        if (ls != null) {
            return ResultUtil.success(ls, 0, ls.size(),null);
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteRoast")
    @ResponseBody
    public ResultVO roastDeleteByKeys(String id, String userId) {
        if (id == null || userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }

        if (service.deleteById(id, userId) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }
}
