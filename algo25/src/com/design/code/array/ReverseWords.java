package com.design.code.array;

import java.util.ArrayList;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// "hello world"
		String s = "the sky is blue";
		String resultString = reverseWords(s);
		System.out.println(resultString);

		s = "  hello world  ";
		resultString = reverseWords(s);
		System.out.println(resultString);

		s = "a good   example";
		resultString = reverseWords(s);
		System.out.println(resultString);
	}

	public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		ArrayList<String> arrayList = new ArrayList<String>();

		char preChar = ' ';
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				preChar = s.charAt(i);
				continue;
			}

			if (preChar == ' ' && s.charAt(i) != ' ') {
				if (!builder.toString().equals("")) {
					arrayList.add(builder.toString());
				}

				builder = new StringBuilder();
			}

			builder.append(s.charAt(i));
			preChar = s.charAt(i);
		}

		if (!builder.toString().equals("")) {
			arrayList.add(builder.toString());
		}

		reverseList(arrayList);

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < arrayList.size(); i++) {
			stringBuilder.append(arrayList.get(i));

			if (i != (arrayList.size() - 1)) {
				stringBuilder.append(" ");
			}
		}

		return stringBuilder.toString();
	}

	private static void reverseList(ArrayList<String> arrayList) {
		if (arrayList == null || arrayList.size() == 0) {
			return;
		}

		for (int i = 0; i < arrayList.size() / 2; i++) {
			String tempString = arrayList.get(i);
			int index = arrayList.size() - i - 1;

			arrayList.set(i, arrayList.get(index));
			arrayList.set(index, tempString);
		}
	}

}
