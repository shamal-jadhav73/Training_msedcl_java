package com.msedcl.main.customer.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected @org.jspecify.annotations.Nullable ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		List<ObjectError> allErrors = ex.getAllErrors();
		Map<String, String> errorMap = new HashMap<>();
		
		for (ObjectError objectError : allErrors) {
			//log.info(objectError.getObjectName() + " " + objectError.getDefaultMessage());
			FieldError fieldError = (FieldError) objectError;
			String fieldName = fieldError.getField();
			String message = objectError.getDefaultMessage();
			errorMap.put(fieldName, message);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ProblemDetail> handleCustomerNotFoundException(CustomerNotFoundException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatusCode.valueOf(404));

		problemDetail.setStatus(HttpStatus.NOT_FOUND);
		problemDetail.setDetail(e.getMessage());
		problemDetail.setTitle("CUSTOMER_NOT_FOUND");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);

	}
}
