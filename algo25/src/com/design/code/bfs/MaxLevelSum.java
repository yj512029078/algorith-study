package com.design.code.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MaxLevelSum {

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
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(0);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(-8);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		int result = maxLevelSum(node1);
		System.out.println(result);
	}

	public static int maxLevelSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		List<List<Integer>> multiList = tranverseTreeLevel(root);
		if (multiList.size() > 0) {
			for (int i = 0; i < multiList.size(); i++) {
				int result = 0;
				List<Integer> maxLevelList = multiList.get(i);
				if (maxLevelList.size() > 0) {
					for (int j = 0; j < maxLevelList.size(); j++) {
						result += maxLevelList.get(j);
					}
				}
				
				System.out.println(result);
				arrayList.add(i, result);
			}
		}

		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i) > maxValue) {
				maxValue = arrayList.get(i);
			}
		}

		System.out.println(maxValue);
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i) == maxValue) {
				return i + 1;
			}
		}
		return 0;
	}

	private static List<List<Integer>> tranverseTreeLevel(TreeNode root) {
		if (root == null) {
			return null;
		}

		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<TreeNode>();
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

//				System.out.print("node:" + node.val + ",level:" + level + " -> ");

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
