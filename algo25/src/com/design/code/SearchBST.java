package com.design.code;

public class SearchBST {

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
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		TreeNode node = searchBST(node1, 2);
		printTree(node);
	}
	
	private static void printTree(TreeNode node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.val + "->");
		printTree(node.left);
		printTree(node.right);
	}

	public static TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}

		if (root.val == val) {
			return root;
		}

		TreeNode node = null;
		if (root.val < val) {
			node = searchBST(root.right, val);
		} else {
			node = searchBST(root.left, val);
		}

		return node;
	}

}
