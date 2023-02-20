package com.cas.demo.config;

import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;

//@Configuration
//@ComponentScan("com.cas.config")
//@Component
@Configuration
@ComponentScan("com.cas.demo.config")
public class AppConfig {

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		// Do any additional configuration here
//		return builder.build();
//	}
	
	@Bean
    public RestTemplate restTemplate() {

		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);

        return new RestTemplate(factory);
    }
	
	@Bean
	public GrpcServerConfigurer keepAliveServerConfigurer() {
	    return serverBuilder -> {
	        if (serverBuilder instanceof NettyServerBuilder) {
	            ((NettyServerBuilder) serverBuilder)
	                    .keepAliveTime(30, TimeUnit.SECONDS)
	                    .keepAliveTimeout(5, TimeUnit.SECONDS)
	                    .permitKeepAliveWithoutCalls(true);
	        }
	    };
	}
}
