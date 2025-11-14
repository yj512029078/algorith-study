package com.design.code.dfs;

public class LongestZigzag {

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
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(1);
		TreeNode node8 = new TreeNode(1);

		node1.right = node2;
		node2.left = node3;
		node2.right = node4;
		node4.left = node5;
		node4.right = node6;
		node5.right = node7;
		node7.right = node8;

		int result = longestZigZag(node1);
		System.out.println(result);

		TreeNode node11 = new TreeNode(1);
		TreeNode node12 = new TreeNode(1);
		TreeNode node13 = new TreeNode(1);
		TreeNode node14 = new TreeNode(1);
		TreeNode node15 = new TreeNode(1);
		TreeNode node16 = new TreeNode(1);
		TreeNode node17 = new TreeNode(1);
		TreeNode node18 = new TreeNode(1);

		node11.right = node12;
		node12.left = node13;
		node12.right = node14;
		node14.left = node15;
		node14.right = node16;
		node15.right = node17;
		node16.right = node18;

		result = longestZigZag(node11);
		System.out.println(result);
	}

	private int maxLength = 0;

	// 基于DFS 思路做计算
	public int longestZigZag2(TreeNode root) {
		dfs(root, true, 0);   // 尝试向左
		dfs(root, false, 0);  // 尝试向右
		return maxLength;
	}

	private void dfs(TreeNode node, boolean goLeft, int length) {
		if (node == null) {
			return;
		}

		// 更新最大长度
		maxLength = Math.max(maxLength, length);

		if (goLeft) {
			// 当前要向左走
			dfs(node.left, false, length + 1);  // 继续交错：去左边，下一步向右
			dfs(node.right, true, 1);           // 重新开始：去右边，下一步向左
		} else {
			// 当前要向右走
			dfs(node.right, true, length + 1);  // 继续交错：去右边，下一步向左
			dfs(node.left, false, 1);           // 重新开始：去左边，下一步向右
		}
	}

	// 基于遍历tree 的思路，涉及到2层tree node 遍历
	public static int longestZigZag(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int result = tranverseTree(root, Integer.MIN_VALUE);
		return result;
	}

	private static int tranverseTree(TreeNode root, int maxLength) {
		if (root == null) {
			return 0;
		}

		int rightMaxLength = tranverseZigZag(root, 1);
		int leftMaxLength = tranverseZigZag(root, -1);
		if (leftMaxLength > maxLength || rightMaxLength > maxLength) {
			maxLength = Math.max(rightMaxLength, leftMaxLength);
		}

		int lLength = tranverseTree(root.left, maxLength);
		int rLength = tranverseTree(root.right, maxLength);

		if (lLength > maxLength || rLength > maxLength) {
			maxLength = Math.max(rLength, lLength);
		}

		return maxLength;
	}

	private static int tranverseZigZag(TreeNode root, int orietation) {
		if (root == null) {
			return 0;
		}

		int count = 0;
		if (orietation == 1) {
			if (root.left != null) {
				count = tranverseZigZag(root.left, -1) + 1;
			}
		} else {
			if (root.right != null) {
				count = tranverseZigZag(root.right, 1) + 1;
			}
		}
		return count;
	}

}
