package com.rackspace.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rackspace.util.DuplicateObjectException;
import com.rackspace.util.ExceptionResponse;
import com.rackspace.util.ObjectNotFoundException;

 

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse response =  new ExceptionResponse(
				new Date()
				, "Validation Failed"
				, ex.getBindingResult().toString()
				);
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req){
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DuplicateObjectException.class)
	public final ResponseEntity<Object> handleDuplicateObject(DuplicateObjectException ex, WebRequest req){
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<Object>(response, HttpStatus.CONFLICT);
	}
	@ExceptionHandler(ObjectNotFoundException.class)
	public final ResponseEntity<Object> handleObjectNotFound(DuplicateObjectException ex, WebRequest req){
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
}
