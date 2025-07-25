package com.qr.icms.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "com.qr.icms")
@EnableDiscoveryClient
@EnableFeignClients
@EnableAsync
public class ICMSOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ICMSOrderApplication.class, args);
	}

}
