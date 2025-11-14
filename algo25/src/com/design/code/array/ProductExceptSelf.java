package com.design.code.array;

public class ProductExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 1, 2, 3, 4 };
		int result[] = productExceptSelf(nums);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "->");
		}
		System.out.println();

		nums = new int[] { -1, 1, 0, -3, 3 };
		result = productExceptSelf(nums);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "->");
		}
		System.out.println();
	}

	// 这个解法比较巧，本质是空间换时间
	// 其它解法：1）暴力求解 2）除法，先得到完整的sum / nums[i]
	public static int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[] { 0 };
		}

		if (nums.length == 1) {
			return new int[] { 0 };
		}

		int leftProduct[] = new int[nums.length];
		leftProduct[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
		}

		for (int i = 0; i < leftProduct.length; i++) {
			System.out.print(leftProduct[i] + "->");
		}
		System.out.println();

		int rightProduct[] = new int[nums.length];
		rightProduct[nums.length - 1] = 1;
		for (int i = (nums.length - 2); i >= 0; i--) {
			rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < rightProduct.length; i++) {
			System.out.print(rightProduct[i] + "->");
		}
		System.out.println();

		int result[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = leftProduct[i] * rightProduct[i];
		}

		return result;
	}

}
