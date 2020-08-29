package com.my.practise.array;

// 思路比较简单

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 2, 2, 3 };
		int result = removeElement(arr, 3);
		System.out.println("result: " + result);
	}

	public static int removeElement(int[] nums, int val) {
		if ((nums == null) || (nums.length == 0)) {
			return 0;
		}

		int newIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[newIndex] = nums[i];
				newIndex++;
			}
		}

		return (newIndex);
	}

}
