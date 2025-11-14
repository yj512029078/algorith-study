package com.design.code.queue;

import java.util.LinkedList;

public class RecentCounter {

	private static LinkedList<Integer> linkedList = new LinkedList<Integer>();

	public RecentCounter() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = ping2(1);
		System.out.println(result);

		result = ping2(100);
		System.out.println(result);

		result = ping2(3001);
		System.out.println(result);

		result = ping2(3002);
		System.out.println(result);
	}

	// 迭代效率不好，每次过来都要从头遍历；其实 t - 3000 之前的元素不需要了
	public static int ping(int t) {
		linkedList.add(t);

		int timeZoneStart = t - 3000;
		int timeZoneEnd = t;
		int count = 0;

		for (int i = 0; i < linkedList.size(); i++) {
			int value = linkedList.get(i);
			if (value >= timeZoneStart && value <= timeZoneEnd) {
				count++;
			}

			if (value > timeZoneEnd) {
				break;
			}
		}

		return count;
	}

	public static int ping2(int t) {
		linkedList.offer(t);

		int timeZoneStart = t - 3000;
		while (linkedList.peek() < timeZoneStart) {
			linkedList.poll();
		}

		return linkedList.size();
	}

}
