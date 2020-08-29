package com.my.practise.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 也是看下 层序 遍历的思路就可以了

public class LevelOrderBottom {

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
		TreeNode treeNode = createTree();
		List<List<Integer>> resultList = levelOrderBottom(treeNode);
		System.out.println("size: " + resultList.size());

		for (int i = 0; i < resultList.size(); i++) {
			List<Integer> arrayList = resultList.get(i);
			for (int j = 0; j < arrayList.size(); j++) {
				System.out.print(" " + arrayList.get(j));
			}
			System.out.println();
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

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List resultList = new ArrayList<List<Integer>>();
		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();

		if (root == null) {
			return resultList;
		}

		linkedList.add(root);

		while (!linkedList.isEmpty()) {
			int size = linkedList.size();

			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = linkedList.pollFirst();
				arrayList.add(node.val);

				if (node.left != null) {
					linkedList.add(node.left);
				}

				if (node.right != null) {
					linkedList.add(node.right);
				}
			}

			if (arrayList.size() != 0) {
				resultList.add(0, arrayList);
			}
		}

		return resultList;
	}

}
