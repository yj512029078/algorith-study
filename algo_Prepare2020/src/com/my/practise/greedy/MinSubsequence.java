package com.my.practise.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 这个还比较简单，先排序就 > 一半就行；思路比较简单

public class MinSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 4, 7, 6, 7 };
		List<Integer> list = minSubsequence(nums);
		for (int i = 0; i < list.size(); i++) {
			System.out.print("index: " + list.get(i));
		}
	}

	public static List<Integer> minSubsequence(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();

		if ((nums == null) || (nums.length == 0)) {
			return list;
		}

		int sum = 0;
		Arrays.sort(nums);
		for (int a : nums) {
			sum += a;
		}

		int tempSum = 0;
		int startIndex = 0;
		for (int i = (nums.length - 1); i >= 0; i--) {
			tempSum += nums[i];
			if (tempSum > sum / 2) {
				startIndex = i;
				break;
			}
		}

		System.out.println("tempSum: " + tempSum);
		System.out.println("sum: " + sum);

		for (int i = (nums.length - 1); i >= startIndex; i--) {
			list.add(nums[i]);
		}

		return list;
	}

}
