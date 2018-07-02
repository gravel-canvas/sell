package com.canvas.enums;

import lombok.Getter;

/**
 * 商品状态
 * @Author: 宗恣
 * @Date: 2018/6/22 13:50
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "在架"),
    DOWN(1, "下架")
    ;

    private Integer code;
    private String  message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}