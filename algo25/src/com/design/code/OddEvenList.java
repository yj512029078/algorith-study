package com.design.code;

import java.io.ObjectInputFilter;
import java.lang.annotation.ElementType;

public class OddEvenList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 2 3 4 5 6
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(7);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		ListNode head = oddEvenList2(node1);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();

		node1 = new ListNode(1);
		head = oddEvenList2(node1);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode evenPreNode = null;
		ListNode oddPreNode = null;

		ListNode evenHeadNode = null;
		ListNode oddHeadNode = null;

		ListNode preNode = null;
		ListNode curNode = head;
		int k = 0;

		while (curNode != null) {
			if (k % 2 == 0) {
				// even 偶数
				if (evenPreNode != null) {
					evenPreNode.next = curNode;
				} else {
					evenHeadNode = curNode;
				}

				evenPreNode = curNode;
			} else {
				// odd 奇数
				if (oddPreNode != null) {
					oddPreNode.next = curNode;
				} else {
					oddHeadNode = curNode;
				}

				oddPreNode = curNode;
			}

			preNode = curNode;
			curNode = curNode.next;

			k++;
		}

		// 非常关键，否则会导致链表出现环
		evenPreNode.next = null;
		// 注意，这里可能为null
		if (oddPreNode != null) {
			oddPreNode.next = null;
		}

		evenPreNode.next = oddHeadNode;
		return evenHeadNode;
	}

	// 2 1 3 5 6 4 7
	public static ListNode oddEvenList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode evenHead = head;
		ListNode evenTail = head.next;

		ListNode oddHead = head.next;
		ListNode oddTail = head.next;

		ListNode preEvenNode = head;
		ListNode preOddNode = head.next;

		ListNode curNode = head.next.next;
		while (curNode != null && curNode.next != null) {
			preEvenNode.next = curNode;
			preEvenNode = curNode;
			evenTail = curNode;

			preOddNode.next = curNode.next;
			preOddNode = curNode.next;
			oddTail = curNode.next;
			
			curNode = curNode.next.next;
		}

		preEvenNode.next = curNode;
		System.out.println(preEvenNode.val + "**1");
		System.out.println(curNode.val + "**2");
		if (curNode != null) {
			evenTail = curNode;
		}

		if (oddTail != null) {
			oddTail.next = null;
		}
		evenTail.next = oddHead;

		return evenHead;
	}

}
