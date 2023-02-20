package com.cas.library.testing.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cas.library.controller.BaseController;
import com.cas.library.grpc.service.HelloReply;
import com.cas.library.grpc.service.HelloRequest;
import com.cas.library.grpc.service.MyServiceGrpc;
import com.cas.library.testing.service.impl.HelloServiceImpl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@RestController
public class HelloController extends BaseController {

	@Autowired
	private HelloServiceImpl hl;

//	final String ROOT_URI = "http://localhost:8083/hello_s2";
	final String ROOT_URI = "https://faker-api-v1.herokuapp.com/api/students";

//	private static Log logger = LogFactory.getLog(HelloController.class);

	@GetMapping("/order/grpc_server")
	public String hello_grpc_server() {
		logger.info("Received request start ");
		System.out.println("Running grpc client");
		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9001).usePlaintext().build();
		MyServiceGrpc.MyServiceBlockingStub stub = MyServiceGrpc.newBlockingStub(managedChannel);
		HelloReply hr = stub.sayHello(HelloRequest.newBuilder().setName("tuan3333").build());
		System.out.println(hr);
		managedChannel.shutdown();
		return "hello grpc";
	}

//	@GetMapping("/hello_local")
//	public String hello_local() {
////		logger.info("Received request start ");
////		System.out.println("Running s1");
//////		return "hello1";
////		return "Hello-test-local";
//		System.out.println("Running grpc");
////		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("static://localhost", 9001).usePlaintext().build();
//		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9001).usePlaintext().build();
//		MyServiceGrpc.MyServiceBlockingStub stub =  MyServiceGrpc.newBlockingStub(managedChannel);
//		HelloReply hr = stub.sayHello(HelloRequest.newBuilder().setName("tuan3333").build());
//		System.out.println(hr);
//		managedChannel.shutdown();
//		return "hello";
//	}
//	
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
