package com.fisher.front.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fanxinglong
 * @create 2019-01-17 10:17
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class FisherMallUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(FisherMallUserApplication.class,args);
    }
}
