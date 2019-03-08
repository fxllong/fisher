package com.fisher.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {"com.fisher.back", "com.fisher.common"})
public class FisherBackServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FisherBackServiceApplication.class, args);
    }
}
