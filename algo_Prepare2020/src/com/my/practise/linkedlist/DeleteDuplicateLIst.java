package com.my.practise.linkedlist;

public class DeleteDuplicateLIst {

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
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode temp = deleteDuplicates(node1);
		while (temp != null) {
			System.out.print("-> " + temp.val);
			temp = temp.next;
		}
	}

	// 核心就是维护2个指针，移动链表的指针就可以了
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode currNode = head;
		ListNode fileterNode = head;

		while (currNode != null) {
			if (fileterNode.val != currNode.val) {
				fileterNode.next = currNode;
				fileterNode = currNode;
			}

			currNode = currNode.next;
		}

		fileterNode.next = null;

		return head;
	}

}
