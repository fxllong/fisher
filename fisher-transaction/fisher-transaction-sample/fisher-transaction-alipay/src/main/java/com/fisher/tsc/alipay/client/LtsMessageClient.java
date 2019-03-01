package com.fisher.tsc.alipay.client;

import com.fisher.tsc.msg.api.LtsMessageApi;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("fisher-transaction-service")
public interface LtsMessageClient extends LtsMessageApi {
}
