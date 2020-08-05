package com.dragon.movie.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(MovieNotFound.class)
	public ResponseEntity<Object> handleMovieNotFound(MovieNotFound ex) {
		
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "City not found");
        
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
