package com.todoservice.gemfirerestapi.model;

public class IntegrationTestResult {
	private BracersTestResult[] bracers;
	private ToDoTestResult[] todo;
	public BracersTestResult[] getBracers() {
		return bracers;
	}
	public void setBracers(BracersTestResult[] bracers) {
		this.bracers = bracers;
	}
	public ToDoTestResult[] getTodo() {
		return todo;
	}
	public void setTodo(ToDoTestResult[] todo) {
		this.todo = todo;
	}

}
