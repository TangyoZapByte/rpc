/*
 Navicat Premium Data Transfer

 Source Server         : linux-tangyizuo
 Source Server Type    : MySQL
 Source Server Version : 80037 (8.0.37)
 Source Host           : 192.168.20.128:3306
 Source Schema         : hundsun_fsms

 Target Server Type    : MySQL
 Target Server Version : 80037 (8.0.37)
 File Encoding         : 65001

 Date: 25/08/2024 12:22:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `account_id` int NOT NULL AUTO_INCREMENT COMMENT '账户id，主键',
  `customer_id` int NOT NULL COMMENT '用户id，外键，引用customer',
  `create_date` datetime NOT NULL COMMENT '账户建立日期',
  `account_risk_level` int NOT NULL COMMENT '账户风险等级',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账户状态',
  PRIMARY KEY (`account_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 1, '2024-08-22 17:27:45', 1, '0');

-- ----------------------------
-- Table structure for creditcard
-- ----------------------------
DROP TABLE IF EXISTS `creditcard`;
CREATE TABLE `creditcard`  (
  `creditcard_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '银行卡id',
  `account_id` int NOT NULL COMMENT '账户id',
  `bank` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '银行名称',
  `balance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '余额',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`creditcard_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of creditcard
-- ----------------------------

-- ----------------------------
-- Table structure for creditcardrecord
-- ----------------------------
DROP TABLE IF EXISTS `creditcardrecord`;
CREATE TABLE `creditcardrecord`  (
  `record_id` int NOT NULL AUTO_INCREMENT COMMENT '银行卡记录id',
  `creditcard_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '银行卡id',
  `creditcard_record_date` datetime NOT NULL COMMENT '银行卡记录日期',
  `creditcard_record_type` int NOT NULL COMMENT '银行卡记录类型',
  `creditcard_record_amount` decimal(10, 2) NOT NULL COMMENT '银行卡记录金额',
  `balance_before` decimal(10, 2) NOT NULL COMMENT '之前余额',
  `balance_after` decimal(10, 2) NOT NULL COMMENT '之后余额',
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of creditcardrecord
-- ----------------------------

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customer_id` int NOT NULL AUTO_INCREMENT COMMENT '客户id，主键',
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户姓名',
  `customer_type` int NOT NULL COMMENT '客户类型',
  `customer_idcard` int NOT NULL COMMENT '客户认证号码',
  `customer_idcard_type` int NOT NULL COMMENT '客户认证类型',
  `customer_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户联系反射方式',
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, 't', 0, 1, 0, '1');

-- ----------------------------
-- Table structure for dailyfundnav
-- ----------------------------
DROP TABLE IF EXISTS `dailyfundnav`;
CREATE TABLE `dailyfundnav`  (
  `nav_id` int NOT NULL AUTO_INCREMENT COMMENT '净值记录id',
  `fund_id` int NOT NULL COMMENT '产品id',
  `nav_date` datetime NOT NULL COMMENT '净值日期',
  `fund_nav` decimal(10, 2) NOT NULL COMMENT '产品净值',
  PRIMARY KEY (`nav_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dailyfundnav
-- ----------------------------

-- ----------------------------
-- Table structure for fund
-- ----------------------------
DROP TABLE IF EXISTS `fund`;
CREATE TABLE `fund`  (
  `fund_id` int NOT NULL COMMENT '\r\n基金id，主键',
  `fund_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '基金名称',
  `fund_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '基金类型',
  `fund_nav` decimal(10, 2) NOT NULL COMMENT '基金净值',
  `fund_est_date` datetime NOT NULL COMMENT '基金成立时间',
  `fund_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '\r\n基金代码（基于类型）',
  `fund_risk_level` int NOT NULL COMMENT '\r\n基金风险等级',
  `fund_manager_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '基金产品经理名称',
  `fund_state` int NOT NULL COMMENT '基金状态',
  PRIMARY KEY (`fund_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fund
-- ----------------------------

-- ----------------------------
-- Table structure for hold
-- ----------------------------
DROP TABLE IF EXISTS `hold`;
CREATE TABLE `hold`  (
  `hold_id` int NOT NULL AUTO_INCREMENT COMMENT '持有信息id',
  `account_id` int NOT NULL COMMENT '账户id',
  `fund_id` int NOT NULL COMMENT '基金id',
  `fund_share` int NOT NULL COMMENT '\r\n持有份额',
  PRIMARY KEY (`hold_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hold
-- ----------------------------

-- ----------------------------
-- Table structure for settlement
-- ----------------------------
DROP TABLE IF EXISTS `settlement`;
CREATE TABLE `settlement`  (
  `settlement_id` int NOT NULL COMMENT '清算id，主键',
  `settlement_date` datetime NOT NULL COMMENT '清算日期',
  `settlement_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '清算结果',
  `settlement_state` int NOT NULL COMMENT '清算状态',
  `user_id` int NOT NULL COMMENT '银行柜员id',
  PRIMARY KEY (`settlement_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of settlement
-- ----------------------------

-- ----------------------------
-- Table structure for sharerecord
-- ----------------------------
DROP TABLE IF EXISTS `sharerecord`;
CREATE TABLE `sharerecord`  (
  `record_id` int NOT NULL AUTO_INCREMENT COMMENT '份额记录id',
  `account_id` int NOT NULL COMMENT '账户id',
  `share_record_date` datetime NOT NULL COMMENT '份额记录日期',
  `share_record_type` int NOT NULL COMMENT '份额记录类型',
  `share_record_amount` int NOT NULL COMMENT '份额记录金额',
  `share_before` int NOT NULL COMMENT '之前份额',
  `share_after` int NOT NULL COMMENT '之后份额',
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sharerecord
-- ----------------------------

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction`  (
  `transaction_id` bigint NOT NULL AUTO_INCREMENT COMMENT '交易id，主键',
  `account_id` int NOT NULL COMMENT '账户id，外键，引用account',
  `fund_id` int NOT NULL COMMENT '基金id，外键，引用fund',
  `transaction_type` int NOT NULL COMMENT '交易类型（申购或者赎回）',
  `transaction_amount` decimal(10, 2) NOT NULL COMMENT '交易金额',
  `transaction_share` decimal(10, 2) NOT NULL COMMENT '交易份额',
  `transaction_date` datetime NOT NULL COMMENT '交易时间',
  `transaction_state` int NOT NULL COMMENT '交易状态',
  PRIMARY KEY (`transaction_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of transaction
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '银行柜员id，主键',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '银行柜员用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '银行柜员密码',
  `user_contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '银行柜员联系方式',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1234567891 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (123456789, 'tangyizuo', '123456', '13212345678');
INSERT INTO `user` VALUES (1234567890, 'Tangyizuo0', '123456', '12345678909');

SET FOREIGN_KEY_CHECKS = 1;
