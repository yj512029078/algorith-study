package com.my.practise.linkedlist;

// 重点看下这个思路

public class IntersectionNode {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listA1 = new ListNode(0);
		ListNode listA2 = new ListNode(9);
		ListNode listA3 = new ListNode(1);
		listA1.next = listA2;
		listA2.next = listA3;

		ListNode listB1 = new ListNode(3);

		ListNode common1 = new ListNode(2);
		ListNode common2 = new ListNode(4);
		common1.next = common2;

		listA3.next = common1;
		listB1.next = common1;

		ListNode insectionNode = getIntersectionNode(listA1, listB1);
		if (insectionNode != null) {
			System.out.println("node: " + insectionNode.val);
		} else {
			System.out.println("node: null");
		}
	}

	// 找相交节点，先走K 步
	// 如果两个链表相交，则最终一定 end 节点 相同
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if ((headA == null) || (headB == null)) {
			return null;
		}

		int lengthA = 0;
		ListNode tempA = headA;
		while (tempA != null) {
			lengthA++;
			tempA = tempA.next;
		}

		int lengthB = 0;
		ListNode tempB = headB;
		while (tempB != null) {
			lengthB++;
			tempB = tempB.next;
		}

		if (lengthA >= lengthB) {
			int deltaLength = lengthA - lengthB;
			while (deltaLength-- > 0) {
				headA = headA.next;
			}
		} else {
			int deltaLength = lengthB - lengthA;
			while (deltaLength-- > 0) {
				headB = headB.next;
			}
		}

		tempA = headA;
		tempB = headB;

		System.out.println("tempA, " + tempA.val);
		System.out.println("tempB, " + tempB.val);

		ListNode insectionNode = null;
		while ((tempA != null) && (tempB != null)) {
			if (tempA == tempB) {
				insectionNode = tempA;
				break;
			}

			tempA = tempA.next;
			tempB = tempB.next;
		}

		return insectionNode;
	}

}
