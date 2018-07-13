package com.canvas.controller;

import com.canvas.exception.SellException;
import com.canvas.form.CategoryForm;
import com.canvas.pojo.ProductCategory;
import com.canvas.service.CategoryServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: 宗恣
 * @Date: 2018/7/13 0013 12:58
 */
@Controller
@RequestMapping("/seller/category/")
@Slf4j
public class SellerCategoryController {

    @Autowired
    private CategoryServcie categoryServcie;

    /**
     * 商品类目列表
     * @param map
     * @return
     */
    @GetMapping("list")
    public ModelAndView list(Map<String, Object> map) {

        List<ProductCategory> productCategoryList = categoryServcie.findAll();

        map.put("categoryList", productCategoryList);

        return new ModelAndView("category/list", map);
    }

    /**
     * 展示
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {

        if (null != categoryId) {
            ProductCategory productCategory = categoryServcie.findOne(categoryId);
            map.put("productCategory", productCategory);

        }

        return new ModelAndView("category/index", map);
    }

    /**
     * 保存/更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {

        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "sell/seller/category/index");

            return new ModelAndView("common/error", map);
        }

        ProductCategory productCategory = new ProductCategory();
        try {
            if (null != form.getCategoryId()) {
                productCategory = categoryServcie.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, productCategory);

            categoryServcie.save(productCategory);

        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");

            return new ModelAndView("common/error", map);
        }

        //  product_info 未修改 category_type

        map.put("url", "/sell/seller/category/list");

        return new ModelAndView("common/success", map);
    }


}
