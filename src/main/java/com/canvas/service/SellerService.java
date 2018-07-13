package com.canvas.service;

import com.canvas.pojo.SellerInfo;

/**
 * @Author: 宗恣
 * @Date: 2018/7/13 0013 14:36
 */
public interface SellerService {

    /**
     * 通过openid查询卖家用户
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);

}
