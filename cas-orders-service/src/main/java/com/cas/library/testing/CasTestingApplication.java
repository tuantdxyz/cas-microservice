package com.cas.library.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.cas.library")
public class CasTestingApplication {

//	@Bean
//	public RestTemplate restTemplate() {
//		var factory = new SimpleClientHttpRequestFactory();
//		factory.setConnectTimeout(5000);
//		factory.setReadTimeout(5000);
//		return new RestTemplate(factory);
//	}

	public static void main(String[] args) {
		SpringApplication.run(CasTestingApplication.class, args);
	}

}
