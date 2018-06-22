package com.canvas.controller;

import com.canvas.pojo.ProductCategory;
import com.canvas.pojo.ProductInfo;
import com.canvas.service.CategoryServcie;
import com.canvas.service.ProductService;
import com.canvas.service.impl.CategoryServiceImpl;
import com.canvas.utils.ResultVOUtil;
import com.canvas.vo.ProductInfoVO;
import com.canvas.vo.ProductVO;
import com.canvas.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @Author: 宗恣
 * @Date: 2018/6/22 14:45
 */

@RestController
@RequestMapping("/buyer/product/")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryServcie categoryServcie;


    @GetMapping("list")
    public ResultVO list() {

        // 1.查询所有的上架商品
        List<ProductInfo> productInfoList =  productService.findUpAll();

        // 2.查询所有类目（一次性查询）
//        List<Integer> categoryTypeList = new ArrayList<Integer>();
        // 传统
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        // 精简(java8，lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryServcie.findByCategoryTypeIn(categoryTypeList);


        // 3.数据拼装
        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
            for(ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType() == productCategory.getCategoryType()) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }


}
