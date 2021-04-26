package com.faculty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FacultyPostNotFoundException extends Exception{

	private String message;

	public FacultyPostNotFoundException() {
		this.message="";
	}

	public FacultyPostNotFoundException(String message) {
		this.message=message;
		
	}

	@Override
	public String toString() {
		return "FacultyPostNotFoundException [message=" + message + "]";
	}
	
	

}
