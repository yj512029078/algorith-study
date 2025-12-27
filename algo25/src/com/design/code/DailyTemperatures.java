package com.design.code;

import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temperatures[] = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
		int result[] = dailyTemperatures(temperatures);
		
		if(result != null) {
			for(int i = 0; i < result.length; i++) {
				System.out.print(result[i] + "->");
			}
		}
	}

	// 单调栈 - 递增 / 递减 stack
	public static int[] dailyTemperatures(int[] temperatures) {
		if (temperatures == null || temperatures.length == 0) {
			return null;
		}

		// 这个不需要显式初始化，int 默认为0
		int result[] = new int[temperatures.length];

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < temperatures.length; i++) {
			// 维护单调递减栈
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int preIndex = stack.pop();
				result[preIndex] = i - preIndex;
			}

			// 存储索引，用于计算实际发生的天数
			stack.push(i);
		}

		return result;
	}

}
