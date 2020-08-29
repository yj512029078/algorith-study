package com.my.practise.greedy;

// 也是看下这个思想就好了；怎么判断是否对称？？【栈 OR 计数】

public class BalancedStringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "RLRRLLRLRL";
		int result = balancedStringSplit(s);
		System.out.println("result: " + result);
	}

	public static int balancedStringSplit(String s) {
		if ((s == null) || s.equals("")) {
			return 0;
		}

		int sum = 0;
		int num = 0;
		int length = s.length();
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) == 'L') {
				num++;
			} else {
				num--;
			}

			if (num == 0) {
				sum++;
			}
		}

		return sum;
	}

}
