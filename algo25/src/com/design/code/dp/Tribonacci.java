package com.design.code.dp;

public class Tribonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int result = tribonacci2(n);
		System.out.println(result);
	}

	// 因为 n - 3 n - 2 n - 1 都要多次计算，效率很低
	public static int tribonacci(int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1 || n == 2) {
			return 1;
		}

		int value = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
		return value;
	}

	// 注意下，从0开始，N + 1 个数
	public static int tribonacci2(int n) {
		int arr[] = new int[n + 1];
		arr[0] = 0;

		if (n >= 1) {
			arr[1] = 1;
		}
		if (n >= 2) {
			arr[2] = 1;
		}

		for (int x = 3; x <= n; x++) {
			arr[x] = arr[x - 1] + arr[x - 2] + arr[x - 3];
		}
		return arr[n];
	}

}
