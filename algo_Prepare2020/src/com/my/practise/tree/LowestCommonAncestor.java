package com.my.practise.tree;

// 需要一定的思考时间和理解能力
// 记录一下答案吧

public class LowestCommonAncestor {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode createTree() {
		TreeNode root = new TreeNode(3);

		TreeNode level2L = new TreeNode(9);
		root.left = level2L;

		TreeNode level2R = new TreeNode(20);
		root.right = level2R;

		TreeNode level3L = new TreeNode(15);
		level2R.left = level3L;

		TreeNode level3R = new TreeNode(7);
		level2R.right = level3R;

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 首先要检查当前的root情况，若为null就直接返回；
		// 若为p、q则是满足最近公共节点为节点本身
		if (root == null || root == p || root == q)
			return root;

		// 再利用递归从根节点开始，开始向下遍历每个节点（以下两步则为具体对每一个节点的左右子树查找），由上述if语句的返回值得到这两个节点的值
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// 对于left和right节点返回的情况，如果根节点的左子树/右子树找不到最近公共节点，那么就说明在右子树/左子树当中
		if (left == null)
			return right;

		if (right == null)
			return left;
		// 如果上述两个情况都不符合 则说明根节点就是最近公共节点，直接返回
		return root;
	}

}
