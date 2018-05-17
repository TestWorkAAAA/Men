package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.ReplayDto;
import com.cdut.myschool.core.dto.TipDto;
import com.cdut.myschool.core.manager.TipManager;
import com.cdut.myschool.core.util.UID;
import com.cdut.myschool.service.service.ReplayService;
import com.cdut.myschool.service.service.TipService;
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
@RequestMapping("/tip")
public class TipController {

    @Autowired
    TipService service;

    @Autowired
    ReplayService replayService;

    @RequestMapping(method = RequestMethod.POST, value = "/addOneTip")
    @ResponseBody
    public ResultVO tipAdd(String userId, String content,String name, String picUrl) {
        if (userId == null || content == null || name == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }
        String tipId = UID.next();
        TipDto dto = new TipDto();
        dto.setPicUrl(picUrl);
        dto.setTime(new Date());
        dto.setName(name);
        dto.setUserId(userId);
        dto.setId(tipId);


        if (service.addOne(dto) > 0) {
            if (replayService.addOne(new ReplayDto(tipId, userId, content, new Date())) > 0) {
                return ResultUtil.success();
            } else {
                return ResultUtil.failure(40001, "查询失败");
            }
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteTip")
    @ResponseBody
    public ResultVO tipDeleteByKeys(String tipId, String userId) {
        if (tipId == null || userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }

        if (service.deleteById(tipId, userId) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getRoastByTipId")
    @ResponseBody
    public ResultVO roastSearchById(String id, String userId, String name) {

        Map<String,Object> map = new HashMap<>();
        if (id != null) {
            map.put(TipManager.KEY_ID, id);
        }

        if (userId != null) {
            map.put(TipManager.KEY_USER_ID, userId);
        }

        if (name != null) {
            map.put(TipManager.KEY_NAME,name);
        }
        List<TipDto> ls = service.queryByParams(map);
        if (ls != null) {
            return ResultUtil.success(ls,0,ls.size(),null);
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }
}
