/*
 Navicat Premium Data Transfer

 Source Server         : mySql
 Source Server Type    : MySQL
 Source Server Version : 50530
 Source Host           : localhost:3306
 Source Schema         : wechat

 Target Server Type    : MySQL
 Target Server Version : 50530
 File Encoding         : 65001

 Date: 09/07/2018 22:42:09
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
INSERT INTO `order_detail` VALUES ('123456788', '11111', '111123', '牛奶', 3.30, 2, 'www.baidu.com', '2018-07-03 16:32:35', '2018-07-03 16:32:35');
INSERT INTO `order_detail` VALUES ('123456789', '11111', '111124', '椰子', 2.30, 2, 'www.baidu.com', '2018-07-03 16:25:52', '2018-07-03 16:25:52');
INSERT INTO `order_detail` VALUES ('1530934898613643806', '1530934898528484349', '456789', '棒棒糖', 2.30, 1, 'http://www.baidu.com', '2018-06-22 22:36:34', '2018-06-22 22:36:34');
INSERT INTO `order_detail` VALUES ('1530935388516613180', '1530935388433249277', '456789', '棒棒糖', 2.30, 1, 'http://www.baidu.com', '2018-06-22 22:36:34', '2018-06-22 22:36:34');
INSERT INTO `order_detail` VALUES ('1530935388537545455', '1530935388433249277', '987654', '小米粥', 4.30, 2, 'http://www.baidu.com', '2018-06-22 22:35:31', '2018-06-22 22:35:31');
INSERT INTO `order_detail` VALUES ('1530951270271174776', '1530951270255107714', '456789', '棒棒糖', 2.30, 1, 'http://www.baidu.com', '2018-06-22 22:36:34', '2018-06-22 22:36:34');
INSERT INTO `order_detail` VALUES ('1530951270295981015', '1530951270255107714', '987654', '小米粥', 4.30, 2, 'http://www.baidu.com', '2018-06-22 22:35:31', '2018-06-22 22:35:31');
INSERT INTO `order_detail` VALUES ('1530975576203630900', '1530975576186240045', '456789', '棒棒糖', 2.30, 1, 'http://www.baidu.com', '2018-06-22 22:36:34', '2018-06-22 22:36:34');
INSERT INTO `order_detail` VALUES ('1530975576225257334', '1530975576186240045', '987654', '小米粥', 4.30, 2, 'http://www.baidu.com', '2018-06-22 22:35:31', '2018-06-22 22:35:31');
INSERT INTO `order_detail` VALUES ('1530975628832549145', '1530975628821839019', '456789', '棒棒糖', 2.30, 1, 'http://www.baidu.com', '2018-06-22 22:36:34', '2018-06-22 22:36:34');
INSERT INTO `order_detail` VALUES ('1530975628857276154', '1530975628821839019', '987654', '小米粥', 4.30, 2, 'http://www.baidu.com', '2018-06-22 22:35:31', '2018-06-22 22:35:31');
INSERT INTO `order_detail` VALUES ('1530980880087213690', '1530980880010678233', '456789', '棒棒糖', 2.30, 2, 'http://www.baidu.com', '2018-06-22 22:36:34', '2018-06-22 22:36:34');
INSERT INTO `order_detail` VALUES ('1530981001196116281', '1530981001192300769', '987654', '小米粥', 4.30, 2, 'http://www.baidu.com', '2018-06-22 22:35:31', '2018-06-22 22:35:31');
INSERT INTO `order_detail` VALUES ('1530981321631701157', '1530981321200413798', '987654', '小米粥', 4.30, 2, 'http://www.baidu.com', '2018-06-22 22:35:31', '2018-06-22 22:35:31');

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
INSERT INTO `order_master` VALUES ('1530934898528484349', '飞', '12345', '天', '12345467', 2.30, 0, 0, '2018-07-07 11:41:38', '2018-07-07 11:41:38');
INSERT INTO `order_master` VALUES ('1530935388433249277', '飞', '12345', '天', '12345467', 10.90, 0, 1, '2018-07-07 11:49:48', '2018-07-07 23:34:46');
INSERT INTO `order_master` VALUES ('1530951270255107714', '飞', '12345', '天', '12345467', 10.90, 0, 0, '2018-07-07 11:49:48', '2018-07-07 11:49:48');
INSERT INTO `order_master` VALUES ('1530975576186240045', '飞', '12345', '天', '12345467', 10.90, 0, 0, '2018-07-07 11:49:48', '2018-07-07 11:49:48');
INSERT INTO `order_master` VALUES ('1530975628821839019', '飞', '12345', '天', '12345467', 10.90, 0, 0, '2018-07-07 11:49:48', '2018-07-07 11:49:48');
INSERT INTO `order_master` VALUES ('1530980880010678233', '张三', '18868822111', '慕课网总部', 'ew3euwhd7sjw9diwkq', 4.60, 0, 0, '2018-07-08 00:28:00', '2018-07-08 00:28:00');
INSERT INTO `order_master` VALUES ('1530981001192300769', '张三', '18868822111', '慕课网总部', 'ew3euwhd7sjw9diwkq', 8.60, 2, 0, '2018-07-08 00:30:01', '2018-07-08 00:30:01');
INSERT INTO `order_master` VALUES ('1530981321200413798', '张三', '18868822111', '慕课网总部', 'ew3euwhd7sjw9diwkq', 8.60, 0, 0, '2018-07-08 00:35:21', '2018-07-08 00:35:21');
INSERT INTO `order_master` VALUES ('456788', '粽子', '12345678911', '汉界', 'abc123', 3.15, 0, 0, '2018-07-07 10:03:17', '2018-07-07 10:03:17');

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
INSERT INTO `product_info` VALUES ('123456', '椰子', 2.30, 100, '很喝噢噢噢噢', 'http://www.baidu.com', 0, 2, '2018-06-22 22:37:24', '2018-06-22 22:37:24');
INSERT INTO `product_info` VALUES ('132456', '柠檬茶', 10.90, 140, '很喝噢噢噢噢', 'http://www.baidu.com', 0, 3, '2018-06-22 22:45:03', '2018-06-22 22:45:03');
INSERT INTO `product_info` VALUES ('456789', '棒棒糖', 2.30, 95, '很好吃呵呵呵', 'http://www.baidu.com', 0, 1, '2018-06-22 22:36:34', '2018-06-22 22:36:34');
INSERT INTO `product_info` VALUES ('987654', '小米粥', 4.30, 94, '很好喝啊啊啊啊', 'http://www.baidu.com', 0, 1, '2018-06-22 22:35:31', '2018-06-22 22:35:31');

SET FOREIGN_KEY_CHECKS = 1;
