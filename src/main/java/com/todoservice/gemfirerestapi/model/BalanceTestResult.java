package com.todoservice.gemfirerestapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceTestResult {

	private String input;
	private boolean isBalanced;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	@JsonProperty("isBalanced")
	public boolean isBalanced() {
		return isBalanced;
	}

	public void setBalanced(boolean isBalanced) {
		this.isBalanced = isBalanced;
	}




}