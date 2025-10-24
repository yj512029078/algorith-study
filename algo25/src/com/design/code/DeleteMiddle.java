package com.design.code;

public class DeleteMiddle {

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
//		head = [1,3,4,7,1,2,6]
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(7);
		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(2);
		ListNode node7 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		ListNode head = deleteMiddle(node1);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();

		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(2);
		ListNode node13 = new ListNode(3);
		ListNode node14 = new ListNode(4);
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;

		head = deleteMiddle(node11);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();

		ListNode node21 = new ListNode(2);
		ListNode node22 = new ListNode(1);
		node21.next = node22;
		head = deleteMiddle(node21);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode deleteMiddle(ListNode head) {
		if (head == null) {
			return head;
		}

		int length = 0;
		ListNode curNode = head;
		while (curNode != null) {
			length++;
			curNode = curNode.next;
		}

		if (length <= 1) {
			return null;
		}

		int deleteIndex = length / 2;
		curNode = head;
		int k = 0;

		ListNode preNode = null;
		while (k < deleteIndex) {
			preNode = curNode;
			curNode = curNode.next;

			if (k == (deleteIndex - 1)) {
				if (curNode != null) {
					preNode.next = curNode.next;
				} else {
					preNode.next = null;
				}
			}

			k++;
		}

		return head;
	}

}
