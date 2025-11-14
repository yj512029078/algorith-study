package com.design.code.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RightSideView {

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
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(4);

		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.right = node5;

		List<Integer> resultList = rightSideView(node1);
		System.out.println(resultList);
	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> finalList = new ArrayList<Integer>();

		List<List<Integer>> resultList = tranverseTreeLevel(root);
		if (resultList == null) {
			return finalList;
		}

		for (int i = 0; i < resultList.size(); i++) {
			List<Integer> levelList = resultList.get(i);
			if (levelList.size() > 0) {
				finalList.add(levelList.get(levelList.size() - 1));
			}
		}

		return finalList;
	}

	private static List<List<Integer>> tranverseTreeLevel(TreeNode root) {
		if (root == null) {
			return null;
		}

		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<RightSideView.TreeNode>();
		arrayDeque.add(root);

		int level = 0;
		while (!arrayDeque.isEmpty()) {
			// 注意在哪里计算level
			level++;
			ArrayList<Integer> arrayList = new ArrayList<Integer>();

			// ✅ 关键：先保存当前层的节点数
			int size = arrayDeque.size();

			// 这个size 不能动态计算
			for (int i = 0; i < size; i++) {
				TreeNode node = arrayDeque.poll();
				arrayList.add(node.val);

				System.out.print("node:" + node.val + ",level:" + level + " -> ");

				if (node.left != null) {
					arrayDeque.add(node.left);
				}

				if (node.right != null) {
					arrayDeque.add(node.right);
				}
			}

			resultList.add(arrayList);
		}

		return resultList;
	}

}
