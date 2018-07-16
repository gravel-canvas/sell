package com.canvas.vo;

import com.canvas.pojo.ProductInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品(包含类目)
 * @Author: 宗恣
 * @Date: 2018/6/22 15:03
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 6106224949569568747L;

    @JsonProperty("name")
    private String      categoryName;

    @JsonProperty("type")
    private Integer     categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
