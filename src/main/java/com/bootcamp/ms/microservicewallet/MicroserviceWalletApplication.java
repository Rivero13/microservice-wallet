package com.bootcamp.ms.microservicewallet;

import com.bootcamp.ms.microservicewallet.domain.Maestro;
import com.bootcamp.ms.microservicewallet.repository.MaestroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EntityScan({"com.bootcamp.ms.commons.entity","com.bootcamp.ms.microservicewallet.domain"})
@EnableCaching
public class MicroserviceWalletApplication  implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private MaestroRepository maestroRepository;

	private final String TIPO_DOCUMENTO="TIPO_DOCUMENTO";

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceWalletApplication.class, args);
	}

	@Override
	public void run(String... strings) {
		//Populating embedded database here
		Maestro maestro1 = new Maestro(TIPO_DOCUMENTO, "DNI");
		Maestro maestro2 = new Maestro(TIPO_DOCUMENTO, "CEX");
		Maestro maestro3 = new Maestro(TIPO_DOCUMENTO, "PASAPORTE");

		maestroRepository.save(maestro1);
		maestroRepository.save(maestro2);
		maestroRepository.save(maestro3);
		LOG.info("Done saving maestro. Data: {}.", maestroRepository.findAll());
	}
}
