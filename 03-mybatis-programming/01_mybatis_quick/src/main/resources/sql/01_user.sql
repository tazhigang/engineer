/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : mybatis_dev

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2020-11-03 14:13:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for 01_user
-- ----------------------------
DROP TABLE IF EXISTS `01_user`;
CREATE TABLE `01_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 01_user
-- ----------------------------
INSERT INTO `01_user` VALUES ('1', 'ittzg', 'tzg', '1', '13212311222', 'tazhigang095@163.com', '');