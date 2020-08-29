package com.my.practise.greedy;

// 看下思想就行：主要就顺着比较就行

public class IsSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String srcString = "abc";
		String targetString = "ahbgdc";

		boolean result = isSubsequence(srcString, targetString);
		System.out.println("result: " + result);
	}

	public static boolean isSubsequence(String s, String t) {
		if ((s == null) || (t == null)) {
			return false;
		}

		if (s.equals("") && t.equals("")) {
			return true;
		}

		int k = 0;
		int m = 0;

		while ((k < s.length()) && (m < t.length())) {
			if (s.charAt(k) == t.charAt(m)) {
				k++;
				m++;
			} else {
				m++;
			}
		}

		return (k == s.length());
	}

}
