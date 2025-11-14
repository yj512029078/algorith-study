package com.design.code.array;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int candies[] = new int[] { 2, 3, 5, 1, 3 };
		int extraCandies = 3;
		List<Boolean> list = kidsWithCandies2(candies, extraCandies);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "-> ");
		}
		System.out.println();

		candies = new int[] { 4, 2, 1, 1, 2 };
		extraCandies = 1;
		list = kidsWithCandies2(candies, extraCandies);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "-> ");
		}
		System.out.println();
		
		candies = new int[] { 2,1,12 };
		extraCandies = 10;
		list = kidsWithCandies2(candies, extraCandies);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "-> ");
		}
		System.out.println();
	}

	// 这个解法是可以work 的，但是时间复杂度有点高，n * n 
	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		ArrayList<Boolean> arrayList = new ArrayList<Boolean>();

		if (candies == null || candies.length == 0) {
			return arrayList;
		}

		for (int i = 0; i < candies.length; i++) {
			if (isLargest(candies, i, extraCandies)) {
				arrayList.add(true);
			} else {
				arrayList.add(false);
			}
		}

		return arrayList;
	}

	private static boolean isLargest(int[] candies, int index, int extraCandies) {
		int value = candies[index] + extraCandies;
		for (int i = 0; i < candies.length; i++) {
			if (i != index && candies[i] > value) {
				return false;
			}
		}

		return true;
	}
	
	// 明显这个时间复杂度更好
	public static List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
		ArrayList<Boolean> arrayList = new ArrayList<Boolean>();

		if (candies == null || candies.length == 0) {
			return arrayList;
		}
		
		int maxCandy = candies[0];
		for (int i = 1; i < candies.length; i++) {
			if(candies[i] > maxCandy) {
				maxCandy = candies[i];
			}
		}

		for (int i = 0; i < candies.length; i++) {
			if (candies[i] + extraCandies >= maxCandy) {
				arrayList.add(true);
			} else {
				arrayList.add(false);
			}
		}

		return arrayList;
	}

}
