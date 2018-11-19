package com.todoservice.gemfirerestapi.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoservice.gemfirerestapi.model.BalanceTestResult;
import com.todoservice.gemfirerestapi.services.ValidationService;

@RestController
public class TasksController {
	@Autowired
	private ValidationService ValidationService;
	
	@GetMapping("/tasks/validateBrackets")
	public BalanceTestResult validateBrackets(@RequestParam(value = "input") String input) throws Exception{
		return ValidationService.getValidateBracketsModel(input);
	}
}
