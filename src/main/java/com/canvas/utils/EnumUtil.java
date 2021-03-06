package com.canvas.utils;

import com.canvas.enums.CodeEnum;

/**
 * @Author: 宗恣
 * @Date: 2018/7/12 0012 9:52
 */
public class EnumUtil {

    public static  <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

}
