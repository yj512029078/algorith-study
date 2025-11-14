package com.design.code.prefixsum;

public class LargestAltitude {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int gain[] = new int[] { -5, 1, 5, 0, -7 };
		int largestAltitude = largestAltitude(gain);
		System.out.println(largestAltitude);

		gain = new int[] { -4, -3, -2, -1, 4, 3, 2 };
		largestAltitude = largestAltitude(gain);
		System.out.println(largestAltitude);
	}

	public static int largestAltitude(int[] gain) {
		if (gain == null || gain.length == 0) {
			return 0;
		}

		int altitudeArr[] = new int[gain.length + 1];
		altitudeArr[0] = 0;

		for (int i = 1; i < altitudeArr.length; i++) {
			altitudeArr[i] = altitudeArr[i - 1] + gain[i - 1];
		}

		int maxElement = altitudeArr[0];
		for (int i = 1; i < altitudeArr.length; i++) {
			if (altitudeArr[i] > maxElement) {
				maxElement = altitudeArr[i];
			}
		}

		return maxElement;
	}

}
