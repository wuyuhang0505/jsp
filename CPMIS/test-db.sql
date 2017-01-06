/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test-db

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-08-30 11:32:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_num` varchar(20) DEFAULT NULL,
  `department_name` varchar(20) DEFAULT NULL,
  `department_chief` bigint(20) DEFAULT NULL,
  `department_chief_na` varchar(20) DEFAULT NULL,
  `department_post_count` int(11) DEFAULT NULL,
  `department_employee_count` int(11) DEFAULT NULL,
  `department_state` bit(1) DEFAULT NULL,
  `remark` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '1', '管理员', '1', 'admin', '4', '1', '', '');
INSERT INTO `department` VALUES ('2', '02', '武装部', null, null, '2', '1', '', '');
INSERT INTO `department` VALUES ('3', '03', '生活部', null, null, '2', '0', '', '');

-- ----------------------------
-- Table structure for `employ`
-- ----------------------------
DROP TABLE IF EXISTS `employ`;
CREATE TABLE `employ` (
  `employ_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) DEFAULT NULL,
  `applicant` varchar(20) DEFAULT NULL,
  `applicant_pwd` varchar(10) DEFAULT NULL,
  `employ_time` date DEFAULT NULL,
  `employ_grade` int(11) DEFAULT NULL,
  `interview_grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`employ_id`),
  KEY `FK_employe` (`post_id`),
  CONSTRAINT `FK_employe` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employ
-- ----------------------------
INSERT INTO `employ` VALUES ('1', '5', ' 安保', '78790', '2015-07-27', '23', '78');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `employee_num` varchar(20) DEFAULT NULL,
  `employee_pwd` varchar(20) DEFAULT NULL,
  `employee_name` varchar(20) DEFAULT NULL,
  `employee_sex` bit(1) DEFAULT NULL,
  `employee_edu` varchar(50) DEFAULT NULL,
  `employee_state` bit(1) DEFAULT NULL,
  `employee_tech_post` int(11) DEFAULT NULL,
  `employee_contract_time` date DEFAULT NULL,
  `employee_contract_length` int(11) DEFAULT NULL,
  `is_specialist` bit(1) DEFAULT NULL,
  `employee_address` varchar(255) DEFAULT NULL,
  `employee_age` int(11) DEFAULT NULL,
  `employee_idcard` bigint(20) DEFAULT NULL,
  `employee_nation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FK_subordinate` (`post_id`),
  KEY `FK_under` (`department_id`),
  CONSTRAINT `FK_subordinate` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`),
  CONSTRAINT `FK_under` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '1', '1', 'admin', '123456', 'admin', '', null, '', '1', null, null, '', null, null, null, null);
INSERT INTO `employee` VALUES ('2', '5', '2', '03', '123456', '逗比', '\0', '双方对符合', '', '0', '2015-07-27', '213', '\0', '湛江', '23', '43050936', '汉族');

