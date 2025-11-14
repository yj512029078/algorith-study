package com.design.code.slidingwindow;

public class longestOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		int result = longestOnes(nums, k);
		System.out.println(result);
	}
	
    public static int longestOnes(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int left = 0;
		int zeroCount = 0;
		int maxOnes = 0;
		
		for (int right = 0; right < nums.length; right++) {
			if(nums[right] == 0) {
				zeroCount++;
			}
			
			while (zeroCount > k) {
				if(nums[left] == 0) {
					zeroCount--;
				}
				left++;
			}
			
			maxOnes = Math.max(maxOnes, right - left + 1);
		}

		return maxOnes;
	}

}
