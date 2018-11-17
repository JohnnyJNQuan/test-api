package com.todoservice.gemfirerestapi.model;


import java.time.OffsetDateTime;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

 
@Region("todoitem")
public class ToDoItem {
	
	private static AtomicLong COUNTER = new AtomicLong(0L);
	
    @Id
    private Long id;
    @Min(1)
    @Max(50)
    private String text;
    private String createAt = OffsetDateTime.now().toString();
    private boolean isCompleted = false;
     
    @PersistenceConstructor
	public ToDoItem() {
		this.id = COUNTER.incrementAndGet();
	}
 
    public long getId() {
        return id;
    }
    
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
    }
    
    public String getCreateAt() {
        return createAt;
    }
    
    
    public boolean getIsCompleted() {
        return isCompleted;
    }
 
    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

     
//    public String toString(){
//        return "firstname: " + firstname + " ,lastname: " + lastname + " ,age: " + age; 
//    }

}