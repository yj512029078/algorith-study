package com.my.practise.heap;

import java.util.PriorityQueue;

// 这个思想：本质上就是堆排序；堆排序可以使用 PriorityQueue
// peek, poll, add

public class KthLargest {

	private static PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	private static int limit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int add(int val) {
		if (queue.size() < limit) {
			queue.add(val);
		} else if (val > queue.peek()) {
			queue.poll();
			queue.add(val);
		}

		return queue.peek();
	}

}
