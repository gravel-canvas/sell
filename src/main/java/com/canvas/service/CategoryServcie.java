package com.canvas.service;

import com.canvas.pojo.ProductCategory;

import java.util.List;

/**
 * 类目业务层
 * @Author: 宗恣
 * @Date: 2018/6/22 11:26
 */
public interface CategoryServcie {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);

    ProductCategory save(ProductCategory productCategory);

}
