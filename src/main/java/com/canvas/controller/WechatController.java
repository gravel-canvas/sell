package com.canvas.controller;

import com.canvas.config.ProjectUrlConfig;
import com.canvas.enums.ResultEnum;
import com.canvas.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * @Author: 宗恣
 * @Date: 2018/7/10 0010 12:26
 */
@Controller
@RequestMapping("/wechat/")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxMpService wxOpenService;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;


    @GetMapping("authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {

        // 1.配置
        // 2.调用方法
        String url = projectUrlConfig.getWechatMpAuthorize() + "/sell/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(returnUrl));

        log.info("【微信网页授权】 获取code, result: {}", redirectUrl);

        return "redirect:" + redirectUrl;
    }

    @GetMapping("userInfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);

        } catch (WxErrorException e) {
            log.error("【微信网页授权】 {}", e);
            throw new SellException(ResultEnum.WX_MP_ERROR.getCode(), e.getMessage());
        }

        String openid = wxMpOAuth2AccessToken.getOpenId();

        log.info("【微信网页授权】openid: {}", openid);

        return "redirect:" + returnUrl + "?openid=" + openid;
    }

    @GetMapping("qrAuthorize")
    public String qrAuthorize(@RequestParam("returnUrl") String returnUrl) {
        String url = projectUrlConfig.getWechatOpenAuthorize() + "/sell/wechat/qrUserInfo";
        String redirectUrl = wxOpenService.buildQrConnectUrl(url, WxConsts.QrConnectScope.SNSAPI_LOGIN, URLEncoder.encode(returnUrl));

        log.info("【微信网页授权】 获取code, result: {}", redirectUrl);

        return "redirect:" + redirectUrl;
    }


    @GetMapping("qrUserInfo")
    public String qrUserInfo(@RequestParam("code") String code,
                             @RequestParam("state") String returnUrl) {

        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxOpenService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】 {}", e);
            throw new SellException(ResultEnum.WX_MP_ERROR.getCode(), e.getMessage());
        }

        log.info("wxMpOAuth2AccessToken: {}", wxMpOAuth2AccessToken);
        String openid = wxMpOAuth2AccessToken.getOpenId();

        log.info("【微信网页授权】openid: {}", openid);

        return "redirect:" + returnUrl + "?openid=" + openid;

    }

}
