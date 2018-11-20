package com.todoservice.gemfirerestapi.model;

import javax.validation.constraints.Size;

public class ToDoItemAddRequest {

	private String text;

	public String getText() {
		return text;
	}

	@Size(min = 1, max = 50)
	public void setText(String text) {
		this.text = text;
	}

}