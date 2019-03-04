package com.fisher.tsc.personal.client;

import com.fisher.tsc.msg.api.FisherMessageApi;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("fisher-transaction-service")
public interface PersonalMessageClient extends FisherMessageApi {
}
