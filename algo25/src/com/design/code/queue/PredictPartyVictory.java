package com.design.code.queue;

import java.util.LinkedList;
import java.util.Queue;

public class PredictPartyVictory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String senate = "RD";
		String resultString = predictPartyVictory2(senate);
		System.out.println(resultString);

		senate = "RDD";
		resultString = predictPartyVictory2(senate);
		System.out.println(resultString);
	}

	public static String predictPartyVictory(String senate) {
		if (senate == null || senate.length() == 0) {
			return "";
		}

		LinkedList<Character> linkedList = new LinkedList<Character>();
		for (int i = 0; i < senate.length(); i++) {
			linkedList.add(senate.charAt(i));
		}

		while (linkedList.size() != 1) {
			LinkedList<Character> tempList = compressListToOne(linkedList);
			System.out.println("tempList size:" + tempList.size() + " ;linkedList size:" + linkedList.size());

			linkedList = tempList;
		}

		if (linkedList.get(0) == 'R') {
			return "Radiant";
		} else {
			return "Dire";
		}
	}

	private static LinkedList<Character> compressListToOne(LinkedList<Character> linkedList) {
		LinkedList<Character> tempList = new LinkedList<Character>();

		for (int i = 0; i < linkedList.size(); i = i + 2) {
			if (i == (linkedList.size() - 1)) {
				for (int j = (tempList.size() - 1); j >= 0; j--) {
					if (tempList.get(j) != linkedList.get(i)) {
						tempList.remove(j);
						break;
					}
				}
			}

			if (linkedList.get(i) == 'R') {
				tempList.add('R');
			} else {
				tempList.add('D');
			}
		}

		return tempList;
	}

	// 这个思路比较巧，但很合理
	public static String predictPartyVictory2(String senate) {
		if (senate == null || senate.length() == 0) {
			return "";
		}

		Queue<Integer> rQueue = new LinkedList<Integer>();
		Queue<Integer> dQueue = new LinkedList<Integer>();

		for (int i = 0; i < senate.length(); i++) {
			if (senate.charAt(i) == 'R') {
				rQueue.offer(i);
			} else {
				dQueue.offer(i);
			}
		}

		while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
			int rValue = rQueue.poll();
			int dValue = dQueue.poll();

			if (rValue < dValue) {
				rQueue.offer(rValue + senate.length());
			} else {
				dQueue.offer(rValue + senate.length());
			}
		}

		if (!rQueue.isEmpty()) {
			return "Radiant";
		} else {
			return "Dire";
		}
	}

}
