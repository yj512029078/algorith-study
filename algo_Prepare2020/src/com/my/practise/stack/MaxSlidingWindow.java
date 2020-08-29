package com.my.practise.stack;

public class MaxSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0) {
			return new int[0];
		}
		int left = 0;
		int right = k - 1;
		int[] result = new int[nums.length - k + 1];// 存储结果
		int max = nums[left];
		for (int i = left; i <= right; i++) {
			max = Math.max(max, nums[i]);
		}
		result[left] = max;
		boolean maxIsStart = max == nums[left] ? true : false;
		left++;
		right++;
		while (right < nums.length) {
			if (maxIsStart) {
				max = nums[left];
				for (int i = left + 1; i <= right; i++) {
					max = Math.max(max, nums[i]);
				}
			} else {
				max = Math.max(max, nums[right]);
			}
			result[left] = max;
			maxIsStart = max == nums[left] ? true : false;
			left++;
			right++;
		}
		return result;
	}

}
