package com.my.practise.dp;

// 这个思路：稍微看下；主要思考下
// dp 问题，有些也是策略问题；并不是所有都要写 dp[i] = max(dp[i -1], dp[i -2] + position[i-1])

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = maxSubArray(arr);
		System.out.println(" result: " + result);
	}

	public static int maxSubArray(int[] nums) {
		if ((nums == null) || nums.length == 0) {
			return 0;
		}

		// 不是使用 0； 避免最终只有1个元素；而结果等于0
		int result = nums[0];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			// 只要和在增大，就继续；否则就终止
			if (sum > 0) {
				sum += nums[i];
			} else {
				sum = nums[i];
			}

			result = Math.max(result, sum);
		}

		return result;
	}

}
