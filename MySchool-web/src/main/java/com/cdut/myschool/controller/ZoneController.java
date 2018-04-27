package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.ZoneDto;
import com.cdut.myschool.core.manager.ZoneManager;
import com.cdut.myschool.service.service.ZoneService;
import com.cdut.myschool.util.CodeUtils;
import com.cdut.myschool.util.ResultUtil;
import com.cdut.myschool.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/zone")
public class ZoneController {
    @Autowired
    ZoneService service;

    @RequestMapping(method = RequestMethod.POST, value = "/getZone")
    @ResponseBody
    public ResultVO zoneSearch(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();


        String userId = request.getParameter("userId");
        String id = request.getParameter("id");
        String location = request.getParameter("location");
        String mind = request.getParameter("mind");
        long date = Long.parseLong(request.getParameter("date"));

        if (userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_USER_ID_NULL,CodeUtils.MSG_USER_ID_NULL);
        } else {
            map.put(ZoneManager.KEY_USER_ID,userId);
        }
        if (date != 0) {
            map.put(ZoneManager.KEY_DATE, date);
        }
        if (null != id) {
            map.put(ZoneManager.KEY_ID,id);
        }
        if (null != mind) {
            map.put(ZoneManager.KEY_MIND, mind);
        }
        if (location != null) {
            map.put(ZoneManager.KEY_LOCATION, location);
        }

        List<ZoneDto> ls = service.queryByParams(map);
        if (ls != null) {
            return ResultUtil.success(ls,0,0, null);
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_UNKNOWN, CodeUtils.MSG_UNKNOWN);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/removeZone")
    @ResponseBody
    public ResultVO removeZone(String id) {
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

    @RequestMapping(method = RequestMethod.POST, value = "/editZone")
    @ResponseBody
    public ResultVO editZone(String id, String userId, String location, String mind, String context, String picUrls, String dateTime) {
        int result = 0;

        if (userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_USER_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }


        List<String> ls = Arrays.asList(picUrls.split(","));
        ZoneDto dto = new ZoneDto(id, userId,location, mind,context,ls,new Date(Long.parseLong(dateTime)));


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

    @RequestMapping(method = RequestMethod.POST, value = "/addOneZone")
    @ResponseBody
    public ResultVO addZone (String userId, String location, String mind, String context, String picUrls, String dateTime) {
        if (userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_USER_ID_NULL, CodeUtils.MSG_USER_ID_NULL);
        }
        List<String> ls = Arrays.asList(picUrls.split(","));
        ZoneDto dto = new ZoneDto(null, userId,location, mind,context,ls,new Date(Long.parseLong(dateTime)));
        int result = service.addOne(dto);

        if (result > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_NO_SUCH_LINE, CodeUtils.MSG_NO_SUCH_LINE);
        }
    }
}
