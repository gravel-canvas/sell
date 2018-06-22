package com.canvas.service;

import com.canvas.pojo.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品业务层
 * @Author: 宗恣
 * @Date: 2018/6/22 13:37
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /** 查询所有在架商品列表*/
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /** 增加库存*/


    /** 减库存*/


}
