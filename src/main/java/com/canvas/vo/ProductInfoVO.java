package com.canvas.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品详情
 * @Author: 宗恣
 * @Date: 2018/6/22 15:07
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = -2859630240649515833L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
