package com.my.practise.linkedlist;

// 这个算法写了很久，其实很简单；想的太复杂了！！！
// 删除某个节点的几种解法：1）双指针 2）拷贝数据 3）next 节点指针指向改变，直接改成下一个

public class RemoveDuplicateNode {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ListNode node1 = new ListNode(1);
		// ListNode node2 = new ListNode(2);
		// ListNode node3 = new ListNode(3);
		// ListNode node4 = new ListNode(3);
		// ListNode node5 = new ListNode(2);
		// ListNode node6 = new ListNode(1);

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(2);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode temp0 = node1;
		while (temp0 != null) {
			System.out.print("-> " + temp0.val + " " + temp0.hashCode());
			temp0 = temp0.next;
		}
		System.out.println();

		ListNode temp = removeDuplicateNodes(node1);
		while (temp != null) {
			System.out.print("-> " + temp.val + " " + temp.hashCode());
			temp = temp.next;
		}
	}

	// // 方案1：暴力办法
	// // 方案2：使用HasshSet，推荐
	// public static ListNode removeDuplicateNodes(ListNode head) {
	// ListNode pivotNode = head;
	//
	// while (pivotNode != null) {
	// ListNode preNode = null;
	// ListNode tempNode = pivotNode;
	//
	// while (tempNode != null) {
	// // 删除某个节点，使用了 preNode
	// if (tempNode.val == pivotNode.val) {
	// System.out.println(tempNode.val + "");
	//
	// if (tempNode.next != null) {
	// tempNode.val = tempNode.next.val;
	// tempNode.next = tempNode.next.next;
	// } else {
	// if (preNode != null) {
	// preNode.next = null;
	// }
	// }
	// }
	//
	// preNode = tempNode;
	// tempNode = tempNode.next;
	// }
	//
	// pivotNode = pivotNode.next;
	// }
	//
	// return head;
	// }

	public static ListNode removeDuplicateNodes(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			ListNode temp = cur;
			while (temp.next != null) {
				if (temp.next.val == cur.val) {
					temp.next = temp.next.next;
				} else {
					temp = temp.next;
				}
			}
			cur = cur.next;
		}
		return head;
	}

}
