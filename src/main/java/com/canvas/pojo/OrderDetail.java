package com.canvas.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 宗恣
 * @Date: 2018/7/3 0003 14:22
 */
@Entity
@Data
public class OrderDetail {

    /** */
    @Id
    private String  detailId;

    /** 订单ID*/
    private String  orderId;

    /** 商品ID*/
    private String  productId;

    /** 商品名称*/
    private String  productName;

    /** 商品单价*/
    private BigDecimal  productPrice;

    /** 商品数量*/
    private Integer productQuantity;

    /** 商品小图*/
    private String  productIcon;

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date  updateTime;

}
