package com.my.practise.linkedlist;

// 注意下这个写法的思路

public class DeleteNode {

	static class ListNode {
		String val;
		ListNode next;

		ListNode(String x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode("a");
		ListNode node2 = new ListNode("b");
		ListNode node3 = new ListNode("c");
		ListNode node4 = new ListNode("d");
		ListNode node5 = new ListNode("e");
		ListNode node6 = new ListNode("f");

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		deleteNode(node3);

		ListNode tempNode = node1;
		while (tempNode != null) {
			System.out.print(tempNode.val + "->");
			tempNode = tempNode.next;
		}
	}

	// 怎么有效的删除一个节点，其实可以删除下一个节点；但同时将下一个节点的数据拷贝
	public static void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}

		node.val = node.next.val;
		node.next = node.next.next;
	}

}
