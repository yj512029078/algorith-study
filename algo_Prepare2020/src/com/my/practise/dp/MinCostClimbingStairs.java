package com.my.practise.dp;

// 这个就简单抄了下答案

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int costs[] = new int[] { 10, 15, 20 };
		int result = minCostClimbingStairs(costs);
		System.out.println("result: " + result);
	}

	public static int minCostClimbingStairs(int[] cost) {
		if (cost.length == 0)
			return 0;
		int[] dp = new int[cost.length];
		dp[0] = cost[0];
		dp[1] = cost[1];
		for (int i = 2; i < cost.length; i++) {
			dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
		}
		// 核心应该是这里，直接比较是 1 / 2；因为开始 从哪一个开始都可以
		return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
	}

}
