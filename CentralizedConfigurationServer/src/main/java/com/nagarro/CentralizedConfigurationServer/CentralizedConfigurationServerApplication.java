package com.nagarro.CentralizedConfigurationServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CentralizedConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralizedConfigurationServerApplication.class, args);
	}

}
