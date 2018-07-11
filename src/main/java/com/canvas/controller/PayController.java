package com.canvas.controller;

import com.canvas.dto.OrderDTO;
import com.canvas.enums.ResultEnum;
import com.canvas.exception.SellException;
import com.canvas.service.OrderService;
import com.canvas.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.rest.type.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**
 * @Author: 宗恣
 * @Date: 2018/7/11 0011 10:02
 */
@Controller
@RequestMapping("/pay/")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        // 1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            log.error("【支付订单】订单不存在");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        // 2. 发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);
    }


    @PostMapping("notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        // 返回微信处理结果
        return new ModelAndView("pay/success");
    }


}
