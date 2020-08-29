package com.my.practise.stack;

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//		int result = maxSubArray(nums);
//		System.out.println("tanxin  solution: " + result);
		
		int result = maxSubArray2(nums);
		System.out.println("dp  solution: " + result);
	}

	/**
	 * 贪心
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
		if ((nums == null) || nums.length == 0) {
			return 0;
		}

		int result = nums[0];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum > 0) {
				sum += nums[i];
			} else {
				sum = nums[i];
			}

			result = Math.max(sum, result);
		}

		return result;
	}
	
	/**
	 * 动态规划
	 * @param nums
	 * @return
	 */
	public static int maxSubArray2(int[] nums) {
		if ((nums == null) || nums.length == 0) {
			return 0;
		}
		
		int[] dp = new int[nums.length];
		dp[0] = nums[0];

		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			result = Math.max(result, dp[i]);
		}
		return result;
	}

}
