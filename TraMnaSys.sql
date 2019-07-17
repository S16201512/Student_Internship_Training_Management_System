/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.13 : Database - tramnasys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tramnasys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tramnasys`;

/*Table structure for table `student_task` */

DROP TABLE IF EXISTS `student_task`;

CREATE TABLE `student_task` (
  `sno` varchar(20) DEFAULT NULL,
  `task_no` int(11) DEFAULT NULL,
  `task_staus` varchar(100) DEFAULT (_utf8mb3'待做'),
  `submit_content` varchar(255) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `remake` varchar(255) DEFAULT NULL,
  `isScored` tinyint(1) DEFAULT NULL,
  `submit_time` datetime DEFAULT NULL,
  `IsSubmit` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student_task` */

insert  into `student_task`(`sno`,`task_no`,`task_staus`,`submit_content`,`grade`,`remake`,`isScored`,`submit_time`,`IsSubmit`) values ('16201512',8,'完成','apple.png\r\ncaret-right.png\r\nclose-circle-fill.png\r\nfast-backward.png\r\nfast-forward.png\r\nfy_ic_flght_TC.png',NULL,NULL,1,'2019-01-16 16:56:52',1),('16201513',8,'待做',NULL,NULL,NULL,NULL,NULL,NULL),('16201514',8,'待做',NULL,NULL,NULL,NULL,NULL,NULL),('16201515',8,'待做',NULL,NULL,NULL,NULL,NULL,NULL),('16201538',8,'待做',NULL,NULL,NULL,NULL,NULL,NULL),('16201512',11,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201513',11,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201514',11,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201515',11,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201538',11,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201512',12,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201513',12,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201514',12,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201515',12,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201538',12,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201512',13,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201513',13,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201514',13,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201515',13,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201538',13,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201512',7,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201513',7,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201514',7,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201515',7,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201538',7,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201512',14,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201513',14,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201514',14,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201515',14,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201538',14,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201512',16,'已过期','caret-right.png\r\nclose-circle-fill.png',60,'这是15:35给的评语：继续努力',1,'2019-01-16 14:55:54',1),('16201513',16,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201514',16,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201515',16,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201538',16,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201512',17,'已过期','权限审批.png\r\n收藏.png\r\n主页.png',NULL,NULL,1,'2019-01-16 16:10:42',1),('16201513',17,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201514',17,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201515',17,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201538',17,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201512',6,'已过期',' 我我我\r\n\r\n                            ',50,'继续努力',1,'2019-01-16 16:59:50',1),('16201513',6,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201514',6,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201515',6,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201538',6,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201512',18,'已过期','2dceebc03c8d83e7cea99905f1bf3133.jpg13',NULL,NULL,1,'2019-01-16 17:08:25',1),('16201513',18,'已过期',NULL,NULL,NULL,NULL,NULL,NULL),('16201514',18,'已过期','16201514-雷发根-浅析黑盒测试.doc',NULL,NULL,1,'2019-01-16 17:10:23',1),('16201515',18,'已过期','162014.xlsx\r\n162015.xlsx',NULL,NULL,1,'2019-01-16 17:08:20',1),('16201538',18,'已过期',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `ano` varchar(20) NOT NULL,
  `psd` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `qq` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`ano`,`psd`,`name`,`phone`,`qq`) values ('1001','123','陈老师','110','123456');

/*Table structure for table `t_class` */

DROP TABLE IF EXISTS `t_class`;

