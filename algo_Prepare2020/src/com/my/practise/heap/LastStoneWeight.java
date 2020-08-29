package com.my.practise.heap;

import java.util.Arrays;

// 思路比较简单清晰：就是不断的排序

public class LastStoneWeight {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 4, 1, 8, 1 };
		int weight = lastStoneWeight(nums);
		System.out.println("weight: " + weight);
	}

	public static int lastStoneWeight(int[] stones) {
		if (stones == null || stones.length == 0) {
			return 0;
		}

		if (stones.length == 1) {
			return stones[0];
		}

		Arrays.sort(stones);
		while (stones[stones.length - 2] != 0) {
			stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
			stones[stones.length - 2] = 0;
			Arrays.sort(stones);
		}

		return stones[stones.length - 1];
	}

}
