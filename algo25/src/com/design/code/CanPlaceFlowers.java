package com.design.code;

public class CanPlaceFlowers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flowerbed[] = new int[] { 1,0,0,0,1 };
		int n = 1;
		boolean result = canPlaceFlowers(flowerbed, n);
		System.out.println(result);

		flowerbed = new int[] { 1,0,0,0,1 };
		n = 2;
		result = canPlaceFlowers(flowerbed, n);
		System.out.println(result);
		
		flowerbed = new int[] { 1,0,1,0,1,0,1 };
		n = 1;
		result = canPlaceFlowers(flowerbed, n);
		System.out.println(result);
	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (flowerbed == null || flowerbed.length == 0) {
			return false;
		}

		int count = 0;

		if (flowerbed.length == 1) {
			if (flowerbed[0] == 0) {
				count++;
			}
			return count >= n;
		}

		for (int i = 0; i < flowerbed.length; i++) {
			if (i == 0) {
				if (flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
					flowerbed[i] = 1;
					count++;
				}
			} else if (i == flowerbed.length - 1) {
				if (flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
					flowerbed[i] = 1;
					count++;
				}
			} else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
				flowerbed[i] = 1;
				count++;
			}
		}
		
		System.out.println(count);

		return count >= n;
	}

}
