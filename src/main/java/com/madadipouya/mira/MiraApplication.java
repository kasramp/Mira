package com.madadipouya.mira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories
@EnableScheduling
@EnableAsync
public class MiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiraApplication.class, args);
	}

}
