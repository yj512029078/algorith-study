package com.design.code.bit;

public class CountBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int result[] = countBits(n);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "->");
		}
		System.out.println();
	}

	// 偶数： f(i) = f(i/2)
	// 因为偶数的二进制最后一位是0，去掉这个0后就是 i/2
	// 奇数： f(i) = f(i/2) + 1
	// 因为奇数的二进制最后一位是1，去掉这个1后就是 i/2
	public static int[] countBits(int n) {
		int dp[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i / 2] + (i & 1);
		}
		return dp;
	}

}
