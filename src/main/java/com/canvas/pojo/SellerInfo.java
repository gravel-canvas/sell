package com.canvas.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: 宗恣
 * @Date: 2018/7/13 0013 14:25
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

    private Date    createTime;

    private Date    updateTime;

}
