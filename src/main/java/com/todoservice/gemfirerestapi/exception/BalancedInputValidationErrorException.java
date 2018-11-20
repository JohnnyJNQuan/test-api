package com.todoservice.gemfirerestapi.exception;

@SuppressWarnings("serial")
public class BalancedInputValidationErrorException extends RuntimeException {

	public BalancedInputValidationErrorException(String exception) {
		super(exception);
	}

}
