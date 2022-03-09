package com.example.ResQmeAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ResQmeAdminApplication extends SpringBootServletInitializer {

	@Bean
	public WebClient.Builder getWebClientBuilder()
	{
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(ResQmeAdminApplication.class, args);
	}

}
