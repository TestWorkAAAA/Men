package com.cdut.myschool.controller;

import com.cdut.myschool.core.dto.OrderDto;
import com.cdut.myschool.core.dto.RoastDto;
import com.cdut.myschool.core.manager.OrderManager;
import com.cdut.myschool.core.manager.RoastManager;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService service;

    @RequestMapping(method = RequestMethod.POST, value = "/cancelOrder")
    @ResponseBody
    public ResultVO cancelOrder(String userId, String id) {
        if (userId == null || id == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }

        if (service.cancelOneOrder(id,userId)) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/finishOrder")
    @ResponseBody
    public ResultVO finishOrder(String id, String userId) {
        if (id == null && userId == null) {
            return ResultUtil.failure(CodeUtils.FAIL_PARAMENT_ERROR, CodeUtils.MSG_PARAMENT_NULL);
        }

        if (service.finishOrder(id, userId)) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getOrder")
    @ResponseBody
    public ResultVO getOrder(String id, String sellerId, String buyerId,String status) {

        Map<String,Object> map = new HashMap<>();
        if (id != null) {
            map.put(OrderManager.KEY_ID, id);
        }

        if (sellerId != null) {
            map.put(OrderManager.KEY_SELLER_ID, sellerId);
        }

        if (buyerId != null) {
            map.put(OrderManager.KEY_BUYER_ID, buyerId);
        }

        if (status != null) {
            map.put(OrderManager.KEY_STATUS, status);
        }
        List<OrderDto> ls = service.queryByParams(map);

        if (ls != null) {
            return ResultUtil.success(ls, 0,ls.size(),null);
        } else {
            return ResultUtil.failure(40001, "查询失败");
        }
    }
}
