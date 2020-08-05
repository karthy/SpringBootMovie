package com.dragon.movie.exception;

import org.springframework.stereotype.Component;

@Component
public class MovieNotFound extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1910873251734538968L;

	public MovieNotFound(String message) {
		super(message);
	}
	
	public MovieNotFound() {
		super();
	}
	
	

}
