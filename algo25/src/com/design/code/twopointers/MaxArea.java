package com.design.code.twopointers;

public class MaxArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int result = maxArea(nums);
		System.out.println(result);

		nums = new int[] { 1, 1 };
		result = maxArea(nums);
		System.out.println(result);
	}

	// 这个题目有一定难度
	public static int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		int low = 0;
		int high = height.length - 1;
		int tempHeight = Math.min(height[low], height[high]);
		int tempArea = (high - low) * tempHeight;

		// 核心逻辑在这，主要控制 low high 怎么移动
		while (low < high) {
			if (Math.min(height[low], height[high]) <= tempHeight) {
				if (height[low] <= tempHeight) {
					low++;
				}

				if (height[high] <= tempHeight) {
					high--;
				}
			} else {
				int currentArea = (high - low) * Math.min(height[low], height[high]);
				if (currentArea > tempArea) {
					tempArea = currentArea;
					tempHeight = Math.min(height[low], height[high]);
				}

				if (height[low] > height[high]) {
					high--;
				} else {
					low++;
				}
			}

		}

		return tempArea;
	}

}
