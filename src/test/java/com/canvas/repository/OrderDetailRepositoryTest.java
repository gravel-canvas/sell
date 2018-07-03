package com.canvas.repository;

import com.canvas.pojo.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: 宗恣
 * @Date: 2018/7/3 0003 16:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456788");
        orderDetail.setOrderId("11111");
        orderDetail.setProductIcon("www.baidu.com");
        orderDetail.setProductId("111123");
        orderDetail.setProductName("牛奶");
        orderDetail.setProductPrice(new BigDecimal(3.3));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrOrderId() {
        String orderid = "11111";
        List<OrderDetail> result = orderDetailRepository.findByOrOrderId(orderid);
        Assert.assertNotEquals(0, result.size());
    }
}