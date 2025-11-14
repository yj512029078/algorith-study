package com.design.code.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class UniqueOccurrence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 1, 2, 2, 1, 1, 3 };
		boolean result = uniqueOccurrences(arr);
		System.out.println(result);

		arr = new int[] { 1, 2 };
		result = uniqueOccurrences(arr);
		System.out.println(result);

		arr = new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
		result = uniqueOccurrences(arr);
		System.out.println(result);
	}

	public static boolean uniqueOccurrences(int[] arr) {
		if (arr == null) {
			return true;
		}

		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
			} else {
				hashMap.put(arr[i], 1);
			}
		}

		HashSet<Integer> hashSet = new HashSet<Integer>();

		Iterator<Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			int value = iterator.next().getValue();
			if (hashSet.contains(value)) {
				return false;
			}
			
			hashSet.add(value);
		}

		return true;
	}

}
