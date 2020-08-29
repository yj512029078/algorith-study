package com.my.practise.greedy;

import java.util.Arrays;

public class CookieAfford {

	public static void main(String[] args) {
		int[] g = { 1, 2, 3 };
		int[] s = { 3 };
		
		int result = findContentChildren(g, s);
		System.out.println("result:  " + result);
	}

	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int sum = 0;
		int i = 0;
		int j = 0;
		for (; i < g.length; i++) {
			for (; j < s.length; j++) {
				if (g[i] <= s[j]) {
					sum += 1;
					j++;
					break;
				}
			}
		}

		return sum;
	}

}
