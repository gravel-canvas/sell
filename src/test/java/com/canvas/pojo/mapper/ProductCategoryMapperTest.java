package com.canvas.pojo.mapper;

import com.canvas.pojo.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author: 宗恣
 * @Date: 2018/7/14 11:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper categoryMapper;

    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name", "竹叶");
        map.put("category_type", 8);

        int result = categoryMapper.insertByMap(map);

        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("我稀饭");
        productCategory.setCategoryType(12);

        int result = categoryMapper.insertByObject(productCategory);

        Assert.assertEquals(1, result);
    }

    @Test
    public void findByCategoryType() {
        ProductCategory result = categoryMapper.findByCategoryType(12);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> result = categoryMapper.findByCategoryName("竹叶");
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void updateByCategoryType() {
        int result = categoryMapper.updateByCategoryType("朕的大清", 1);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("孤的大秦");
        productCategory.setCategoryType(2);
        int result = categoryMapper.updateByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void deleteByCategoryType() {
        int result = categoryMapper.deleteByCategoryType(12);
        Assert.assertEquals(1, result);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory result = categoryMapper.selectByCategoryType(2);
        Assert.assertNotNull(result);
    }

    @Test
    public void selectByCategoryName() {
        List<ProductCategory> result = categoryMapper.selectByCategoryName("竹叶");
        Assert.assertNotEquals(0, result.size());
    }

}