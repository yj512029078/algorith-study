package com.my.practise.stack;

import java.util.Stack;

// 2个栈模拟一个队列，思路大概看看

public class StackAsQueue {

	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	private int front = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		if (stack1.isEmpty()) {
			front = x;
		}
		stack1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty())
				stack2.push(stack1.pop());
		}
		return stack2.pop();

		// if(!stack2.isEmpty()) {
		// return stack2.pop();
		// }

		// if (!stack1.isEmpty()) {
		// int size = stack1.size();
		// for (int x = 0; x < size; x++) {
		// stack2.push(stack1.pop());
		// System.out.print("pop, push " + x);
		// }
		// }

		// if (!empty()) {
		// return stack2.pop();
		// } else {
		// return -1;
		// }
	}

	/** Get the front element. */
	public int peek() {
		if (!stack2.isEmpty()) {
			return stack2.peek();
		} else {
			return front;
		}
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

}
