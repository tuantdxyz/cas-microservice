//package com.cas.library.service.impl;
//
//import java.net.URI;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.cas.library.entity.dto.PersonDto;
//import com.cas.library.service.RestTemplateIService;
//
//
//@Service
//public class RestTemplateIServiceImpl implements RestTemplateIService {
//	
//	@Autowired
//	private RestTemplate restTemplate;
//
//	@Override
//	public <T> T getForObject(String url, Class<T> responseType) {
//		// TODO Auto-generated method stub
//		ResponseEntity<T> response = restTemplate.getForEntity(url + "/1", responseType);
//		T res = response.getBody();
//		return res;
//	}
//
//}
