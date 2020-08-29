package com.my.practise.linkedlist;

// 注意下，这个属于链表基础 -- 反转链表

public class ReverseList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// 维护2个指针，preNode + curNode；不断的改变 preNoe 和 curNode 的指针指向
	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode preNode = null;
		ListNode curNode = head;

		while (curNode != null) {
			ListNode temp = curNode.next;

			curNode.next = preNode;
			preNode = curNode;
			curNode = temp;
		}

		return preNode;
	}

	public static void main(String[] args) {
		// proc1, construct linked list
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode temp = node1;
		while (temp != null) {
			System.out.print("-> " + temp.val);
			temp = temp.next;
		}

		System.out.println();

		// proc1, reverse linked list
		ListNode resultNode = reverseList(node1);
		temp = resultNode;
		while (temp != null) {
			System.out.print("-> " + temp.val);
			temp = temp.next;
		}
	}

}
