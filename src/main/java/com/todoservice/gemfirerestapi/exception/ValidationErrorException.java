package com.todoservice.gemfirerestapi.exception;

@SuppressWarnings("serial")
public class ValidationErrorException extends RuntimeException {

	public ValidationErrorException(String exception) {
		super(exception);
	}

}
