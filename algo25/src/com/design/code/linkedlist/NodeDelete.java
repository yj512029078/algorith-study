package com.design.code.linkedlist;

/**
 * 删除倒序第 N个节点
 */
public class NodeDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode resultNode = deleteNodeFromEndN(node1, 3);
		while (resultNode != null) {
			System.out.print(resultNode.value + " ");
			resultNode = resultNode.next;
		}
	}

	static class ListNode {
		public ListNode(int value) {
			this.value = value;
		}

		int value;
		ListNode next;
	}

	private static ListNode deleteNodeFromEndN(ListNode node, int reverseN) {
		if (node == null) {
			return null;
		}

		ListNode head = node;
		if (reverseN <= 0) {
			return head;
		}

		int length = getNodeListLength(node);
		if (length < reverseN) {
			return head;
		}

		if (length == reverseN) {
			return head.next;
		}

		ListNode preNode = null;
		ListNode postNode = null;

		int indexN = length - reverseN;
		int count = 0;

		while (node.next != null) {
			count++;

			if (count == indexN) {
				preNode = node;
				postNode = node.next;
				break;
			}

			node = node.next;
		}

		// 直接移动到前驱节点，不需要while循环和计数
		ListNode current = head;
		for (int i = 1; i < length - reverseN; i++) {
			current = current.next;
		}

		preNode.next = postNode.next;
		return head;
	}

	private static int getNodeListLength(ListNode node) {
		if (node == null) {
			return 0;
		}

		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}

}
