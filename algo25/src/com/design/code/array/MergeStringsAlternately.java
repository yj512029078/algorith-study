package com.design.code.array;

/**
 * 合并2个字符串，分别取一个字符
 */
public class MergeStringsAlternately {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firstString = "abcd";
		String secondString = "efl";
		String resultString = mergeStringsAlternately(firstString, secondString);
		System.out.println(resultString);
	}

	private static String mergeStringsAlternately(String firstString, String secondString) {
		if (firstString == null || firstString.length() == 0) {
			return secondString;
		}

		if (secondString == null || secondString.length() == 0) {
			return firstString;
		}

		int firstLength = firstString.length();
		int secondLength = secondString.length();

		StringBuilder builder = new StringBuilder();

		int commonLength = Math.min(firstLength, secondLength);
		for (int i = 0; i < commonLength; i++) {
			char firstChar = firstString.charAt(i);
			builder.append(firstChar);

			char secondChar = secondString.charAt(i);
			builder.append(secondChar);
		}

		if (firstLength > commonLength) {
			for (int i = commonLength; i < firstLength; i++) {
				char ch = firstString.charAt(i);
				builder.append(ch);
			}
		} else if (secondLength > commonLength) {
			for (int i = commonLength; i < secondLength; i++) {
				char ch = secondString.charAt(i);
				builder.append(ch);
			}
		}
		
		String finalString = builder.toString();
		return finalString;
	}

}
