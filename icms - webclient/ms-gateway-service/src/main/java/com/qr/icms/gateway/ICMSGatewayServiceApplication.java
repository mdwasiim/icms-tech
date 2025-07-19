package com.qr.icms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ICMSGatewayServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(ICMSGatewayServiceApplication.class, args);
	}

}
