package com.canvas.controller;

import com.canvas.enums.ProductStatusEnum;
import com.canvas.exception.SellException;
import com.canvas.form.ProductForm;
import com.canvas.pojo.ProductCategory;
import com.canvas.pojo.ProductInfo;
import com.canvas.service.CategoryServcie;
import com.canvas.service.ProductService;
import com.canvas.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
 * @Date: 2018/7/13 0013 8:50
 */
@Controller
@RequestMapping("/seller/product/")
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryServcie categoryServcie;

    /**
     * 产品列表
     */
    @GetMapping("list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             Map<String, Object> map) {

        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage =  productService.findAll(pageRequest);

        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("product/list", map);
    }

    /**
     * 上架商品
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {

        try {
            productService.onSale(productId);
        } catch (SellException e) {
            log.error("【卖家修改商品状态】出现异常:", e);

            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");

            return new ModelAndView("common/error", map);
        }

        // map.put("msg", ResultEnum.SUCCESS.getMessage());
        map.put("url", "/sell/seller/product/list");


        return new ModelAndView("/common/success", map);
    }

    /**
     * 下架商品
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {

        try {
            productService.offSale(productId);
        } catch (SellException e) {
            log.error("【卖家修改商品状态】出现异常:", e);

            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");

            return new ModelAndView("common/error", map);
        }

        // map.put("msg", ResultEnum.SUCCESS.getMessage());
        map.put("url", "/sell/seller/product/list");

        return new ModelAndView("/common/success", map);
    }

    @GetMapping("index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                      Map<String, Object> map) {

        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        // 查询所有的类目
        List<ProductCategory> productCategoryList = categoryServcie.findAll();
        map.put("categoryList", productCategoryList);

        return new ModelAndView("product/index", map);
    }


    /**
     * 修改/新增产品
     * @return
     */
    @PostMapping("save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {

        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");

            return new ModelAndView("common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            // 如果productId为空,则是新增商品
            if (!StringUtils.isEmpty(form.getProductId())) {
                productInfo = productService.findOne(form.getProductId());
            } else {
                form.setProductId(KeyUtil.genUniqueKey());
            }

            BeanUtils.copyProperties(form, productInfo);
            productService.save(productInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");

            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");

        return new ModelAndView("/common/success", map);
    }

}
