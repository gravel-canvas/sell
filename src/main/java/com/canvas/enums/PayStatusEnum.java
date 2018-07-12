package com.canvas.enums;

import lombok.Getter;

/**
 * @Author: 宗恣
 * @Date: 2018/7/3 0003 14:18
 */
@Getter
public enum PayStatusEnum implements CodeEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功")

    ;


    private Integer code;
    private String  message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
