package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.GoodsDto;
import com.cdut.myschool.core.dto.OrderDto;
import com.cdut.myschool.core.dto.RoastDto;
import com.cdut.myschool.core.manager.GoodsManager;
import com.cdut.myschool.core.manager.OrderManager;
import com.cdut.myschool.core.manager.RoastManager;
import com.cdut.myschool.service.service.GoodsService;
import com.cdut.myschool.service.service.OrderService;
import com.cdut.myschool.service.service.RoastService;
import com.cdut.myschool.util.CodeUtils;
import com.cdut.myschool.util.ResultUtil;
import com.cdut.myschool.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService service;

    @RequestMapping(method = RequestMethod.POST, value = "/addOne")
    @ResponseBody
    public ResultVO addOneGoods(String userId, String name, String introduce, String tip_id, String location,
                                String price) {
        if (userId == null || name == null || tip_id == null || price == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }

        GoodsDto dto = new GoodsDto(null, tip_id, new BigDecimal(price),location, userId,name,introduce, null , -1);

        if (service.addOne(dto) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteGoods")
    @ResponseBody
    public ResultVO deleteGoods(String id, String userId) {
        if (id == null && userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }

        if (service.removeOne(id) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getGoods")
    @ResponseBody
    public ResultVO getGoods(String id, String name, String userId,String highPrice, String lowPrice, String status) {

        Map<String,Object> map = new HashMap<>();
        if (id != null) {
            map.put(GoodsManager.KEY_ID, id);
        }

        if (name != null) {
            map.put(GoodsManager.KEY_NAME, name);
        }

        if (userId != null) {
            map.put(GoodsManager.KEY_USER_ID, userId);
        }

        if (highPrice != null) {
            map.put(GoodsManager.KEY_HIGH_PRICE, highPrice);
        }

        if (lowPrice != null) {
            map.put(GoodsManager.KEY_LOW_PRICE, lowPrice);
        }

        if (status != null) {
            map.put(GoodsManager.KEY_STATUS, status);
        }
        List<GoodsDto> ls = service.queryByParams(map);

        if (ls != null) {
            return ResultUtil.success(ls, 0,ls.size(),null);
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }
}
