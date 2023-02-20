package com.cas.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cas.demo.grpc.HelloService;
import com.cas.demo.service.impl.HelloClientGrpcService;
import com.cas.demo.service.impl.RestTemplateIServiceImpl;
import com.cas.dto.PersonDto;
import com.cas.library.grpc.service.HelloReply;
import com.cas.library.grpc.service.HelloRequest;

import io.grpc.stub.StreamObserver;

@RestController
public class DemoRestController {

	@Autowired
	private RestTemplateIServiceImpl rt;

	@Autowired
	HelloClientGrpcService hl;

	@Autowired
	HelloService hse;

////	@Value("${myrest.url}")
//	private String restUrl;

	final String ROOT_URI = "https://jsonplaceholder.typicode.com/users";
//	final String ROOT_URI = "https://faker-api-v1.herokuapp.com/api/students";

	private static Log logger = LogFactory.getLog(DemoRestController.class);

	@GetMapping("/products/hello_rest")
	public PersonDto hello_rest() {
		logger.info("Running RestTemplate");
		System.out.println("Running RestTemplate");
		return rt.getForObject(ROOT_URI, PersonDto.class);
	}

	@GetMapping("/products/hello_grpc")
	public String hello_grpc() {
		System.out.println("Running grpc client");

		StreamObserver<HelloReply> responseObserver = new StreamObserver<HelloReply>() {
			@Override
			public void onNext(HelloReply status) {
				System.out.print("onNext: " + status.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.print("complete");
			}
		};

		// handle logic
		hse.sayHello(HelloRequest.newBuilder().setName("tuan123456-test-grpc").build(), responseObserver);
		return "Response grpc client in server";
	}

	@GetMapping("/test")
	public String hello_local() {
		logger.info("Running local");
		System.out.println("Running local");
//		return "hello1";
		return "Hello-test-local";
	}

//	@GetMapping("/hello_s1_oauth2")
//	public String hello_s1_oauth2() {
//		logger.info("Received request start ");
//		System.out.println("Running s1");
////		return "hello1";
//		return "Hello-test-hello_s1_oauth2";
//	}
//
//	@GetMapping("/auth/webapi/role")
//	public String hello_s1_role() {
//		logger.info("Received request start ");
//		System.out.println("Running s1");
////		return "hello1";
//		return "Hello-test-hello_s1_role";
//	}

}
