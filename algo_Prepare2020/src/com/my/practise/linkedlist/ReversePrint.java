package com.my.practise.linkedlist;

import java.util.ArrayList;

// 反转打印
// 思路1：递归
// 思路2：栈

public class ReversePrint {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);

		node1.next = node2;
		node2.next = node3;

		int[] arr = reversePrint(node1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "->");
		}
		System.out.println();
	}

	// 思考逻辑1：可以用栈
	// 思考逻辑2：可以用递归
	public static int[] reversePrint(ListNode head) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		reversePrint(head, arrayList);

		int[] array = new int[arrayList.size()];
		int index = 0;
		for (int value : arrayList) {
			array[index++] = value;
		}

		return array;
	}

	public static void reversePrint(ListNode head, ArrayList<Integer> arrayList) {
		if (head == null) {
			return;
		}

		reversePrint(head.next, arrayList);
		arrayList.add(head.val);
	}

}
