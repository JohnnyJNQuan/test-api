package com.todoservice.gemfirerestapi.services;

import java.util.LinkedList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.todoservice.gemfirerestapi.model.BalanceTestResult;

public interface ValidationService {
	
	public BalanceTestResult getValidateBracketsModel(String input);
}
