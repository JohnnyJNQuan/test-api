package com.todoservice.gemfirerestapi.controllor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.todoservice.gemfirerestapi.services.ValidationService;
import com.todoservice.gemfirerestapi.model.BalanceTestResult;
import com.todoservice.gemfirerestapi.model.ToDoItem;
import com.todoservice.gemfirerestapi.model.ToDoItemAddRequest;
import com.todoservice.gemfirerestapi.repository.*;
import com.todoservice.gemfirerestapi.exception.ItemNotFoundException;;

@RestController
public class ToDoController {
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private ValidationService ValidationService;
	
	@RequestMapping("/todo/{id}")
    public ResponseEntity<ToDoItem>  getItem(@PathVariable("id") long id) {
		if(todoRepository.findById(id)==null) throw new ItemNotFoundException("Item with "+id+" not found");
    	 return new ResponseEntity<ToDoItem>(todoRepository.findById(id), HttpStatus.OK);
    }

	@PostMapping("/todo")
    public ResponseEntity<ToDoItem> postItem( @RequestBody ToDoItemAddRequest viewModel)throws Exception {

		ToDoItem toDoItem = new ToDoItem();
		toDoItem.setText(viewModel.getText());
		todoRepository.save(toDoItem);
    
    	 return new ResponseEntity<ToDoItem>(toDoItem, HttpStatus.OK);
    }
	
	@PatchMapping("/todo/{id}")
    public ResponseEntity<ToDoItem> patchItem(@RequestBody ToDoItemAddRequest viewModel, @PathVariable("id") long id ) {

		ToDoItem toDoItem = todoRepository.findById(id);
		toDoItem.setText(viewModel.getText());
		todoRepository.save(toDoItem);
    
    	 return new ResponseEntity<ToDoItem>(toDoItem, HttpStatus.OK);
    }

	@RequestMapping("/tasks/validateBrackets")
	public BalanceTestResult validateBrackets(@RequestParam(value = "input") String input) {
		return ValidationService.getValidateBracketsModel(input);
	}
}