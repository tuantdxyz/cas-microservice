//package com.cas.library.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class AuthorizationServer {
//
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
////                .mvcMatchers("/products/**").access("hasAuthority('SCOPE_products.read')")
////				.antMatchers(HttpMethod.GET, "/products/**").hasAuthority("SCOPE_products.read")
//				.antMatchers(HttpMethod.GET, "/test").hasAuthority("SCOPE_products.read")
//				.antMatchers(HttpMethod.GET, "http://localhost:8082/hello_s1_oauth2").hasAuthority("SCOPE_products.view")
////				.antMatchers(HttpMethod.GET, "/test").hasAuthority("SCOPE_products.view")	//test sai scope
////				.antMatchers(HttpMethod.POST, "/api/foos").hasAuthority("SCOPE_write")
//
//				.antMatchers(HttpMethod.POST, "/auth/webapi/user").hasAuthority("ROLE_SRS_15_ADD")
//				.antMatchers(HttpMethod.GET, "/auth/webapi/role/**").hasRole("SRS_16_VIEW_LIST")
//				.anyRequest().authenticated().and().oauth2ResourceServer().jwt();
//		return http.build();
//	}
//}
