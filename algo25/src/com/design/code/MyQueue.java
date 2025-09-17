package com.design.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于ArrayList 实现队列
 * @param <T>
 */
public class MyQueue<T> {

	private List<T> list;

	public MyQueue() {
		this.list = new ArrayList<>();
	}

	public void enqueue(T item) {
		list.add(item);
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("list is empty, no data");
		}

		return list.remove(0);
	}

	public T front() {
		if (isEmpty()) {
			throw new RuntimeException("list is empty, no data");
		}

		return list.get(0);
	}

	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	public int size() {
		return list.size();
	}

}
