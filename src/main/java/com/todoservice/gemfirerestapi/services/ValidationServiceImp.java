package com.todoservice.gemfirerestapi.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.todoservice.gemfirerestapi.model.BalanceTestResult;

@Service("ValidationService")
public class ValidationServiceImp implements ValidationService {
	// Validate the input is balanced or not
	@Override
	public BalanceTestResult getValidateBracketsModel(String input) {
		BalanceTestResult validateBracketsModel = new BalanceTestResult();
		if (!filterEndBrakets(input)) {
			validateBracketsModel.setInput(input);
			validateBracketsModel.setBalanced(false);

			return validateBracketsModel;
		}
		final Map<Character, Character> balancedHashMap = new HashMap<Character, Character>();
		balancedHashMap.put('}', '{');
		balancedHashMap.put(']', '[');
		balancedHashMap.put(')', '(');
		validateBracketsModel.setInput(input);
		validateBracketsModel.setBalanced(isBalanced(input, new LinkedList<Character>(), balancedHashMap));

		return validateBracketsModel;
	}

	// check whether the input is balanced or not
	public static boolean isBalanced(final String str1, final LinkedList<Character> startedList,
			final Map<Character, Character> balancedHashMap) {
		if ((str1 == null) || str1.isEmpty()) {
			return startedList.isEmpty();
		} else if (balancedHashMap.containsValue(str1.charAt(0))) { // if find {, [ or ( add to linkedList
			startedList.add(str1.charAt(0));
			return isBalanced(str1.substring(1), startedList, balancedHashMap);
		} else if (balancedHashMap.containsKey(str1.charAt(0))) { // if find },] or ) remove last added item.
			if (startedList.size() != 0 && startedList.getLast() == balancedHashMap.get(str1.charAt(0))) {
				startedList.removeLast();
				return isBalanced(str1.substring(1), startedList, balancedHashMap);
			} else {
				return false;
			}
		} else {
			return isBalanced(str1.substring(1), startedList, balancedHashMap); // input without brackets
		}
	}

	// Filter the single closed bracket
	private static boolean filterEndBrakets(String str) {
		boolean bool = true;
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);

			if (c == '(' || c == '[' || c == '{') {
				bool = true;
				break;
			} else if (c == ')' || c == ']' || c == '}') {
				bool = false;
				break;
			}
		}
		return bool;
	}

}