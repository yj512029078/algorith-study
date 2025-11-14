package com.design.code.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class CloseStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "abc";
		String word2 = "bca";
		boolean isClose = closeStrings2(word1, word2);
		System.out.println(isClose);

		word1 = "a";
		word2 = "aa";
		isClose = closeStrings2(word1, word2);
		System.out.println(isClose);

		word1 = "cabbba";
		word2 = "abbccc";
		isClose = closeStrings2(word1, word2);
		System.out.println(isClose);

		word1 = "abbzzca";
		word2 = "babzzcz";
		isClose = closeStrings2(word1, word2);
		System.out.println(isClose);
	}

	// 这个思路完全是错的
	public static boolean closeStrings(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return true;
		}
		if ("".equals(word1) && "".equals(word2)) {
			return true;
		}

		if (word1 == null || "".equals(word1)) {
			return false;
		}
		if (word2 == null || "".equals(word2)) {
			return false;
		}

		if (word1.length() != word2.length()) {
			return false;
		}

		HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
		for (int i = 0; i < word1.length(); i++) {
			char ch = word1.charAt(i);
			if (hashMap.containsKey(ch)) {
				char value = hashMap.get(ch);
				if (value != word2.charAt(i)) {
					return false;
				}
			} else {
				hashMap.put(word1.charAt(i), word2.charAt(i));
			}
		}

		Iterator<Entry<Character, Character>> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Character, Character> entry = iterator.next();
			char tempKey = entry.getKey();
			char tempValue = entry.getValue();

			if (hashMap.containsKey(tempValue)) {
				if (hashMap.get(tempValue) != tempKey) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean closeStrings2(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return true;
		}
		if ("".equals(word1) && "".equals(word2)) {
			return true;
		}

		if (word1 == null || "".equals(word1)) {
			return false;
		}
		if (word2 == null || "".equals(word2)) {
			return false;
		}

		if (word1.length() != word2.length()) {
			return false;
		}

		HashMap<Character, Integer> hashMap1 = new HashMap<Character, Integer>();
		for (int i = 0; i < word1.length(); i++) {
			char ch = word1.charAt(i);

			if (hashMap1.containsKey(ch)) {
				hashMap1.put(ch, hashMap1.get(ch) + 1);
			} else {
				hashMap1.put(ch, 1);
			}
		}

		HashMap<Character, Integer> hashMap2 = new HashMap<Character, Integer>();
		for (int i = 0; i < word2.length(); i++) {
			char ch = word2.charAt(i);

			if (hashMap2.containsKey(ch)) {
				hashMap2.put(ch, hashMap2.get(ch) + 1);
			} else {
				hashMap2.put(ch, 1);
			}
		}

		// 判断字符的集合是否一致
		Set<Character> hashSet1 = hashMap1.keySet();
		Set<Character> hashSet2 = hashMap2.keySet();
		if (!hashSet1.equals(hashSet2)) {
			return false;
		}

		// 判断字符出现的频率是否一致，但是不一定是同一个字符
		// 注意这里的写法，这里有语法，很容易写错
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>(hashMap1.values());
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>(hashMap2.values());
		Collections.sort(arrayList1);
		Collections.sort(arrayList2);

		// 不能用remove 的操作，可能arraylist1 的元素少
		if (!arrayList1.equals(arrayList2)) {
			return false;
		}

		return true;
	}

}
