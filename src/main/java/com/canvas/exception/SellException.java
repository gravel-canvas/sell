package com.canvas.exception;

import com.canvas.enums.ResultEnum;

/**
 * @Author: 宗恣
 * @Date: 2018/7/3 0003 17:25
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
}
