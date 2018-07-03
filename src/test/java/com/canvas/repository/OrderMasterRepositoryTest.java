package com.canvas.repository;

import com.canvas.pojo.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: 宗恣
 * @Date: 2018/7/3 0003 15:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("456788");
        orderMaster.setBuyerName("粽子");
        orderMaster.setBuyerPhone("12345678911");
        orderMaster.setBuyerAddress("汉界");
        orderMaster.setBuyerOpenid("abc123");
        orderMaster.setOrderAmount(new BigDecimal(3.15));

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByBuyerOpenid() {
        String openid = "abc123";
        PageRequest pageRequest = new PageRequest(0, 3);

        Page<OrderMaster> result = orderMasterRepository.findByBuyerOpenid(openid, pageRequest);
        Assert.assertNotEquals(0, result.getTotalElements());
    }

}