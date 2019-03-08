# Database fisher_msg

CREATE TABLE `message_log`
(
  `id`                 bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `version`            int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  `update_time`        datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time`        datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `message_id`         varchar(50)  NOT NULL DEFAULT '' COMMENT '消息ID',
  `message_body`       text         NOT NULL COMMENT '消息内容',
  `event_type`         varchar(100) NOT NULL DEFAULT '' COMMENT '事件类型',
  `message_send_times` smallint(6) NOT NULL DEFAULT '0' COMMENT '消息重发次数',
  `dead`               varchar(20)  NOT NULL DEFAULT '' COMMENT '是否死亡',
  `status`             varchar(20)  NOT NULL DEFAULT '' COMMENT '状态',
  `remark`             varchar(200)          DEFAULT NULL COMMENT '备注',
  `editor`             varchar(100)          DEFAULT NULL COMMENT '修改者',
  `creater`            varchar(100)          DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`id`),
  KEY                  `message_id_index` (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='日志表';