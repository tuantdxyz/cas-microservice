package com.cas.demo.service;

public interface RestTemplateIService {
	public <T> T getForObject(String url, Class<T> responseType);
	
//	public <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables);
	
//	public void put(String url, Object request, Map<String, ?> urlVariables)
	
//	public void delete(String url, Map<String, ?> urlVariables);
	
	

}
