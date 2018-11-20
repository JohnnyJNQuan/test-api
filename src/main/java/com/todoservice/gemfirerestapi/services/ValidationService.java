package com.todoservice.gemfirerestapi.services;

import com.todoservice.gemfirerestapi.model.BalanceTestResult;

public interface ValidationService {
	
	public BalanceTestResult getValidateBracketsModel(String input);
}
