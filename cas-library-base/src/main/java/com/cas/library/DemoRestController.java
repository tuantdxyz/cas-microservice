//package com.cas.library;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cas.library.entity.dto.PersonDto;
//import com.cas.library.service.impl.RestTemplateIServiceImpl;
//
//@RestController
//public class DemoRestController {
//	
//	@Autowired
//	private RestTemplateIServiceImpl rt;
//	
////	@Value("${myrest.url}")
//    private String restUrl;
//    
////    @Bean
////    public Sampler alwaysSampler() {
////        return Sampler.ALWAYS_SAMPLE;
////    }
//	
////	final String ROOT_URI = "https://jsonplaceholder.typicode.com/users"; 
//	final String ROOT_URI = "https://faker-api-v1.herokuapp.com/api/students";
//	
//	private static Log logger = LogFactory.getLog(DemoRestController.class);
//	
//	@GetMapping("/hello")
//	public PersonDto hello() {
//		logger.info("Received request start ");
//		System.out.println("Running");
//		return rt.getForObject(ROOT_URI, PersonDto.class);
//	}
//
//}
