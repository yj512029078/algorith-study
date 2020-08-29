package com.my.practise.greedy;

import java.util.Arrays;

// 比较朴素的思想：反正总是将最小的元素替换
// 贪心有一类涉及到的就是 排序，永远取最小 OR  最大

public class LargestSumAfterKNegations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 2, 3 };

		int result = largestSumAfterKNegations(nums, 1);
		System.out.println("result: " + result);
	}

	public static int largestSumAfterKNegations(int[] A, int K) {
		if (A == null) {
			return 0;
		}

		while (K-- > 0) {
			Arrays.sort(A);
			A[0] = -A[0];
		}

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		return sum;
	}

}
