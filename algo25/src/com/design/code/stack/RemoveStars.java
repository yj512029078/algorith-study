package com.design.code.stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class RemoveStars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leet**cod*e";
		String resultString = removeStars2(s);
		System.out.println(resultString);

		s = "erase*****";
		resultString = removeStars2(s);
		System.out.println(resultString);
	}

	// 有个比较大的问题是，全部加入了栈，从后往前处理会有问题；主要是导致stack overflow
	public static String removeStars(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		Stack<Character> stack = new Stack<Character>();
		LinkedList<Character> linkedList = new LinkedList<Character>();

		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}

		// 注意搞清楚顺序，addFirst removeFirst
		while (!stack.isEmpty()) {
			Character character = stack.pop();

			if (character != '*' && linkedList.size() > 0 && linkedList.getFirst() == '*') {
				linkedList.removeFirst();
			} else {
				linkedList.addFirst(character);
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < linkedList.size(); i++) {
			stringBuilder.append(linkedList.get(i));
		}

		String resultString = stringBuilder.toString();
		return resultString;
	}

	// 顺着遍历数组，添加到栈顶，如果碰到*，就移出栈顶
	public static String removeStars2(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		ArrayDeque<Character> stack = new ArrayDeque<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}

		// stringBuilder 可以做reverse
		StringBuilder stringBuilder = new StringBuilder();
		while (!stack.isEmpty()) {
			Character character = stack.pop();
			stringBuilder.append(character);
		}

		String resultString = stringBuilder.reverse().toString();
		return resultString;
	}

}
