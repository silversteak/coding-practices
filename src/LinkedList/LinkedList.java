package LinkedList;

import java.util.Stack;

public class LinkedList {

	// Stack<Integer> stk = null;

	Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/*
	 * void printMiddle() { Node slow_ptr = head; Node fast_ptr = head; if (head !=
	 * null) { while (fast_ptr != null && fast_ptr.next != null) { fast_ptr =
	 * fast_ptr.next.next; slow_ptr = slow_ptr.next; }
	 * System.out.println("The middle element is [" + slow_ptr.data + "] \n"); } }
	 */

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public void insert(int new_data) {
		Node new_node = new Node(new_data);

		if (head == null) {
			head = new_node;
			return;
		}
		
		Node tnode = head;

		while (tnode.next != null) {
			tnode = tnode.next;
		}
		
		tnode.next = new_node;
		return;

	}

	/*
	 * This function prints contents of linked list starting from the given node
	 */
	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + ">>>");
			tnode = tnode.next;
		}
		System.out.println("NULL");
	}

	void manipulate() {
		Stack<Integer> stk = new Stack<Integer>();
		Node tnode = head;
		int count = 0, i = 1;
		while (tnode != null) {
			stk.push(tnode.data);
			tnode = tnode.next;
			count++;
		}

		tnode = head;
		int mid = (count / 2);

		while (tnode != null && i++ <= mid) {
			tnode.data -= stk.pop();
			tnode = tnode.next;
		}
	}

	public static void main(String[] args) {
		LinkedList linkList = new LinkedList();

		// linkList.push(2);
		// linkList.push(5);
		// linkList.printList();
		// System.out.println("-------------");
		// linkList.push(7);
		// linkList.push(8);
		linkList.insert(2);
		linkList.insert(1);
		linkList.insert(8);
		linkList.printList();
		linkList.push(3);
		linkList.printList();
		linkList.insert(2);
		linkList.insert(4);
		linkList.printList();
		linkList.push(1);
		linkList.printList();

		//System.out.println("______________");
		//linkList.printList();
		linkList.manipulate();
		linkList.printList();

	}

}
