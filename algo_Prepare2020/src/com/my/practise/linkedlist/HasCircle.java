package com.my.practise.linkedlist;

// 方案1：可以使用 HashSet
// 方案2：可以使用 快慢指针

public class HasCircle {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;

		boolean isCycle = hasCycle(node1);
		System.out.println("circle: " + isCycle);
	}

	public static boolean hasCycle(ListNode head) {
		boolean isCycle = false;

		// 外部判断
		if ((head == null) || (head.next == null)) {
			return isCycle;
		}

		ListNode slow = head;
		// 快指针
		ListNode fast = head.next;

		// 同时判断
		while ((fast != null) && (fast.next != null)) {
			if (slow == fast) {
				isCycle = true;
				break;
			}

			slow = slow.next;
			fast = fast.next.next;
		}

		return isCycle;
	}

}
