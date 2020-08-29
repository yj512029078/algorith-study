package com.my.practise.linkedlist;

public class MergeTwoList {

	public static void main(String[] args) {
		ListNode listA1 = new ListNode(1);
		ListNode listA2 = new ListNode(2);
		ListNode listA3 = new ListNode(4);
		listA1.next = listA2;
		listA2.next = listA3;

		ListNode listB1 = new ListNode(1);
		ListNode listB2 = new ListNode(3);
		ListNode listB3 = new ListNode(4);
		listB1.next = listB2;
		listB2.next = listB3;
		
		ListNode resultNode = mergeTwoLists(listA1,  listB1);
		while (resultNode != null) {
			System.out.print(resultNode.val + "->");
			resultNode = resultNode.next;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// 构造一个新队列的指针，内部根据大小不断的调整就可以
	private static ListNode mergeTwoLists(ListNode listA, ListNode listB) {
		if (listA == null) {
			return listB;
		}

		if (listB == null) {
			return listA;
		}

		ListNode resultHead = null; 
		ListNode resultNode = null;
		ListNode currA = listA;
		ListNode currB = listB;
		
		if(currA.val <= currB.val) {
			resultNode = currA;
			currA = currA.next;
		} else {
			resultNode = currB;
			currB = currB.next;
		}
		
		resultHead = resultNode;

		while ((currA != null) && (currB != null)) {
			if(currA.val <= currB.val) {
				resultNode.next = currA;
				resultNode = currA;
				
				currA = currA.next;
			} else {
				resultNode.next = currB;
				resultNode = currB;
				
				currB = currB.next;
			}
		}
		
		if(currA == null) {
			resultNode.next = currB;
		}
		
		if(currB == null) {
			resultNode.next = currA;
		}

		return resultHead;
	}

}
