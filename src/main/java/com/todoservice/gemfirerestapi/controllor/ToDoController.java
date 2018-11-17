package com.todoservice.gemfirerestapi.controllor;

import org.springframework.beans.factory.annotation.Autowired;
//import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoservice.gemfirerestapi.services.ValidationService;
import com.todoservice.gemfirerestapi.model.ToDoItem;
import com.todoservice.gemfirerestapi.model.ValidateBracketsModel;
import com.todoservice.gemfirerestapi.repository.*;

@RestController
public class ToDoController {
	  @Autowired
	  private TodoRepository TodoRepository;
	  @Autowired
	   private ValidationService ValidationService;
    @RequestMapping("/item")
    public Iterable<ToDoItem> greeting() {
        return TodoRepository.findAll();
    }
    @RequestMapping("/tasks/validateBrackets")
    public ValidateBracketsModel validateBrackets(@RequestParam(value="input") String input) {
        return ValidationService.getValidateBracketsModel(input);
    }
}