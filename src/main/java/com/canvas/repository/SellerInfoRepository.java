package com.canvas.repository;

import com.canvas.pojo.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 宗恣
 * @Date: 2018/7/13 0013 14:28
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);

}
