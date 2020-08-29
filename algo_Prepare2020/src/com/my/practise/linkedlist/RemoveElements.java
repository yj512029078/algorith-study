package com.my.practise.linkedlist;

// 这里涉及到 2种思路：
// 思路1：引入哨兵
// 思路2：针对第一个节点，保证一定 valid；然后其它的 采用 node.next 判定即可 【要看下判定条件】

public class RemoveElements {

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
		// ListNode node3 = new ListNode(6);
		// ListNode node4 = new ListNode(3);
		// ListNode node5 = new ListNode(4);
		// ListNode node6 = new ListNode(5);
		// ListNode node7 = new ListNode(6);
		//
		// node1.next = node2;
		// node2.next = node3;
		// node3.next = node4;
		// node4.next = node5;
		// node5.next = node6;
		// node6.next = node7;

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;

		ListNode temp = removeElements2(node1, 1);
		while (temp != null) {
			System.out.print("-> " + temp.val);
			temp = temp.next;
		}
	}

	// 循环删除，第一个先保证一定是有效的节点
	public static ListNode removeElements(ListNode head, int val) {
		ListNode temp = head;

		// 开头多次循环，干掉不合适的，保证第一个节点一定是合适的
		// 因为后面的流程，不管第一个节点
		while ((head != null) && (head.val == val)) {
			head = head.next;
			temp = head;
		}

		if (temp == null) {
			return null;
		}

		while ((temp != null) && (temp.next != null)) {
			if (temp.next.val == val) {
				// 注意：这里做完后不再需要 将temp 指向下一个
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}

		return head;
	}

	// 伪造一个节点，使整体链表处理标准化
	public static ListNode removeElements2(ListNode head, int val) {
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;

		ListNode temp = fakeHead;
		while ((temp != null) && (temp.next != null)) {
			if (temp.next.val == val) {
				// 注意：这里做完后不再需要 将temp 指向下一个
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}

		return fakeHead.next;
	}

}
