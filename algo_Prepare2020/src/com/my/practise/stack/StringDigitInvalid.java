package com.my.practise.stack;

import java.util.HashMap;
import java.util.Stack;

// 思路看下，这个其实是一个字符串匹配的简化版本

public class StringDigitInvalid {

	private static HashMap<Character, Character> mappings;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		mappings = new HashMap<Character, Character>();
		mappings.put(')', '(');
		mappings.put('}', '{');
		mappings.put(']', '[');

		String string = "([)]";
		boolean isValid = isValid(string);
		System.out.println("isValid: " + isValid);
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (mappings.containsKey(ch)) {
				Character topCharacter = '#';
				if (!stack.isEmpty()) {
					topCharacter = stack.pop();
				}

				if (topCharacter != mappings.get(ch)) {
					return false;
				}
			} else {
				stack.push(ch);
			}
		}

		return stack.isEmpty();
	}

}
