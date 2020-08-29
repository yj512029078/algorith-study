package com.my.practise.tree;

import java.util.LinkedList;

// 层序遍历的时候做一点处理

public class InvertTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode createTree() {
		TreeNode root = new TreeNode(1);

		TreeNode level2L = new TreeNode(2);
		root.left = level2L;

		TreeNode level2R = new TreeNode(3);
		root.right = level2R;

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
		linkedList.add(root);

		while (!linkedList.isEmpty()) {
			int size = linkedList.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = linkedList.pollFirst();

				if (node.left != null) {
					linkedList.add(node.left);
				}

				if (node.right != null) {
					linkedList.add(node.right);
				}

				TreeNode tempNode = node.left;
				node.left = node.right;
				node.right = tempNode;
			}
		}

		return root;
	}

}
