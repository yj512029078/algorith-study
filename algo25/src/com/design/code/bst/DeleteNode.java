package com.design.code.bst;

public class DeleteNode {

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
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;

		int key = 3;
		TreeNode resultNode = deleteNode(node1, key);
		printTree(resultNode);

		TreeNode node21 = null;
		resultNode = deleteNode(node21, key);
		printTree(resultNode);
	}

	private static void printTree(TreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.val + " -> ");
		printTree(node.left);
		printTree(node.right);
	}

	public static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}

		// 如果是删除root 节点，单独处理
		if (root.val == key) {
			if (root.right != null) {
				TreeNode smalleTreeNode = findSmalletNode(root.right);
				smalleTreeNode.left = root.left;
				return root.right;
			} else {
				return root.left;
			}
		}

		if (root.val > key) {
			tranverseDeleteNode(root.left, key, root);
		} else {
			tranverseDeleteNode(root.right, key, root);
		}
		return root;
	}

	public static void tranverseDeleteNode(TreeNode node, int key, TreeNode parent) {
		if (node == null) {
			return;
		}

		// 这段逻辑其实是删除节点的核心
		// 不是简单的找到node 删除，还需要把 node 的left right 节点合理的接上去
		// 具体是接入parent left 还是 right，就和BST tree 特性有关
		// 需要要考虑到特定node 的 right 是不是空的，如果是要额外处理
		if (node.val == key) {
			if (parent.val > key) {
				if (node.right != null) {
					parent.left = node.right;

					TreeNode smalleTreeNode = findSmalletNode(node.right);
					smalleTreeNode.left = node.left;
				} else {
					parent.left = node.left;
				}
			} else {
				if (node.right != null) {
					parent.right = node.right;

					TreeNode smalleTreeNode = findSmalletNode(node.right);
					smalleTreeNode.left = node.left;
				} else {
					// 这里别写错了，应该是right
					parent.right = node.left;
				}
			}
		}

		if (node.val > key) {
			tranverseDeleteNode(node.left, key, node);
		} else {
			tranverseDeleteNode(node.right, key, node);
		}
	}

	private static TreeNode findSmalletNode(TreeNode node) {
		if (node == null) {
			return node;
		}

		TreeNode tempNode = node;
		while (tempNode != null) {
			if (tempNode.left == null) {
				return tempNode;
			}

			tempNode = tempNode.left;
		}

		return null;
	}

}
