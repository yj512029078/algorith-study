package com.my.practise.greedy;

import java.util.Arrays;

// 注意下这个思想就可以了，想法有一定的复杂度

public class TwoCitySchedCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 二维数组初始化的方法
		int[][] cost = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };

		int resultCost = twoCitySchedCost(cost);
		System.out.println("resultCost: " + resultCost);
	}

	// 想法一：默认都走A，然后算下 A B 路线的差值；排序；
	// 想法二：把最小的拿出来，做个排序
	public static int twoCitySchedCost(int[][] costs) {
		if (costs == null) {
			return 0;
		}

		int res = 0;
		int[] temp = new int[costs.length];

		for (int i = 0; i < costs.length; i++) {
			temp[i] = costs[i][1] - costs[i][0];
			res += costs[i][0];
		}

		Arrays.sort(temp);
		for (int i = 0; i < temp.length / 2; i++) {
			res += temp[i];
		}

		return res;
	}

}
