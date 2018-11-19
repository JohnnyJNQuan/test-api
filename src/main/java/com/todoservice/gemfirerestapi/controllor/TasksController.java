package com.todoservice.gemfirerestapi.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todoservice.gemfirerestapi.exception.ValidationErrorException;
import com.todoservice.gemfirerestapi.model.BalanceTestResult;
import com.todoservice.gemfirerestapi.services.ValidationService;

public class TasksController {
	@Autowired
	private ValidationService ValidationService;
	
	@RequestMapping("/tasks/validateBrackets")
	public BalanceTestResult validateBrackets(@RequestParam(value = "input") String input) throws Exception{
		if (input.length()>50 ||input.length()<1 ) 
			throw new ValidationErrorException(input);
		return ValidationService.getValidateBracketsModel(input);
	}
}
