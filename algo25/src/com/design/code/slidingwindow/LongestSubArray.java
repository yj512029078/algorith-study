package com.design.code.slidingwindow;

public class LongestSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 1, 1, 0, 1 };
		int result = longestSubarray(nums);
		System.out.println(result);

		nums = new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
		result = longestSubarray(nums);
		System.out.println(result);

		nums = new int[] { 1, 1, 1 };
		result = longestSubarray(nums);
		System.out.println(result);
	}

	public static int longestSubarray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int longestValue = 0;
		for (int i = 0; i < nums.length; i++) {
			int temp = computeLongestOne(i, nums.length, nums);
			if (temp > longestValue) {
				longestValue = temp;
			}
		}

		return longestValue;
	}

	private static int computeLongestOne(int index, int length, int[] nums) {
		int k = index + 1;
		int rightCount = 0;
		while (k <= (length - 1)) {
			if (nums[k] != 1) {
				break;
			}
			k++;
			rightCount++;
		}

		int m = index - 1;
		int leftCount = 0;
		while (m >= 0) {
			if (nums[m] != 1) {
				break;
			}
			m--;
			leftCount++;
		}

		int result = leftCount + rightCount;
		return result;
	}

}
