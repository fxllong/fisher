# Database: fisher_gen

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='代码生成表';