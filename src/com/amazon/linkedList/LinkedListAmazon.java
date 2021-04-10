package com.amazon.linkedList;

import java.util.Stack;

public class LinkedListAmazon {

	static class Node {
		int data;
		Node next;
		Node(int d)  { data = d;  next = null; }
	}

	/**
	 * Here two pointers are used to track the end position.
	 * 
	 *  slow = slow.next
	 *  fast = fast.next.next
	 * 
	 * @param head
	 * @return
	 */

	public static int getMiddle(Node head)
	{
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public static Node deleteMid(Node head) {
		// This is method only submission.
		// You only need to complete the method.
		if(head == null || head.next == null){
			return null;
		}

		Node fast = head, slow = head, prev = null;

		while(fast != null && fast.next != null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = slow.next;

		return head;
	}


	/**
	 * 
	 * @param head1
	 * @param key
	 * @return
	 */

	public static Node sortedInsert(Node head1, int key) {
		// Add your code here.
		// If the head is null or it has just one node
		if(head1 == null || head1.data > key){
			Node temp = new Node(key);
			temp.next = head1;
			head1 = temp;
			return head1;
		}

		Node temp = head1;

		while(temp.next != null && temp.next.data < key){
			temp = temp.next;
		}

		Node newNode = new Node(key);
		newNode.next = temp.next;
		temp.next = newNode;

		return head1;
	}

	/**
	 * 
	 * @param head
	 * @return
	 */

	Node reverseList(Node head)
	{
		/*
		 * three  reference variable to track the prev , curr and next
		 * */

		Node curr = head, prev = null, next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;

		return head;
	}

	Node reverseUtil(Node curr, Node prev, Node head) 
	{ 

		/* If last node mark it head*/
		if (curr.next == null) { 
			head = curr; 

			/* Update next to prev node */
			curr.next = prev; 

			return head; 
		} 

		/* Save curr->next node for recursive call */
		Node next1 = curr.next; 

		/* and update next ..*/
		curr.next = prev; 

		reverseUtil(next1, curr, head); 
		return head; 
	} 


	/**
	 * rotate the list by k nodes
	 * @param head
	 * @param k
	 * @return
	 */
	public Node rotate(Node head, int k) {
		// add code here.
		Node temp = head;
		for(int i = 1 ; i < k && (temp != null); i++){
			temp = temp.next;
		}

		if(temp == null)
			return head;

		Node ptr = temp;

		while(temp.next != null){
			temp = temp.next;
		}

		temp.next = head;
		head = ptr.next;
		ptr.next = null;

		return head;
	}

	/**
	 * 
	 * @param head
	 * @return
	 */

	static Node segregate(Node head)
	{
		// base case
		if (head == null || head.next == null) {
			return head;
		}

		// maintain three dummy nodes
		Node first = new Node(0), second = new Node(0), third = new Node(0);

		// maintain three references
		Node zero = first, one = second, two = third;

		// traverse the list
		Node curr = head;
		while (curr != null)
		{
			if (curr.data == 0)
			{
				zero.next = curr;
				zero = zero.next;
			}
			else if (curr.data == 1)
			{
				one.next = curr;
				one = one.next;
			}
			else
			{
				two.next = curr;
				two = two.next;
			}
			curr = curr.next;
		}

		// combine lists containing 0's, 1's and 2's
		zero.next = (second.next != null)? (second.next): (third.next);
		one.next = third.next;
		two.next = null;

		// change head
		return first.next;
	}

	/**
	 * 
	 * @param node
	 * @return
	 */

	public Node pairwiseSwap(Node node)
	{
		if (node == null || node.next == null) { 
			return node; 
		} 

		// Initialize previous and current pointers 
		Node first = node; 
		//Node second = node.next; 

		node = first.next; // Change head before proceeeding 

		// Traverse the list 
		while (true) { 
			Node second = first.next;
			Node temp = second.next; 

			second.next = first; // Change next of current as previous node 

			// If next NULL or next is the last node 
			if (temp == null || temp.next == null) { 
				first.next = temp; 
				break; 
			} 

			// Change next of previous to next next 
			first.next = temp.next; 

			// Update previous and curr 
			first = temp;
		} 
		return node; 

		/*Node temp = head; 

	        Traverse only till there are atleast 2 nodes left
	        while (temp != null && temp.next != null) { 

	            int k = temp.data; 
	            temp.data = temp.next.data; 
	            temp.next.data = k; 
	            temp = temp.next.next; 
	        }

	        return head;
		 */

		/*Node dummyNode = new Node(0);
	        dummyNode.next = head;
	        Node temp = dummyNode;

	        while(temp.next != null && temp.next.next != null){
	            Node first = temp.next;
	            Node second = temp.next.next;

	            // set temp to seconf node
	            temp.next = second;
	            //set first node to point to the next of second node
	            first.next = second.next;
	            // connect second node to first node
	            second.next = first;
	            //point temp to the first node for the next iterartion
	            temp = first;

	        }

	        return dummyNode.next;*/

	}

	/**
	 * it is the utility fuction for adding one to the linked list
	 * @param head
	 * @return
	 */

	public static int addOneUtil(Node head){

		if(head == null)
			return 1;

		int res = head.data + addOneUtil(head.next);

		head.data = res % 10;
		return res/10;

	}

	public static Node addOne(Node head) 
	{ 
		int carry = addOneUtil(head);

		if(carry > 0){
			Node temp = new Node(carry);
			temp.next = head;
			head = temp;
		}

		return head;
	}

	/**
	 * Use of stack to get the darta
	 * @param first
	 * @param second
	 * @return
	 */
	static Node addLists(Node first, Node second){
		Stack<Integer> stk1 = new Stack<>();
		Stack<Integer> stk2 = new Stack<>();

		while(first != null) {
			stk1.add(first.data);
			first = first.next;
		}

		while(second != null) {
			stk2.add(second.data);
			second = second.next;
		}

		int sum = 0;

		Node head = null;
		while(!stk1.isEmpty() || !stk2.isEmpty()) {
			if(!stk1.isEmpty()) sum += stk1.pop(); 
			if(!stk2.isEmpty()) sum += stk2.pop();
			Node temp = new Node(sum%10);
			temp.next = head;
			head = temp;
			sum = sum/10;
		}
		if(sum > 0){
			Node temp = new Node(sum%10);
			temp.next = head;
			head = temp;
		}

		return head;
	}

	/**
	 * 
	 * @param head
	 * @return
	 */
	static Node rearrangeEvenOdd(Node head)
	{
		if(head == null)
			return null;

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

	static void zigZagList(Node head) 
	{ 
		// If flag is true, then 
		// next node should be greater 
		// in the desired output. 
		boolean flag = true; 

		int temp = 0;
		
		// Traverse linked list starting from head. 
		Node current = head; 
		while (current != null && current.next != null) { 
			if (flag == true) /* "<" relation expected */
			{ 
				/* If we have a situation like A > B > C  
	            where A, B and C are consecutive Nodes  
	            in list we get A > B < C by swapping B  
	            and C */
				if (current.data > current.next.data) { 
					temp = current.data; 
					current.data = current.next.data; 
					current.next.data = temp; 
				} 
			} 
			else /* ">" relation expected */
			{ 
				/* If we have a situation like A < B < C where  
	            A, B and C are consecutive Nodes in list we  
	            get A < C > B by swapping B and C */
				if (current.data < current.next.data) { 
					temp = current.data; 
					current.data = current.next.data; 
					current.next.data = temp; 
				} 
			} 

			current = current.next; 

			/* flip flag for reverse checking */
			flag = !(flag); 
		} 
	} 

	/**
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	int getNthFromLast(Node head, int n)
	{
		Node fast_ptr = head, slow_ptr = head;
		int count = 0;
		if(head != null){
			while(count < n){
				if(fast_ptr == null)
					return -1;
				fast_ptr = fast_ptr.next;    
				count++;
			}

			while(fast_ptr != null){
				slow_ptr = slow_ptr.next;
				fast_ptr = fast_ptr.next;
			}

		}
		return slow_ptr.data;
	}

	static Node sortedMerge(Node a, Node b) { 
		Node result = null; 
		/* Base cases */
		if (a == null) 
			return b; 
		if (b == null) 
			return a; 

		/* Pick either a or b, and recur */
		if (a.data <= b.data) { 
			result = a; 
			result.next = sortedMerge(a.next, b); 
		} 
		else { 
			result = b; 
			result.next = sortedMerge(a, b.next); 
		} 
		return result; 
	}

	public static Node findIntersection(Node head1, Node head2){
		Node result = null;

		if(head1 == null || head2 == null)
			return null;

		if(head1.data == head2.data) {
			result = new Node(head1.data);
			result.next = findIntersection(head1.next, head2.next);
		}else if(head1.data < head2.data){
			return findIntersection(head1.next, head2);
		}else {
			return findIntersection(head1, head2.next);
		}

		return result;
	}

	static Node mergeSort(Node h) { 
		// Base case : if head is null 
		if (h == null || h.next == null) { 
			return h; 
		} 

		// get the middle of the list 
		Node middle = getMiddleHelper(h); 
		Node nextofmiddle = middle.next; 

		// set the next of middle node to null 
		middle.next = null; 

		// Apply mergeSort on left list 
		Node left = mergeSort(h); 

		// Apply mergeSort on right list 
		Node right = mergeSort(nextofmiddle); 

		// Merge the left and right lists 
		Node sortedlist = sortedMerge(left, right); 
		return sortedlist; 
	} 

	// Utility function to get the middle of the linked list 
	public static Node getMiddleHelper(Node head) { 
		if (head == null) 
			return head; 

		Node slow = head, fast = head; 

		while (fast.next != null && fast.next.next != null) { 
			slow = slow.next; 
			fast = fast.next.next; 
		} 
		return slow; 
	} 



	public static void removeLoop(Node head){
		// code here
		// remove the loop without losing any nodes
		Node slow = head;
		Node fast = head;
		// boolean to check if there a loop exists in the given Linked List.
		boolean flag = false;
		// Traverse the list until fast or fast.next becomes null.
		while (fast != null && fast.next != null) {
			// Move forward slow by one node.
			slow = slow.next;
			// Move forward fast by two nodes.
			fast = fast.next.next;
			// Check if slow and fast meet at some node, then there is a loop in the Linked
			// List and So make flag true and break.
			if (slow == fast) {
				flag = true;
				break;
			}
		}
		// When there is a loop in the Linked List.
		if (flag) {
			// Assign head to slow.
			slow = head;
			// Loop until next of slow and fast are not equal.
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}

			Node prev = fast;
			fast = fast.next;
			while(fast != slow){
				prev = fast;
				fast = fast.next;
			}

			// Make next of fast that is last node of Linked List NULL.
			prev.next = null;
		}

	}

}
