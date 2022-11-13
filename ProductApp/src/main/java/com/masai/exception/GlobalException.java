package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyError> handleProductException(ProductException pe,WebRequest req){
		MyError me=new MyError();
		me.setTimestamp(LocalDateTime.now());
		me.setDescription(req.getDescription(false));
		me.setMessage(pe.getMessage());
		
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> handleException(Exception pe,WebRequest req){
		MyError me=new MyError();
		me.setTimestamp(LocalDateTime.now());
		me.setDescription(req.getDescription(false));
		me.setMessage(pe.getMessage());
		
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
	}
	
	
}
