package com.design.code.heap;

import java.util.PriorityQueue;

public class FindKthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		int result = findKthLargest(nums, k);
		System.out.println(result);

		nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		k = 4;
		result = findKthLargest(nums, k);
		System.out.println(result);
	}

	// 思路1：直接使用堆
	// 思路2：做排序，把K 个最大的元素放在右边
	public static int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length < k) {
			return 0;
		}

		// 第K 大，使用小堆；如果反过来，第K小，需要使用大堆
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for (int i = 0; i < nums.length; i++) {
			priorityQueue.offer(nums[i]);
		}

		while (priorityQueue.size() > k) {
			priorityQueue.poll();
		}

		int result = priorityQueue.peek();
		return result;
	}

}
