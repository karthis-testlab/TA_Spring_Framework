package com.ta.spring.code.TA_Spring_Framework.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ta.spring.code.TA_Spring_Framework.pojo.files.ErrorResponse;

@ControllerAdvice
public class RequestValidationException extends ResponseEntityExceptionHandler {
	
	@Nullable
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ErrorResponse errorResponse = ErrorResponse.builder()
				                      .code(status.value())
				                      .message(ex.getFieldErrors().stream().map(error -> error.getDefaultMessage()).toList())
				                      .timeStamp(LocalDateTime.now())
				                      .details(request.getDescription(false))
				                      .build();
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
			
	}

}