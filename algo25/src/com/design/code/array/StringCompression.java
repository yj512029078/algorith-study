package com.design.code.array;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// chars = ["a","a","b","b","c","c","c"]
		char[] stringsArrStrings = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		int result = stringCompression2(stringsArrStrings);
		System.out.println("final result, " + result);

		char[] stringsArrStrings2 = new char[] { 'a' };
		int result2 = stringCompression2(stringsArrStrings2);
		System.out.println("final result, " + result2);

		char[] stringsArrStrings3 = new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
		int result3 = stringCompression2(stringsArrStrings3);
		System.out.println("final result, " + result3);

		char[] stringsArrStrings4 = new char[] { 'a', 'b', 'c' };
		int result4 = stringCompression2(stringsArrStrings4);
		System.out.println("final result, " + result4);
	}

	// 这个解法不好，违背了constant 空间的需求
	private static int stringCompression(char[] stringsArr) {
		if (stringsArr == null || stringsArr.length == 0) {
			return 0;
		}

		char startString = stringsArr[0];
		int repeatedStringCount = 0;
		char currentString = stringsArr[0];

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < stringsArr.length; i++) {
			currentString = stringsArr[i];

			if (currentString != startString) {
				stringBuilder.append(startString);

				if (repeatedStringCount != 1) {
					stringBuilder.append(String.valueOf(repeatedStringCount));
				}

				startString = currentString;
				repeatedStringCount = 1;
			} else {
				repeatedStringCount++;

				if (i == (stringsArr.length - 1)) {
					stringBuilder.append(startString);
					if (repeatedStringCount != 1) {
						stringBuilder.append(String.valueOf(repeatedStringCount));
					}
				}
			}
		}

		for (int i = 0; i < stringBuilder.length(); i++) {
			stringsArr[i] = stringBuilder.charAt(i);
		}

		System.out.println("final string, " + stringBuilder.toString());
		return stringBuilder.length();
	}

	private static int stringCompression2(char[] stringsArr) {
		if (stringsArr == null || stringsArr.length == 0) {
			return 0;
		}

		char startString = stringsArr[0];
		int repeatedStringCount = 1;
		char currentString = stringsArr[0];

		int writeIndex = 0;

		for (int i = 1; i < stringsArr.length; i++) {
			currentString = stringsArr[i];

			if (currentString != startString) {
				stringsArr[writeIndex++] = startString;

				if (repeatedStringCount != 1) {
					char[] tempArr = String.valueOf(repeatedStringCount).toCharArray();
					for (int j = 0; j < tempArr.length; j++) {
						stringsArr[writeIndex++] = tempArr[j];
					}
				}

				startString = currentString;
				repeatedStringCount = 1;
			} else {
				repeatedStringCount++;
			}
		}

		stringsArr[writeIndex++] = startString;
		if (repeatedStringCount != 1) {
			char[] tempArr = String.valueOf(repeatedStringCount).toCharArray();
			for (int j = 0; j < tempArr.length; j++) {
				stringsArr[writeIndex++] = tempArr[j];
			}
		}

		String string = new String(stringsArr, 0, writeIndex);
		System.out.println("final string, " + string.toString());
		return writeIndex;
	}

}
