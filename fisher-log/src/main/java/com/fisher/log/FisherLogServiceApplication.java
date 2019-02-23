package com.fisher.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {"com.fisher.log", "com.fisher.common"})
public class FisherLogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FisherLogServiceApplication.class, args);
    }
}
