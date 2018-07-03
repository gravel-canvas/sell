package com.canvas.service.impl;

import com.canvas.dto.OrderDTO;
import com.canvas.enums.ResultEnum;
import com.canvas.exception.SellException;
import com.canvas.pojo.OrderDetail;
import com.canvas.pojo.OrderMaster;
import com.canvas.pojo.ProductInfo;
import com.canvas.repository.OrderDetailRepository;
import com.canvas.repository.OrderMasterRepository;
import com.canvas.service.OrderService;
import com.canvas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author: 宗恣
 * @Date: 2018/7/3 0003 16:54
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository   orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        // 1.查询商品（数量，价格）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (null == productInfo) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            // 2. 计算总价
            orderAmount = orderDetail.getProductPrice()
                                     .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                                     .add(orderAmount);

            // 3. 写入订单数据库（orderMaster和orderDetail）
            orderDetail.setDetailId("");
            orderDetail.setOrderId("");

            orderDetailRepository.save(orderDetail);





        }


        // 4. 减库存

        return null;
    }

    @Override
    public OrderMaster findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
