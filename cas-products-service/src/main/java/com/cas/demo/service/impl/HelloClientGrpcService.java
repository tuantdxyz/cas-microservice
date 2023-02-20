package com.cas.demo.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cas.library.grpc.service.HelloReply;
import com.cas.library.grpc.service.HelloRequest;
import com.cas.library.grpc.service.MyServiceGrpc.MyServiceBlockingStub;
//import com.cas.demo.grpc.HelloService;
//import com.cas.demo.grpc.service.HelloReply;
//import com.cas.demo.grpc.service.HelloRequest;
//import com.cas.demo.grpc.service.MyServiceGrpc.MyServiceBlockingStub;
import com.google.protobuf.Descriptors;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class HelloClientGrpcService {
	
//	@Autowired
	@GrpcClient(value = "com.cas.library.grpc.service.MyService")
	MyServiceBlockingStub synchClient;
//	@Autowired
//	HelloService hs;
	
	public Map<Descriptors.FieldDescriptor, Object> getAuthor(String authorName) {
		HelloRequest hr = HelloRequest.newBuilder().setName(authorName).build();
//		MyServiceBlockingStub synchClient = new MyServiceBlockingStub();
//		MyServiceBlockingStub synchClient = null;
		HelloReply hres =  synchClient.sayHello(hr);
        return hres.getAllFields();
    }

}
