package com.design.code;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 2, 2, 1 };
		int result = singleNumber(nums);
		System.out.println(result);

		nums = new int[] { 4, 1, 2, 1, 2 };
		result = singleNumber(nums);
		System.out.println(result);
	}

	public static int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result = result ^ nums[i];
		}

		return result;
	}

}
