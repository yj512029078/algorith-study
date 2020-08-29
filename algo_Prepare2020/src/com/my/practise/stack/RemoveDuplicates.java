package com.my.practise.stack;

import java.util.Stack;

// 看下就行了，Stack 

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String removeDuplicates(String s) {
		if (s == null) {
			return s;
		}
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < chars.length; i++) {
			if (stack.isEmpty() || stack.peek() != chars[i]) {
				stack.push(chars[i]);
			} else {
				stack.pop();
			}
		}

		StringBuffer buffer = new StringBuffer();
		for (Character character : stack) {
			buffer.append(character);
		}

		return buffer.toString();
	}

}
