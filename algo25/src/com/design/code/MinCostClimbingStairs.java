package com.design.code;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cost[] = new int[] { 10, 15, 20 };
		int minCost = minCostClimbingStairs(cost);
		System.out.println(minCost);
	}

	// DP 迭代的解法
	// 注意cost 的含义，以及终点index，不是 cost.length - 1
	public static int minCostClimbingStairs(int[] cost) {
		if (cost == null || cost.length == 0) {
			return 0;
		}

//		int dpCost[] = new int[cost.length + 1];
//		int minCost = dp(dpCost, cost);
//		return minCost;
		
		int minCost = dp2(cost, cost.length);
		return minCost;
	}

	public static int dp(int[] dpCost, int[] cost) {
		if (cost == null || cost.length == 0) {
			return 0;
		}

		dpCost[0] = 0;
		dpCost[1] = 0;

		for (int i = 2; i < dpCost.length; i++) {
			dpCost[i] = Math.min(dpCost[i - 1] + cost[i - 1], dpCost[i - 2] + cost[i - 2]);
		}
		return dpCost[dpCost.length - 1];
	}

	// 递归的解法
	// DP 迭代的解法
	// 注意cost 的含义，以及终点index，不是 cost.length - 1
	public static int minCostClimbingStairs2(int[] cost) {
		if (cost == null || cost.length == 0) {
			return 0;
		}

		int dpCost[] = new int[cost.length + 1];
		int minCost = dp(dpCost, cost);
		return minCost;
	}

	public static int dp2(int[] cost, int index) {
		if (cost == null || cost.length == 0) {
			return 0;
		}

		if (index == 0 || index == 1) {
			return 0;
		}

		int value = Math.min(dp2(cost, index - 1) + cost[index - 1], dp2(cost, index - 2) + cost[index - 2]);
		return value;
	}

}