CREATE TABLE `t_class` (
  `cno` varchar(20) NOT NULL,
  `profession` varchar(108) DEFAULT NULL,
  `totalPerson` int(11) DEFAULT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_class` */

insert  into `t_class`(`cno`,`profession`,`totalPerson`) values ('162014','软件',4),('162015','软件',4);

/*Table structure for table `t_file` */

DROP TABLE IF EXISTS `t_file`;

CREATE TABLE `t_file` (
  `fno` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(100) DEFAULT NULL,
  `filetype` varchar(30) DEFAULT NULL,
  `time` varchar(200) DEFAULT NULL,
  `task_no` int(11) DEFAULT NULL,
  `owe_perNo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`fno`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*Data for the table `t_file` */

insert  into `t_file`(`fno`,`filename`,`filetype`,`time`,`task_no`,`owe_perNo`) values (1,'新建文本文档.txt','txt','2019-01-12 14:49:53',1,'10001'),(2,'student.xlsx','xlsx','2019-01-12 14:57:56',1,'10001'),(3,'新建文本文档.txt','txt','2019-01-12 15:03:56',2,'10001'),(4,'student.xlsx','xlsx','2019-01-12 15:05:05',NULL,'16201512'),(5,'162014.xlsx','xlsx','2019-01-12 15:15:43',NULL,'16201512'),(6,'162015.xlsx','xlsx','2019-01-12 15:15:43',NULL,'16201512'),(7,'student.xlsx','xlsx','2019-01-12 15:15:43',NULL,'16201512'),(8,'162014.xlsx','xlsx','2019-01-12 15:18:38',2,'16201512'),(9,'162015.xlsx','xlsx','2019-01-12 15:18:38',2,'16201512'),(10,'student.xlsx','xlsx','2019-01-12 15:18:38',2,'16201512'),(11,'162014.xlsx','xlsx','2019-01-12 15:46:45',3,'10001'),(12,'162015.xlsx','xlsx','2019-01-12 15:46:45',3,'10001'),(13,'student.xlsx','xlsx','2019-01-12 15:46:45',3,'10001'),(14,'新建文本文档.txt','txt','2019-01-12 15:47:50',3,'16201512'),(15,'新建文本文档.txt','txt','2019-01-12 15:55:26',3,'16201512'),(17,'新建文本文档.txt','txt','a',4,'16201512'),(18,'项目要求.txt','txt','2019-01-15 21:37:38',5,'10001'),(20,'总结报告要求.txt','txt','2019-01-15 21:49:59',7,'10001'),(22,'总结报告要求.txt','txt','2019-01-16 09:21:41',9,'10001'),(34,'156页第2题.ncb','ncb','2019-01-16 11:44:46',11,'10001'),(35,'156页第2题.plg','plg','2019-01-16 11:46:05',11,'16201512'),(41,'156页第2题.dsp','dsp','2019-01-16 14:17:55',13,'10001'),(42,'156页第2题.ncb','ncb','2019-01-16 14:17:55',13,'10001'),(43,'156页第2题.opt','opt','2019-01-16 14:17:55',13,'10001'),(44,'apple.png','png','2019-01-16 14:46:12',14,'10001'),(45,'apple.png','png','2019-01-16 14:55:10',16,'10001'),(46,'caret-right.png','png','2019-01-16 14:55:10',16,'10001'),(47,'caret-right.png','png','2019-01-16 16:09:00',17,'10001'),(48,'close-circle-fill.png','png','2019-01-16 16:09:01',17,'10001'),(49,'fast-backward.png','png','2019-01-16 16:09:01',17,'10001'),(50,'qqmap-wx-jssdk.min.js','min.js','2019-01-16 17:07:40',18,'10001'),(51,'qz.jpg','jpg','2019-01-16 17:07:40',18,'10001');

/*Table structure for table `t_registration` */

DROP TABLE IF EXISTS `t_registration`;

CREATE TABLE `t_registration` (
  `rno` varchar(50) NOT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `linkman` varchar(30) DEFAULT NULL,
  `linkmanphone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`rno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_registration` */

insert  into `t_registration`(`rno`,`province`,`city`,`company`,`linkman`,`linkmanphone`) values ('16201401','上海','西安','北京航空航天','何文勇','123421'),('16201402','广东','西安','北京航空航天','何文勇','123421'),('16201403','北京','西安','北京航空航天','何文勇','123421'),('16201404','北京','西安','北京航空航天','何文勇','123421'),('16201405','北京','西安','北京航空航天','何文勇','123421'),('16201406','北京','西安','北京航空航天','何文勇','123421'),('16201407','北京','西安','北京航空航天','何文勇','123421'),('16201408','北京','西安','北京航空航天','何文勇','123421'),('16201409','北京','西安','北京航空航天','何文勇','123421'),('16201410','北京','西安','北京航空航天','何文勇','123421'),('16201411','上海','西安','北京航空航天','何文勇','123421'),('16201412','广东','西安','北京航空航天','何文勇','123421'),('16201413','北京','西安','北京航空航天','何文勇','123421'),('16201414','北京','西安','北京航空航天','何文勇','123421'),('16201415','北京','西安','北京航空航天','何文勇','123421'),('16201416','北京','西安','北京航空航天','何文勇','123421'),('16201417','北京','西安','北京航空航天','何文勇','123421'),('16201418','北京','西安','北京航空航天','何文勇','123421'),('16201419','北京','西安','北京航空航天','何文勇','123421'),('16201420','北京','西安','北京航空航天','何文勇','123421'),('16201501','北京','北京','北京航空航天','何文勇','123421'),('16201502','广东','广州','北京航空航天','何文勇','123421'),('16201503','北京','大连','北京航空航天','何文勇','123421'),('16201504','北京','南宁','北京航空航天','何文勇','123421'),('16201505','北京','西安','北京航空航天','何文勇','123421'),('16201506','北京','拉萨','北京航空航天','何文勇','123421'),('16201507','北京','长春','北京航空航天','何文勇','123421'),('16201508','北京','包头','北京航空航天','何文勇','123421'),('16201509','北京','重庆','北京航空航天','何文勇','123421'),('16201510','北京','常州','北京航空航天','何文勇','123421'),('16201511','上海','上海','北京航空航天','何文勇','123421'),('16201512','广东','上海','北京航空航天','何文勇','123421'),('16201513','北京','广州','北京航空航天','何文勇','123421'),('16201514','北京','重庆','北京航空航天','何文勇','123421'),('16201515','北京','西安','北京航空航天','何文勇','123421'),('16201516','北京','西安','北京航空航天','何文勇','123421'),('16201517','北京','西安','北京航空航天','何文勇','123421'),('16201518','北京','重庆','北京航空航天','何文勇','123421'),('16201519','北京','重庆','北京航空航天','何文勇','123421'),('16201520','北京','重庆','北京航空航天','何文勇','123421');

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `sno` varchar(20) NOT NULL,
  `cno` varchar(20) DEFAULT NULL,
  `psd` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `qq` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`sno`,`cno`,`psd`,`name`,`phone`,`qq`) values ('16201401','162014','123','x1112','123','123'),('16201402','162014','123','abc','123','123'),('16201403','162014','123','前位','123','123'),('16201404','162014','123','sad','123','123'),('16201512','162015','123','何文勇','123','111'),('16201513','162015','123','黄凯','456','222'),('16201514','162015','123','雷发根','789','333'),('16201515','162015','123','李强','133','444'),('16201538','162015','123','李强','1579797170','1337111735');

/*Table structure for table `t_tc` */

DROP TABLE IF EXISTS `t_tc`;

CREATE TABLE `t_tc` (
  `cno` varchar(30) NOT NULL,
  `tno` varchar(20) NOT NULL,
  PRIMARY KEY (`cno`,`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_tc` */

insert  into `t_tc`(`cno`,`tno`) values ('162014','10002'),('162015','10001');

/*Table structure for table `t_teacher` */

DROP TABLE IF EXISTS `t_teacher`;

CREATE TABLE `t_teacher` (
  `tno` varchar(24) NOT NULL,
  `psd` varchar(108) DEFAULT NULL,
  `name` varchar(108) DEFAULT NULL,
  `phone` varchar(108) DEFAULT NULL,
  `qq` varchar(108) DEFAULT NULL,
  `profession` varchar(108) DEFAULT NULL,
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_teacher` */

insert  into `t_teacher`(`tno`,`psd`,`name`,`phone`,`qq`,`profession`) values ('10001','123','何','12354758','123','软件'),('10002','123','黄','124','124','软件'),('10003','123','雷','125','125','软件'),('10004','123','李','126','126','软件');

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `task_no` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(100) DEFAULT NULL,
  `tno` varchar(24) DEFAULT NULL,
  `task_content` varchar(1000) DEFAULT NULL,
  `submit` tinyint(1) DEFAULT '0',
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`task_no`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `task` */

insert  into `task`(`task_no`,`task_name`,`tno`,`task_content`,`submit`,`start_time`,`end_time`,`create_time`) values (5,'作业一','10001','1.       作业内容：\r\n\r\n制作一个个人展示网站，内容自定，网站采用DIV+CSS布局。基于JSP或者Model 1（JSP + Java Bean）的方式在第2次作业的基础上添加相关信息（信息内容自定）的增、删、改（有数据校验）、查（组合查询、可分页）等功能，\r\n\r\n \r\n\r\n2.       作业要求：\r\n\r\n（1）       班级内每位同学的网站均不相同并且必须自行完成，不得从网上下载，禁止拷贝。\r\n\r\n（2）       要求在该网站中必须使用到HTML、CSS、JavaScript、JSP、Java Bean、JDBC等Web技术；数据在增加、修改时必须有基本的数据校验；数据库中的表格应当有主键字段；数据库文件统一放置在\"d:\\temp\\db\"目录下。\r\n\r\n（3）       网站制作完成后给出一个简要的说明（不少于500字），内容包括：数据库结构，每个类与每个JSP页面的功能与作用，制作过程中遇到的问题以及解决办法（不少于200字）。\r\n\r\n（4）       代码的排版必须缩进对齐，并有关键性的注释。\r\n\r\n\r\n3.       提交内容：\r\n\r\n（1）       附件内应当包含工程的源代码与SQL脚本以及网站制作说明。\r\n\r\n（2）       要求war文件与数据库文件均以学号命名，并统一提交给学委后再交给助教。\r\n                    ',0,'2019-01-15 00:00:00','2019-01-15 12:12:00','2019-01-15 21:37:38'),(6,'作业二','10001','从下面四个类别中任选一个来写一篇科技论文：\r\n1.黑盒测试技术综述\r\n2.白盒测试技术综述\r\n3.面向对象测试技术综述\r\n4.Web测试技术综述\r\n\r\n具体题目自拟\r\n\r\n（1）建议结合我们的课程内容来写这篇课程论文（每人一份），要求字数3000-5000，格式要求见“格式要求”附件\r\n\r\n（2）每名同学做一份论文内容摘要的PPT（主要讲解论文的主要内容概要，答辩用，时间控制在五分钟以内）\r\n上交时间：最后一次课程之前（最后一次课程安排部分同学以PPT方式陈述论文内容）\r\n\r\n上交方式：论文采用word编辑，将Word文档命名为“学号-姓名-课程论文”，ppt采用powerpoint编辑，将ppt文件命名为“学号-姓名-答辩ppt”，不要压缩，以附件形式发送到超星系统。\r\n                    \r\n\r\n                    ',1,'2017-06-30 13:30:00','2019-01-16 16:59:00','2019-01-15 21:40:31'),(7,'任务三','10001','测试文房\r\n                    ',1,'2019-01-15 11:01:00','2019-01-15 22:22:00','2019-01-15 21:49:59'),(8,'任务4','10001','做足偶都速度搜啊读书\r\n                    ',1,'2019-01-15 00:00:00','2019-01-19 00:00:00','2019-01-15 22:26:59'),(11,'任务100','10001','何文勇写作业\r\n                    ',1,'2019-01-16 00:00:00','2019-01-16 11:46:00','2019-01-16 11:44:46'),(12,'任务199999','10001','14:02的测试任务\r\n                    \r\n\r\n                    ',1,'2017-06-30 13:30:00','2019-01-16 14:11:00','2019-01-16 14:02:35'),(13,'任务1888','10001','东方红积分会尽快发货就爱开发商实际\r\n                    ',1,'2019-01-16 00:00:00','2019-01-16 14:19:00','2019-01-16 14:17:55'),(14,'任务12','10001','我是谁，我从哪里来\r\n                    ',1,'2019-01-16 00:00:00','2019-01-16 14:49:00','2019-01-16 14:46:12'),(15,'任务789',NULL,'我问哈咖啡机哈空间和巴萨时看见\r\n                    ',0,'2019-01-16 00:00:00','2019-01-16 15:00:00','2019-01-16 14:53:53'),(16,'任务789','10001','法伤结果哈萨克1\r\n                    ',1,'2019-01-16 00:00:00','2019-01-16 15:00:00','2019-01-16 14:55:10'),(17,'任务98745631','10001','16:08\r\n                    ',1,'2019-01-16 00:00:00','2019-01-16 16:20:00','2019-01-16 16:09:00'),(18,'任务150000','10001','发哈空间发噶会计法\r\n                    ',1,'2019-01-16 00:00:00','2019-01-16 17:12:00','2019-01-16 17:07:40');

/* Trigger structure for table `task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `update_student_task` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `update_student_task` AFTER UPDATE ON `task` FOR EACH ROW begin    
     declare t_sno varchar(255);
     declare Done int DEFAULT 0;
     declare result cursor for select sno from t_student,t_tc where t_student.cno=t_tc.cno and t_tc.tno=new.tno;
     declare continue handler for not found set Done =1; 
     open  result;
     flag_loop:loop
     fetch  result into t_sno;
     if Done then leave flag_loop ; end if ;
     if (new.submit=1 and t_sno not in(select sno from student_task where task_no=new.task_no))
     then      
     insert into student_task(sno,task_no) values(t_sno,new.task_no);
     end if;
     if(new.submit=0 and t_sno in(select sno from student_task where task_no=new.task_no))
     then
     delete from  student_task where sno=t_sno and task_no=new.task_no;
     end if;
     end loop flag_loop;
     close result;
end */$$


DELIMITER ;

/*!50106 set global event_scheduler = 1*/;

/* Event structure for event `event_remind_status` */

/*!50106 DROP EVENT IF EXISTS `event_remind_status`*/;

DELIMITER $$

/*!50106 CREATE DEFINER=`root`@`localhost` EVENT `event_remind_status` ON SCHEDULE EVERY 1 SECOND STARTS '2019-01-12 14:18:17' ON COMPLETION PRESERVE ENABLE DO begin  
call update_task_status();  
end */$$
DELIMITER ;

/* Procedure structure for procedure `update_task_status` */

/*!50003 DROP PROCEDURE IF EXISTS  `update_task_status` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `update_task_status`()
BEGIN  
    
IF exists (SELECT task.task_no from task where  SYSDATE()>=task.end_time) 
THEN  
            
update student_task set task_staus='已过期'  
            
where task_no in 
(SELECT task.task_no from task where  SYSDATE()>=task.end_time);  
    
END IF;  
END */$$
DELIMITER ;

/*Table structure for table `admin_view` */

DROP TABLE IF EXISTS `admin_view`;

/*!50001 DROP VIEW IF EXISTS `admin_view` */;
/*!50001 DROP TABLE IF EXISTS `admin_view` */;

/*!50001 CREATE TABLE  `admin_view`(
 `ano` varchar(20) ,
 `psd` varchar(100) ,
 `name` varchar(100) ,
 `phone` varchar(100) ,
 `qq` varchar(100) 
)*/;

/*Table structure for table `allstudent_alltask_view` */

DROP TABLE IF EXISTS `allstudent_alltask_view`;

/*!50001 DROP VIEW IF EXISTS `allstudent_alltask_view` */;
/*!50001 DROP TABLE IF EXISTS `allstudent_alltask_view` */;

/*!50001 CREATE TABLE  `allstudent_alltask_view`(
 `sno` varchar(20) ,
 `task_no` int(11) ,
 `task_name` varchar(100) ,
 `tno` varchar(24) ,
 `task_content` varchar(1000) ,
 `start_time` datetime ,
 `end_time` datetime ,
 `grade` int(11) ,
 `task_staus` varchar(100) 
)*/;

/*Table structure for table `allstudent_studyplace_view` */

DROP TABLE IF EXISTS `allstudent_studyplace_view`;

/*!50001 DROP VIEW IF EXISTS `allstudent_studyplace_view` */;
/*!50001 DROP TABLE IF EXISTS `allstudent_studyplace_view` */;

/*!50001 CREATE TABLE  `allstudent_studyplace_view`(
 `city` varchar(20) ,
 `tno` varchar(20) 
)*/;

/*Table structure for table `allstudent_submitedtasklist_view` */

DROP TABLE IF EXISTS `allstudent_submitedtasklist_view`;

/*!50001 DROP VIEW IF EXISTS `allstudent_submitedtasklist_view` */;
/*!50001 DROP TABLE IF EXISTS `allstudent_submitedtasklist_view` */;

/*!50001 CREATE TABLE  `allstudent_submitedtasklist_view`(
 `name` varchar(100) ,
 `task_name` varchar(100) ,
 `sno` varchar(20) ,
 `task_no` int(11) ,
 `cno` varchar(20) ,
 `submit_content` varchar(255) ,
 `submit_time` datetime ,
 `remake` varchar(255) ,
 `task_content` varchar(1000) 
)*/;

/*Table structure for table `class_view` */

DROP TABLE IF EXISTS `class_view`;

/*!50001 DROP VIEW IF EXISTS `class_view` */;
/*!50001 DROP TABLE IF EXISTS `class_view` */;

/*!50001 CREATE TABLE  `class_view`(
 `cno` varchar(20) ,
 `profession` varchar(108) ,
 `totalPerson` int(11) 
)*/;

/*Table structure for table `eachclass_eachtask_submitednum_view` */

DROP TABLE IF EXISTS `eachclass_eachtask_submitednum_view`;

/*!50001 DROP VIEW IF EXISTS `eachclass_eachtask_submitednum_view` */;
/*!50001 DROP TABLE IF EXISTS `eachclass_eachtask_submitednum_view` */;

/*!50001 CREATE TABLE  `eachclass_eachtask_submitednum_view`(
 `tno` varchar(24) ,
 `task_no` int(11) 
)*/;

/*Table structure for table `eachclass_eachtask_totalpeople_view` */

DROP TABLE IF EXISTS `eachclass_eachtask_totalpeople_view`;

/*!50001 DROP VIEW IF EXISTS `eachclass_eachtask_totalpeople_view` */;
/*!50001 DROP TABLE IF EXISTS `eachclass_eachtask_totalpeople_view` */;

/*!50001 CREATE TABLE  `eachclass_eachtask_totalpeople_view`(
 `tno` varchar(24) ,
 `task_no` int(11) 
)*/;

/*Table structure for table `eachteacher_eachtask_maycorrect_view` */

DROP TABLE IF EXISTS `eachteacher_eachtask_maycorrect_view`;

/*!50001 DROP VIEW IF EXISTS `eachteacher_eachtask_maycorrect_view` */;
/*!50001 DROP TABLE IF EXISTS `eachteacher_eachtask_maycorrect_view` */;

/*!50001 CREATE TABLE  `eachteacher_eachtask_maycorrect_view`(
 `task_no` int(11) ,
 `task_name` varchar(100) ,
 `sno` varchar(20) ,
 `name` varchar(100) ,
 `submit_time` datetime ,
 `grade` int(11) ,
 `tno` varchar(20) 
)*/;

/*Table structure for table `eachteacher_maycorrect_view` */

DROP TABLE IF EXISTS `eachteacher_maycorrect_view`;

/*!50001 DROP VIEW IF EXISTS `eachteacher_maycorrect_view` */;
/*!50001 DROP TABLE IF EXISTS `eachteacher_maycorrect_view` */;

/*!50001 CREATE TABLE  `eachteacher_maycorrect_view`(
 `task_no` int(11) ,
 `task_name` varchar(100) ,
 `tno` varchar(24) ,
 `task_content` varchar(1000) ,
 `start_time` datetime ,
 `create_time` datetime ,
 `end_time` datetime 
)*/;

/*Table structure for table `file_view` */

DROP TABLE IF EXISTS `file_view`;

/*!50001 DROP VIEW IF EXISTS `file_view` */;
/*!50001 DROP TABLE IF EXISTS `file_view` */;

/*!50001 CREATE TABLE  `file_view`(
 `fno` int(11) ,
 `filename` varchar(100) ,
 `filetype` varchar(30) ,
 `time` varchar(200) ,
 `task_no` int(11) ,
 `owe_perNo` varchar(200) 
)*/;

/*Table structure for table `registration_view` */

DROP TABLE IF EXISTS `registration_view`;

/*!50001 DROP VIEW IF EXISTS `registration_view` */;
/*!50001 DROP TABLE IF EXISTS `registration_view` */;

/*!50001 CREATE TABLE  `registration_view`(
 `rno` varchar(50) ,
 `province` varchar(20) ,
 `city` varchar(20) ,
 `company` varchar(50) ,
 `linkman` varchar(30) ,
 `linkmanphone` varchar(30) 
)*/;

/*Table structure for table `student_view` */

DROP TABLE IF EXISTS `student_view`;

/*!50001 DROP VIEW IF EXISTS `student_view` */;
/*!50001 DROP TABLE IF EXISTS `student_view` */;

/*!50001 CREATE TABLE  `student_view`(
 `sno` varchar(20) ,
 `cno` varchar(20) ,
 `psd` varchar(100) ,
 `name` varchar(100) ,
 `phone` varchar(100) ,
 `qq` varchar(100) 
)*/;

/*Table structure for table `studenttask_view` */

DROP TABLE IF EXISTS `studenttask_view`;

/*!50001 DROP VIEW IF EXISTS `studenttask_view` */;
/*!50001 DROP TABLE IF EXISTS `studenttask_view` */;

/*!50001 CREATE TABLE  `studenttask_view`(
 `sno` varchar(20) ,
 `task_no` int(11) ,
 `task_staus` varchar(100) ,
 `submit_content` varchar(255) ,
 `grade` int(11) ,
 `remake` varchar(255) ,
 `isScored` tinyint(1) ,
 `submit_time` datetime ,
 `IsSubmit` tinyint(1) 
)*/;

/*Table structure for table `task_view` */

DROP TABLE IF EXISTS `task_view`;

/*!50001 DROP VIEW IF EXISTS `task_view` */;
/*!50001 DROP TABLE IF EXISTS `task_view` */;

/*!50001 CREATE TABLE  `task_view`(
 `task_no` int(11) ,
 `task_name` varchar(100) ,
 `tno` varchar(24) ,
 `task_content` varchar(1000) ,
 `submit` tinyint(1) ,
 `start_time` datetime ,
 `end_time` datetime ,
 `create_time` datetime 
)*/;

/*Table structure for table `tc_view` */

DROP TABLE IF EXISTS `tc_view`;

/*!50001 DROP VIEW IF EXISTS `tc_view` */;
/*!50001 DROP TABLE IF EXISTS `tc_view` */;

/*!50001 CREATE TABLE  `tc_view`(
 `cno` varchar(30) ,
 `tno` varchar(20) 
)*/;

/*Table structure for table `teacher_view` */

DROP TABLE IF EXISTS `teacher_view`;

/*!50001 DROP VIEW IF EXISTS `teacher_view` */;
/*!50001 DROP TABLE IF EXISTS `teacher_view` */;

/*!50001 CREATE TABLE  `teacher_view`(
 `tno` varchar(24) ,
 `psd` varchar(108) ,
 `name` varchar(108) ,
 `phone` varchar(108) ,
 `qq` varchar(108) ,
 `profession` varchar(108) 
)*/;

/*View structure for view admin_view */

/*!50001 DROP TABLE IF EXISTS `admin_view` */;
/*!50001 DROP VIEW IF EXISTS `admin_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `admin_view` AS select `t_admin`.`ano` AS `ano`,`t_admin`.`psd` AS `psd`,`t_admin`.`name` AS `name`,`t_admin`.`phone` AS `phone`,`t_admin`.`qq` AS `qq` from `t_admin` */;

/*View structure for view allstudent_alltask_view */

/*!50001 DROP TABLE IF EXISTS `allstudent_alltask_view` */;
/*!50001 DROP VIEW IF EXISTS `allstudent_alltask_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `allstudent_alltask_view` AS select `student_task`.`sno` AS `sno`,`task`.`task_no` AS `task_no`,`task`.`task_name` AS `task_name`,`task`.`tno` AS `tno`,`task`.`task_content` AS `task_content`,`task`.`start_time` AS `start_time`,`task`.`end_time` AS `end_time`,`student_task`.`grade` AS `grade`,`student_task`.`task_staus` AS `task_staus` from (`task` join `student_task`) where (`task`.`task_no` = `student_task`.`task_no`) */;

/*View structure for view allstudent_studyplace_view */

/*!50001 DROP TABLE IF EXISTS `allstudent_studyplace_view` */;
/*!50001 DROP VIEW IF EXISTS `allstudent_studyplace_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `allstudent_studyplace_view` AS select `t_registration`.`city` AS `city`,`t_tc`.`tno` AS `tno` from ((`t_student` join `t_tc`) join `t_registration`) where ((`t_student`.`cno` = `t_tc`.`cno`) and (`t_student`.`sno` = `t_registration`.`rno`)) */;

/*View structure for view allstudent_submitedtasklist_view */

/*!50001 DROP TABLE IF EXISTS `allstudent_submitedtasklist_view` */;
/*!50001 DROP VIEW IF EXISTS `allstudent_submitedtasklist_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `allstudent_submitedtasklist_view` AS select `t_student`.`name` AS `name`,`task`.`task_name` AS `task_name`,`t_student`.`sno` AS `sno`,`student_task`.`task_no` AS `task_no`,`t_student`.`cno` AS `cno`,`student_task`.`submit_content` AS `submit_content`,`student_task`.`submit_time` AS `submit_time`,`student_task`.`remake` AS `remake`,`task`.`task_content` AS `task_content` from ((`task` join `student_task`) join `t_student`) where ((`student_task`.`sno` = `t_student`.`sno`) and (`student_task`.`task_no` = `task`.`task_no`)) */;

/*View structure for view class_view */

/*!50001 DROP TABLE IF EXISTS `class_view` */;
/*!50001 DROP VIEW IF EXISTS `class_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `class_view` AS select `t_class`.`cno` AS `cno`,`t_class`.`profession` AS `profession`,`t_class`.`totalPerson` AS `totalPerson` from `t_class` */;

/*View structure for view eachclass_eachtask_submitednum_view */

/*!50001 DROP TABLE IF EXISTS `eachclass_eachtask_submitednum_view` */;
/*!50001 DROP VIEW IF EXISTS `eachclass_eachtask_submitednum_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `eachclass_eachtask_submitednum_view` AS select `task`.`tno` AS `tno`,`task`.`task_no` AS `task_no` from (`task` join `student_task`) where ((`task`.`task_no` = `student_task`.`task_no`) and (`task`.`submit` = 1) and (`student_task`.`task_staus` = '已过期') and (`student_task`.`IsSubmit` = 1)) */;

/*View structure for view eachclass_eachtask_totalpeople_view */

/*!50001 DROP TABLE IF EXISTS `eachclass_eachtask_totalpeople_view` */;
/*!50001 DROP VIEW IF EXISTS `eachclass_eachtask_totalpeople_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `eachclass_eachtask_totalpeople_view` AS select `task`.`tno` AS `tno`,`task`.`task_no` AS `task_no` from (`task` join `student_task`) where ((`task`.`task_no` = `student_task`.`task_no`) and (`task`.`submit` = 1) and (`student_task`.`task_staus` = '已过期')) */;

/*View structure for view eachteacher_eachtask_maycorrect_view */

/*!50001 DROP TABLE IF EXISTS `eachteacher_eachtask_maycorrect_view` */;
/*!50001 DROP VIEW IF EXISTS `eachteacher_eachtask_maycorrect_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `eachteacher_eachtask_maycorrect_view` AS select `task`.`task_no` AS `task_no`,`task`.`task_name` AS `task_name`,`t_student`.`sno` AS `sno`,`t_student`.`name` AS `name`,`student_task`.`submit_time` AS `submit_time`,`student_task`.`grade` AS `grade`,`t_tc`.`tno` AS `tno` from (((`task` join `student_task`) join `t_student`) join `t_tc`) where ((`task`.`task_no` = `student_task`.`task_no`) and (`student_task`.`task_staus` = '已过期') and (`t_tc`.`tno` = `task`.`tno`) and (`t_student`.`cno` = `t_tc`.`cno`) and (`student_task`.`IsSubmit` = 1) and (`student_task`.`sno` = `t_student`.`sno`)) */;

/*View structure for view eachteacher_maycorrect_view */

/*!50001 DROP TABLE IF EXISTS `eachteacher_maycorrect_view` */;
/*!50001 DROP VIEW IF EXISTS `eachteacher_maycorrect_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `eachteacher_maycorrect_view` AS select distinct `task`.`task_no` AS `task_no`,`task`.`task_name` AS `task_name`,`task`.`tno` AS `tno`,`task`.`task_content` AS `task_content`,`task`.`start_time` AS `start_time`,`task`.`create_time` AS `create_time`,`task`.`end_time` AS `end_time` from (`task` join `student_task`) where ((`task`.`task_no` = `student_task`.`task_no`) and (`task`.`submit` = 1) and (`student_task`.`task_staus` = '已过期')) */;

/*View structure for view file_view */

/*!50001 DROP TABLE IF EXISTS `file_view` */;
/*!50001 DROP VIEW IF EXISTS `file_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `file_view` AS select `t_file`.`fno` AS `fno`,`t_file`.`filename` AS `filename`,`t_file`.`filetype` AS `filetype`,`t_file`.`time` AS `time`,`t_file`.`task_no` AS `task_no`,`t_file`.`owe_perNo` AS `owe_perNo` from `t_file` */;

/*View structure for view registration_view */

/*!50001 DROP TABLE IF EXISTS `registration_view` */;
/*!50001 DROP VIEW IF EXISTS `registration_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `registration_view` AS select `t_registration`.`rno` AS `rno`,`t_registration`.`province` AS `province`,`t_registration`.`city` AS `city`,`t_registration`.`company` AS `company`,`t_registration`.`linkman` AS `linkman`,`t_registration`.`linkmanphone` AS `linkmanphone` from `t_registration` */;

/*View structure for view student_view */

/*!50001 DROP TABLE IF EXISTS `student_view` */;
/*!50001 DROP VIEW IF EXISTS `student_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `student_view` AS select `t_student`.`sno` AS `sno`,`t_student`.`cno` AS `cno`,`t_student`.`psd` AS `psd`,`t_student`.`name` AS `name`,`t_student`.`phone` AS `phone`,`t_student`.`qq` AS `qq` from `t_student` */;

/*View structure for view studenttask_view */

/*!50001 DROP TABLE IF EXISTS `studenttask_view` */;
/*!50001 DROP VIEW IF EXISTS `studenttask_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `studenttask_view` AS select `student_task`.`sno` AS `sno`,`student_task`.`task_no` AS `task_no`,`student_task`.`task_staus` AS `task_staus`,`student_task`.`submit_content` AS `submit_content`,`student_task`.`grade` AS `grade`,`student_task`.`remake` AS `remake`,`student_task`.`isScored` AS `isScored`,`student_task`.`submit_time` AS `submit_time`,`student_task`.`IsSubmit` AS `IsSubmit` from `student_task` */;

/*View structure for view task_view */

/*!50001 DROP TABLE IF EXISTS `task_view` */;
/*!50001 DROP VIEW IF EXISTS `task_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `task_view` AS select `task`.`task_no` AS `task_no`,`task`.`task_name` AS `task_name`,`task`.`tno` AS `tno`,`task`.`task_content` AS `task_content`,`task`.`submit` AS `submit`,`task`.`start_time` AS `start_time`,`task`.`end_time` AS `end_time`,`task`.`create_time` AS `create_time` from `task` */;

/*View structure for view tc_view */

/*!50001 DROP TABLE IF EXISTS `tc_view` */;
/*!50001 DROP VIEW IF EXISTS `tc_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `tc_view` AS select `t_tc`.`cno` AS `cno`,`t_tc`.`tno` AS `tno` from `t_tc` */;

/*View structure for view teacher_view */

/*!50001 DROP TABLE IF EXISTS `teacher_view` */;
/*!50001 DROP VIEW IF EXISTS `teacher_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `teacher_view` AS select `t_teacher`.`tno` AS `tno`,`t_teacher`.`psd` AS `psd`,`t_teacher`.`name` AS `name`,`t_teacher`.`phone` AS `phone`,`t_teacher`.`qq` AS `qq`,`t_teacher`.`profession` AS `profession` from `t_teacher` */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
