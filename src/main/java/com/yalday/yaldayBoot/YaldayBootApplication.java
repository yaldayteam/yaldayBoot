package com.yalday.yaldayBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class YaldayBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(YaldayBootApplication.class, args);
	}

}
