/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 8.0.17 : Database - privilege_management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`privilege_management` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `privilege_management`;

/*Table structure for table `member_tab` */

DROP TABLE IF EXISTS `member_tab`;

CREATE TABLE `member_tab` (
  `id` varchar(32) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_tab` */

insert  into `member_tab`(`id`,`NAME`,`nickname`,`phoneNum`,`email`) values ('E61D65F673D54F68B0861025C69773DB','张三','小三','18888888888','zs@163.com');

/*Table structure for table `order_traveller` */

DROP TABLE IF EXISTS `order_traveller`;

CREATE TABLE `order_traveller` (
  `orderId` varchar(32) NOT NULL,
  `travellerId` varchar(32) NOT NULL,
  PRIMARY KEY (`orderId`,`travellerId`),
  KEY `travellerId` (`travellerId`),
  CONSTRAINT `order_traveller_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`),
  CONSTRAINT `order_traveller_ibfk_2` FOREIGN KEY (`travellerId`) REFERENCES `traveller` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_traveller` */

insert  into `order_traveller`(`orderId`,`travellerId`) values ('0E7231DC797C486290E8713CA3C6ECCC','3FE27DF2A4E44A6DBC5D0FE4651D3D3E'),('2FF351C4AC744E2092DCF08CFD314420','3FE27DF2A4E44A6DBC5D0FE4651D3D3E'),('5DC6A48DD4E94592AE904930EA866AFA','3FE27DF2A4E44A6DBC5D0FE4651D3D3E'),('A0657832D93E4B10AE88A2D4B70B1A28','3FE27DF2A4E44A6DBC5D0FE4651D3D3E'),('3081770BC3984EF092D9E99760FDABDE','EE7A71FB6945483FBF91543DBE851960'),('55F9AF582D5A4DB28FB4EC3199385762','EE7A71FB6945483FBF91543DBE851960'),('96CC8BD43C734CC2ACBFF09501B4DD5D','EE7A71FB6945483FBF91543DBE851960'),('CA005CF1BE3C4EF68F88ABC7DF30E976','EE7A71FB6945483FBF91543DBE851960'),('E4DD4C45EED84870ABA83574A801083E','EE7A71FB6945483FBF91543DBE851960');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` varchar(32) NOT NULL,
  `orderNum` varchar(20) NOT NULL,
  `orderTime` timestamp NULL DEFAULT NULL,
  `peopleCount` int(11) DEFAULT NULL,
  `orderDesc` varchar(500) DEFAULT NULL,
  `payType` int(11) DEFAULT NULL,
  `orderStatus` int(11) DEFAULT NULL,
  `productId` varchar(32) DEFAULT NULL,
  `memberId` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `orderNum` (`orderNum`),
  KEY `productId` (`productId`),
  KEY `memberId` (`memberId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`memberId`) REFERENCES `member_tab` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`orderNum`,`orderTime`,`peopleCount`,`orderDesc`,`payType`,`orderStatus`,`productId`,`memberId`) values ('0E7231DC797C486290E8713CA3C6ECCC','12345','2020-04-10 11:59:10',2,'没什么',0,1,'676C5BD1D35E429A8C2E114939C5685A','E61D65F673D54F68B0861025C69773DB'),('2FF351C4AC744E2092DCF08CFD314420','67890','2020-04-10 11:59:10',2,'没什么',0,1,'12B7ABF2A4C544568B0A7C69F36BF8B7','E61D65F673D54F68B0861025C69773DB'),('3081770BC3984EF092D9E99760FDABDE','55555','2020-04-10 11:59:10',2,'没什么',0,1,'9F71F01CB448476DAFB309AA6DF9497F','E61D65F673D54F68B0861025C69773DB'),('55F9AF582D5A4DB28FB4EC3199385762','33333','2020-04-10 11:59:10',2,'没什么',0,1,'9F71F01CB448476DAFB309AA6DF9497F','E61D65F673D54F68B0861025C69773DB'),('5DC6A48DD4E94592AE904930EA866AFA','54321','2020-04-10 11:59:10',2,'没什么',0,1,'676C5BD1D35E429A8C2E114939C5685A','E61D65F673D54F68B0861025C69773DB'),('96CC8BD43C734CC2ACBFF09501B4DD5D','22222','2020-04-10 11:59:10',2,'没什么',0,1,'12B7ABF2A4C544568B0A7C69F36BF8B7','E61D65F673D54F68B0861025C69773DB'),('A0657832D93E4B10AE88A2D4B70B1A28','98765','2020-04-10 11:59:10',2,'没什么',0,1,'12B7ABF2A4C544568B0A7C69F36BF8B7','E61D65F673D54F68B0861025C69773DB'),('CA005CF1BE3C4EF68F88ABC7DF30E976','44444','2020-04-10 11:59:10',2,'没什么',0,1,'9F71F01CB448476DAFB309AA6DF9497F','E61D65F673D54F68B0861025C69773DB'),('E4DD4C45EED84870ABA83574A801083E','11111','2020-04-10 11:59:10',2,'没什么',0,1,'12B7ABF2A4C544568B0A7C69F36BF8B7','E61D65F673D54F68B0861025C69773DB');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` varchar(32) NOT NULL,
  `permissionName` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`id`,`permissionName`,`url`) values ('0c82ce8d543c43028b1ae3056f73219e','user findbyid','/user/findbyid'),('bc7bf217bffe4a8d9005740b4aa1a11e','user findAll','/user/findAll'),('deb6ecf9aa644565abb7c5f79af00fd7','role findall','/role/findall');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` varchar(32) NOT NULL,
  `productNum` varchar(50) NOT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `cityName` varchar(50) DEFAULT NULL,
  `DepartureTime` timestamp NULL DEFAULT NULL,
  `productPrice` double DEFAULT NULL,
  `productDesc` varchar(500) DEFAULT NULL,
  `productStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product` (`id`,`productNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`productNum`,`productName`,`cityName`,`DepartureTime`,`productPrice`,`productDesc`,`productStatus`) values ('12B7ABF2A4C544568B0A7C69F36BF8B7','itcast-003','上海五日游','上海','2018-04-25 14:30:00',1800,'魔都我来了',0),('4dd59cd5a95347d4a8122e2e6c7704b0','','烧烤','岳阳','2020-04-11 09:00:00',10000,'',1),('676C5BD1D35E429A8C2E114939C5685A','itcast-002','北京三日游','北京','2018-10-10 10:10:00',1200,'不错的旅行',1),('9F71F01CB448476DAFB309AA6DF9497F','itcast-001','北京三日游','北京','2018-10-10 10:10:00',1200,'不错的旅行',1),('ab751e06009c4c7cbcf10bda8dd93bec','','擂茶','益阳','2020-04-10 23:15:00',5,'',1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `roleName` varchar(50) DEFAULT NULL,
  `roleDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`roleName`,`roleDesc`) values ('6455657da42046f1a9598a6ad61be42b','test1','test1'),('c11f5a6e4b9444b0b7c75e97db510a75','test','test'),('d6c1fa7238694742bafe8d62b048b608','ADMIN','vip'),('facad77da93846d5839371cd323010c0','USER','vip');

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `permissionId` varchar(32) NOT NULL,
  `roleId` varchar(32) NOT NULL,
  PRIMARY KEY (`permissionId`,`roleId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`),
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_permission` */

insert  into `role_permission`(`permissionId`,`roleId`) values ('bc7bf217bffe4a8d9005740b4aa1a11e','6455657da42046f1a9598a6ad61be42b'),('0c82ce8d543c43028b1ae3056f73219e','d6c1fa7238694742bafe8d62b048b608'),('bc7bf217bffe4a8d9005740b4aa1a11e','d6c1fa7238694742bafe8d62b048b608'),('bc7bf217bffe4a8d9005740b4aa1a11e','facad77da93846d5839371cd323010c0');

/*Table structure for table `syslog` */

DROP TABLE IF EXISTS `syslog`;

CREATE TABLE `syslog` (
  `id` varchar(32) NOT NULL,
  `visitime` timestamp NULL DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `executiontime` int(11) DEFAULT NULL,
  `method` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `syslog` */

insert  into `syslog`(`id`,`visitime`,`username`,`ip`,`url`,`executiontime`,`method`) values ('35a97da3bf4045108ac80e5a9473ae88','2020-04-17 12:17:45','sijude','0:0:0:0:0:0:0:1','/product/findAll',2289,'[类名]cn.lgq.www.controller.ProductController[方法名]findAll'),('4e64c688418042c6843b1ab4ee994e84','2020-04-17 12:43:40','lgq','0:0:0:0:0:0:0:1','/syslog/findall',305,'[类名]cn.lgq.www.controller.SysLogController[方法名]findAll');

/*Table structure for table `traveller` */

DROP TABLE IF EXISTS `traveller`;

CREATE TABLE `traveller` (
  `id` varchar(32) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `credentialsType` int(11) DEFAULT NULL,
  `credentialsNum` varchar(50) DEFAULT NULL,
  `travellerType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `traveller` */

