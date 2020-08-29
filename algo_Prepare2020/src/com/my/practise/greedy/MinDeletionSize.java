package com.my.practise.greedy;

// 注意下思想，简单看下

public class MinDeletionSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = new String[] { "cba", "daf", "ghi" };
		int result = minDeletionSize(arr);
		System.out.println("result: " + result);
	}

	// 核心思想：就是将数组挨个遍历，不满足条件的就删除
	public static int minDeletionSize(String[] A) {
		if (A == null) {
			return 0;
		}

		if (A.length <= 1) {
			return 0;
		}

		int minItemLength = A[0].length();
		int maxItemLength = A[0].length();
		for (int i = 0; i < A.length; i++) {
			if (A[i].length() < minItemLength) {
				minItemLength = A[i].length();
			}
			if (A[i].length() > maxItemLength) {
				maxItemLength = A[i].length();
			}
		}

		int deletionCount = 0;
		for (int i = 0; i < minItemLength; i++) {
			for (int j = 1; j < A.length; j++) {
				if (A[j].charAt(i) < A[j - 1].charAt(i)) {
					deletionCount++;
					break;
				}
			}
		}

		deletionCount += (maxItemLength - minItemLength);
		return deletionCount;
	}

}
