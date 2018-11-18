package com.todoservice.gemfirerestapi.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.todoservice.gemfirerestapi.services.ValidationService;
import com.todoservice.gemfirerestapi.model.ToDoItem;
import com.todoservice.gemfirerestapi.model.ToDoItemViewModel;
import com.todoservice.gemfirerestapi.model.ValidateBracketsModel;
import com.todoservice.gemfirerestapi.repository.*;
import com.todoservice.gemfirerestapi.model.ToDoItem;

@RestController
public class ToDoController {
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private ValidationService ValidationService;

	@RequestMapping("/items")
	public Iterable<ToDoItem> getAllItems() {
		return todoRepository.findAll();
	}
	
	@RequestMapping("/todo/{id}")
    public ToDoItem getItem(@PathVariable("id") long id) {
    
    	 return todoRepository.findById(id);
    }

	@PostMapping("/todo")
    public ToDoItem postItem(@RequestBody ToDoItemViewModel viewModel) {

		ToDoItem toDoItem = new ToDoItem();
		toDoItem.setText(viewModel.getText());
		todoRepository.save(toDoItem);
    
    	 return toDoItem;
    }
	
	@PatchMapping("/todo/{id}")
    public ToDoItem patchItem(@RequestBody ToDoItemViewModel viewModel, @PathVariable("id") long id ) {

		ToDoItem toDoItem = todoRepository.findById(id);
		toDoItem.setText(viewModel.getText());
		todoRepository.save(toDoItem);
    
    	 return toDoItem;
    }

	@RequestMapping("/tasks/validateBrackets")
	public ValidateBracketsModel validateBrackets(@RequestParam(value = "input") String input) {
		return ValidationService.getValidateBracketsModel(input);
	}
}