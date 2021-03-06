package com.canvas.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * @Author: 宗恣
 * @Date: 2018/6/22 14:51
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 5875592176845240812L;

    /** 错误码*/
    private Integer code;

    /** 提示信息*/
    private String  msg;

    /** 返回的具体对象*/
    private T       data;

}
