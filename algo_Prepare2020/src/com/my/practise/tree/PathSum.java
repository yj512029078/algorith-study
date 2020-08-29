package com.my.practise.tree;

// 这个思路记一下
// 其实呢，思想并不算复杂；1）基于深搜的方式发现自己节点 2）深搜所有节点

public class PathSum {

	static int count = 0;

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode node = createTree();
		pathSum(node, 8);
	}

	public static void preOrder(TreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(" " + node.val);
		preOrder(node.left);
		preOrder(node.right);
	}

	public static TreeNode createTree() {
		TreeNode root = new TreeNode(10);

		TreeNode level2L = new TreeNode(5);
		root.left = level2L;

		TreeNode level2R = new TreeNode(-3);
		root.right = level2R;

		TreeNode level3R = new TreeNode(11);
		level2R.right = level3R;

		TreeNode level3L = new TreeNode(3);
		level2L.left = level3L;

		level3R = new TreeNode(2);
		level2L.right = level3R;

		return root;
	}

	public static int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}

		dfs(root, sum);
		pathSum(root.left, sum);
		pathSum(root.right, sum);
		return count;
	}

	public static void dfs(TreeNode root, int num) {
		if (root == null) {
			return;
		}

		if (root.val == num) {
			count++;
		}
		dfs(root.left, num - root.val);
		dfs(root.right, num - root.val);
	}

}
