# Database: fisher_log

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
