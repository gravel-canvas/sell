package com.canvas.dto;

import com.canvas.config.WechatAccountConfig;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: 宗恣
 * @Date: 2018/7/13 0013 15:04
 */
@Component
public class WechatOpenConfig {

    @Autowired
    private WechatAccountConfig wechatAccountConfig;


    @Bean
    public WxMpService wxOpenService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxOpenConfigStorage());

        return  wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxOpenConfigStorage() {
        WxMpInMemoryConfigStorage wxOpenInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
        wxOpenInMemoryConfigStorage.setAppId(wechatAccountConfig.getOpenAppId());
        wxOpenInMemoryConfigStorage.setSecret(wechatAccountConfig.getOpenAppSecret());

        return wxOpenInMemoryConfigStorage;
    }

}
