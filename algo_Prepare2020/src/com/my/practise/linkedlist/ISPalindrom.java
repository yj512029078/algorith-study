package com.my.practise.linkedlist;

// 这个题目有一定的代码量，注意下
// 涉及到 快慢指针找中间节点；链表反转

public class ISPalindrom {

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
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		boolean flag = isPalindrome(node1);
		System.out.println("flag: " + flag);
	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}

		ListNode slow = head;
		ListNode fast = head;
		ListNode newNode = null;

		// 基于快慢指针分析中间节点；如果是奇数个节点，需要微调，找到链表的一半位置
		while ((fast != null) && (fast.next != null)) {
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) {
			newNode = slow.next;
		} else {
			newNode = slow;
		}

		ListNode reversedHead = reverse(newNode);

		boolean result = true;
		while (reversedHead != null) {
			if (head.val != reversedHead.val) {
				result = false;
				break;
			}

			head = head.next;
			reversedHead = reversedHead.next;
		}

		return result;
	}

	// 反转链表
	private static ListNode reverse(ListNode head) {
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

}
