package com.fisher.tsc.alipay.client;

import com.fisher.tsc.msg.api.FisherMessageApi;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("fisher-transaction-service")
public interface AlipayMessageClient extends FisherMessageApi {
}
