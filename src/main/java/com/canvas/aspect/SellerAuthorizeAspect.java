package com.canvas.aspect;

import com.canvas.constant.CookieConstant;
import com.canvas.constant.RedisConstant;
import com.canvas.exception.SellException;
import com.canvas.exception.SellerAuthorizeException;
import com.canvas.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 宗恣
 * @Date: 2018/7/13 0013 17:55
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("execution(public * com.canvas.controller.Seller*.*(..))" +
    "&& !execution(public * com.canvas.controller.SellerUserController.*(..))")
    public void verify() {}

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 查询Cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        // 判断cookie
        if (null == cookie) {
            log.warn("【登陆校验】Cookie中查不到token");
            throw new SellerAuthorizeException();
        }

        // 从redis查询
        String tokenValue = stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登陆校验】Redis中查不到token");
            throw new SellerAuthorizeException();
        }

    }

}
