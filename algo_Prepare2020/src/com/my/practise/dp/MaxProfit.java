package com.my.practise.dp;

// 有很多策略，DP 是一种；
// 另一种是贪心策略；只要是 最低价格买入，最高价格卖出即可

// 容易弄混的几类问题：
// 股票交易的频繁买入卖出
// 最大子序列和
// 股票交易，只能交易一次的，最大收益

public class MaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = { 7, 1, 5, 3, 6, 4 };
		int profit = maxProfit(prices);
		System.out.println("profit: " + profit);
	}

	// 可以使用DP计算
	public static int maxProfit(int[] prices) {
		if ((prices == null) || (prices.length == 0)) {
			return 0;
		}

		int length = prices.length;
		// 创建两个数组，一个记录每次卖出的最大收益，一个记录每次买入最大收益
		int[] sell = new int[length];
		int[] buy = new int[length];

		sell[0] = 0;
		buy[0] = -prices[0];

		for (int i = 1; i < length; i++) {
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
			// 因为只能先买后卖
			buy[i] = Math.max(buy[i - 1], -prices[i]);
		}

		return Math.max(sell[length - 1], buy[length - 1]);
	}

	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int n = prices.length;
		int minVal = Integer.MAX_VALUE;
		int res = 0;
		for (int i : prices) {
			// 遍历数组，不断更新最小价格
			// 再计算出max(当前值-最小值)
			if (minVal > i) {
				minVal = i;
			}
			int tmp = i - minVal;
			if (tmp > res) {
				res = tmp;
			}
		}
		return res;
	}

}
