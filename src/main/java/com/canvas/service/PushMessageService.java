package com.canvas.service;

import com.canvas.dto.OrderDTO;

/**
 * 推送消息
 * @Author: 宗恣
 * @Date: 2018/7/13 22:24
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);

}
