package com.design.code;


public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 0, 1, 0, 3, 12 };
		moveZeroes2(nums);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " -> ");
		}
		System.out.println();
		
		nums = new int[] { 0 };
		moveZeroes2(nums);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " -> ");
		}
		System.out.println();
		
		nums = new int[] { 0, 0, 1 };
		moveZeroes2(nums);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " -> ");
		}
		System.out.println();
	}

	// 这个解法不对，没有保持相对的顺序
	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int nonZeroIndex = 0;
		int zeroIndex = nums.length - 1;

		for (int i = 0; i <= zeroIndex; i++) {
			if (nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[zeroIndex];
				nums[zeroIndex] = temp;
				zeroIndex--;
			}
		}
	}
	
	// 要保持顺序，就要跟相邻的数据反复交换
	// 但是如果遇到0，要让0和第一个非0做交换
	public static void moveZeroes2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		for (int i = 0; i <= (nums.length - 1); i++) {
			if (nums[i] == 0) {
				int k = i;
				for(int m = i; m < (nums.length - 1); m++) {
					if(nums[m + 1] != 0) {
						swap(nums, k++, m + 1);
					}
				}
			}
		}
	}
	
	private static void swap(int[] nums, int i , int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
