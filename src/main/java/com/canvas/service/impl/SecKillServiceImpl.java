package com.canvas.service.impl;

import com.canvas.exception.SellException;
import com.canvas.service.RedisLock;
import com.canvas.service.SecKillService;
import com.canvas.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SecKillServiceImpl implements SecKillService {

    @Autowired
    private RedisLock redisLock;

    private static final int TIMEOUT = 10 * 1000;

    /**
     * 中秋活动 秒杀月饼 限量100000
     */
    static Map<String, Integer> products;
    static Map<String, Integer> stock;
    static Map<String, String> orders;

    static {
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("abc123456", 100000);
        stock.put("abc123456", 100000);
    }

    private String queryMap(String productId) {
        return "中秋活动，月饼特价，限量份"
                + products.get(productId)
                + " 还剩：" + stock.get(productId) + " 份"
                + " 该商品成功下单用户数目："
                + orders.size() + " 人";
    }


    @Override
    public String querySecKillProductInfo(String productId) {
        return queryMap(productId);
    }

    /**
     * 描述逻辑
     *
     * @param productId
     */

    @Override
    public void  orderProductMockDiffUser(String productId) {

        // 加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(productId, String.valueOf(time))) {
            throw new SellException(101, "请换个姿势，再试试...");
        }

        // 1.查询商品库存, 为0则活动结束
        int stockNum = stock.get(productId);
        if (stockNum == 0) {
            //库存不足
            throw new SellException(100, "活动已经结束,请下次参与");
        } else {
            // 2.下单(模拟不同用户openid不同)
            orders.put(KeyUtil.genUniqueKey(), productId);
            // 3.减库存
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

        // 解锁
        redisLock.unlock(productId, String.valueOf(time));

    }


//    @Override
//    public void orderProductMockDiffUser(String productId) {
//        long time = System.currentTimeMillis() + TIMOUT;
//        if (!redisLock.lock(productId, String.valueOf(time))) {
//            throw new SellException(110, "没抢到，换个姿势再试一遍呀");
//        }
//
//        int stockNum = stock.get(productId);
//        if (stockNum == 0) {
//            //库存不足
//            throw new SellException(100, "活动已经结束,请留意下次活动");
//        } else {
//
//            orders.put(KeyUtil.genUniqueKey(), productId);
//            stockNum = stockNum - 1;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//            stock.put(productId, stockNum);
//        }
//
//        redisLock.unlock(productId, String.valueOf(time));
//    }


    /*@Override
    public synchronized void  orderProductMockDiffUser(String productId) {

        int stockNum = stock.get(productId);
        if (stockNum == 0) {
            //库存不足
            throw new SellException(100, "活动已经结束,请留意下次活动");
        } else {

            orders.put(KeyUtil.genUniqueKey(), productId);
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

    }*/
}
