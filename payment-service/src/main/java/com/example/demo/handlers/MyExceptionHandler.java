package com.example.demo.handlers;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.models.MyErrorHandler;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value = NoSuchElementException.class)
	public MyErrorHandler handleElementNotFound(Exception ex, WebRequest req) {
		
		return new MyErrorHandler(LocalDateTime.now(), ex.getMessage(),req.getDescription(false)) ;
	}
}