insert  into `traveller`(`id`,`NAME`,`sex`,`phoneNum`,`credentialsType`,`credentialsNum`,`travellerType`) values ('3FE27DF2A4E44A6DBC5D0FE4651D3D3E','张龙','男','13333333333',0,'123456789009876543',0),('EE7A71FB6945483FBF91543DBE851960','张小龙','男','15555555555',0,'987654321123456789',1);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` varchar(32) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`email`,`username`,`password`,`phoneNum`,`STATUS`) values ('19fce9ef0f1b428485dcfc5f57f4225b','ljl1@ljl.com','ljl','$2a$10$hVhAqRPfb/16ehEqVC4DaOhER01hcFbOl8TTEWMkRQtlcv7oMtwKa','11111111111',1),('cb480fb4734b4d07acdcb032b241d51d','111@111.com','lgq','$2a$10$eOHZvltxAfQpxsrF4FgH1uB38nJSxKnySkj4M2nx8ENmLPnUAa.Ia','11111111111',1),('eb82d06a1f0a4af38c27b5739674b14d','ljl@ljl.com','sijude','$2a$10$P6UsKaJQk7wsdBso2GvzL.c4kXL7drmkg8PEZsRU2uWe1dOP70/HC','11111111111',1);

/*Table structure for table `users_role` */

DROP TABLE IF EXISTS `users_role`;

CREATE TABLE `users_role` (
  `userId` varchar(32) NOT NULL,
  `roleId` varchar(32) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `users_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
  CONSTRAINT `users_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users_role` */

insert  into `users_role`(`userId`,`roleId`) values ('19fce9ef0f1b428485dcfc5f57f4225b','6455657da42046f1a9598a6ad61be42b'),('cb480fb4734b4d07acdcb032b241d51d','6455657da42046f1a9598a6ad61be42b'),('cb480fb4734b4d07acdcb032b241d51d','c11f5a6e4b9444b0b7c75e97db510a75'),('cb480fb4734b4d07acdcb032b241d51d','d6c1fa7238694742bafe8d62b048b608'),('eb82d06a1f0a4af38c27b5739674b14d','d6c1fa7238694742bafe8d62b048b608'),('cb480fb4734b4d07acdcb032b241d51d','facad77da93846d5839371cd323010c0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
