package com.my.practise.array;

import java.util.Arrays;

// 暴力破解
// HashMap  【不要忽视 HashMap，这个其实是很重要的一个思路】
// 排序后，通过 low high 双指针

public class TwoDataSum {

	public static void main(String[] args) {
		int nums[] = { 2, 5, 5, 11 };
		int target = 10;
		int result[] = twoSum(nums, target);

		for (int i = 0; i < result.length; i++) {
			System.out.println("result: " + result[i]);
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		int originNums[] = Arrays.copyOf(nums, nums.length);

		int[] result = new int[] { 0, 0 };
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.println("mid: " + nums[i]);
		}

		boolean isFirstSet = false;

		for (int i = 0; i < nums.length; i++) {
			int[] temp = new int[] { 0, 0 };
			boolean flag = getTargetIndex(nums, target, temp);
			if (flag) {
				for (int j = 0; j < originNums.length; j++) {
					if ((originNums[j] == nums[temp[0]]) && !isFirstSet) {
						result[0] = j;
						isFirstSet = true;
					} else if (originNums[j] == nums[temp[1]]) {
						result[1] = j;
					}
				}
				break;
			}
		}

		return result;
	}

	private static boolean getTargetIndex(int[] sortedNums, int target, int[] result) {
		boolean flag = false;
		int low = 0;
		int high = (sortedNums.length - 1);
		while (low <= high) {
			if (sortedNums[low] + sortedNums[high] > target) {
				high--;
			} else if (sortedNums[low] + sortedNums[high] < target) {
				low++;
			} else {
				result[0] = low;
				result[1] = high;

				flag = true;
				break;
			}
		}

		System.out.println("low: " + low + "; high:" + high);
		return flag;
	}

}
