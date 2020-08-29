package com.my.practise.array;

// 简单看下

public class IntReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = (int) 9646324351L;
		int result = reverse(x);
		System.out.println("result: " + result);
	}

	public static int reverse(int x) {
		String string = String.valueOf(x);
		StringBuilder stringBuilder = new StringBuilder();

		System.out.println("result: 1 " + string);

		boolean hasNegative = false;

		for (int i = (string.length() - 1); i >= 0; i--) {
			char ch = string.charAt(i);

			if (ch == '-') {
				hasNegative = true;
				continue;
			}

			if ((ch != 0) && (i == (string.length() - 1))) {
				stringBuilder.append(ch);
			}

			if (i != (string.length() - 1)) {
				stringBuilder.append(ch);
			}
		}

		String resultString = stringBuilder.toString();
		if (hasNegative) {
			resultString = "-" + resultString;
		}
		if (resultString.equals("")) {
			resultString = "0";
		}

		System.out.println("result: 2 " + resultString);

		long data = Long.valueOf(resultString);

		if (data > Integer.MAX_VALUE || data < Integer.MIN_VALUE) {
			data = 0;
		}

		return (int) data;
	}

}
