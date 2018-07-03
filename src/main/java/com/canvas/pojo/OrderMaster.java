package com.canvas.pojo;

import com.canvas.enums.OrderStatusEnum;
import com.canvas.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 宗恣
 * @Date: 2018/7/3 0003 13:45
 */
@Entity
@Data
public class OrderMaster {

    /** 订单ID*/
    @Id
    private String  orderId;

    /** 买家名字*/
    private String  buyerName;

    /** 买家手机号*/
    private String  buyerPhone;

    /** 买家地址*/
    private String  buyerAddress;

    /** 买家微信Openid*/
    private String  buyerOpenid;

    /** 订单总金额*/
    private BigDecimal  orderAmount;

    /** 订单状态,默认为新下单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态,默认是0：未支付 1：已支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date  updateTime;

}
