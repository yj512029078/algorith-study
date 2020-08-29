package com.my.practise.dp;

// 常规思路，看看还好

public class Massage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int time[] = new int[] { 2, 7, 9, 3, 1 };
		int result = massage(time);
		System.out.println("result: " + result);
	}

	public static int massage(int[] nums) {
		if ((nums == null) || (nums.length == 0)) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		// 也可以从下标 0 开始算，构造长度为N
		int dp[] = new int[nums.length + 1];
		dp[1] = nums[0];
		dp[2] = Math.max(nums[0], nums[1]);

		for (int i = 3; i <= nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
		}

		return dp[nums.length];
	}

}
