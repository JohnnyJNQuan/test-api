package com.todoservice.gemfirerestapi.model;

public class ToDoItemValidationError {
	private ToDoItemValidationErrorDetails[] details;
	private String name;

	public ToDoItemValidationErrorDetails[] getDetails() {
		return details;
	}

	public void setDetails(ToDoItemValidationErrorDetails[] details) {
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
