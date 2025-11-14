package com.design.code.slidingwindow;

public class MaxVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 2 3 4 5
		String string = "abciiidef";
		int k = 3;
		int maxVowels = maxVowels(string, k);
		System.out.println(maxVowels);

		string = "aeiou";
		k = 2;
		maxVowels = maxVowels(string, k);
		System.out.println(maxVowels);

		string = "leetcode";
		k = 3;
		maxVowels = maxVowels(string, k);
		System.out.println(maxVowels);
	}

	// 核心是怎么减少计算复杂度，O(n) 而不是 O(n * k)
	public static int maxVowels(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		if (k <= 0 || k > s.length()) {
			return 0;
		}

		int maxVowels = 0;
		int lastVowels = 0;
		for (int i = 0; i < k; i++) {
			if (isVowel(s.charAt(i))) {
				maxVowels++;
				lastVowels++;
			}
		}

		for (int i = 1; i < (s.length() - k + 1); i++) {
			int tempCount = lastVowels;

			// 这里不是在完整遍历k 个数，是因为完全可以依赖上一次的计算结果，做尽可能少的计算
			if (isVowel(s.charAt(i + k - 1))) {
				tempCount++;
			}

			if (isVowel(s.charAt(i - 1))) {
				tempCount--;
			}

			if (tempCount > maxVowels) {
				maxVowels = tempCount;
			}
			lastVowels = tempCount;
		}

		return maxVowels;
	}

	private static boolean isVowel(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}

		return false;
	}

}
