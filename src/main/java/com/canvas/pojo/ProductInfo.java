package com.canvas.pojo;

import com.canvas.enums.ProductStatusEnum;
import com.canvas.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * @Author: 宗恣
 * @Date: 2018/6/22 12:42
 */

@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    /** 产品ID*/
    @Id
    private String      productId;

    /** 商品名称*/
    private String      productName;

    /** 价格*/
    private BigDecimal productPrice;

    /** 库存*/
    private Integer     productStock;

    /** 描述*/
    private String      productDescription;

    /** 小图*/
    private String      productIcon;

    /** 商品状态，0：正常 1：下架*/
    private Integer     productStatus = ProductStatusEnum.UP.getCode();

    /** 类目编号*/
    private Integer      categoryType;

    /** 创建时间*/
    private Date        createTime;

    /** 更新时间*/
    private Date        updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }



}
