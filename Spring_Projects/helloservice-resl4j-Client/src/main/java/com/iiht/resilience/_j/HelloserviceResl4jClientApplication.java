package com.iiht.resilience._j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HelloserviceResl4jClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloserviceResl4jClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate newTemplate() {
		
		return new RestTemplate();
	}

}
