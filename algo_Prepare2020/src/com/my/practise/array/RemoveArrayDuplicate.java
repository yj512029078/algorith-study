package com.my.practise.array;

// 这个思想简单看下就可以

public class RemoveArrayDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		int result = removeDuplicates(nums);
		System.out.println("result: " + result);
	}

	// 这个思想也比较朴素简单：count 标识不重复的元素记录；preValue 保存上一个元素
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int preValue = nums[0];
		int count = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != preValue) {
				nums[count] = nums[i];
				count++;
			}
			preValue = nums[i];
		}

		return count;
	}

}
