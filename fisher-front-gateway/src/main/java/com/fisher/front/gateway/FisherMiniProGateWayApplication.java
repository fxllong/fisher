package com.fisher.front.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author fanxinglong
 * @create 2019-01-16 14:41
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FisherMiniProGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(FisherMiniProGateWayApplication.class,args);
    }

}
