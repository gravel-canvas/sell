package com.canvas.service.impl;

import com.canvas.dto.CartDTO;
import com.canvas.enums.ProductStatusEnum;
import com.canvas.enums.ResultEnum;
import com.canvas.exception.SellException;
import com.canvas.pojo.ProductInfo;
import com.canvas.repository.ProductInfoRepository;
import com.canvas.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 宗恣
 * @Date: 2018/6/22 13:44
 */
@Service
@Slf4j
//@CacheConfig(cacheNames = "product")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
//    @Cacheable(key = "123")
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
//    @CachePut(key = "123")
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (null == productInfo) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (null == productInfo) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw  new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);

        if (null == productId) {
            log.error("【卖家修改商品状态】商品不存在, productId: {}", productId);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            log.error("【卖家修改商品状态】商品状态不正确, productId: {}", productId);
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        ProductInfo result = repository.save(productInfo);

        return result;
        }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);

        if (null == productId) {
            log.error("【卖家修改商品状态】商品不存在, productId: {}", productId);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            log.error("【卖家修改商品状态】商品状态不正确, productId: {}", productId);
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());

        ProductInfo result = repository.save(productInfo);

        return result;
    }

}
