package com.design.code.stack;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Input: s = "3[a]2[bc]"
//		Output: "aaabcbc"

//		Input: s = "3[abc5[ef]]2[bc]"
//		Output: "aaabcbc"

		String s = "3[a]2[bc]";
		String resultString = decodeString(s);
		System.out.println(resultString);

		System.out.println("***********************");

		s = "3[abc5[ef]]2[bc]";
		resultString = decodeString(s);
		System.out.println(resultString);
	}

	// string stack 的作用是用来暂存记录
	// 遇到'['表示新结构开始，原来的信息要暂存，所以需要push stack
	// 遇到']'表示当前结构结束，所以需要pop stack，并做拼接
	public static String decodeString(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		int currentNum = 0;
		StringBuilder currentStringBuilder = new StringBuilder();

		Stack<Integer> numStack = new Stack<Integer>();
		Stack<String> stringStack = new Stack<String>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (Character.isDigit(ch)) {
				// 如何计算字符串的 int 值
				currentNum = currentNum * 10 + (ch - '0');
			} else if (ch == '[') {
				numStack.push(currentNum);
				// 字符串入栈，很关键
				stringStack.push(currentStringBuilder.toString());

				currentNum = 0;
				currentStringBuilder = new StringBuilder();
			} else if (ch == ']') {
				int repeatNum = numStack.pop();
				// 将前面的字符串出栈，很关键
				String preString = stringStack.pop();

				StringBuilder stringBuilder = new StringBuilder();
				for (int k = 0; k < repeatNum; k++) {
					stringBuilder.append(currentStringBuilder.toString());
				}

				// 重复后的字符串和前面的拼接，很关键
				currentStringBuilder = new StringBuilder(preString);
				currentStringBuilder.append(stringBuilder.toString());
			} else {
				currentStringBuilder.append(ch);
			}
		}

		return currentStringBuilder.toString();
	}

}
