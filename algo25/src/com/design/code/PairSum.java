package com.design.code;

public class PairSum {

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
		int nums[] = new int[] { 5, 4, 2, 1 };

		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		int sum = pairSum(node1);
		System.out.println(sum);

		ListNode node11 = new ListNode(4);
		ListNode node21 = new ListNode(2);
		ListNode node31 = new ListNode(2);
		ListNode node41 = new ListNode(3);

		node11.next = node21;
		node21.next = node31;
		node31.next = node41;

		sum = pairSum(node11);
		System.out.println(sum);
		
		
		ListNode node13 = new ListNode(1);
		ListNode node23 = new ListNode(100000);
		node13.next = node23;

		sum = pairSum(node13);
		System.out.println(sum);
	}

	public static int pairSum(ListNode head) {
		if (head == null) {
			return 0;
		}

		int sum = Integer.MIN_VALUE;
		int length = 0;

		ListNode tempNode = head;
		while (tempNode != null) {
			length++;
			tempNode = tempNode.next;
		}

		ListNode nextHalfHead = head;
		for (int i = 0; i < length / 2; i++) {
			nextHalfHead = nextHalfHead.next;
		}

		ListNode firstHalfHead = reverseList(head, length / 2);
		tempNode = firstHalfHead;
//		while (tempNode != null) {
//			System.out.print(tempNode.val + "->");
//			tempNode = tempNode.next;
//		}
//		System.out.println();

		for (int i = 0; i < length / 2; i++) {
			int temSum = nextHalfHead.val + firstHalfHead.val;
			if (temSum > sum) {
				sum = temSum;
			}

			nextHalfHead = nextHalfHead.next;
			firstHalfHead = firstHalfHead.next;
		}

		return sum;
	}

	// 1 2 3 4
	public static ListNode reverseList(ListNode head, int reverseLength) {
		if (head == null) {
			return head;
		}

		ListNode preNode = null;
		ListNode curNode = head;

		int count = 0;
		while (curNode != null) {
			ListNode tempNode = curNode.next;

			curNode.next = preNode;
			preNode = curNode;

			count++;
			System.out.println("count:" + count + " reverseLength:" + reverseLength);
			if (count == reverseLength) {
				break;
			}

			curNode = tempNode;
		}

		return curNode;
	}

}
