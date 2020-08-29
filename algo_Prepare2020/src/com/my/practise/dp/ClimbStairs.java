package com.my.practise.dp;

// 状态转移方程要思考清楚: dp[i] = dp[i - 1] + dp[i - 2]

public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int result = climbStairs(n);
		System.out.println("result: " + result);
	}

	public static int climbStairs(int n) {
		int dp[] = new int[n + 1];

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			// result[i] = Math.max(result[i - 1], result[i - 2] + 2);
			// 注意：这里不是比较最大值；而是直接 想加
			dp[i] = dp[i - 1] + dp[i - 2];
			System.out.println("temp: " + dp[i]);
		}

		return dp[n];
	}

}
