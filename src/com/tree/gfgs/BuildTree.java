package com.tree.gfgs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BuildTree {
	
	static Map<Integer, Integer> hash = new HashMap<>();
	static int prefix = 0;
	
	static public class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
    public static Node buildTree(int[] preorder, int[] inorder) {
	        preprocess(inorder);
	        return buildTree(preorder, inorder, 0, preorder.length-1);
	    }

	private static Node buildTree(int[] preorder, int[] inorder, int is, int ie) {
		
		//Breaking condition // When the index overlap it will return null
		// This is used during the leaves and other terminating condition
		if(is > ie) return null;
		
		//Create the Node
		
		Node temp = new Node(preorder[prefix++]);
		
		//Get the index
		
		int index = hash.get(temp.data);
		
		temp.left = buildTree(preorder, inorder, is, index - 1);
		temp.right = buildTree(preorder, inorder, index + 1, ie);
				
		//Call the left and right
		
		return temp;
	}

	private static void preprocess(int[] inorder) {
		for(int i = 0; i < inorder.length; i++) {
			hash.put(inorder[i], i);
		}
	}
	
	public static int postOrder(Node root,int postOrder[], int index) {
		if (root == null)
			return index;
		index = postOrder(root.left, postOrder, index);
		index = postOrder(root.right, postOrder, index);
		
		if(root.data == postOrder[index])
			index++;
		else
			return -1;
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int inOrder[] = {4, 2, 5, 1, 3};  
	    int preOrder[] = {1, 2, 4, 5, 3};
	    int postOrder[] = {4, 5, 2, 3, 1}; 
	    Node root = buildTree(preOrder, inOrder);
	   
	    int index = postOrder(root, postOrder, 0);
		
	    if(index == inOrder.length)
	    	System.out.println("YESSSSS");
	    else
	    	System.out.println("NOOOOOOOO");
	    
	    Stack<Character> stak = new Stack<>();
		
	    stak.add('a');
	    
	}

}
