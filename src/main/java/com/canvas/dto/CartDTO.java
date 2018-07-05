package com.canvas.dto;

import lombok.Data;

/**
 * @Author: 宗恣
 * @Date: 2018/7/5 21:58
 */
@Data
public class CartDTO {

    /** 商品ID*/
    private String productId;

    /** 数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
