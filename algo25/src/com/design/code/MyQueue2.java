package com.design.code;

import java.util.Stack;

/**
 * 基于 stack 实现队列
 * 
 * @param <T>
 */
public class MyQueue2<T> {
	private Stack<T> inStack;
	private Stack<T> outStack;

	public MyQueue2() {
		inStack = new Stack<T>();
		outStack = new Stack<T>();
	}

	public void enqueue(T item) {
		inStack.push(item);
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		}

		if (!outStack.isEmpty()) {
			return outStack.pop();
		}

		while (!inStack.isEmpty()) {
			T value = inStack.pop();
			outStack.push(value);
		}
		return outStack.pop();
	}

	public boolean isEmpty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}

	public int size() {
		return inStack.size() + outStack.size();
	}

	public T front() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		}

		if (!outStack.isEmpty()) {
			return outStack.peek();
		}

		while (!inStack.isEmpty()) {
			T value = inStack.pop();
			outStack.push(value);
		}
		return outStack.peek();
	}

}
