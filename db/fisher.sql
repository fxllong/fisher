# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.19)
# Database: fisher
# Generation Time: 2019-03-03 14:36:28 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table sys_dict
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `desc` varchar(255) DEFAULT NULL COMMENT '字典描述',
                          `value` varchar(255) DEFAULT NULL COMMENT '字典值',
                          `parent_id` int(11) NOT NULL COMMENT '上层id  定义默认是-1',
                          `sort_order` int(11) NOT NULL COMMENT '权重',
                          `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                          `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          `del_flag` char(1) DEFAULT '0' COMMENT '是否删除 1-删除，0-未删除',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典表';

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;

INSERT INTO `sys_dict` (`id`, `desc`, `value`, `parent_id`, `sort_order`, `remark`, `create_time`, `modify_time`, `del_flag`)
VALUES
(8,'性别','sex',-1,100,'备注remark','2019-01-24 14:52:52','2019-01-24 16:58:47','0'),
(9,'腾讯云短信配置','tecent_sms_config',-1,1,NULL,'2019-01-24 16:08:23',NULL,'0'),
(10,'阿里云短信配置','aliyun_sms_config',-1,2,NULL,'2019-01-24 16:09:48',NULL,'0'),
(11,'测试','test',-1,1,NULL,'2019-01-24 17:15:45',NULL,'0');

/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_gen_db_config
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_gen_db_config`;

CREATE TABLE `sys_gen_db_config` (
                                   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                   `host` varchar(32) NOT NULL COMMENT '数据库地址',
                                   `port` varchar(32) NOT NULL COMMENT '数据库端口',
                                   `db_type` varchar(32) NOT NULL COMMENT '数据库类型',
                                   `driver_class_name` varchar(32) NOT NULL COMMENT 'jdbc驱动类名',
                                   `database` varchar(32) NOT NULL COMMENT '具体数据库名',
                                   `user_name` varchar(255) NOT NULL COMMENT '用户名',
                                   `password` varchar(255) NOT NULL COMMENT '密码',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='代码生成器配置表';



# Dump of table sys_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
                         `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
                         `type` char(1) DEFAULT '1' COMMENT '日志类型',
                         `status` char(1) NOT NULL DEFAULT '0' COMMENT '操作状态  0 成功 1 失败',
                         `module_name` varchar(255) DEFAULT '' COMMENT '模块名',
                         `action_name` varchar(255) DEFAULT '' COMMENT '操作名',
                         `service_id` varchar(32) DEFAULT NULL COMMENT '服务ID',
                         `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
                         `user_agent` varchar(1000) DEFAULT NULL COMMENT '用户代理',
                         `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
                         `method` varchar(10) DEFAULT NULL COMMENT '操作方式',
                         `params` text COMMENT '操作提交的数据',
                         `time` mediumtext COMMENT '执行时间',
                         `exception` text COMMENT '异常信息',
                         `del_flag` char(1) DEFAULT '0' COMMENT '删除标记',
                         `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                         `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         PRIMARY KEY (`id`),
                         KEY `sys_log_create_by` (`create_by`),
                         KEY `sys_log_request_uri` (`request_uri`),
                         KEY `sys_log_type` (`type`),
                         KEY `sys_log_create_date` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='日志表';

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;

