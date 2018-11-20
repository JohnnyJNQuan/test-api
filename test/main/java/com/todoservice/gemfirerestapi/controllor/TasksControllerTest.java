package com.todoservice.gemfirerestapi.controllor;

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
public class TasksControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	// verify balanced input
	@Test
	public void verifyBlanceTasks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/tasks/validateBrackets").param("input", "{test}[test](test)")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.input").exists())
				.andExpect(jsonPath("$.isBalanced").exists()).andExpect(jsonPath("$.input").value("{test}[test](test)"))
				.andExpect(jsonPath("$.isBalanced").value(true)).andDo(print());
	}

	// verify balanced input without brackets
	@Test
	public void verifyBlanceTasksWithOutBrackets() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/tasks/validateBrackets")
				.param("input", "verifyBlanceTasksWithOutBrackets").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.input").exists()).andExpect(jsonPath("$.isBalanced").exists())
				.andExpect(jsonPath("$.input").value("verifyBlanceTasksWithOutBrackets"))
				.andExpect(jsonPath("$.isBalanced").value(true)).andDo(print());
	}

	// verify imbalance input
	@Test
	public void verifyFalseBlanceTasks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/tasks/validateBrackets").param("input", "]{(})[")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.input").exists())
				.andExpect(jsonPath("$.isBalanced").exists()).andExpect(jsonPath("$.input").value("]{(})["))
				.andExpect(jsonPath("$.isBalanced").value(false)).andDo(print());
	}

	// verify single imbalance bracket
	@Test
	public void verifySingleImBlanceTasks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/tasks/validateBrackets").param("input", "}")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.input").exists())
				.andExpect(jsonPath("$.isBalanced").exists()).andExpect(jsonPath("$.input").value("}"))
				.andExpect(jsonPath("$.isBalanced").value(false)).andDo(print());
	}

	// verify empty input
	@Test
	public void verifyInvalidInput() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/tasks/validateBrackets").param("input", "")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.details[0].location").value("query"))
				.andExpect(jsonPath("$.details[0].param").value("input"))
				.andExpect(jsonPath("$.details[0].msg").value("Invalid value"))
				.andExpect(jsonPath("$.details[0].value").value(""))
				.andExpect(jsonPath("$.name").value("ValidationError")).andDo(print());
	}
}
