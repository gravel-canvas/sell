package com.canvas.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 宗恣
 * @Date: 2018/7/13 0013 16:42
 */
public class CookieUtil {

    /**
     * 设置token至cookie
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge) {

        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(7200);
        response.addCookie(cookie);

    }

    /**
     * 获取Cookie
     * @param request
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest request,
                           String name) {

        Map<String, Cookie> cookieMap = readCookieMap(request);

        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        } else {
            return null;
        }

    }

    /**
     * 将cookie封装成map
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        Map<String, Cookie> cookieMap = new HashMap<>();

        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }

        return cookieMap;
    }

}