INSERT INTO `sys_log` (`id`, `type`, `status`, `module_name`, `action_name`, `service_id`, `remote_addr`, `user_agent`, `request_uri`, `method`, `params`, `time`, `exception`, `del_flag`, `create_by`, `create_time`, `update_time`)
VALUES
(329,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','PostmanRuntime/6.1.6','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','21',NULL,'0','fisher','2019-02-23 16:26:39',NULL),
(330,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','PostmanRuntime/6.1.6','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','17',NULL,'0','fisher','2019-02-23 16:26:50',NULL),
(331,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','32',NULL,'0','fisher','2019-02-23 16:33:16',NULL),
(332,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','9',NULL,'0','fisher','2019-02-23 16:33:26',NULL),
(333,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','18',NULL,'0','fisher','2019-02-23 16:33:38',NULL),
(334,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','11',NULL,'0','fisher','2019-02-23 16:33:41',NULL),
(335,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','11',NULL,'0','fisher','2019-02-23 16:33:47',NULL),
(336,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','9',NULL,'0','fisher','2019-02-23 16:33:58',NULL),
(337,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','14',NULL,'0','fisher','2019-02-23 16:37:20',NULL),
(338,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"40\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','16',NULL,'0','fisher','2019-02-23 16:37:28',NULL),
(339,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','15',NULL,'0','fisher','2019-02-23 16:37:38',NULL),
(340,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','388',NULL,'0','fisher','2019-02-23 16:41:41',NULL),
(341,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','11',NULL,'0','fisher','2019-02-23 16:41:46',NULL),
(342,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','8',NULL,'0','fisher','2019-02-23 16:41:52',NULL),
(343,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','10',NULL,'0','fisher','2019-02-23 16:42:23',NULL),
(344,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','7',NULL,'0','fisher','2019-02-23 16:42:27',NULL),
(345,'1','0','系统用户模块','根据token获取用户信息','FISHER_USER_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/user/info','GET','{\"access_token\":[\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJmaXNoZXIiLCJzY29wZSI6WyJzZXJ2ZXIiXSwiZXhwIjoxNTUwOTU2ODczLCJ1c2VyTmFtZSI6ImZpc2hlciIsInVzZXJJZCI6NTAsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwianRpIjoiYTJjNDJiOTAtY2MyMi00YWUwLWJmMmQtOTAwZjc4NDljODNjIiwiY2xpZW50X2lkIjoiY2xvdWQifQ.a9VMZta7C3CQMSxvX7CovVm6tukrAPKeDV124a3SeG0\"]}','314',NULL,'0','fisher','2019-02-23 17:21:33',NULL),
(346,'1','0','系统资源模块','根据token查询当前用户权限的菜单树','FISHER_USER_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/resource/menu/tree','GET','{}','26',NULL,'0','fisher','2019-02-23 17:21:33',NULL),
(347,'1','0','系统日志模块','日志信息分页查询','FISHER_LOG_SERVICE','127.0.0.1','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:65.0) Gecko/20100101 Firefox/65.0','/log/page','GET','{\"size\":[\"10\"],\"current\":[\"1\"],\"moduleName\":[\"\"],\"type\":[\"1\"],\"status\":[\"\"]}','328',NULL,'0','fisher','2019-02-23 17:21:38',NULL);

/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_oauth_client_details
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_oauth_client_details`;

CREATE TABLE `sys_oauth_client_details` (
                                          `client_id` varchar(256) NOT NULL,
                                          `resources_ids` varchar(256) DEFAULT NULL,
                                          `client_secret` varchar(256) DEFAULT NULL,
                                          `scope` varchar(256) DEFAULT NULL,
                                          `authorized_grant_types` varchar(256) DEFAULT NULL,
                                          `web_server_redirect_uri` varchar(256) DEFAULT NULL,
                                          `authorities` varchar(256) DEFAULT NULL,
                                          `access_token_validity` int(11) DEFAULT NULL,
                                          `refresh_token_validity` int(11) DEFAULT NULL,
                                          `addition_information` varchar(4096) DEFAULT NULL,
                                          `autoapprove` varchar(256) DEFAULT NULL,
                                          PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

LOCK TABLES `sys_oauth_client_details` WRITE;
/*!40000 ALTER TABLE `sys_oauth_client_details` DISABLE KEYS */;

INSERT INTO `sys_oauth_client_details` (`client_id`, `resources_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `addition_information`, `autoapprove`)
VALUES
('cloud',NULL,'$2a$10$X1HOPGX6ADkQn4rvtk.C4uaz8vF1TdpY2aP/iC.3UKlonvco/k9e.','server','password,refresh_token,authorization_code',NULL,NULL,NULL,NULL,NULL,'false');

/*!40000 ALTER TABLE `sys_oauth_client_details` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_resource
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                              `name` varchar(64) NOT NULL COMMENT '资源名称',
                              `type` char(1) NOT NULL DEFAULT '0' COMMENT '资源类型 0-菜单 1-按钮',
                              `path` varchar(128) DEFAULT NULL COMMENT '前端url',
                              `permission` varchar(32) DEFAULT NULL COMMENT '按钮权限资源标识',
                              `color` varchar(64) DEFAULT NULL COMMENT '颜色',
                              `parent_id` int(11) NOT NULL COMMENT '父资源id',
                              `icon` varchar(32) DEFAULT NULL COMMENT '图标',
                              `component` varchar(128) DEFAULT NULL COMMENT '组件路径',
                              `sort` int(11) DEFAULT NULL COMMENT '排序权重',
                              `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                              `del_flag` char(1) DEFAULT '0' COMMENT '是否删除 1-删除，0-未删除',
                              `url` varchar(128) DEFAULT NULL COMMENT '后端路径',
                              `method` varchar(11) DEFAULT NULL COMMENT '请求方式',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='资源表(菜单与按钮)';

LOCK TABLES `sys_resource` WRITE;
/*!40000 ALTER TABLE `sys_resource` DISABLE KEYS */;

INSERT INTO `sys_resource` (`id`, `name`, `type`, `path`, `permission`, `color`, `parent_id`, `icon`, `component`, `sort`, `create_time`, `modify_time`, `del_flag`, `url`, `method`)
VALUES
(1,'系统管理','0','/admin','/admin',NULL,-1,'xitongguanli','Layout',2,'2017-11-07 20:56:00','2019-03-03 17:00:46','0','',NULL),
(2,'用户管理','0','user','/admin/user',NULL,1,'yonghuguanli','views/admin/user/index',2,'2017-11-02 22:24:37','2019-03-03 17:05:20','0','',NULL),
(3,'资源管理','0','menu','/admin/resource',NULL,1,'caidanguanli','views/admin/menu/index',3,'2017-11-08 09:57:27','2019-03-03 17:05:21','0','',NULL),
(4,'角色管理','0','role','/admin/role',NULL,1,'jueseguanli','views/admin/role/index',4,'2017-11-08 10:13:37','2019-03-03 17:05:22','0','',NULL),
(6,'系统监控','0','/system','/system:view',NULL,-1,'iconbmgl','System',8,'2018-01-22 12:30:41','2019-03-03 22:30:20','0',NULL,NULL),
(9,'查看用户','1',NULL,'/admin/user:select',NULL,2,NULL,NULL,2,'2018-10-17 16:32:36','2019-03-03 22:06:03','0','/admin/user/*','GET'),
(10,'测试','0','/a/b','/test',NULL,-1,'xx','/a/b',2,'2018-10-29 20:48:37','2019-01-31 15:07:03','1',NULL,NULL),
(13,'添加用户','1',NULL,'/admin/user:add',NULL,2,NULL,NULL,1,'2018-11-05 15:49:44','2019-03-03 22:06:42','0','/admin/user/*','POST'),
(14,'修改用户','1',NULL,'/admin/user:update',NULL,2,NULL,NULL,1,'2018-11-05 15:50:02','2019-03-03 22:07:33','0','/admin/user/*','PUT'),
(15,'删除用户','1',NULL,'/admin/user:delete',NULL,2,NULL,NULL,5,'2018-11-05 15:50:26','2019-03-03 22:07:40','0','/admin/user/*','DELETE'),
(16,'添加资源','1','','/admin/menu:add',NULL,3,'caidanguanli','views/admin/menu/index',0,'2017-11-07 20:56:00','2019-03-03 22:07:44','0','/admin/resource/**','POST'),
(17,'编辑资源','1',NULL,'/admin/menu:update',NULL,3,NULL,'views/admin/menu/index',1,'2018-11-05 15:50:26','2019-03-03 22:07:48','0','/admin/resource/**','PUT'),
(18,'删除资源','1',NULL,'/admin/menu:delete',NULL,3,NULL,'views/admin/menu/index',1,'2018-11-05 15:50:26','2019-03-03 22:07:53','0','/admin/resource/**','DELETE'),
(19,'查询资源','1',NULL,'/admin/menu:select',NULL,3,NULL,'views/admin/menu/index',1,'2018-11-05 15:50:26','2019-03-03 22:07:58','0','/admin/resource/**','GET'),
(20,'查看资源','1',NULL,'/admin/role:select',NULL,4,NULL,'views/admin/role/index',1,'2018-11-05 15:50:26','2019-03-03 22:08:01','0','/admin/role/**','GET'),
(21,'添加资源','1',NULL,'/admin/role:add',NULL,4,NULL,'views/admin/role/index',1,'2018-11-05 15:50:26','2019-03-03 22:08:06','0','/admin/role/**','POST'),
(22,'编辑资源','1',NULL,'/admin/role:update',NULL,4,NULL,'views/admin/role/index',1,'2018-11-05 15:50:26','2019-03-03 22:08:09','0','/admin/role/**','PUT'),
(23,'删除资源','1',NULL,'/admin/role:delete',NULL,4,NULL,'views/admin/role/index',1,'2018-11-05 15:50:26','2019-03-03 22:08:13','0','/admin/role/**','DELETE'),
(29,'查询','1',NULL,'/gen/code:select',NULL,61,NULL,'views/gen/code/index',1,'2018-11-08 18:02:20','2019-03-03 22:08:18','0','/gen/code/**','GET'),
(30,'下载','1',NULL,'/gen/code:download',NULL,61,NULL,'views/gen/code/index',1,'2018-11-08 18:02:42','2019-03-03 22:08:22','0','/gen/code/**','POST'),
(31,'研发管理','0','/gen','/gen',NULL,-1,'develop','Layout',4,'2018-01-22 12:30:41','2019-03-03 22:32:34','0','',NULL),
(55,'消息管理','0','/tsc','/tsc',NULL,-1,'develop','Layout',2,'2019-03-02 15:07:08','2019-03-03 22:32:28','0','',NULL),
(57,'消息处理','0','msg','/tsc/msg',NULL,55,'code','views/msg/index',1,'2019-03-02 15:16:38','2019-03-03 22:25:23','0','/tsc/msg/**','POST'),
(61,'代码生成','0','code','/gen/code',NULL,31,'code','views/gen/code/index',1,'2019-03-03 17:55:21','2019-03-03 22:25:24','0','/gen/code/**','GET'),
(63,'查看日志','0','log','/syslog/log',NULL,64,'rizhiguanli','views/admin/log/index',1,'2017-11-20 14:06:22','2019-03-03 22:32:10','0','/syslog/log/*','GET'),
(64,'日志管理','0','/syslog','/syslog',NULL,-1,'rizhiguanli','Layout',5,'2017-11-20 14:06:22','2019-03-03 22:32:29','0','',NULL);

/*!40000 ALTER TABLE `sys_resource` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
                          `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `role_code` varchar(32) NOT NULL COMMENT '角色code用于springsecurity角色标识码',
                          `role_name` varchar(128) NOT NULL COMMENT '角色名称',
                          `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          `del_flag` char(1) DEFAULT '0' COMMENT '是否删除 1-删除，0-未删除',
                          PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='角色表';

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;

INSERT INTO `sys_role` (`role_id`, `role_code`, `role_name`, `create_time`, `modify_time`, `del_flag`)
VALUES
(1,'ROLE_ADMIN','管理员用户','2018-10-16 17:47:54','2018-11-02 16:38:27','0'),
(2,'ROLE_DEMO','测试用户','2018-10-16 17:48:12','2019-02-23 18:03:40','0'),
(4,'ROLE_TEST','test','2018-11-06 15:05:30',NULL,'0');

/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_role_resource
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_role_resource`;

CREATE TABLE `sys_role_resource` (
                                   `role_id` int(11) NOT NULL COMMENT '主键',
                                   `resource_id` int(11) NOT NULL COMMENT '主键',
                                   PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='角色资源关联表';

LOCK TABLES `sys_role_resource` WRITE;
/*!40000 ALTER TABLE `sys_role_resource` DISABLE KEYS */;

INSERT INTO `sys_role_resource` (`role_id`, `resource_id`)
VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,9),
(1,13),
(1,14),
(1,15),
(1,16),
(1,17),
(1,18),
(1,19),
(1,20),
(1,21),
(1,22),
(1,23),
(1,29),
(1,30),
(1,31),
(1,55),
(1,57),
(1,61),
(1,63),
(1,64),
(2,1),
(2,4),
(2,8),
(2,20),
(2,24),
(4,1),
(4,2),
(4,3),
(4,4),
(4,9),
(4,19),
(4,20);

/*!40000 ALTER TABLE `sys_role_resource` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
                          `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                          `username` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
                          `password` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
                          `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
                          `mobile` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '手机号码',
                          `qq` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'qq号码',
                          `wechat` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微信号码',
                          `weibo` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微博url',
                          `avatar` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像url',
                          `qq_openid` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'qq openid',
                          `wechat_openid` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微信openid',
                          `weibo_openid` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微博openid',
                          `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          `del_flag` char(1) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '是否删除 0-未删除 1-删除',
                          PRIMARY KEY (`user_id`),
                          UNIQUE KEY `user_idx_username` (`username`),
                          UNIQUE KEY `user_idx_mobile` (`mobile`),
                          UNIQUE KEY `user_idx_emal` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户表';

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;

INSERT INTO `sys_user` (`user_id`, `username`, `password`, `email`, `mobile`, `qq`, `wechat`, `weibo`, `avatar`, `qq_openid`, `wechat_openid`, `weibo_openid`, `create_time`, `modify_time`, `del_flag`)
VALUES
(50,X'666973686572',X'24326124313024326B56374E356B6C6749753646305362485646704A7576682F597A772F6C55734851454B47643166314530716371536E3342713379',NULL,X'3135303739313535363134',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-10-08 16:45:43','2019-02-22 15:22:44',X'30'),
(56,X'737570657232',X'24326124313024322E5A455A6470716739584D6D49474F726C5365512E6E3765747450362E45764C794E39424938425648575461784B6D6751383561',NULL,X'3133393836383631333938',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-03-02 17:07:32',NULL,X'30');

/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
                               `user_id` int(11) NOT NULL COMMENT '主键',
                               `role_id` int(11) NOT NULL COMMENT '主键',
                               PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户角色关联表';

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;

INSERT INTO `sys_user_role` (`user_id`, `role_id`)
VALUES
(50,1),
(51,1),
(51,2),
(51,4),
(52,2),
(54,1),
(55,2),
(56,1);

/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_zuul_route
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_zuul_route`;

CREATE TABLE `sys_zuul_route` (
                                `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'router Id',
                                `path` varchar(255) NOT NULL COMMENT '路由路径',
                                `service_id` varchar(255) NOT NULL COMMENT '服务名称',
                                `url` varchar(255) DEFAULT NULL COMMENT 'url代理',
                                `strip_prefix` char(1) DEFAULT '1' COMMENT '转发去掉前缀',
                                `retryable` char(1) DEFAULT '1' COMMENT '是否重试',
                                `enabled` char(1) DEFAULT '1' COMMENT '是否启用',
                                `sensitiveHeaders_list` varchar(255) DEFAULT NULL COMMENT '敏感请求头',
                                `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                `del_flag` char(1) DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='动态路由配置表';

LOCK TABLES `sys_zuul_route` WRITE;
/*!40000 ALTER TABLE `sys_zuul_route` DISABLE KEYS */;

INSERT INTO `sys_zuul_route` (`id`, `path`, `service_id`, `url`, `strip_prefix`, `retryable`, `enabled`, `sensitiveHeaders_list`, `create_time`, `update_time`, `del_flag`)
VALUES
(4,'/admin/**','fisher-user-service','','1','1','1','','2018-05-21 11:40:38','2019-02-22 17:24:52','0'),
(5,'/auth/**','fisher-auth-service','','1','1','1','','2018-05-21 11:41:08','2019-02-22 17:24:49','0'),
(6,'/syslog/**','fisher-log-service',' ','1','1','1','','2019-02-23 14:29:56','2019-02-23 15:24:54','0'),
(7,'/gen/**','fisher-gen-service','','1','1','1','','2019-02-26 12:54:11','2019-02-26 13:06:07','0'),
(8,'/tsc/**','fisher-transaction-web-service','','1','1','1','','2019-03-02 15:01:15','2019-03-02 15:01:51','0');

/*!40000 ALTER TABLE `sys_zuul_route` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
