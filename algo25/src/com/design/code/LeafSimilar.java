package com.design.code;

import java.util.ArrayList;
import java.util.Collections;

public class LeafSimilar {

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
		TreeNode node11 = new TreeNode(1);
		TreeNode node12 = new TreeNode(2);
		TreeNode node13 = new TreeNode(3);
		node11.left = node12;
		node11.right = node13;

		TreeNode node21 = new TreeNode(1);
		TreeNode node22 = new TreeNode(3);
		TreeNode node23 = new TreeNode(2);
		node21.left = node22;
		node21.right = node23;

		boolean result = leafSimilar(node11, node21);
		System.out.println(result);
	}

	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		ArrayList<TreeNode> arrayList1 = new ArrayList<TreeNode>();
		tranverseTree(root1, arrayList1);
		for (int k = 0; k < arrayList1.size(); k++) {
			System.out.print(arrayList1.get(k).val + "->");
		}
		System.out.println();

		ArrayList<TreeNode> arrayList2 = new ArrayList<TreeNode>();
		tranverseTree(root2, arrayList2);
		for (int k = 0; k < arrayList2.size(); k++) {
			System.out.print(arrayList2.get(k).val + "->");
		}
		System.out.println();

		if (arrayList1.size() != arrayList2.size()) {
			System.out.println("size not match");
			return false;
		}

		for (int i = 0; i < arrayList1.size(); i++) {
			if (arrayList1.get(i).val != arrayList2.get(i).val) {
				System.out.println("data not match");
				return false;
			}
		}

		return true;
	}

	private static void tranverseTree(TreeNode node, ArrayList<TreeNode> arrayList) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			arrayList.add(node);
		}

		tranverseTree(node.left, arrayList);
		tranverseTree(node.right, arrayList);
	}

	// 这个思路有比较大的问题，叶子节点匹配不等于结构完全匹配；虽然你只判断了leaf val 相等，但是仍然依赖结构匹配
	public static boolean leafSimilar2(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		// 核心比如这里的判断，root1 null，root2 != null，不一定代表就不匹配
		if (root1 == null && root2 != null) {
			return false;
		}
		if (root2 == null && root1 != null) {
			return false;
		}

		if (root1.left == null && root1.right == null) {
			if (root2.left == null && root2.right == null && root1.val == root2.val) {
				return true;
			} else {
				return false;
			}
		}

		boolean result = leafSimilar2(root1.left, root2.left);
		if (result) {
			result = leafSimilar2(root1.right, root2.right);
		}

		return result;
	}

}
