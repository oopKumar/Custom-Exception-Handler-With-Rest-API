package com.oop.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ExceptionInfo> customerNotFoundException(CustomerNotFoundException cnfe){
	
		ExceptionInfo info = new ExceptionInfo();
		info.setCode("XX0011");
		info.setMsg(cnfe.getMessage());
		info.setDate(LocalDateTime.now());
		return new ResponseEntity<>(info,HttpStatus.BAD_REQUEST);
	}

}
