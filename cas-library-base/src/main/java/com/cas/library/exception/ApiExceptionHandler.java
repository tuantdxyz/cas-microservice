package com.cas.library.exception;

import java.net.SocketTimeoutException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleAllException(Exception ex, WebRequest request) {
//        return new ErrorMessage(10000, ex.getLocalizedMessage());
		System.out.println("Running 1");
		if (ex.getCause() instanceof SocketTimeoutException) {
//			ex.printStackTrace();
			System.out.println("Running 2");
			return "SocketTimeoutException";
		}
		return "Exception";
	}

	/**
	 * IndexOutOfBoundsException
	 */
//	@ExceptionHandler(IndexOutOfBoundsException.class)
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	public String TodoException(Exception ex, WebRequest request) {
//		System.out.println("Running 2");
//		return "err2";
////        return new ErrorMessage(10100, "TuanTD");
//	}

	@ExceptionHandler(SocketTimeoutException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String SocketException(Exception ex, WebRequest request) {
		System.out.println("Running 3");
		return "err3";
	}

}
