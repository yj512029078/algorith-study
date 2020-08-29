package com.my.practise.tree;

import java.util.ArrayList;

// 本质上可以先序遍历，找到所有的叶子节点
// 修改下函数，可以传入是否 left 标识 + arraylist（装入所有）

public class SumOfLeftLeaves {

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
		TreeNode node = createTree2();
		int sum = sumOfLeftLeaves(node);
		System.out.println("sum: " + sum);
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

	public static TreeNode createTree2() {
		TreeNode root = new TreeNode(1);
		return root;
	}

	public static int sumOfLeftLeaves(TreeNode root) {
		int result = 0;
		if (root == null) {
			return result;
		}

		if (root.left == null && root.right == null) {
			result = root.val;
			return result;
		}

		System.out.println("hahaha1");

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		preOrder(root, false, arrayList);
		for (Integer x : arrayList) {
			result += x;
		}

		System.out.println("hahaha2");

		return result;
	}

	public static void preOrder(TreeNode root, boolean left, ArrayList<Integer> arrayList) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			System.out.println("hahaha3 " + root.val);

			if (left) {
				arrayList.add(root.val);
			}
		} else {
			preOrder(root.left, true, arrayList);
			preOrder(root.right, false, arrayList);
		}
	}

}
