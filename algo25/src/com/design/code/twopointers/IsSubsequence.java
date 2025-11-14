package com.design.code.twopointers;

public class IsSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		String t = "ahbgdc";
		boolean result = isSubsequence2(s, t);
		System.out.println(result);

		s = "axc";
		t = "ahbgdc";
		result = isSubsequence2(s, t);
		System.out.println(result);
		
		s = "";
		t = "ahbgdc";
		result = isSubsequence2(s, t);
		System.out.println(result);
		
		s = "abc";
		t = "";
		result = isSubsequence2(s, t);
		System.out.println(result);
		
		s = "b";
		t = "abc";
		result = isSubsequence2(s, t);
		System.out.println(result);
	}

	// 这个解法不对，这个做成了连续子序列，实际上它需要的可以是离散子序列
	public static boolean isSubsequence(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return false;
		}

		int sLength = s.length();
		int tLength = t.length();

		if (sLength >= tLength) {
			for (int i = 0; i < tLength; i++) {
				for (int j = 0; j < sLength; j++) {
					if (t.charAt(i) != s.charAt(j)) {
						break;
					} else {
						if (i == (tLength - 1)) {
							return true;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < sLength; i++) {
				for (int j = 0; j < sLength; j++) {
					if (s.charAt(i) != t.charAt(j)) {
						break;
					} else {
						if (i == (sLength - 1)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	// 本质上，就是反复遍历base string，直到和 sub string 匹配
	public static boolean isSubsequence2(String s, String t) {
		if (s == null || t == null) {
			return false;
		}

		int sLength = s.length();
		if(sLength == 0) {
			return true;
		}

		String baseString = t;
		String matchedString = s;

		boolean result = false;
		int iterateIndex = 0;
		for (int i = iterateIndex; i < baseString.length(); i++) {
			result = findMatchedString(iterateIndex, baseString, matchedString);
			break;
		}

		return result;
	}

	// 抽象成函数
	private static boolean findMatchedString(int iterateIndex, String baseString, String matchedString) {
		int matchIndex = 0;

		for (int i = iterateIndex; i < baseString.length(); i++) {
			if (baseString.charAt(i) == matchedString.charAt(matchIndex)) {
				matchIndex++;
				
				// 这里要及时break，否则会崩溃
				if (matchIndex == matchedString.length()) {
					break;
				}
			}
		}

		if (matchIndex == matchedString.length()) {
			return true;
		}
		return false;
	}

}
