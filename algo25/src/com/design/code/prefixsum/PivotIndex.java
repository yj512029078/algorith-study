package com.design.code.prefixsum;

public class PivotIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 1, 7, 3, 6, 5, 6 };
		int pivotIndex = pivotIndex(nums);
		System.out.println(pivotIndex);

		nums = new int[] { 1, 2, 3 };
		pivotIndex = pivotIndex(nums);
		System.out.println(pivotIndex);

		nums = new int[] { 2, 1, -1 };
		pivotIndex = pivotIndex(nums);
		System.out.println(pivotIndex);
	}

	public static int pivotIndex(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		int pivotIndex = -1;
		int pivotSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (pivotSum * 2 + nums[i] == sum) {
				pivotIndex = i;
				break;
			}
			pivotSum += nums[i];
		}

		return pivotIndex;
	}

}
