package com.canvas.service.impl;

import com.canvas.enums.ProductStatusEnum;
import com.canvas.pojo.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: 宗恣
 * @Date: 2018/6/22 13:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo result = productService.findOne("987654");
        Assert.assertEquals("987654", result.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productService.findUpAll();
        Assert.assertNotEquals(0, ((List) result).size());
    }

    @Test
    public void findAll() {
        PageRequest       request = new PageRequest(0, 2);
        Page<ProductInfo> page    = productService.findAll(request);
        System.out.println(page.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(1.2));
        productInfo.setProductStock(10);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductIcon("www.baidu.com");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(3);

        ProductInfo productInfo1 = productService.save(productInfo);
        Assert.assertNotNull(productInfo);
    }
}