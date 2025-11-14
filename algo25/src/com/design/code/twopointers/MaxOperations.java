package com.design.code.twopointers;

import java.util.Arrays;

public class MaxOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 1, 2, 3, 4 };
		int k = 5;

		int result = maxOperations(nums, k);
		System.out.println(result);

		nums = new int[] { 3, 1, 3, 4, 3 };
		k = 6;

		result = maxOperations(nums, k);
		System.out.println(result);
	}

	public static int maxOperations(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Arrays.sort(nums);

		int low = 0;
		int high = nums.length - 1;

		int count = 0;
		while (low < high) {
			if (nums[high] + nums[low] == k) {
				count++;

				low++;
				high--;
				continue;
			}

			if (nums[high] + nums[low] > k) {
				high--;
			} else {
				low++;
			}
		}

		return count;
	}

}
