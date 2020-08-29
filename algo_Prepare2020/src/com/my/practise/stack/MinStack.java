package com.my.practise.stack;

import java.util.Stack;

// 最小值，这个找个变量保存一下就可以了

public class MinStack {

	static class Node {
		int val;
		int minValue;
	}

	private static Stack<Node> stack = new Stack<MinStack.Node>();

	public static void main(String[] args) {
		push(-2);
		push(0);
		push(-3);

		int min = getMin();
		System.out.println("min: " + min);

		pop();
		int top = top();
		System.out.println("top: " + top);

		min = getMin();
		System.out.println("min: " + min);
	}

	public static void push(int x) {
		Node node = new Node();
		node.val = x;

		int minValue = x;
		if (!stack.isEmpty()) {
			int temp = stack.peek().minValue;
			if (temp < minValue) {
				minValue = temp;
			}
		}
		node.minValue = minValue;
		stack.push(node);
	}

	public static void pop() {
		stack.pop();
	}

	public static int top() {
		if (!stack.isEmpty()) {
			return stack.peek().val;
		} else {
			return Integer.MIN_VALUE;
		}
	}

	public static int getMin() {
		if (!stack.isEmpty()) {
			return stack.peek().minValue;
		} else {
			return Integer.MIN_VALUE;
		}
	}

}
