package com.thecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradleApplication.class, args);
	}

}
