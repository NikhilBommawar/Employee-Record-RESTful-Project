package com.example;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

/*	//handle a specific exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException re,WebRequest request){
		ErrorDetail detail=new ErrorDetail(new Date(),re.getMessage() ,request.getDescription(false));
	return new ResponseEntity<>(detail,HttpStatus.NOT_FOUND);
	}
	
*/	
	
	//handle a genral exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception re,WebRequest request){
		ErrorDetail detail=new ErrorDetail(new Date(),re.getMessage() ,request.getDescription(true));
	return new ResponseEntity<>(detail,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}



