package com.my.practise.linkedlist;

// 注意第二种解法

public class KthToLast {

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
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		int result = kthToLast(node1, 2);
		System.out.println("result: " + result);
	}

	// 解法1：走 (length - K) 步骤即可
	// 解法2：先走K步，然后2个指针一起走
	public static int kthToLast(ListNode head, int k) {
		ListNode slowNode = head;
		ListNode fastNode = head;

		while (k-- > 0) {
			fastNode = fastNode.next;
		}

		// 可能本身就只有1个元素
		// if (fastNode == null) {
		// return result;
		// }

		while ((slowNode != null) && (fastNode != null)) {
			slowNode = slowNode.next;
			fastNode = fastNode.next;
		}

		return slowNode.val;
	}

}
