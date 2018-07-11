package com.canvas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 宗恣
 * @Date: 2018/7/10 0010 10:47
 */
@RestController
@RequestMapping("/weixin/")
@Slf4j
public class WeixinController {

    @GetMapping("auth")
    public void auth(@RequestParam("code") String code) {

        log.info("code: {}", code);

        log.info("进入auth方法。。。");

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx9dc1bacb928a3680&secret=8d1e2b543e36096894e93e0ed647f601&code=" + code + "&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);
        log.info("response: {}",response);



    }

}
