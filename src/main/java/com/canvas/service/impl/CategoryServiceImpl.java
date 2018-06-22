package com.canvas.service.impl;

import com.canvas.pojo.ProductCategory;
import com.canvas.repository.ProductCategoryRepository;
import com.canvas.service.CategoryServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目业务层实现类
 * @Author: 宗恣
 * @Date: 2018/6/22 11:30
 */
@Service
public class CategoryServiceImpl implements CategoryServcie {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
        return repository.findByCategoryTypeIn(categoryType);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
