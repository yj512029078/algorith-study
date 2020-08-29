package com.my.practise.tree;

import java.util.ArrayList;

// 这道题挺重要的，需要仔细看下
// 核心思想就是普通的先序遍历，碰到叶子节点，则这一条路径终止

//为什么用pathpath从4回去后不是1->2->3了，而是又变回1->2呢？
//答：因为path不是引用类型，递归3执行的只是值传递，节点2只是把1->2传给了节点3，节点3对path的修改不会影响到节点2的path。

public class BinaryTreePath {

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
		TreeNode node = createTree();

		ArrayList<String> arrayList = new ArrayList<String>();
		// preOrder(node, arrayList);

		binaryTreePaths(node, "", arrayList);
		for (String string : arrayList) {
			System.out.println(string);
		}
	}

	public static TreeNode createTree() {
		TreeNode root = new TreeNode(1);

		TreeNode level2L = new TreeNode(2);
		root.left = level2L;

		TreeNode level2R = new TreeNode(3);
		root.right = level2R;

		TreeNode level3R = new TreeNode(5);
		level2L.right = level3R;
		return root;
	}

	/**
	 * 输出所有 tree path
	 * 
	 * @param root
	 * @param path
	 */
	public static void binaryTreePaths(TreeNode root, String path, ArrayList<String> arrayList) {
		if (root == null) {
			return;
		}

		path += root.val;
		// 只有叶子节点才打印路径
		if (root.left == null && root.right == null) {
			System.out.println("path: " + path);
			arrayList.add(path);
		} else {
			binaryTreePaths(root.left, path + "->", arrayList);
			binaryTreePaths(root.right, path + "->", arrayList);
		}
	}

	/**
	 * 先序遍历，arraylist 会拿到所有路径上的节点
	 * 
	 * @param root
	 * @param arrayList
	 */
	public static void preOrder(TreeNode root, ArrayList<Integer> arrayList) {
		if (root == null) {
			return;
		}

		arrayList.add(root.val);
		preOrder(root.left, arrayList);
		preOrder(root.right, arrayList);
	}

}
