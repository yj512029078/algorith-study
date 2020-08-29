package com.my.practise.tree;

// 反正和求最大的做法也不太一样
// 这个写法短期也记不住：递归
// 其它方案：层顺遍历，找到最小的 高度
// 先序遍历，找到所有叶子节点的最小高度

public class MinDepth {

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
		int height = minDepth(treeNode);
		System.out.print("height: " + height);
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

	static int minDepth = 0;

	/**
	 * 需要仔细思考，为什么求最大和最小，思路是不同的；差别到底在哪里
	 * 
	 * @param root
	 * @return
	 */
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		int minDepth = Integer.MAX_VALUE;

		if (root.left != null) {
			minDepth = Math.min(minDepth(root.left), minDepth);
		}

		if (root.right != null) {
			minDepth = Math.min(minDepth(root.right), minDepth);
		}

		minDepth = minDepth + 1;
		return minDepth;
	}

}
