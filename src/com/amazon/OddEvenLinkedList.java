package com.amazon;

public class OddEvenLinkedList {

	static class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
		}
	}
	
	public static Node oddEven(Node head) {
		
		Node odd = head;
		Node even = head.next;
		
		Node evenHead = even;
		
		while(even != null && even.next != null) {
			
			odd.next = even.next;
			odd = odd.next;
			
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		
		return head;
	}
	
	public static void print(Node root) {
		while(root!=null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
		
	}
	
	
	public static void main(String[] args) {

		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		root.next.next.next.next.next.next = new Node(7);
		
		print(root);
		
		Node head = oddEven(root);
		System.out.println();
		print(head);
		
		
		
		
	}

}
