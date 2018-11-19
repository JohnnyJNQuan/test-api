package com.todoservice.gemfirerestapi.model;

public class BracersTestResult {
	private String input;
	private boolean result;
	private boolean expected;
	private boolean fisCorrect;
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public boolean isExpected() {
		return expected;
	}
	public void setExpected(boolean expected) {
		this.expected = expected;
	}
	public boolean isFisCorrect() {
		return fisCorrect;
	}
	public void setFisCorrect(boolean fisCorrect) {
		this.fisCorrect = fisCorrect;
	}
}
