package com.fisher.boot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Allen
 * @create 2019-03-08 18:50
 **/

@EnableAdminServer
@SpringBootApplication
@EnableDiscoveryClient
public class FisherBootAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(FisherBootAdminApplication.class,args);
    }

}
