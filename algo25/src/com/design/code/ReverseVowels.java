package com.design.code;

public class ReverseVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "IceCreAm";
		String resultString = reverseVowels(s);
		System.out.println(resultString);

		s = "leetcode";
		resultString = reverseVowels(s);
		System.out.println(resultString);
	}

	public static String reverseVowels(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		
		char arr[] = s.toCharArray();
		
		int length = s.length();
		int low = 0;
		int high = length - 1;

		while (low <= high) {			
			if (!isVowels(arr[low])) {
				low++;
				continue;
			}

			if (!isVowels(arr[high])) {
				high--;
				continue;
			}

			swap(arr, low++, high--);
		}

		String result = new String(arr);
		return result;
	}

	private static void swap(char arr[], int firstIndex, int secondIndex) {
		char temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}

	private static boolean isVowels(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}
		
		if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
			return true;
		}

		return false;
	}

}
