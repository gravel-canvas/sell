package com.canvas.controller;

import com.canvas.converter.OrderForm2OrderDTOConverter;
import com.canvas.dto.OrderDTO;
import com.canvas.enums.ResultEnum;
import com.canvas.exception.SellException;
import com.canvas.form.OrderForm;
import com.canvas.service.OrderService;
import com.canvas.utils.ResultVOUtil;
import com.canvas.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 宗恣
 * @Date: 2018/7/7 23:37
 */
@RestController
@RequestMapping("/buyer/order/")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;


    // 创建订单
    @PostMapping("create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("【创建订单】 参数不正确 orderForm: {}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }


        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);

        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】 购物车为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String > map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    // 查询订单列表
    @GetMapping("list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {

        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】 openid 为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }


        PageRequest pageRequest = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage =  orderService.findList(openid, pageRequest);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    // 订单详情
    @GetMapping("detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {

        // TODO 不安全的做法，需改进
        OrderDTO orderDTO = orderService.findOne(orderId);

        return ResultVOUtil.success(orderDTO);
    }

    // 取消订单
    @PostMapping("cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {

        // TODO 不安全的做法，需改进

        OrderDTO orderDTO = orderService.findOne(orderId);

        orderService.cancel(orderDTO);

        return ResultVOUtil.success();

    }


}
