package com.cas.library.testing.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cas.library.service.RestTemplateIService;

@Service
public class HelloServiceImpl implements RestTemplateIService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public <T> T getForObject(String url, Class<T> responseType) {
		ResponseEntity<T> response = restTemplate.getForEntity(url, responseType);
		T res = response.getBody();
		return res;
	}

	@Override
	public <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(String url, Object request, Map<String, ?> urlVariables) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String url, Map<String, ?> urlVariables) {
		// TODO Auto-generated method stub

	}

}
