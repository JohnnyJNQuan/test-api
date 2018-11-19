package com.todoservice.gemfirerestapi.controllor;

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
import com.todoservice.gemfirerestapi.exception.ItemNotFoundException;
import com.todoservice.gemfirerestapi.exception.ValidationErrorException;;

@RestController
public class ToDoController {
	@Autowired
	private TodoRepository todoRepository;
	
	@RequestMapping("/todo/{id}")
    public ResponseEntity<ToDoItem>  getItem(@PathVariable("id") long id) throws Exception {
		if(todoRepository.findById(id)==null) throw new ItemNotFoundException("Item with "+id+" not found");
    	 return new ResponseEntity<ToDoItem>(todoRepository.findById(id), HttpStatus.OK);
    }

	@PostMapping("/todo")
    public ResponseEntity<ToDoItem> postItem( @RequestBody ToDoItemAddRequest viewModel)throws Exception {
		if (viewModel.getText().length()>50 ||viewModel.getText().length()<1 ) 
			throw new ValidationErrorException(viewModel.getText());
		ToDoItem toDoItem = new ToDoItem();
		toDoItem.setText(viewModel.getText());
		todoRepository.save(toDoItem);
    
    	 return new ResponseEntity<ToDoItem>(toDoItem, HttpStatus.OK);
    }
	
	@PatchMapping("/todo/{id}")
    public ResponseEntity<ToDoItem> patchItem(@RequestBody ToDoItemAddRequest viewModel, @PathVariable("id") long id ) throws Exception {
		if (viewModel.getText().length()>50 ||viewModel.getText().length()<1 ) 
			throw new ValidationErrorException(viewModel.getText());
		ToDoItem toDoItem = todoRepository.findById(id);
		toDoItem.setText(viewModel.getText());
		todoRepository.save(toDoItem);
    
    	 return new ResponseEntity<ToDoItem>(toDoItem, HttpStatus.OK);
    }


}