package com.todoservice.gemfirerestapi.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.todoservice.gemfirerestapi.model.ValidateBracketsModel;

@Service
public class ValidationService {
    public ValidateBracketsModel getValidateBracketsModel(String input) {
    	ValidateBracketsModel validateBracketsModel = new ValidateBracketsModel();
    	if (!filterEndBrakets(input)) {
    		validateBracketsModel.setInput(input);
            validateBracketsModel.setBalanced(false);

        	return validateBracketsModel;
    	}
        final Map<Character, Character> closeToOpen = new HashMap<Character, Character>();
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');
        closeToOpen.put(')', '(');
        validateBracketsModel.setInput(input);
        validateBracketsModel.setBalanced(isBalanced(input, new LinkedList<Character>(), closeToOpen));

    	return validateBracketsModel;
    }
    
    private static boolean isBalanced(final String str1, final LinkedList<Character> openedBrackets, final Map<Character, Character> closeToOpen) {
        if ((str1 == null) || str1.isEmpty()) {
            return openedBrackets.isEmpty();
        } else if (closeToOpen.containsValue(str1.charAt(0))) {
            openedBrackets.add(str1.charAt(0));
            return isBalanced(str1.substring(1), openedBrackets, closeToOpen);
        } else if (closeToOpen.containsKey(str1.charAt(0))) {
            if (openedBrackets.getLast() == closeToOpen.get(str1.charAt(0))) {
                openedBrackets.removeLast();
                return isBalanced(str1.substring(1), openedBrackets, closeToOpen);
            } else {
                return false;
            }
        } else {
            return isBalanced(str1.substring(1), openedBrackets, closeToOpen);
        }
    }
    private static boolean filterEndBrakets(String str) {
        boolean bool = true;
        char c;
        for(int i=0; i < str.length(); i++) {
            c = str.charAt(i);

            if(c == '(' || c == '['  || c == '{' ) {
            	bool = true;
            	break;
            }else if (c == ')' || c == ']'  || c == '}') {
            	bool = false;
            	break;
            }
        }
        return bool;
    }
    
}