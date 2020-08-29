package com.my.practise.linkedlist;

// 这个思路要看下，本质上其实很简单的
// 算和 不需要引用 Math.pow(2)，没必要的

public class GetDecimalValue {

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
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;

		int sum = getDecimalValue(node1);
		System.out.println("value: " + sum);
	}

	// 二进制： 1 0 0 1 1 -> 19
	public static int getDecimalValue(ListNode head) {
		int sum = 0;
		// int baseValue = 1;

		ListNode tempNode = head;

		// while (tempNode != null) {
		// sum += tempNode.val * baseValue;
		//
		// tempNode = tempNode.next;
		// baseValue *= 2;
		// }

		while (tempNode != null) {
			// 每次发现新节点，就相当于整体左移一位，也就是 *2
			sum = tempNode.val + sum * 2;
			tempNode = tempNode.next;
		}

		return sum;
	}

}
