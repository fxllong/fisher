drop database if exists cloud;
create database cloud;



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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资源表(菜单与按钮)';

LOCK TABLES `sys_resource` WRITE;
/*!40000 ALTER TABLE `sys_resource` DISABLE KEYS */;

INSERT INTO `sys_resource` (`id`, `name`, `type`, `path`, `permission`, `color`, `parent_id`, `icon`, `component`, `sort`, `create_time`, `modify_time`, `del_flag`)
VALUES
	(1,'系统管理','0','/admin','',NULL,-1,'xitongguanli','Layout',2,'2017-11-07 20:56:00','2018-11-05 15:49:01','0'),
	(2,'用户管理','0','user','',NULL,1,'yonghuguanli','views/admin/user/index',2,'2017-11-02 22:24:37','2018-11-05 15:48:57','0'),
	(3,'资源管理','0','menu','',NULL,1,'caidanguanli','views/admin/menu/index',3,'2017-11-08 09:57:27','2018-11-06 16:12:06','0'),
	(4,'角色管理','0','role','',NULL,1,'jueseguanli','views/admin/role/index',4,'2017-11-08 10:13:37','2018-11-05 15:48:55','0'),
	(5,'日志管理','0','log',NULL,NULL,1,'rizhiguanli','views/admin/log/index',5,'2017-11-20 14:06:22','2018-08-09 10:56:35','0'),
	(6,'字典管理','0','dict',NULL,NULL,1,'zidianguanli','views/admin/dict/index',6,'2017-11-29 11:30:52','2018-08-09 10:56:35','0'),
	(8,'系统监控','0','',NULL,NULL,-1,'iconbmgl',NULL,8,'2018-01-22 12:30:41','2018-08-09 10:56:35','0'),
	(9,'查看用户','1',NULL,'/admin/user:select',NULL,2,NULL,NULL,2,'2018-10-17 16:32:36','2018-11-05 15:54:12','0'),
	(10,'测试','0','/a/b','',NULL,-1,'xx','/a/b',2,'2018-10-29 20:48:37','2018-11-05 15:48:54','1'),
	(11,'研发管理','0','/a/develop','',NULL,-1,'aac','/a/develop',151,'2018-10-30 19:37:08','2018-11-05 15:48:50','1'),
	(12,'代码生成','0','/a/develo/code','',NULL,11,'caidanguanli','/a/develop',1,'2018-10-31 13:10:34','2018-11-05 15:48:52','1'),
	(13,'添加用户','1',NULL,'/admin/user:add',NULL,2,NULL,NULL,1,'2018-11-05 15:49:44','2018-11-05 15:54:15','0'),
	(14,'修改用户','1',NULL,'/admin/user:update',NULL,2,NULL,NULL,1,'2018-11-05 15:50:02','2018-11-05 15:54:17','0'),
	(15,'删除用户','1',NULL,'/admin/user:delete',NULL,2,NULL,NULL,5,'2018-11-05 15:50:26','2018-11-05 15:54:19','0'),
	(16,'添加资源','1','/add','/admin/menu:add',NULL,3,'caidanguanli','views/admin/menu/index',0,'2017-11-07 20:56:00','2018-11-05 15:49:01','0'),
	(17,'编辑资源','1',NULL,'/admin/menu:update',NULL,3,NULL,'views/admin/menu/index',1,'2018-11-05 15:50:26','2018-11-06 16:07:43','0'),
	(18,'删除资源','1',NULL,'/admin/menu:delete',NULL,3,NULL,'views/admin/menu/index',1,'2018-11-05 15:50:26','2018-11-05 15:54:19','0'),
	(19,'查询资源','1',NULL,'/admin/menu:select',NULL,3,NULL,'views/admin/menu/index',1,'2018-11-05 15:50:26','2018-11-05 15:54:19','0'),
	(20,'查看资源','1',NULL,'/admin/role:select',NULL,4,NULL,'views/admin/role/index',1,'2018-11-05 15:50:26','2018-11-05 15:54:19','0'),
	(21,'添加资源','1',NULL,'/admin/role:add',NULL,4,NULL,'views/admin/role/index',1,'2018-11-05 15:50:26','2018-11-05 15:54:19','0'),
	(22,'编辑资源','1',NULL,'/admin/role:update',NULL,4,NULL,'views/admin/role/index',1,'2018-11-05 15:50:26','2018-11-06 16:07:37','0'),
	(23,'删除资源','1',NULL,'/admin/role:delete',NULL,4,NULL,'views/admin/role/index',1,'2018-11-05 15:50:26','2018-11-05 15:54:19','0');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;

INSERT INTO `sys_role` (`role_id`, `role_code`, `role_name`, `create_time`, `modify_time`, `del_flag`)
VALUES
	(1,'ROLE_ADMIN','管理员用户','2018-10-16 17:47:54','2018-11-02 16:38:27','0'),
	(2,'ROLE_DEMO','demo用户','2018-10-16 17:48:12',NULL,'0'),
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色资源关联表';

LOCK TABLES `sys_role_resource` WRITE;
/*!40000 ALTER TABLE `sys_role_resource` DISABLE KEYS */;

INSERT INTO `sys_role_resource` (`role_id`, `resource_id`)
VALUES
	(1,1),
	(1,2),
	(1,3),
	(1,4),
	(1,6),
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
	(2,1),
	(2,8),
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
	(50,X'79756B6F6E67',X'24326124313024326B56374E356B6C6749753646305362485646704A7576682F597A772F6C55734851454B47643166314530716371536E3342713379',NULL,X'3135303739313535363134',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-10-08 16:45:43','2018-10-09 17:13:18',X'30'),
	(51,X'61646D696E',X'24326124313024326B56374E356B6C6749753646305362485646704A7576682F597A772F6C55734851454B47643166314530716371536E3342713379',NULL,X'3133383638373232393133',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-11-05 16:34:58','2018-11-05 16:35:14',X'30');

/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '主键',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;

INSERT INTO `sys_user_role` (`user_id`, `role_id`)
VALUES
	(50,1),
	(50,2),
	(51,4);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='动态路由配置表';

LOCK TABLES `sys_zuul_route` WRITE;
/*!40000 ALTER TABLE `sys_zuul_route` DISABLE KEYS */;

INSERT INTO `sys_zuul_route` (`id`, `path`, `service_id`, `url`, `strip_prefix`, `retryable`, `enabled`, `sensitiveHeaders_list`, `create_time`, `update_time`, `del_flag`)
VALUES
	(4,'/admin/**','panda-user-service','','1','1','1','','2018-05-21 11:40:38','2018-10-17 17:03:36','0'),
	(5,'/auth/**','panda-auth','','1','1','1','','2018-05-21 11:41:08','2018-10-16 09:45:48','0');

/*!40000 ALTER TABLE `sys_zuul_route` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;