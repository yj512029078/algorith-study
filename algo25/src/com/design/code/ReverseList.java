package com.design.code;

public class ReverseList {

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
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode reverseHead = reverseList(node1);
		ListNode node = reverseHead;
		while (node != null) {
			System.out.print(node.val + "-> ");
			node = node.next;
		}
		System.out.println();
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode currentNode = head;
		ListNode preNode = null;
		while (currentNode != null) {
			ListNode tempNode = currentNode;
			currentNode = currentNode.next;

			tempNode.next = preNode;
			preNode = tempNode;
		}

		return preNode;
	}

}
