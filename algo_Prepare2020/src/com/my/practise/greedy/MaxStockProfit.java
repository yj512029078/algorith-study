package com.my.practise.greedy;

// 贪心策略：这个股市交易策略，简单有效
// 动态规划：贪心的问题，最终都可以转换为 DP 问题

public class MaxStockProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stock[] = new int[] { 7, 1, 5, 3, 6, 4 };
		int maxProfit = MaxProfit(stock);
		System.out.println("stock: " + maxProfit);
	}

	// 这种交易策略本质上是有效的；一定是贪心最大
	// 只是实际上并不会这么处理
	/**
	 * 贪心算法
	 * 
	 * @param prices
	 * @return
	 */
	public static int MaxProfit(int[] prices) {
		int profit = 0;

		// 非常朴素的交易策略
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}

		return profit;
	}

	/**
	 * 基于 DP 的算法
	 */
	// int maxProfit(vector<int>& prices) {
	// // 动态规划解法
	//
	// // 0.初始判断
	// if(prices.empty()) return 0;
	//
	// int dp[prices.size()][2];
	// // 1.初始状态
	// dp[0][0] = 0;
	// dp[0][1] = -prices[0];
	//
	// // 2.状态转移
	// for(int i = 1; i<prices.size();i++){
	// // 3.状态转移方程
	// dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]);
	// dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i]);
	// }
	// return dp[prices.size()-1][0];
	// }

}
