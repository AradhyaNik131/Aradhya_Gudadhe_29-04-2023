package com.avisys.cim.exceptionss;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.avisys.cim.payload.ApiResponse;

//Global Exception Handling when duplicate Mobile Number going to Inserted
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(DuplicateMobileNumberException.class)
	public ResponseEntity<ApiResponse> duplicateNumberExceptionHandler(DuplicateMobileNumberException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
}