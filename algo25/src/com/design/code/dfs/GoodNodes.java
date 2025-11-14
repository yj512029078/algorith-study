package com.design.code.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class GoodNodes {

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
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;

		int result = goodNodes2(node1);
		System.out.println(result);

		TreeNode node11 = new TreeNode(3);
		TreeNode node12 = new TreeNode(3);
		TreeNode node13 = new TreeNode(4);
		TreeNode node14 = new TreeNode(2);
		node11.left = node12;
		node12.left = node13;
		node12.right = node14;

		result = goodNodes2(node11);
		System.out.println(result);
	}

	public static int goodNodes2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int count = dfs(root, root.val);
		return count;
	}

	// 这个思路很巧，理解下
	public static int dfs(TreeNode root, int currentMaxValue) {
		if (root == null) {
			return 0;
		}

		int count = 0;
		if (root.val >= currentMaxValue) {
			count = 1;
		}

		if (root.left != null) {
			int leftMaxValue = Math.max(root.left.val, currentMaxValue);
			count += dfs(root.left, leftMaxValue);
		}

		if (root.right != null) {
			int rightMaxValue = Math.max(root.right.val, currentMaxValue);
			count += dfs(root.right, rightMaxValue);
		}

		return count;
	}

	// 要注意路径path 的回溯，否则 arraylist 就不对了
	// 另外每个node 记录arraylist path，空间占用太多了
	public static int goodNodes(TreeNode root) {
		ArrayList<TreeNode> arrayList = new ArrayList<GoodNodes.TreeNode>();
		HashMap<TreeNode, ArrayList<TreeNode>> hashMap = new HashMap<GoodNodes.TreeNode, ArrayList<TreeNode>>();

		tranverseTree(root, arrayList, hashMap);

		int count = 0;
		Iterator<Entry<TreeNode, ArrayList<TreeNode>>> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<TreeNode, ArrayList<TreeNode>> entry = iterator.next();
			ArrayList<TreeNode> tempList = entry.getValue();
			if (isIncrementPath(tempList)) {
				count++;
			}
		}

		return count;
	}

	private static void tranverseTree(TreeNode root, ArrayList<TreeNode> arrayList,
			HashMap<TreeNode, ArrayList<TreeNode>> hashMap) {
		if (root == null) {
			return;
		}

		arrayList.add(root);
		hashMap.put(root, new ArrayList<GoodNodes.TreeNode>(arrayList));

		tranverseTree(root.left, arrayList, hashMap);
		tranverseTree(root.right, arrayList, hashMap);

		// 计算节点路径，是一定要做回溯的；否则你的路径算多了
		arrayList.remove(arrayList.size() - 1);
	}

	private static boolean isIncrementPath(ArrayList<TreeNode> arrayList) {
		if (arrayList == null || arrayList.size() == 0) {
			return false;
		}

		int maxValue = arrayList.get(arrayList.size() - 1).val;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).val > maxValue) {
				return false;
			}
		}

		return true;
	}

}
