package com.cas.demo.grpc;



import com.cas.library.grpc.service.HelloReply;
import com.cas.library.grpc.service.HelloRequest;
import com.cas.library.grpc.service.MyServiceGrpc.MyServiceImplBase;

//import com.cas.demo.grpc.service.HelloReply;
//import com.cas.demo.grpc.service.HelloRequest;
//import com.cas.demo.grpc.service.MyServiceGrpc.MyServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloService extends MyServiceImplBase{

	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
		// TODO Auto-generated method stub
		System.out.println("hello grpc");
		HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
//		super.sayHello(request, responseObserver);
	}
	

}
