package com.todoservice.gemfirerestapi.model;

public class ValidateBracketsModel {

	private String input;
	private boolean isBalanced;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public boolean isBalanced() {
		return isBalanced;
	}

	public void setBalanced(boolean isBalanced) {
		this.isBalanced = isBalanced;
	}

}
