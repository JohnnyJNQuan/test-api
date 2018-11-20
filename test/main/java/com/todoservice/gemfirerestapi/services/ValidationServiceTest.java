package com.todoservice.gemfirerestapi.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.todoservice.gemfirerestapi.model.BalanceTestResult;



@RunWith(SpringJUnit4ClassRunner.class)
public class ValidationServiceTest {
	
	@InjectMocks
	private ValidationServiceImp validationService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSingleOpenOne(){
		
		BalanceTestResult result = validationService.getValidateBracketsModel("[");
		assertEquals("[", result.getInput());
		assertEquals(false, result.isBalanced());
	}
	
	@Test
	public void testSingleOpenTwo(){
		
		BalanceTestResult result = validationService.getValidateBracketsModel("{");
		assertEquals("{", result.getInput());
		assertEquals(false, result.isBalanced());
	}
	
	@Test
	public void testSingleOpenThree(){
		
		BalanceTestResult result = validationService.getValidateBracketsModel("(");
		assertEquals("(", result.getInput());
		assertEquals(false, result.isBalanced());
	}
	
	@Test
	public void testSingleCloseOne(){
		
		BalanceTestResult result = validationService.getValidateBracketsModel("]");
		assertEquals("]", result.getInput());
		assertEquals(false, result.isBalanced());
	}
	
	@Test
	public void testSingleCloseTwo(){
		
		BalanceTestResult result = validationService.getValidateBracketsModel("}");
		assertEquals("}", result.getInput());
		assertEquals(false, result.isBalanced());
	}
	
	@Test
	public void testSingleCloseThree(){
		
		BalanceTestResult result = validationService.getValidateBracketsModel(")");
		assertEquals(")", result.getInput());
		assertEquals(false, result.isBalanced());
	}
	
	
	@Test
	public void testMalIsBalancedFunction(){
        final Map<Character, Character> balancedHashMap = new HashMap<Character, Character>();
        balancedHashMap.put('}', '{');
        balancedHashMap.put(']', '[');
        balancedHashMap.put(')', '(');
		boolean result = ValidationServiceImp.isBalanced("{[}{]", new LinkedList<Character>(), balancedHashMap);
		assertEquals(false, result);
	}
	
	@Test
	public void testSingleMalIsBalancedFunction(){
        final Map<Character, Character> balancedHashMap = new HashMap<Character, Character>();
        balancedHashMap.put('}', '{');
        balancedHashMap.put(']', '[');
        balancedHashMap.put(')', '(');
		boolean result = ValidationServiceImp.isBalanced("}", new LinkedList<Character>(), balancedHashMap);
		assertEquals(false, result);
	}
	
	@Test
	public void testNullIsBalancedFunction(){
        final Map<Character, Character> balancedHashMap = new HashMap<Character, Character>();
        balancedHashMap.put('}', '{');
        balancedHashMap.put(']', '[');
        balancedHashMap.put(')', '(');
		boolean result = ValidationServiceImp.isBalanced(null, new LinkedList<Character>(), balancedHashMap);
		assertEquals(true, result);
	}

}
