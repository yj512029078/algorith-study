package com.design.code;

public class GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 2 3 4 5 6
		int n = 2126753390;
		pick = 1702766719;
//		int result = guessNumber(n);
//		System.out.println(result);
		
		int result = guessNumber2(n);
		System.out.println(result);
	}

	private static int pick;

	public static int guessNumber(int n) {
		int number = guess(1, n);
		return number;
	}

	// 这里用到的是递归的解法，不合理，会导致 stack overflow
	public static int guess(int low, int high) {
		System.out.println("low:" + low + " high:" + high);

		int middle = (low + high) / 2;
		if (low == high) {
			return middle;
		}

		if (guess(middle) == 1) {
			return guess(middle + 1, high);
		} else if (guess(middle) == -1) {
			return guess(low, middle - 1);
		} else {
			return middle;
		}
	}

	public static int guess(int num) {
		if (num > pick) {
			return -1;
		} else if (num < pick) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int guessNumber2(int n) {
		int number = guess2(1, n);
		return number;
	}

	public static int guess2(int low, int high) {
		while (low <= high) {
			// 如果整数很大，这里会溢出，所以一个很小的技巧
//			int middle = (low + high) / 2;
			int middle = low + (high - low) / 2;
			
			System.out.println("low:" + low + " high:" + high);
			
			if (guess(middle) == 1) {
				low = middle + 1;
			} else if (guess(middle) == -1) {
				high = middle - 1;
			} else {
				return middle;
			}
		}
		
		return -1;
	}

}
