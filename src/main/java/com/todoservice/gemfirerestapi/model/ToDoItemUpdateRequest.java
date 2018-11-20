package com.todoservice.gemfirerestapi.model;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDoItemUpdateRequest {
	private String text;
	private Boolean isCompleted;

	@JsonProperty("isCompleted")
	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getText() {
		return text;
	}

	@Size(min = 1, max = 50)
	public void setText(String text) {
		this.text = text;
	}

	public boolean isTextNull() {
		if (this.text == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCompletedNull() {
		if (this.isCompleted == null) {
			return true;
		} else {
			return false;
		}
	}
}
