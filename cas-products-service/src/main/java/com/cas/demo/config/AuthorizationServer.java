package com.cas.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthorizationServer {

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.cors()
//        .and()
//        .authorizeRequests()
//        .antMatchers(HttpMethod.GET, "/user/info", "/api/foos/**")
//        .hasAuthority("SCOPE_read")
//        .antMatchers(HttpMethod.POST, "/api/foos")
//        .hasAuthority("SCOPE_write")
//        .anyRequest()
//        .authenticated()
//        .and()
//        .oauth2ResourceServer()
//        .jwt();
//		
////		System.out.println("GEN: " + http.build().toString());
//    return http.build();
//	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//                .mvcMatchers("/products/**").access("hasAuthority('SCOPE_products.read')")
				.antMatchers(HttpMethod.GET, "/products/**").hasAuthority("SCOPE_products.read")
//				.antMatchers(HttpMethod.GET, "/test").hasAuthority("SCOPE_products.read")
				.antMatchers(HttpMethod.GET, "/test").hasAuthority("SCOPE_products.view")
//				.antMatchers(HttpMethod.POST, "/api/foos").hasAuthority("SCOPE_write")
				.anyRequest().authenticated()
				.and().oauth2ResourceServer().jwt();
		return http.build();
	}
}
