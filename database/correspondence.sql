/*
SQLyog v10.2 
MySQL - 5.5.40 : Database - respondence
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`respondence` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `respondence`;

/*Table structure for table `tb_contacts` */

DROP TABLE IF EXISTS `tb_contacts`;

CREATE TABLE `tb_contacts` (
  `uid` int(100) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `workplace` varchar(100) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `groupname` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `gid` int(255) DEFAULT NULL,
  `imgPath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  KEY `gid` (`gid`),
  CONSTRAINT `tb_contacts_ibfk_1` FOREIGN KEY (`gid`) REFERENCES `tb_group` (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=gbk;

/*Data for the table `tb_contacts` */

insert  into `tb_contacts`(`uid`,`username`,`name`,`phone`,`sex`,`birthday`,`address`,`email`,`workplace`,`telephone`,`groupname`,`remark`,`gid`,`imgPath`) values (8,'test','赵六','13067889200','男','2012-5-16','','123@qq.com','','6690123','好友','',1,'F:\\note\\repository\\correspondence\\image\\20170509001132.jpg'),(9,'test','圣七','13067889200','男','2017-5-17','','123@qq.com','','6690123','好友','',1,'F:\\note\\repository\\correspondence\\image\\20170508233552.jpg'),(14,'test','赵四','13602805418','女','2017-5-3','','456@qq.com','','','好朋友','',4,NULL),(36,'test','赵三','13102796677','男','2017-5-19','','1234@qq.com','','','好友','',1,NULL),(49,'test','老李','13102796676','男','2017/5/19','','123@qq.com','','6623190','老朋友','',31,NULL),(51,'test','小李','13102796677','女','2017/5/19','','','','','新朋友','',1,NULL),(52,'test','赵丽','13156789111','女','1995-5-11','','111@qq.com','','','好友','',1,'');

/*Table structure for table `tb_group` */

DROP TABLE IF EXISTS `tb_group`;

CREATE TABLE `tb_group` (
  `gid` int(255) NOT NULL AUTO_INCREMENT COMMENT '组名的唯一标识',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `groupname` varchar(255) DEFAULT NULL COMMENT '组名',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=gbk;

/*Data for the table `tb_group` */

insert  into `tb_group`(`gid`,`username`,`groupname`) values (1,'test','好友'),(4,'test','好朋友'),(7,'test','我的亲人'),(31,'test','老朋友'),(32,'test','新朋友');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(20) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `mobilephone` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`password`,`mail`,`mobilephone`,`username`) values (1,'test','819090655@qq.com','13602805417','test');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
