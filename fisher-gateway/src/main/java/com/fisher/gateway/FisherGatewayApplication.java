package com.fisher.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.fisher.common", "com.fisher.gateway"})
@EnableZuulProxy
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FisherGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FisherGatewayApplication.class, args);
	}
}
