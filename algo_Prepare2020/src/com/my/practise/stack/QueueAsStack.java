package com.my.practise.stack;

import java.util.LinkedList;

// 这个比较简单，直接使用 linkedlist 模拟了

public class QueueAsStack {

	private LinkedList<Integer> linkedList = new LinkedList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** Initialize your data structure here. */
	public QueueAsStack() {
		linkedList = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		linkedList.add(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return linkedList.removeLast();
	}

	/** Get the top element. */
	public int top() {
		return linkedList.getLast();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return linkedList.size() == 0;
	}

}
