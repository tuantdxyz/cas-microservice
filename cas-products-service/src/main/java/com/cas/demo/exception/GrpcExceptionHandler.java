//package com.cas.demo.exception;
//
//@GrpcAdvice
//public class GrpcExceptionHandler {
//
//	@GrpcExceptionHandler
//	public Status handleInvalidArgument(IllegalArgumentException e) {
//		return Status.INVALID_ARGUMENT.withDescription("Your description").withCause(e);
//	}
//
//	@GrpcExceptionHandler(ResourceNotFoundException.class)
//    public StatusException handleResourceNotFoundException(ResourceNotFoundException e) {
//        Status status = Status.NOT_FOUND.withDescription("Your description").withCause(e);
//        Metadata metadata = ...
//        return status.asException(metadata);
//    }
//
//}
