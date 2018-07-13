package com.canvas.service.impl;

import com.canvas.enums.ResultEnum;
import com.canvas.exception.SellException;
import com.canvas.pojo.SellerInfo;
import com.canvas.repository.SellerInfoRepository;
import com.canvas.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 宗恣
 * @Date: 2018/7/13 0013 14:38
 */
@Service
@Slf4j
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {

        SellerInfo sellerInfo = repository.findByOpenid(openid);

//        if (null == sellerInfo) {
//            log.error("【】");
//            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
//        }

        return sellerInfo ;
    }


}
