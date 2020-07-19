/*
 Navicat Premium Data Transfer

 Source Server         : yuanzhisheng
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : wjfnews

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 15/04/2020 21:38:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cateId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` int(11) NULL DEFAULT NULL,
  `createOn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `newsOffOn` int(11) NULL DEFAULT NULL,
  `newsSort` int(11) NULL DEFAULT NULL,
  `newsStatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateBy` int(11) NULL DEFAULT NULL,
  `updateOn` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (28, '韦鉴峰', '游戏测评', '刺客信条真的*b', NULL, NULL, 1, 1, '开', 'http://47.93.234.52:80/img/78cef2b3-f6a5-4f55-a942-6523f4d4df55.png', '没有备注', '没有摘要', '这是一篇测评', NULL, NULL);
INSERT INTO `news` VALUES (29, '大神', '游戏攻略', '攻略攻略攻略', NULL, NULL, 1, 2, '开', 'http://47.93.234.52:80/img/fd75047e-cc7d-4bf1-aa14-35cbcd40ad7d.png', '高玩必备', '数据文章', '攻略', NULL, NULL);
INSERT INTO `news` VALUES (30, '韦鉴峰', '游戏杂谈', '混混混混混混混混混混混混混混混混', NULL, NULL, 1, 3, '开', 'http://47.93.234.52:80/img/17ddcd65-1d43-4cdb-be8f-67fc9598c58d.png', '混', '一个字', '论路人的养成', NULL, NULL);
INSERT INTO `news` VALUES (31, '韦鉴峰', '游戏实况', '6666666666666666666666666666666666666666', NULL, NULL, 1, 4, '开', 'http://47.93.234.52:80/img/cb5c7e22-5319-4e00-9b5c-43089ea65d7f.png', '没有', '随便吧', '黑暗之魂', NULL, NULL);
INSERT INTO `news` VALUES (32, '韦鉴峰', '游戏推荐', '66666666666666666666666666666666', NULL, NULL, 1, 5, '1', 'http://47.93.234.52:80/img/72d1d68b-a6b4-4dd4-8671-a1260a7e93b1.png', '没有', '懒得写', '推荐环节', NULL, NULL);
INSERT INTO `news` VALUES (33, '测试', '游戏攻略', '测试测试测试测试测试测试测试测试测试测试', NULL, NULL, 1, 5, '测试', 'http://47.93.234.52:80/img/461aa4d4-9b2f-4af8-b05e-45d7a299feef.png', '测试', '测试', '测试', NULL, NULL);
INSERT INTO `news` VALUES (34, '测试', '游戏实况', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', NULL, NULL, 1, 1, '1', 'http://47.93.234.52:80/img/9ecbf4eb-2911-4683-88c4-f5786c667f8a.png', '测试', '测试', '测试', NULL, NULL);
INSERT INTO `news` VALUES (35, '测试', '游戏测评', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', NULL, NULL, 1, 12, '测试测试测试测试', NULL, '测试', '测试', '测试', NULL, NULL);
INSERT INTO `news` VALUES (36, '测试', '游戏攻略', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', NULL, NULL, 1, 22, '测试测试测试', NULL, '测试', '测试', '测试', NULL, NULL);
INSERT INTO `news` VALUES (37, '测试测试测试测试测试测试测试测试', '游戏推荐', '测试', NULL, NULL, 1, 111, '测试测试测试', 'http://47.93.234.52:80/img/39e86e6f-6d43-4626-a3f8-5613cab5253a.png', '测试测试测试测试', '测试测试测试测试测试测试测试测试测试测试测试', '测试测试测试', NULL, NULL);
INSERT INTO `news` VALUES (38, '游戏实况', '游戏实况', '游戏实况游戏实况游戏实况游戏实况游戏实况游戏实况游戏实况游戏实况', NULL, '2020-04-16 00:00:00.000000', 1, 99, '游戏实况', NULL, '游戏实况', '游戏实况', '游戏实况', NULL, NULL);
INSERT INTO `news` VALUES (39, '游戏测评', '游戏测评', '游戏测评游戏测评游戏测评游戏测评游戏测评游戏测评游戏测评游戏测评游戏测评游戏测评', NULL, '2020-04-21 00:00:00.000000', 1, 1111, '11', 'http://47.93.234.52:80/img/b800416b-a6db-4735-8320-c0cc1ebfc0ca.png', '游戏测评', '游戏测评', '游戏测评', NULL, NULL);
INSERT INTO `news` VALUES (40, '123123', '游戏推荐', '123213', NULL, '2020-04-15 18:14:58', 1, 12312, '12313', 'http://47.93.234.52:80/img/b969c30d-2066-4d03-922d-26ff425fac69.png', '213123', '123', '1321', NULL, '');

-- ----------------------------
-- Table structure for newscate
-- ----------------------------
DROP TABLE IF EXISTS `newscate`;
CREATE TABLE `newscate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cateDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cateName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cateOffOn` int(11) NULL DEFAULT NULL,
  `cateSort` int(11) NULL DEFAULT NULL,
  `cateStatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` int(11) NULL DEFAULT NULL,
  `createOn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateBy` int(11) NULL DEFAULT NULL,
  `updateOn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of newscate
-- ----------------------------
INSERT INTO `newscate` VALUES (6, '字面意思', '游戏杂谈', 1, 1, '开', NULL, NULL, NULL, NULL);
INSERT INTO `newscate` VALUES (7, '就是攻略', '游戏攻略', 1, 2, '开', NULL, NULL, NULL, NULL);
INSERT INTO `newscate` VALUES (8, '测评', '游戏测评', 1, 3, '1', NULL, NULL, NULL, NULL);
INSERT INTO `newscate` VALUES (9, '游戏', '游戏推荐', 1, 4, '开', NULL, NULL, NULL, NULL);
INSERT INTO `newscate` VALUES (10, '实况', '游戏实况', 1, 5, '开', NULL, NULL, NULL, NULL);
INSERT INTO `newscate` VALUES (11, '测试', '测试', 1, 111, '测试', 111, '2020-04-15 18:30:40', NULL, '');

-- ----------------------------
-- Table structure for newscomment
-- ----------------------------
DROP TABLE IF EXISTS `newscomment`;
CREATE TABLE `newscomment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `updateOn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `commentOnOff` int(11) NULL DEFAULT NULL,
  `commentSort` int(11) NULL DEFAULT NULL,
  `commentStatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` int(11) NULL DEFAULT NULL,
  `createOn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fromIp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idOfNews` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateBy` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of newscomment
-- ----------------------------
INSERT INTO `newscomment` VALUES (21, NULL, '韦鉴峰', NULL, NULL, NULL, '66666666', NULL, NULL, NULL, 28, NULL, NULL);
INSERT INTO `newscomment` VALUES (22, NULL, '韦鉴峰', 1, NULL, NULL, '66666666', NULL, NULL, NULL, 28, NULL, NULL);
INSERT INTO `newscomment` VALUES (23, NULL, '韦鉴峰', 1, NULL, NULL, '66666666', NULL, NULL, NULL, 28, NULL, NULL);
INSERT INTO `newscomment` VALUES (24, '', '111', 1, 111, '111', '111', 11, '2020-04-15 18:31:39', '111', 28, '111', NULL);

SET FOREIGN_KEY_CHECKS = 1;
