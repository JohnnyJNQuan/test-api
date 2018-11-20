package com.todoservice.gemfirerestapi.exception;

@SuppressWarnings("serial")
public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException(String exception) {
		super(exception);
	}

}
