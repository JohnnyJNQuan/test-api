package com.todoservice.gemfirerestapi.model;



public class ToDoItemNotFoundError {
	private Details[] details;
	private String name;

	public Details[] getDetails() {
		return details;
	}

	public void setDetails(Details[] details) {
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	class Details {
		protected String message;

	}
}
