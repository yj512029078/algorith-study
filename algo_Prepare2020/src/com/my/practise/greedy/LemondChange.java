package com.my.practise.greedy;

// 这个算法看下就行；其实就是记录多个变量

public class LemondChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 5, 5, 10, 10, 20 };
		boolean result = lemonadeChange(nums);
		System.out.println("result: " + result);
	}

	public static boolean lemonadeChange(int[] bills) {
		boolean result = false;

		if ((bills == null) || bills.length == 0) {
			return result;
		}

		int fiveCount = 0;
		int tenCount = 0;
		for (int i = 0; i < bills.length; i++) {
			switch (bills[i]) {
			case 5:
				fiveCount++;
				break;
			case 10: {
				if (fiveCount <= 0) {
					return result;
				}

				fiveCount--;
				tenCount++;
				break;
			}
			case 20: {
				if (fiveCount >= 1 && tenCount >= 1) {
					fiveCount--;
					tenCount--;
				} else if (fiveCount >= 3) {
					fiveCount = fiveCount - 3;
				} else {
					return result;
				}
				break;
			}
			}
		}

		return true;
	}

}
