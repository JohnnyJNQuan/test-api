package com.todoservice.gemfirerestapi.model;



public class ToDoItemNotFoundError {


	private ToDoItemNotFoundErrorDetails[] details;
	private String name;

	public ToDoItemNotFoundErrorDetails[] getDetails() {
		return details;
	}

	public void setDetails(ToDoItemNotFoundErrorDetails[] details) {
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
