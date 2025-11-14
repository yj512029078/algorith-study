package com.algo.practise.test;

public class ReverseList {

	// node: 1-2-3-4-5-6， m=2, n=5
	// return 1-5-4-3-2-6

	static class Node {
		Node next;
		int val;

		public Node(int value) {
			this.val = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static Node reverseListSegment(Node node, int m, int n) {
		if (node == null) {
			return node;
		}

		Node reverListPreNode = null;
		Node reverListPostNode = null;

		Node tempNode = node;
		int count = 0;
		while (tempNode != null) {
			count++;
			
			if (count == (m - 1)) {
				reverListPreNode = tempNode;
			}

			if (count == n) {
				reverListPostNode = tempNode.next;
			}

			tempNode = tempNode.next;
		}

		Node reverseListHeadNode = reverListPreNode.next;
		reverseListHeadNode = reverseList(reverseListHeadNode);

		reverListPreNode.next = reverseListHeadNode;

		Node currentNode = reverseListHeadNode;
		Node preNode = null;
		while (currentNode != null) {
			preNode = currentNode;
			currentNode = currentNode.next;
		}
		preNode.next = reverListPostNode;

		return null;
	}

	// 1-2-3-4-5-6
	private static Node reverseList(Node node) {
		if (node == null) {
			return node;
		}

		Node preNode = null;
		Node curNode = node;

		while (node != null) {
			Node tempNode = node;
			node.next = preNode;
			node = tempNode.next;
		}

		return node;
	}

}
