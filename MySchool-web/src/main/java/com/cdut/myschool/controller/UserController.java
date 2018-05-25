package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.UserActionDto;
import com.cdut.myschool.core.dto.UserInfoDto;
import com.cdut.myschool.core.manager.UserInfoManager;
import com.cdut.myschool.service.service.UserActionService;
import com.cdut.myschool.service.service.UserInfoService;
import com.cdut.myschool.util.CodeUtils;
import com.cdut.myschool.util.ResultUtil;
import com.cdut.myschool.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    UserActionService userActionService;

    @RequestMapping(method = RequestMethod.POST, value = "/addOneUser")
    @ResponseBody
    public ResultVO tipAdd(String id,String userName, String headPicUrl, String phoneNumber, String location, String introduce) {
        if (id == null || userName == null || phoneNumber == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }
        if (!userInfoService.checkExist(userName)&&userInfoService.checkNumberExist(phoneNumber)) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }
        UserInfoDto dto = new UserInfoDto();
        dto.setId(id);
        dto.setUserName(userName);
        dto.setCoin(0);
        dto.setCreditNun(100);
        dto.setHeadPicUrl(headPicUrl);
        dto.setIntroduce(introduce);
        dto.setLocation(location);
        dto.setPhoneNumber(phoneNumber);

        if (userInfoService.addOne(dto) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editUser")
    @ResponseBody
    public ResultVO tipEdit(String id, String userName, String headPicUrl, String phoneNumber, String location, String introduce) {
        if (id == null || userName == null || phoneNumber == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }
        if (!userInfoService.checkExist(userName)&&userInfoService.checkNumberExist(phoneNumber)) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }
        UserInfoDto dto = new UserInfoDto();
        dto.setId(id);
        dto.setUserName(userName);
        dto.setCoin(0);
        dto.setCreditNun(100);
        dto.setHeadPicUrl(headPicUrl);
        dto.setIntroduce(introduce);
        dto.setLocation(location);
        dto.setPhoneNumber(phoneNumber);

        if (userInfoService.updateOne(dto) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkUserName")
    @ResponseBody
    public ResultVO checkName(String userName) {
        if (userName == null ) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }

        if (userInfoService.checkExist(userName)) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_USER_NAME_REPEAT, CodeUtils.MSG_USER_NAME_REPEAT);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkPhoneNumber")
    @ResponseBody
    public ResultVO checkNumber(String phoneNumber) {
        if (phoneNumber == null ) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }

        if (userInfoService.checkNumberExist(phoneNumber)) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_PHONE_REPEAT, CodeUtils.MSG_PHONE_REPEAT);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUserAction")
    @ResponseBody
    public ResultVO addAction(String tipId, String userId, String type) {
        if (tipId == null|| userId == null || type == null ) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }

        UserActionDto dto = new UserActionDto();
        dto.setUserId(userId);
        dto.setTipId(tipId);
        dto.setType(Integer.parseInt(type));
        if (userActionService.addOne(dto) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_PHONE_REPEAT, CodeUtils.MSG_PHONE_REPEAT);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteUserAction")
    @ResponseBody
    public ResultVO removeAction(String id, String userId) {
        if (id == null || userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }


        if (userActionService.delete(id, userId) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(CodeUtils.FAIL_PHONE_REPEAT, CodeUtils.MSG_PHONE_REPEAT);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getUserByTipId")
    @ResponseBody
    public ResultVO roastSearchById(String id, String userName) {

        Map<String,Object> map = new HashMap<>();
        if (id != null) {
            map.put(UserInfoManager.KEY_ID, id);
        }

        if (userName != null) {
            map.put(UserInfoManager.KEY_USER_NAME, userName);
        }

        List<UserInfoDto> ls = userInfoService.queryByParams(map);
        if (ls != null) {
            return ResultUtil.success(ls,0,ls.size(),null);
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }
}
