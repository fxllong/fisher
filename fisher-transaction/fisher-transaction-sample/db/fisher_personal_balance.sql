CREATE TABLE `personal_balance_account` (
  `id` int(11) NOT NULL COMMENT '交易订单号',
  `version` int(11) DEFAULT '0' COMMENT '交易订单号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `total_amount` decimal(20,2) DEFAULT NULL COMMENT '总额度',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `personal_trade_order` (
  `order_no` varchar(45) NOT NULL COMMENT '交易订单号',
  `version` int(11) DEFAULT '0' COMMENT '交易订单号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `message_id` varchar(50) DEFAULT NULL COMMENT '消息id用于幂等性判定',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `amount` decimal(10,0) DEFAULT NULL COMMENT '交易金额',
  `status` varchar(45) DEFAULT NULL COMMENT '交易状态',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`order_no`),
  KEY `message_id_index` (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `personal_balance_account` VALUES ('1', '0', '2019-01-10 21:01:41', '2019-02-25 21:06:21', '100.00', '10180');