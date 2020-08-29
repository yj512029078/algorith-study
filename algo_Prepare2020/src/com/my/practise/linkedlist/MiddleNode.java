package com.my.practise.linkedlist;

// 思路还是蛮简单的，适当看下即可

public class MiddleNode {

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
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		ListNode tempListNode = middleNode(node1);
		System.out.println("data: " + tempListNode.val);
	}

	// 快慢指针
	public static ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null) {
			if (fast.next != null) {
				fast = fast.next.next;
			} else {
				break;
			}

			slow = slow.next;
		}

		return slow;
	}

}
