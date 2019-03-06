CREATE TABLE `alipay_account` (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `version` int(11) DEFAULT '0',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `balance_amount` decimal(20,2) DEFAULT NULL COMMENT '余额',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `alipay_trade_order` (
  `order_no` varchar(45) NOT NULL COMMENT '交易订单号',
  `version` int(11) DEFAULT '0',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `amount` decimal(10,0) DEFAULT NULL COMMENT '交易金额',
  `status` varchar(45) DEFAULT NULL COMMENT '交易状态',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `alipay_account` VALUES ('1', '2', '2019-01-10 21:02:30', '2019-02-26 21:06:21', '2000000.00', '10180');
