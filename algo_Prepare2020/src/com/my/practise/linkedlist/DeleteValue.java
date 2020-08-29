package com.my.practise.linkedlist;

public class DeleteValue {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(9);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode temp = deleteNode(node1, 5);
		while (temp != null) {
			System.out.print("-> " + temp.val);
			temp = temp.next;
		}
	}

	// 注意：需要的是删除一个节点，双指针就可以搞定
	public static ListNode deleteNode(ListNode head, int val) {
		if (head == null) {
			return null;
		}

		ListNode preNode = null;
		ListNode currNode = head;

		if (head.val == val) {
			return head.next;
		}

		preNode = currNode;
		currNode = currNode.next;
		while (currNode != null) {
			if (currNode.val == val) {
				preNode.next = currNode.next;
				break;
			}

			preNode = currNode;
			currNode = currNode.next;
		}

		return head;
	}

}
