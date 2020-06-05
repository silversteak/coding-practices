package com.amazon;

public class ISBST {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static boolean isValidUtil(TreeNode root, long min, long max){

		if(root == null)
			return true;

		if(root.val <= min || root.val >= max)
			return false;

		return isValidUtil(root.left, min, root.val) && isValidUtil(root.right, root.val, max); 

	}

	public static boolean isValidBST(TreeNode root) {
		return isValidUtil(root, Long.MIN_VALUE,Long.MAX_VALUE); 
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
