package com.cas.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableZipkinServer
public class CasSpringCoreApplication {

	public static void main(String[] args) throws IOException, InterruptedException {

//		Server serverGrpc = ServerBuilder.forPort(9000).addService(new HelloService()).build();
//		serverGrpc.start();

//		serverGrpc.awaitTermination();

		SpringApplication.run(CasSpringCoreApplication.class, args);
	}

//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		// 3000ms = 3s
//		return builder.setConnectTimeout(Duration.ofMillis(3000)).setReadTimeout(Duration.ofMillis(3000)).build();
//	}
}
