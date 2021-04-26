package com.faculty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FacultyNotFoundException extends Exception {

	
	private String message;

	public FacultyNotFoundException() {
		this.message="";
	}

	public FacultyNotFoundException(String message) {
		this.message=message;
		
	}

	@Override
	public String toString() {
		return "FacultyNotFoundException [message=" + message + "]";
	}


	
	
}
