package com.my.practise.greedy;

// 思路：计算 整体瓶子的数量 & 空瓶子的数量

public class WaterBottles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] nums = { 4, 3, 10, 9, 8 };

		int numBottles = 15;
		int numExchange = 8;
		int result = numWaterBottles(numBottles, numExchange);
		System.out.println("result: " + result);
	}

	public static int numWaterBottles(int numBottles, int numExchange) {
		int sum = 0;
		int emptyNums = 0;

		while (numBottles != 0) {
			sum += numBottles;
			int data = (numBottles + emptyNums) / numExchange;

			emptyNums = (numBottles + emptyNums) % numExchange;
			numBottles = data;
		}

		// while (left >= numExchange) {
		// sum += left;
		// left = (left / numExchange) + left % numExchange;
		// // left = (left / numExchange);
		// }
		// System.out.println("data: " + sum);
		//
		// sum += left;

		return sum;
	}

}
