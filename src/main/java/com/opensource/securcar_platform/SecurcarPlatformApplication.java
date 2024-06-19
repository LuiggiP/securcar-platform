package com.opensource.securcar_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Enable JPA Auditing
public class SecurcarPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurcarPlatformApplication.class, args);
	}

}
