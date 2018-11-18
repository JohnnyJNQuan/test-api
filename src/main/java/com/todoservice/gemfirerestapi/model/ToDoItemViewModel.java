package com.todoservice.gemfirerestapi.model;


public class ToDoItemViewModel {
	
    private String text;
    private boolean isCompleted = false;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
     
  

}