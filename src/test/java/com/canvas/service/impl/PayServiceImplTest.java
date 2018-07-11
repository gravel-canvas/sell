package com.canvas.service.impl;

import com.canvas.dto.OrderDTO;
import com.canvas.service.OrderService;
import com.canvas.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * @Author: 宗恣
 * @Date: 2018/7/11 0011 11:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO =orderService.findOne("1531280321735599372");

        payService.create(orderDTO);

    }

    @Test
    public void refund() {
        OrderDTO orderDTO =orderService.findOne("1531280321735599372");
        payService.refund(orderDTO);
    }


}