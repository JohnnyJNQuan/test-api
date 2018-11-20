package com.todoservice.gemfirerestapi.services;

import org.springframework.stereotype.Service;

import com.todoservice.gemfirerestapi.model.BalanceTestResult;

public interface ValidationService {
	
	public BalanceTestResult getValidateBracketsModel(String input);
}
