package com.design.code.dfs;

import java.util.ArrayDeque;
import java.util.Stack;

public class MaxDepth {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);

		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;

		int maxDepth = maxDepth(node1);
		System.out.println(maxDepth);

		TreeNode node11 = new TreeNode(1);
		TreeNode node12 = new TreeNode(2);
		node11.right = node12;

		maxDepth = maxDepth(node11);
		System.out.println(maxDepth);

		maxDepth = computeDepthWithStack(node1);
		System.out.println(maxDepth);
		
		maxDepth = computeDepthWithBFS(node1);
		System.out.println(maxDepth);
		
		maxDepth = computeDepthWithBFS(node11);
		System.out.println(maxDepth);
	}

	// 求最大深度简单，但是如果是要求每个叶子节点的深度，以及每个节点的深度呢
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int lDepth = maxDepth(root.left) + 1;
		int rDepth = maxDepth(root.right) + 1;

		int maxDepth = Math.max(lDepth, rDepth);
		return maxDepth;
	}

	/**
	 * 通过递归遍历的方式，可以计算每一个节点的depth
	 * 
	 * @param root
	 */
	public static void computeTreeNodeDepth(TreeNode root) {
		if (root == null) {
			return;
		}

		tranverseDepth(root, 1);
	}

	public static void tranverseDepth(TreeNode root, int depth) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			tranverseDepth(root.left, depth + 1);
		}

		if (root.right != null) {
			tranverseDepth(root.right, depth + 1);
		}
	}

	/**
	 * 基于 stack （非递归，非层序遍历的方式）计算二叉树的 depth
	 * 
	 * @param root
	 * @return
	 */
	public static int computeDepthWithStack(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Stack<TreeNode> nodeStack = new Stack<MaxDepth.TreeNode>();
		Stack<Integer> depthStack = new Stack<Integer>();
		nodeStack.push(root);
		depthStack.push(1);

		int maxDpeth = 0;
		while (!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			int depth = depthStack.pop();

			maxDpeth = Math.max(depth, maxDpeth);

			if (node.left != null) {
				nodeStack.push(node.left);
				depthStack.push(depth + 1);
			}

			if (node.right != null) {
				nodeStack.push(node.right);
				depthStack.push(depth + 1);
			}
		}

		return maxDpeth;
	}

	/**
	 * 基于 层序遍历的方式 计算二叉树的 depth
	 * 
	 * @param root
	 * @return
	 */
	public static int computeDepthWithBFS(TreeNode root) {
		if (root == null) {
			return 0;
		}

		ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<MaxDepth.TreeNode>();
		// 注意是 offer，从尾部加入；不是push，从头部加入
		arrayDeque.offer(root);

		int depth = 0;
		while (!arrayDeque.isEmpty()) {
			depth++;
			
			int size = arrayDeque.size();
			for (int i = 0; i < size; i++) {
				// 这里是poll，从头部取出；或者pop 也行
				TreeNode node = arrayDeque.poll();

				if (node.left != null) {
					arrayDeque.offer(node);
				}

				if (node.right != null) {
					arrayDeque.offer(node.right);
				}
			}
		}
		
		return depth;
	}

}
