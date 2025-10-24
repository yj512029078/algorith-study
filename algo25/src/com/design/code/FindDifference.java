package com.design.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FindDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = new int[] { 1, 2, 3 };
		int nums2[] = new int[] { 2, 4, 6 };
		List<List<Integer>> multiList = findDifference(nums1, nums2);
		System.out.println(multiList);

		nums1 = new int[] { 1, 2, 3, 3 };
		nums2 = new int[] { 1, 1, 2, 2 };
		multiList = findDifference(nums1, nums2);
		System.out.println(multiList);
	}

	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		List<List<Integer>> multiList = new ArrayList<List<Integer>>();
		List<Integer> nums1List = new ArrayList<Integer>();
		List<Integer> nums2List = new ArrayList<Integer>();
		multiList.add(nums1List);
		multiList.add(nums2List);

		HashSet<Integer> nums1Set = new HashSet<Integer>();
		if(nums1 != null) {
			for (int i = 0; i < nums1.length; i++) {
				nums1Set.add(nums1[i]);
			}
		}

		HashSet<Integer> nums2Set = new HashSet<Integer>();
		if(nums2 != null) {
			for (int i = 0; i < nums2.length; i++) {
				nums2Set.add(nums2[i]);
			}	
		}

		// 注意 iterator 的写法，否则导致heap 溢出
		Iterator<Integer> iterator = nums1Set.iterator();
		while (iterator.hasNext()) {
			int value = iterator.next();
			if(!nums2Set.contains(value)) {
				nums1List.add(value);
			}
		}
		
		iterator = nums2Set.iterator();
		while (iterator.hasNext()) {
			int value = iterator.next();
			if(!nums1Set.contains(value)) {
				nums2List.add(value);
			}
		}

		return multiList;
	}

}
