package com.design.code.dp;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3;
		int n = 7;
		int result = uniquePaths(m, n);
		System.out.println(result);
	}

	// 这里不是求步数，而是求走法
	public static int uniquePaths(int m, int n) {
		int dp[][] = new int[m][n];
		dp[0][0] = 0;

		// 注意这里，是直接走多步的；不是一次可以走0步，或者不走
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}

//		for (int i = 1; i < m; i++) {
//			for (int j = 1; j < n; j++) {
//				dp[i][j] = dp[i - 1][j - 1] + 2;
//			}
//		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}

		int result = dp[m - 1][n - 1];
		return result;
	}

}
