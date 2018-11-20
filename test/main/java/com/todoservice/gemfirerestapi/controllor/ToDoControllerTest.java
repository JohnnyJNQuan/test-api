package com.todoservice.gemfirerestapi.controllor;

import static org.junit.Assert.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.todoservice.gemfirerestapi.SpringBootGemfireRestfulApiApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootGemfireRestfulApiApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ToDoControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	
	@Test
	public void verifySaveToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/todo/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"text\" : \"New ToDo Sample\"}")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.text").exists())
		.andExpect(jsonPath("$.isCompleted").exists())
		.andExpect(jsonPath("$.createdAt").exists())
		.andExpect(jsonPath("$.text").value("New ToDo Sample"))
		.andExpect(jsonPath("$.isCompleted").value(false))
		.andDo(print());
	}
	
	@Test
	public void verifyMinMalformedSaveToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/todo/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{ \"text\" : \"\" }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.details[0].location").value("params"))
		.andExpect(jsonPath("$.details[0].param").value("text"))
		.andExpect(jsonPath("$.details[0].msg").value("Must be between 1 and 50 chars long"))
		.andExpect(jsonPath("$.details[0].value").value(""))
		.andExpect(jsonPath("$.name").value("ValidationError"))
		.andDo(print());
	}
	
	@Test
	public void verifyMaxMalformedSaveToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/todo/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{ \"text\" : \"123456789012345678901234567890123456789012345678901234567890\" }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.details[0].location").value("params"))
		.andExpect(jsonPath("$.details[0].param").value("text"))
		.andExpect(jsonPath("$.details[0].msg").value("Must be between 1 and 50 chars long"))
		.andExpect(jsonPath("$.details[0].value").value("123456789012345678901234567890123456789012345678901234567890"))
		.andExpect(jsonPath("$.name").value("ValidationError"))
		.andDo(print());
	}
	
	@Test
	public void verifyNullInputSaveToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/todo/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{ }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.details[0].location").value("params"))
		.andExpect(jsonPath("$.details[0].param").value("text"))
		.andExpect(jsonPath("$.details[0].msg").value("Text field must be defined"))
		.andExpect(jsonPath("$.name").value("ValidationError"))
		.andDo(print());
	}
	
	@Test
	public void verifyToDoById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/todo/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.text").exists())
		.andExpect(jsonPath("$.isCompleted").exists())
		.andExpect(jsonPath("$.createdAt").exists())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.text").value("New ToDo Sample"))
		.andExpect(jsonPath("$.isCompleted").value(false))
		.andDo(print());
	}
	
	@Test
	public void verifyInvalidToDoId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/todo/0").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.details[0].message").value("Item with 0 not found"))
		.andExpect(jsonPath("$.name").value("NotFoundError"))
		.andDo(print());
	}
	
	@Test
	public void verifyNullToDoId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/todo/99").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.details[0].message").value("Item with 99 not found"))
		.andExpect(jsonPath("$.name").value("NotFoundError"))
		.andDo(print());
	}
	
	@Test
	public void verifyUpdateToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/todo/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"text\" : \"Updated ToDo Text\", \"isCompleted\" : \"true\" }")
        .accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.text").exists())
		.andExpect(jsonPath("$.isCompleted").exists())
		.andExpect(jsonPath("$.createdAt").exists())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.text").value("Updated ToDo Text"))
		.andExpect(jsonPath("$.isCompleted").value(true))
		.andDo(print());
	}
	

	@Test
	public void verifyMinInvalidToDoUpdate() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/todo/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"text\" : \"\", \"isCompleted\" : \"true\" }")
        .accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.details[0].location").value("params"))
		.andExpect(jsonPath("$.details[0].param").value("text"))
		.andExpect(jsonPath("$.details[0].msg").value("Must be between 1 and 50 chars long"))
		.andExpect(jsonPath("$.details[0].value").value(""))
		.andExpect(jsonPath("$.name").value("ValidationError"))
		.andDo(print());
	}
	@Test
	public void verifyMaxInvalidToDoUpdate() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/todo/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"text\" : \"123456789012345678901234567890123456789012345678901234567890\", \"isCompleted\" : \"true\" }")
        .accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.details[0].location").value("params"))
		.andExpect(jsonPath("$.details[0].param").value("text"))
		.andExpect(jsonPath("$.details[0].msg").value("Must be between 1 and 50 chars long"))
		.andExpect(jsonPath("$.details[0].value").value("123456789012345678901234567890123456789012345678901234567890"))
		.andExpect(jsonPath("$.name").value("ValidationError"))
		.andDo(print());
	}
	

}
