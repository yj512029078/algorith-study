package com.design.code.dfs;


public class LowestCommonAncestor {
	
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

	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case 1: 空节点
        if (root == null) {
            return null;
        }
        
        // Base case 2: 找到 p 或 q
        if (root == p || root == q) {
            return root;
        }
        
        // 递归左右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // 情况1: p 和 q 分别在左右子树
        if (left != null && right != null) {
            return root;
        }
        
        // 情况2: p 和 q 都在左子树
        if (left != null) {
            return left;
        }
        
        // 情况3: p 和 q 都在右子树
        return right;
    }

}
