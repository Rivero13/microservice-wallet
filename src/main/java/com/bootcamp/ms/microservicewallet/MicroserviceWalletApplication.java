package com.bootcamp.ms.microservicewallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.bootcamp.ms.commons.entity"})
public class MicroserviceWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceWalletApplication.class, args);
	}

}
