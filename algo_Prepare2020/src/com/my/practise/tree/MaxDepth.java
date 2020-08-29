package com.my.practise.tree;

import java.util.LinkedList;

// 问题：二叉树最大深度

// 思路和写法还是要记一下
// 层序遍历计算深度，层序遍历的核心思想是有个 linkedlist 作为栈记录；每次将节点加入这个栈中，然后不断的POP 出来
// 递归，反正比较最终大小就可以了
// 先序遍历，将叶子节点的 高度保存下来；每次和 缓存的 mMaxDepth 比较

public class MaxDepth {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = createTree();
		int maxDepth = maxDepth3(root);
		System.out.println("depth: " + maxDepth);
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

	/**
	 * 层序遍历算高度
	 * 
	 * @param root
	 * @return
	 */
	public static int maxDepth3(TreeNode root) {
		if (root == null) {
			return 0;
		}

		LinkedList<TreeNode> linkedList = new LinkedList<MaxDepth.TreeNode>();
		linkedList.add(root);

		int depth = 0;

		while (!linkedList.isEmpty()) {
			depth++;
			System.out.println("data: " + linkedList.getLast().val);

			// note：这里不要动态算 size，会有问题的
			int size = linkedList.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = linkedList.poll();

				if (node.left != null) {
					linkedList.add(node.left);
				}

				if (node.right != null) {
					linkedList.add(node.right);
				}
			}
		}

		return depth;
	}

	/**
	 * 递归计算高度
	 * 
	 * @param root
	 * @return
	 */
	public static int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = maxDepth2(root.left) + 1;
		int rightHeight = maxDepth2(root.right) + 1;
		maxDepth = Math.max(leftHeight, rightHeight);
		return maxDepth;
	}

	static int maxDepth = 0;

	public static int maxDepth(TreeNode root) {
		preorder(root, 0);
		return maxDepth;
	}

	/**
	 * 先序遍历，对叶子节点，算高度，不断更新
	 * 
	 * @param root
	 * @param depth
	 */
	public static void preorder(TreeNode root, int depth) {
		if (root == null) {
			return;
		}

		depth++;
		if (root.left == null && root.right == null) {
			if (depth > maxDepth) {
				maxDepth = depth;
			}
		} else {
			preorder(root.left, depth);
			preorder(root.right, depth);
		}
	}

}
