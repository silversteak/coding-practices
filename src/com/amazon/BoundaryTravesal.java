package com.amazon;

public class BoundaryTravesal {

	static class Node{
		int val;
		Node left;
		Node right;
		Node(int val){
			this.val = val;
		}
	}
	
	static void boundaryTraversal(Node root) {
		
		leftBoundary(root);
		printLeaves(root);
		rightBoundary(root.right);
		
	}
	
	private static void rightBoundary(Node root) {
		if(root!=null) {		
			if(root.right != null) {
				rightBoundary(root.right);
				System.out.print(root.val + " ");
			}
			else if(root.left != null) {
				rightBoundary(root.left);
				System.out.print(root.val + " ");
			}
			
		}
		
	}

	private static void printLeaves(Node root) {
		if(root != null) {
			printLeaves(root.left);
			
			if(root.left == null && root.right == null) {
				System.out.print(root.val + " ");
			}
			
			printLeaves(root.right);
		}
	}

	private static void leftBoundary(Node root) {
		if(root!=null) {		
			if(root.left != null) {
				System.out.print(root.val + " ");
				leftBoundary(root.left);
			}
			else if(root.right != null) {
				System.out.print(root.val + " ");
				leftBoundary(root.right);
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node (2);
		root.right = new Node(3);
		root.right.left = new Node(9);
		root.right.right = new Node(10);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.left.right = new Node(7);
		root.left.right.left.right.left = new Node(8);
		
		boundaryTraversal(root);

	}

}
