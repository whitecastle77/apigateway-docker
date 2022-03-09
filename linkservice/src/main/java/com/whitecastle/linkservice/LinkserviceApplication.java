package com.whitecastle.linkservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LinkserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkserviceApplication.class, args);
	}

}
