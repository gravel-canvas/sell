/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50530
 Source Host           : localhost:3306
 Source Schema         : wechat

 Target Server Type    : MySQL
 Target Server Version : 50530
 File Encoding         : 65001

 Date: 12/07/2018 17:31:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情ID',
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(8, 2) NOT NULL,
  `product_quantity` int(11) NOT NULL,
  `product_icon` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('123456788', '456788', '111123', '牛奶', 3.30, 2, 'www.baidu.com', '2018-07-03 16:32:35', '2018-07-11 11:16:48');
INSERT INTO `order_detail` VALUES ('123456789', '456788', '111124', '椰子', 2.30, 2, 'www.baidu.com', '2018-07-03 16:25:52', '2018-07-11 11:16:50');
INSERT INTO `order_detail` VALUES ('1531280321782461247', '1531280321735599372', '456789', '棒棒糖', 2.30, 1, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923946760.jpg', '2018-06-22 22:36:34', '2018-07-10 15:11:29');
INSERT INTO `order_detail` VALUES ('1531280321794275966', '1531280321735599372', '987654', '小米粥', 4.30, 2, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923715466.jpg', '2018-06-22 22:35:31', '2018-07-10 15:11:30');
INSERT INTO `order_detail` VALUES ('1531364930382229294', '1531364930330624198', '456789', '棒棒糖', 2.30, 1, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923946760.jpg', '2018-06-22 22:36:34', '2018-07-10 15:11:29');
INSERT INTO `order_detail` VALUES ('1531364930396490396', '1531364930330624198', '987654', '小米粥', 4.30, 2, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923715466.jpg', '2018-06-22 22:35:31', '2018-07-10 15:11:30');
INSERT INTO `order_detail` VALUES ('1531364989018643578', '1531364988966729784', '456789', '棒棒糖', 2.30, 1, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923946760.jpg', '2018-06-22 22:36:34', '2018-07-10 15:11:29');
INSERT INTO `order_detail` VALUES ('1531364989032228769', '1531364988966729784', '987654', '小米粥', 4.30, 2, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923715466.jpg', '2018-06-22 22:35:31', '2018-07-10 15:11:30');
INSERT INTO `order_detail` VALUES ('1531365560986610563', '1531365560939590340', '456789', '棒棒糖', 2.30, 1, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923946760.jpg', '2018-06-22 22:36:34', '2018-07-10 15:11:29');
INSERT INTO `order_detail` VALUES ('1531365561003256659', '1531365560939590340', '987654', '小米粥', 4.30, 2, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923715466.jpg', '2018-06-22 22:35:31', '2018-07-10 15:11:30');
INSERT INTO `order_detail` VALUES ('1531365640006209975', '1531365639952303420', '456789', '棒棒糖', 2.30, 1, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923946760.jpg', '2018-06-22 22:36:34', '2018-07-10 15:11:29');
INSERT INTO `order_detail` VALUES ('1531365640019860214', '1531365639952303420', '987654', '小米粥', 4.30, 2, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923715466.jpg', '2018-06-22 22:35:31', '2018-07-10 15:11:30');
INSERT INTO `order_detail` VALUES ('1531372584978301209', '1531372584925865304', '456789', '棒棒糖', 2.30, 1, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923946760.jpg', '2018-06-22 22:36:34', '2018-07-10 15:11:29');
INSERT INTO `order_detail` VALUES ('1531372584993160120', '1531372584925865304', '987654', '小米粥', 4.30, 2, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923715466.jpg', '2018-06-22 22:35:31', '2018-07-10 15:11:30');
INSERT INTO `order_detail` VALUES ('1531372624486144153', '1531372624435192360', '456789', '棒棒糖', 2.30, 1, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923946760.jpg', '2018-06-22 22:36:34', '2018-07-10 15:11:29');
INSERT INTO `order_detail` VALUES ('1531372624499604628', '1531372624435192360', '987654', '小米粥', 4.30, 2, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923715466.jpg', '2018-06-22 22:35:31', '2018-07-10 15:11:30');
INSERT INTO `order_detail` VALUES ('1531372645585153290', '1531372645539895320', '456789', '棒棒糖', 2.30, 1, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923946760.jpg', '2018-06-22 22:36:34', '2018-07-10 15:11:29');
INSERT INTO `order_detail` VALUES ('1531372645603540554', '1531372645539895320', '987654', '小米粥', 4.30, 2, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923715466.jpg', '2018-06-22 22:35:31', '2018-07-10 15:11:30');
INSERT INTO `order_detail` VALUES ('1531372670550859945', '1531372670502147650', '456789', '棒棒糖', 2.30, 1, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923946760.jpg', '2018-06-22 22:36:34', '2018-07-10 15:11:29');
INSERT INTO `order_detail` VALUES ('1531372670565921598', '1531372670502147650', '987654', '小米粥', 4.30, 2, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923715466.jpg', '2018-06-22 22:35:31', '2018-07-10 15:11:30');
INSERT INTO `order_detail` VALUES ('1531372697124249777', '1531372697074686652', '456789', '棒棒糖', 2.30, 1, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923946760.jpg', '2018-06-22 22:36:34', '2018-07-10 15:11:29');
INSERT INTO `order_detail` VALUES ('1531372697138809214', '1531372697074686652', '987654', '小米粥', 4.30, 2, 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923715466.jpg', '2018-06-22 22:35:31', '2018-07-10 15:11:30');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家姓名',
  `buyer_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '订单状态(0：新下单)',
  `pay_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '支付状态(0：未支付)',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `idx_buyer_openid`(`buyer_openid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1531280321735599372', '飞', '12345', '天', 'o7rsq1WomNumGzazc8yVSwHgvCr0', 10.90, 0, 0, '2018-07-12 09:41:39', '2018-07-12 09:41:44');
INSERT INTO `order_master` VALUES ('1531364930330624198', '木鱼', '12345', '南天门', '12345467', 10.90, 2, 0, '2018-07-12 11:19:44', '2018-07-12 11:19:44');
INSERT INTO `order_master` VALUES ('1531364988966729784', '玫瑰', '12345', '沙漠', '12345467', 10.90, 0, 0, '2018-07-12 11:19:44', '2018-07-12 11:19:44');
INSERT INTO `order_master` VALUES ('1531365560939590340', '白鸽', '12345', '广场', '12345467', 10.90, 0, 0, '2018-07-12 11:19:44', '2018-07-12 11:19:44');
INSERT INTO `order_master` VALUES ('1531365639952303420', '青鸟', '12345', '橄榄枝', '12345467', 10.90, 1, 0, '2018-07-12 11:20:40', '2018-07-12 15:08:58');
INSERT INTO `order_master` VALUES ('1531372584925865304', '白马', '12345', '非马', '12345467', 10.90, 2, 0, '2018-07-12 13:16:25', '2018-07-12 13:16:25');
INSERT INTO `order_master` VALUES ('1531372624435192360', '墨河', '12345', '澜沧江', '12345467', 10.90, 2, 0, '2018-07-12 13:17:04', '2018-07-12 13:17:04');
INSERT INTO `order_master` VALUES ('1531372645539895320', '绝壁', '12345', '黄山', '12345467', 10.90, 2, 0, '2018-07-12 13:17:25', '2018-07-12 13:17:25');
INSERT INTO `order_master` VALUES ('1531372670502147650', '秀木', '12345', '甲天下', '12345467', 10.90, 2, 0, '2018-07-12 13:17:50', '2018-07-12 13:17:50');
INSERT INTO `order_master` VALUES ('1531372697074686652', '晚宴', '12345', '咸阳宫', '12345467', 10.90, 2, 0, '2018-07-12 13:18:17', '2018-07-12 13:18:17');
INSERT INTO `order_master` VALUES ('456788', '粽子', '12345678911', '汉界', 'abc123', 3.15, 0, 0, '2018-07-12 09:41:45', '2018-07-12 09:41:48');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `category_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类目名称',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `uqe_category_type`(`category_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (2, '男生最爱', 2, '2018-06-22 22:26:47', '2018-06-22 22:26:47');
INSERT INTO `product_category` VALUES (3, '女人最爱', 1, '2018-06-22 22:28:04', '2018-06-22 22:28:04');
INSERT INTO `product_category` VALUES (5, '精选榜', 3, '2018-06-22 22:31:05', '2018-06-22 22:31:05');
INSERT INTO `product_category` VALUES (6, '热销榜', 4, '2018-06-22 22:46:05', '2018-06-22 22:46:05');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '产品ID',
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '价格',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '小图',
  `product_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '商品状态 0：在架 1：下架',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('123456', '椰子', 2.30, 100, '很喝噢噢噢噢', 'http://images.cad.com.cn/2018/0708/thumb_375_250_1531007259312.jpg', 0, 2, '2018-06-22 22:37:24', '2018-07-10 15:10:58');
INSERT INTO `product_info` VALUES ('132456', '柠檬茶', 10.90, 140, '很喝噢噢噢噢', 'http://images.cad.com.cn/2018/0709/thumb_375_250_1531106893690.jpg', 0, 3, '2018-06-22 22:45:03', '2018-07-10 15:11:10');
INSERT INTO `product_info` VALUES ('456789', '棒棒糖', 2.30, 96, '很好吃呵呵呵', 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923946760.jpg', 0, 1, '2018-06-22 22:36:34', '2018-07-10 15:11:29');
INSERT INTO `product_info` VALUES ('987654', '小米粥', 4.30, 92, '很好喝啊啊啊啊', 'http://images.cad.com.cn/2018/0707/thumb_375_250_1530923715466.jpg', 0, 1, '2018-06-22 22:35:31', '2018-07-10 15:11:30');

SET FOREIGN_KEY_CHECKS = 1;
