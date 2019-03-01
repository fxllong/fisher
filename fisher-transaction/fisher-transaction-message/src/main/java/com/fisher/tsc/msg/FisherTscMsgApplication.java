package com.fisher.tsc.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class FisherTscMsgApplication {

	public static void main(String[] args) {
		SpringApplication.run(FisherTscMsgApplication.class, args);
	}

}
