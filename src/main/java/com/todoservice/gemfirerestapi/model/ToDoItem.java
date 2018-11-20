package com.todoservice.gemfirerestapi.model;


import java.time.OffsetDateTime;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

import com.fasterxml.jackson.annotation.JsonProperty;

 
@Region("todoitem")
public class ToDoItem {
	
	private static AtomicLong COUNTER = new AtomicLong(0L);
	
    @Id
    private Long id;
    private String text;
    private String createAt;
    private boolean isCompleted;
     
    @PersistenceConstructor
	public ToDoItem() {
		this.id = COUNTER.incrementAndGet();
		this.createAt = OffsetDateTime.now().toString();
		this.isCompleted = false;
	}
    @JsonProperty("id")
    public long getId() {
        return id;
    }
    @JsonProperty("text")
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
    }
    @JsonProperty("createdAt")
    public String getCreateAt() {
        return createAt;
    }
    
    @JsonProperty("isCompleted")
    public boolean getIsCompleted() {
        return isCompleted;
    }
 
    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }



}