-- ----------------------------
-- Table structure for `information`
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `inform_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) DEFAULT NULL,
  `inform_time` date DEFAULT NULL,
  `inform_title` varchar(50) DEFAULT NULL,
  `infrom_body` varchar(600) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `inform_body` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`inform_id`),
  KEY `FK_inform` (`employee_id`),
  CONSTRAINT `FK_inform` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('1', '1', '2015-08-14', 'hfh', null, 'admin', 'hgfhgff');

-- ----------------------------
-- Table structure for `logbook`
-- ----------------------------
DROP TABLE IF EXISTS `logbook`;
CREATE TABLE `logbook` (
  `log_book_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_id` bigint(20) DEFAULT NULL,
  `log_content` text,
  `log_date` date DEFAULT NULL,
  PRIMARY KEY (`log_book_id`),
  KEY `FK_record` (`task_id`),
  CONSTRAINT `FK_record` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logbook
-- ----------------------------

-- ----------------------------
-- Table structure for `move`
-- ----------------------------
DROP TABLE IF EXISTS `move`;
CREATE TABLE `move` (
  `move_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) DEFAULT NULL,
  `move_time` date DEFAULT NULL,
  `sourcepost_id` bigint(20) DEFAULT NULL,
  `sourcedepartment_id` bigint(20) DEFAULT NULL,
  `destpost_id` bigint(20) DEFAULT NULL,
  `destdepartment_id` bigint(20) DEFAULT NULL,
  `move_reason` varchar(400) DEFAULT NULL,
  `destdepartment_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`move_id`),
  KEY `FK_redeploy` (`employee_id`),
  CONSTRAINT `FK_redeploy` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of move
-- ----------------------------
INSERT INTO `move` VALUES ('1', '2', '2015-07-29', '5', '2', '7', '3', '', null);
INSERT INTO `move` VALUES ('2', '2', '2015-08-18', '7', '3', '5', '2', '', null);
INSERT INTO `move` VALUES ('3', '2', '2015-08-25', '5', '2', '7', '3', '', null);
INSERT INTO `move` VALUES ('4', '2', '2015-08-10', '7', '3', '6', '2', '', null);
INSERT INTO `move` VALUES ('5', '2', '2015-08-20', '6', '2', '7', '3', '', null);
INSERT INTO `move` VALUES ('6', '2', '2015-08-25', '7', '3', '5', '2', 'asdasd', null);
INSERT INTO `move` VALUES ('7', '2', '2015-08-04', '5', '2', '7', '3', '八佰伴八佰伴', null);
INSERT INTO `move` VALUES ('8', '2', '2015-08-19', '7', '3', '5', '2', '', null);

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_id` bigint(20) DEFAULT NULL,
  `department_name` varchar(20) DEFAULT NULL,
  `post_employee_count` int(11) DEFAULT NULL,
  `post_num` varchar(20) DEFAULT NULL,
  `post_name` varchar(20) DEFAULT NULL,
  `post_state` bit(1) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `FK_set` (`department_id`),
  CONSTRAINT `FK_set` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '1', '管理员', '1', '1', '超级管理员', '');
INSERT INTO `post` VALUES ('2', '1', '管理员', '0', '2', '人事管理员', '');
INSERT INTO `post` VALUES ('3', '1', '管理员', '0', '3', '机构管理员', '');
INSERT INTO `post` VALUES ('4', '1', '管理员', '0', '4', '任务管理员', '');
INSERT INTO `post` VALUES ('5', '2', '武装部', '1', '0201', '狙击手', '');
INSERT INTO `post` VALUES ('6', '2', '武装部', '0', '0202', '前锋', '');
INSERT INTO `post` VALUES ('7', '3', '生活部', '0', '0301', '阿姨', '');
INSERT INTO `post` VALUES ('8', '3', '生活部', '0', '0302', '大叔', '');

-- ----------------------------
-- Table structure for `rankapply`
-- ----------------------------
DROP TABLE IF EXISTS `rankapply`;
CREATE TABLE `rankapply` (
  `rank_apply_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apply_pass` bit(1) DEFAULT NULL,
  `apply_reason` varchar(255) DEFAULT NULL,
  `apply_time` date DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rank_apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rankapply
-- ----------------------------
INSERT INTO `rankapply` VALUES ('1', '', 'fff', '2015-08-30', '1', 'admin');

-- ----------------------------
-- Table structure for `specialistapply`
-- ----------------------------
DROP TABLE IF EXISTS `specialistapply`;
CREATE TABLE `specialistapply` (
  `specialist_apply_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) DEFAULT NULL,
  `apply_specialist_name` varchar(20) DEFAULT NULL,
  `apply_time` date DEFAULT NULL,
  `apply_pass` bit(1) DEFAULT NULL,
  `apply_reason` varchar(800) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`specialist_apply_id`),
  KEY `FK_apply` (`employee_id`),
  CONSTRAINT `FK_apply` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialistapply
-- ----------------------------
INSERT INTO `specialistapply` VALUES ('1', '1', 'aa', '2015-08-30', '', 'ddd', 'admin');

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `task_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) DEFAULT NULL,
  `context` varchar(400) DEFAULT NULL,
  `task_star_time` date DEFAULT NULL,
  `task_limit` int(11) DEFAULT NULL,
  `task_num` varchar(20) DEFAULT NULL,
  `task_name` varchar(20) DEFAULT NULL,
  `task_completed` bit(1) DEFAULT NULL,
  `tasktaker_id` bigint(20) DEFAULT NULL,
  `destdepartment_id` bigint(20) DEFAULT NULL,
  `destpost_id` bigint(20) DEFAULT NULL,
  `sourcedepartment_id` bigint(20) DEFAULT NULL,
  `sourcepost_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FK_distribute` (`employee_id`),
  CONSTRAINT `FK_distribute` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('1', '2', '', '2015-08-14', '8', 'gjg', 'gfhg', '\0', '2', '2', '5', '2', '5');
