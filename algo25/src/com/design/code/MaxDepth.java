package com.design.code;

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

}
