package com.my.practise.array;

// 这个大概看下，本质上就是 二分查找；思路也不复杂
// 当然，也可以采用暴力方式来做

public class SearchInsertItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 3, 5, 6 };
		int target = 2;

		int result = searchInsert(nums, target);
		System.out.println("result: " + result);
	}

	public static int searchInsert(int[] nums, int target) {
		int result = -1;
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] > target) {
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				result = mid;
				break;
			}
		}

		if (result < 0) {
			result = low;
		}
		return result;
	}

}
