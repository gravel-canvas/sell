package com.canvas.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: 宗恣
 * @Date: 2018/7/13 0013 11:09
 */
@Data
public class ProductForm {

    /** 产品ID*/
    private String      productId;

    /** 商品名称*/
    private String      productName;

    /** 价格*/
    private BigDecimal productPrice;

    /** 库存*/
    private Integer     productStock;

    /** 描述*/
    private String      productDescription;

    /** 小图*/
    private String      productIcon;

    /** 类目编号*/
    private Integer      categoryType;

}
