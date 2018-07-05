package com.canvas.utils;

import java.util.Random;

/**
 * @Author: 宗恣
 * @Date: 2018/7/5 21:37
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间 + 随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return  System.currentTimeMillis() + String.valueOf(number);
    }

}
