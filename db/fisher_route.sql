# Database: fisher_route

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

INSERT INTO `sys_zuul_route` (`id`, `path`, `service_id`, `url`, `strip_prefix`, `retryable`, `enabled`, `sensitiveHeaders_list`, `create_time`, `update_time`, `del_flag`)
VALUES
(4,'/admin/**','fisher-back-service','','1','1','1','','2018-05-21 11:40:38','2019-02-22 17:24:52','0'),
(5,'/auth/**','fisher-auth-service','','1','1','1','','2018-05-21 11:41:08','2019-02-22 17:24:49','0'),
(6,'/syslog/**','fisher-log-service',' ','1','1','1','','2019-02-23 14:29:56','2019-02-23 15:24:54','0'),
(7,'/gen/**','fisher-gen-service','','1','1','1','','2019-02-26 12:54:11','2019-02-26 13:06:07','0'),
(8,'/tsc/**','fisher-transaction-web-service','','1','1','1','','2019-03-02 15:01:15','2019-03-02 15:01:51','0');
