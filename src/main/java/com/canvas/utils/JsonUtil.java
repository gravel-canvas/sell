package com.canvas.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Author: 宗恣
 * @Date: 2018/7/11 0011 12:13
 */
public class JsonUtil {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        return gson.toJson(object);
    }



}
