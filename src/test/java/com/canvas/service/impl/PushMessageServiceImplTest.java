package com.canvas.service.impl;

import com.canvas.dto.OrderDTO;
import com.canvas.service.OrderService;
import com.canvas.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: 宗恣
 * @Date: 2018/7/13 22:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1531280321735599372");

        pushMessageService.orderStatus(orderDTO);

    }


}