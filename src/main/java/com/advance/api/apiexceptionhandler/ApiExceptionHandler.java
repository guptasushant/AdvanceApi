package com.advance.api.apiexceptionhandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.advance.api.apiexception.ApiException;
import com.advance.api.exceptionpayload.ApiExceptionPayload;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handler(MethodArgumentNotValidException e) {
		Map<String, String> map = new HashMap<>();
		List<FieldError> fieldErrors = e.getFieldErrors();
		for (FieldError f : fieldErrors) {
			map.put(f.getField(), f.getDefaultMessage());
		}
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = ApiException.class)
	public ResponseEntity<Object> handler1(ApiException ex) {
		ApiExceptionPayload payload = new ApiExceptionPayload(ex.getMessage(), ex.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(payload, HttpStatus.NOT_FOUND);
	}
}
