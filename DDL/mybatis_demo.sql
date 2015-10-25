/*
Navicat MySQL Data Transfer

Source Server         : localhost3306
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-10-25 18:11:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `price` float(10,1) DEFAULT NULL,
  `detail` text,
  `pic` varchar(512) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', 'prod1', '10.0', null, null, '2015-10-25 10:23:07');
INSERT INTO `items` VALUES ('2', 'prod2', '20.0', null, null, '2015-10-25 10:23:23');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_id` int(11) DEFAULT NULL,
  `items_id` int(11) DEFAULT NULL,
  `items_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', '1', '1', '1');
INSERT INTO `orderdetail` VALUES ('2', '2', '1', '2');
INSERT INTO `orderdetail` VALUES ('3', '2', '2', '1');
INSERT INTO `orderdetail` VALUES ('4', '3', '2', '3');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `number` varchar(32) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '1000010', '2015-10-21 09:44:56', null);
INSERT INTO `orders` VALUES ('2', '1', '1000011', '2015-10-22 09:45:17', null);
INSERT INTO `orders` VALUES ('3', '2', '1000012', '2015-10-24 09:45:35', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `birthday` date DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'liw', '2015-09-09', '1', '上海');
INSERT INTO `user` VALUES ('2', 'Tom', '2015-09-01', '1', '北京');
INSERT INTO `user` VALUES ('3', 'Jack', '2015-09-03', '1', '南京');
INSERT INTO `user` VALUES ('4', 'Apple', '2015-09-07', '0', '上海');
INSERT INTO `user` VALUES ('6', '王小五', '2015-09-27', '0', '河南');
INSERT INTO `user` VALUES ('7', '王小五', '2015-09-27', '1', '河南');
INSERT INTO `user` VALUES ('9', '王小七', '2015-10-01', '1', '河南');
