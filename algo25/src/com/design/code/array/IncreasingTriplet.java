package com.design.code.array;

public class IncreasingTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 1, 2, 3, 4, 5 };
		boolean result = increasingTriplet(nums);
		System.out.println(result);

		nums = new int[] { 5, 4, 3, 2, 1 };
		result = increasingTriplet(nums);
		System.out.println(result);

		nums = new int[] { 2, 1, 5, 0, 4, 6 };
		result = increasingTriplet(nums);
		System.out.println(result);

		nums = new int[] { 5, 1, 6 };
		result = increasingTriplet(nums);
		System.out.println(result);
	}

	// 这个思路比较巧
	// 思路2：暴力遍历，但是有3层循环，不是好的思路
	public static boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		if (nums.length < 3) {
			return false;
		}

		// 这里要注意，初始化为这个MAX_VALUE，为什么不是 nums[0]  nums[1]
		int minimestValue = Integer.MAX_VALUE;
		int secondaryMinVlue = Integer.MAX_VALUE;

		// 怎么有效的找到 minimum  secondaryMin value
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= minimestValue) {
				minimestValue = nums[i];
			} else if (nums[i] <= secondaryMinVlue) {
				secondaryMinVlue = nums[i];
			} else {
				return true;
			}
		}

		return false;
	}

}
