package com.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class OffersNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(OffersNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> exceptionHandler(OffersNotFoundException exception){
		Map<String, String> errorMap = new HashMap<>();
		
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;
	}

}
