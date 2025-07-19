package com.qr.icms.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class ICMSRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ICMSRegistryServiceApplication.class, args);
	}

}
