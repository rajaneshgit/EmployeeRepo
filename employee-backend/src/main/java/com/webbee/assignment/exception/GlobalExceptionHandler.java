package com.webbee.assignment.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//handling custom validation 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception){
		ErrorDetails errorDetails = new ErrorDetails(exception.getBindingResult().getFieldError()
				.getDefaultMessage(),"Validation failed", new Date());
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> recoredNotFound(ResourceNotFoundException exception){
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(),"Not found", new Date());
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
}
