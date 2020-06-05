package com.amazon;

import java.util.Stack;

public class ReverseInKGroups {
	
	static class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
		}
	}
	
	public static Node reverse(Node root, int k) {
		
		Node curr = root;
		Node prev = null;
		Node next = null;
		int count = 0;
		
		while(curr != null && count < k) {
			
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(next != null) {
			root.next = reverse(next, k);
		}
		
		return prev;
		
	}
	
	//Using stacks
	
	public static Node reverseStack(Node root, int k) {
		
		Node curr = root;
		Node prev = null;
		
	    Stack<Node> mystack = new Stack<Node> ();  
		
		while(curr != null) {
			
			int count = 0;
			
			while(curr != null && count < k) {
				mystack.push(curr);
				curr = curr.next;
				count++;
			}
			
			while(!mystack.isEmpty()) {
				
				if(prev == null) {
					prev = mystack.pop();
					root = prev;
				}else {
					prev.next = mystack.pop();
					prev = prev.next;
				}
				
			}
			prev.next = null;			
		}
		return root;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
