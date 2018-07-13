package com.canvas.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 类目表
 * @Author: 宗恣
 * @Date: 2018/6/22 9:32
 * 假如表明有前缀  如：t_product_category  需使用 @Table注解
 * @DynamicUpdate 自动更新时间
 */
// @Table(name = "t_product_category")
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    /** 类目ID*/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名称*/
    private String  categoryName;

    /** 类目编号*/
    private Integer categoryType;

    /** 创建时间*/
    private Date    createTime;

    /** 更新时间*/
    private Date    updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
