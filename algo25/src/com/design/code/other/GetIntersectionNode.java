package com.design.code.other;

import java.util.HashSet;
import java.util.Set;

import com.design.code.other.HasCycle.ListNode;

public class GetIntersectionNode {
	
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
	
	// solution1 
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    if (headA == null || headB == null) {
	        return null;
	    }
	    
	    ListNode pA = headA;
	    ListNode pB = headB;
	    
	    // 当两个指针相遇时停止（可能是交点，也可能都是null）
	    while (pA != pB) {
	        // pA 走完链表A后跳转到链表B的头部
	        pA = (pA == null) ? headB : pA.next;
	        // pB 走完链表B后跳转到链表A的头部
	        pB = (pB == null) ? headA : pB.next;
	    }
	    
	    return pA; // 返回交点（或null）
	}
	
	// solution2
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
	    Set<ListNode> visited = new HashSet<ListNode>();
	    
	    // 遍历链表A，将所有节点加入集合
	    ListNode current = headA;
	    while (current != null) {
	        visited.add(current);
	        current = current.next;
	    }
	    
	    // 遍历链表B，检查是否有节点在集合中
	    current = headB;
	    while (current != null) {
	        if (visited.contains(current)) {
	            return current; // 找到交点
	        }
	        current = current.next;
	    }
	    
	    return null; // 无交点
	}

}
