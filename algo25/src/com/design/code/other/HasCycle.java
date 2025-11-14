package com.design.code.other;

import com.design.code.linkedlist.DeleteMiddle.ListNode;

public class HasCycle {
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasCycle(ListNode head) {
	    if (head == null || head.next == null) {
	        return false;
	    }
	    
	    ListNode slow = head;
	    ListNode fast = head.next;
	    
	    while (slow != fast) {
	        if (fast == null || fast.next == null) {
	            return false; // 快指针到达末尾，无环
	        }
	        slow = slow.next;      // 慢指针走一步
	        fast = fast.next.next; // 快指针走两步
	    }
	    
	    return true; // 快慢指针相遇，有环
	}

}
