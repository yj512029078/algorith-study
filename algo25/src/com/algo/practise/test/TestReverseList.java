package com.algo.practise.test;

public class TestReverseList {
	
	static class ListNode {
		ListNode next;
		int value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// 1 -> 2 -> 3 -> 6 -> 4 -> 5
	
	public static reverseListWithRegion(ListNode head, int m, int n) {
		if(head == null) {
			return null;
		}
		
		ListNode reverseRegionListPreNode = null;
		ListNode reverseRegionListPostNode = null;
		
		ListNode curNode = head;
		while (curNode != null) {
			curNode = curNode.next;
		}
		
		return null;
	}
	
	public static ListNode reverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		
		ListNode curNode = head;
		ListNode preNode = null;
		
		while (curNode != null) {
			ListNode tempNode = curNode.next;
			curNode.next = preNode;
			
			preNode = curNode;
			curNode = tempNode;
		}
		
		return preNode;
	}

}
