package com.todoservice.gemfirerestapi.model;

import javax.validation.constraints.Size;

public class ToDoItemUpdateRequest {
    private String text;
    private boolean isCompleted;

	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getText() {
		return text;
	}
	@Size(min=1, max=50)
	public void setText(String text) {
		this.text = text;
	}
}
