package com.cdut.myschool.controller;


import com.cdut.myschool.core.dto.ReplayDto;
import com.cdut.myschool.persist.entity.Replay;
import com.cdut.myschool.service.service.ReplayService;
import com.cdut.myschool.util.CodeUtils;
import com.cdut.myschool.util.ResultUtil;
import com.cdut.myschool.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static com.cdut.myschool.core.manager.ReplayManager.KEY_TIP_ID;
import static com.cdut.myschool.core.manager.ReplayManager.KEY_USER_ID;

@Controller
@RequestMapping("/replay")
public class ReplayController {

    @Autowired
    ReplayService service;

    @RequestMapping(method = RequestMethod.POST, value = "/addOneReplay")
    @ResponseBody
    public ResultVO replayAdd(String userId, String  tipId, String content) {
        if (userId == null || tipId == null || content == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }
        ReplayDto dto = new ReplayDto();
        dto.setTipId(tipId);
        dto.setTime(new Date());
        dto.setUserId(userId);
        dto.setContent(content);
        if (service.addOne(dto) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }


    @RequestMapping(method = RequestMethod.POST, value = "/getReplayByTipId")
    @ResponseBody
    public ResultVO replaySearchByTipId(String tipId, String userId) {
        if (tipId == null && userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }
        Map<String,Object> map = new HashMap<>();
        if (tipId != null) {
            map.put(KEY_TIP_ID, tipId);
        }

        if (userId != null) {
            map.put(KEY_USER_ID, userId);
        }
        List<ReplayDto> ls = service.queryByParams(map);
        if (ls != null) {
            return ResultUtil.success(ls, 0,ls.size(),null);
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteReplay")
    @ResponseBody
    public ResultVO replayDeleteByKeys(String tipId, String userId) {
        if (tipId == null || userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }

        if (service.deleteById(tipId, userId) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }
}
