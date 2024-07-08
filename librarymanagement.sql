/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80037
 Source Host           : localhost:3306
 Source Schema         : librarymanagement

 Target Server Type    : MySQL
 Target Server Version : 80037
 File Encoding         : 65001

 Date: 08/07/2024 21:22:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bookID` int NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NOT NULL,
  `stock` int NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`bookID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '红楼梦', NULL, '曹雪芹', '古典文学', 19.99, 100, '2024-07-08 16:02:51', '2024-07-08 16:02:51');
INSERT INTO `book` VALUES (2, '西游记', NULL, '吴承恩', '古典文学', 18.99, 150, '2024-07-08 16:02:51', '2024-07-08 16:02:51');
INSERT INTO `book` VALUES (3, '三国演义', NULL, '罗贯中', '古典文学', 21.99, 116, '2024-07-08 16:02:51', '2024-07-08 16:02:51');
INSERT INTO `book` VALUES (4, '水浒传', NULL, '施耐庵', '古典文学', 20.99, 130, '2024-07-08 16:02:51', '2024-07-08 16:02:51');
INSERT INTO `book` VALUES (5, '骆驼祥子', NULL, '老舍', '现代文学', 15.99, 100, '2024-07-08 16:02:51', '2024-07-08 16:02:51');
INSERT INTO `book` VALUES (6, '围城', NULL, '钱钟书', '现代文学', 14.99, 90, '2024-07-08 16:02:51', '2024-07-08 16:02:51');
INSERT INTO `book` VALUES (7, '平凡的世界', NULL, '路遥', '现代文学', 25.99, 200, '2024-07-08 16:02:51', '2024-07-08 16:02:51');
INSERT INTO `book` VALUES (8, '活着', NULL, '余华', '现代文学', 17.99, 140, '2024-07-08 16:02:51', '2024-07-08 16:02:51');
INSERT INTO `book` VALUES (9, '长恨歌', NULL, '王安忆', '现代文学', 13.99, 80, '2024-07-08 16:02:51', '2024-07-08 16:02:51');
INSERT INTO `book` VALUES (10, '白夜行', NULL, '东野圭吾', '悬疑小说', 22.99, 100, '2024-07-08 16:02:51', '2024-07-08 16:02:51');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `totalPrice` decimal(10, 2) NOT NULL,
  `orderDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userID` int NULL DEFAULT NULL,
  PRIMARY KEY (`orderID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_orderitem_relation
-- ----------------------------
DROP TABLE IF EXISTS `order_orderitem_relation`;
CREATE TABLE `order_orderitem_relation`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `orderID` int NULL DEFAULT NULL,
  `orderItemID` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_orderitem_relation
-- ----------------------------

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `orderItemID` int NOT NULL AUTO_INCREMENT,
  `itemName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `quantity` int NOT NULL,
  `itemPrice` decimal(10, 2) NOT NULL,
  `totalPrice` decimal(10, 2) NULL DEFAULT NULL,
  `orderID` int NULL DEFAULT NULL,
  `bookID` int NULL DEFAULT NULL,
  PRIMARY KEY (`orderItemID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `roleID` int NOT NULL,
  `roleName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`roleID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '卖家');
INSERT INTO `role` VALUES (2, '买家');
INSERT INTO `role` VALUES (3, '管理员');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `balance` decimal(10, 2) NULL DEFAULT 0.00,
  `roleID` int NULL DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`userID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'asd', '123', 'http', 8372.74, 2, '2024-07-08 14:14:48', '2024-07-08 14:15:31');

SET FOREIGN_KEY_CHECKS = 1;
