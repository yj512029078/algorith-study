package com.my.practise.array;

// 看下这个思路
// 下面的解决代码是抄的

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 4, 3, 2, 1 };
		arr = plusOne(arr);

		int size = arr.length;

		for (int i = 0; i < size; i++) {
			System.out.print("element: " + arr[i]);
		}
		System.out.println();
	}

	// 数组加 1 的解法
	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i] = digits[i] + 1;
				return digits;
			}
		}
		int[] result = new int[digits.length + 1];
		result[0] = 1;
		return result;
	}

}
