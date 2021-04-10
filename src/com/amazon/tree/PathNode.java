package com.amazon.tree;

public class PathNode {

	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
		}
	}

	// Find the LCA and then get the path distance

	public static Node LCA(Node root, Node node1, Node node2) {
		//case 1 when the root node is null
		if(root == null) {
			return null;
		}
		//case 2 when the node1 or node2 is found
		if(root == node1 || root == node2) {
			return root;
		}

		Node LCALeft = LCA(root.left, node1, node2);
		Node LCARight = LCA(root.right, node1, node2);

		if(LCALeft != null && LCARight != null) {
			return root;
		}

		if(LCALeft != null) {
			return LCALeft;
		}

		if(LCARight != null) {
			return LCARight;
		}

		return null;
	}

	public static int PathNodeDistanceHelper(Node root, Node left, Node right) {

		Node LCANode = LCA(root, left, right);
		if(LCANode != null) {
			int leftDist = findLevel(LCANode, left, 0);
			int rightDist = findLevel(LCANode, right, 0);
			return leftDist + rightDist;
		}
		return Integer.MIN_VALUE;
	}


	private static int findLevel(Node lCANode, Node node, int i) {
		if(node == null)
			return -1;
		if(node == lCANode) {
			return i;
		}
		
		int level = findLevel(lCANode, node.left, i+1);
		if(level != -1)
			return level;
		return findLevel(lCANode, node.right, i+1);
	}

	public static void main(String[] args) {



	}

}
