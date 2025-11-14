package com.design.code.array;

public class GcdOfStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resultString = gcdOfStrings2("ABCABC", "ABC");
		System.out.println(resultString);

		resultString = gcdOfStrings2("ABABAB", "ABAB");
		System.out.println(resultString);

		resultString = gcdOfStrings2("LEET", "CODE");
		System.out.println(resultString);

		resultString = gcdOfStrings2("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX");
		System.out.println(resultString);
	}

	// 思路不对
	// str2 是 str1 的子序列，或者多余的 str1 部分是 str2 的子序列
	// 思路问题在于，多余的 str1 部分并不一定是 str2 的子序列，也可能是更小的序列是子序列
	public static String gcdOfStrings(String str1, String str2) {
		if (str1 == null || str1.length() == 0) {
			return "";
		}

		if (str2 == null || str2.length() == 0) {
			return "";
		}

		int length1 = str1.length();
		int length2 = str2.length();
		if (length1 < length2) {
			return "";
		}

		int x = length1 / length2;
		for (int i = 0; i < x; i++) {
			if (!str1.substring(i * length2, (i + 1) * length2).equals(str2)) {
				return "";
			}
		}

		int y = length1 % length2;
		if (y == 0) {
			return str2;
		}

		String remainderStr1 = str1.substring(x * length2, x * length2 + y);
		if (!isPerfectMatched(remainderStr1, str2)) {
			System.out.println(remainderStr1 + " " + str2);
			return "";
		}

		return remainderStr1;
	}

	// str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
	// 用这个会更简单
	private static boolean isPerfectMatched(String str1, String str2) {
		int length1 = str1.length();
		int length2 = str2.length();

		if (str1.length() > str2.length()) {
			int x = str1.length() / str2.length();
			int y = str1.length() % str2.length();

			if (y != 0) {
				return false;
			}

			for (int i = 0; i < x; i++) {
				if (!str1.substring(i * length2, (i + 1) * length2).equals(str2)) {
					return false;
				}
			}
		} else {
			int x = str2.length() / str1.length();
			int y = str2.length() % str1.length();

			if (y != 0) {
				return false;
			}

			for (int i = 0; i < x; i++) {
				if (!str2.substring(i * length1, (i + 1) * length1).equals(str1)) {
					return false;
				}
			}
		}

		return true;
	}

	// 暴力求解，是个办法
	// 要考虑str1 str2 哪个长
	public static String gcdOfStrings2(String str1, String str2) {
		if (str1 == null || str1.length() == 0) {
			return "";
		}

		if (str2 == null || str2.length() == 0) {
			return "";
		}

		int length1 = str1.length();
		int length2 = str2.length();
		if (length1 >= length2) {
			// 从最大部分，看匹配程度
			for (int i = (str2.length() - 1); i >= 0; i--) {
				String subString = str2.substring(0, i + 1);
				if (isPerfectMatched(subString, str2) && isPerfectMatched(subString, str1)) {
					return subString;
				}
			}
		} else {
			for (int i = (str1.length() - 1); i >= 0; i--) {
				String subString = str1.substring(0, i + 1);
				if (isPerfectMatched(subString, str1) && isPerfectMatched(subString, str2)) {
					return subString;
				}
			}
		}

		return "";
	}

	public static int gcd(int x, int y) {
		if (y == 0) {
			return x;
		} else {
			return gcd(y, x % y);
		}
	}

	// 如果存在可整除的字符串，则 GCD 字符串必定是 gcdBase
	public static String gcdOfStrings3(String str1, String str2) {
		// Check if they have non-zero GCD string.
		if (!(str1 + str2).equals(str2 + str1)) {
			return "";
		}

		// Get the GCD of the two lengths.
		int gcdLength = gcd(str1.length(), str2.length());
		return str1.substring(0, gcdLength);
	}

}
