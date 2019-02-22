package com.fisher.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FisherServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FisherServerApplication.class, args);
    }
}
