package com.freecodecamp;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;

	private class Node<T> {
		T data;
		Node<T> prev, next;

		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}

	public void clear() {
		Node<T> trav = head;
		while (trav != null) {
			Node<T> next = trav.next;
			trav.prev = trav.next = null;
			trav.data = null;
			trav = next;
		}
		head = tail = trav = null;
		size = 0;
	}

	// Return the size of this linked list
	public int size() {
		return size;
	}

	// Is this linked list empty?
	public boolean isEmpty() {
		return size() == 0;
	}

	// Add an element to the tail of the linked list, O(1)
	public void add(T elem) {
		addLast(elem);
	}

	// Add a node to the tail of the linked list, O(1)
	public void addLast(T elem) {

		// The linked list is empty
		if (isEmpty()) {
			head = tail = new Node<T>(elem, null, null);
		} else {
			tail.next = new Node<T>(elem, tail, null);
			tail = tail.next;
		}
		size++;
	}

	// Add an element to the beginning of this linked list, O(1)
	public void addFirst(T elem) {

		// The linked list is empty
		if (isEmpty()) {
			head = tail = new Node<T>(elem, null, null);
		} else {
			head.prev = new Node<T>(elem, null, head);
			head = head.prev;
		}

		size++;
	}

	// Check the value of the first node if it exists, O(1)
	public T peekFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty list");
		return head.data;
	}

	// Check the value of the last node if it exists, O(1)
	public T peekLast() {
		if (isEmpty())
			throw new RuntimeException("Empty list");
		return tail.data;
	}

	// Remove the first value at the head of the linked list, O(1)
	public T removeFirst() {

		// Can't remove data from an empty list -_-
		if (isEmpty())
			throw new RuntimeException("Empty list");

		// Extract the data at the head and move
		// the head pointer forwards one node
		T data = head.data;
		head = head.next;
		--size;

		// If the list is empty set the tail to null
		if (isEmpty())
			tail = null;

		// Do a memory cleanup of the previous node
		else
			head.prev = null;

		// Return the data that was at the first node we just removed
		return data;
	}

	// Remove the last value at the tail of the linked list, O(1)
	public T removeLast() {

		// Can't remove data from an empty list -_-
		if (isEmpty())
			throw new RuntimeException("Empty list");

		// Extract the data at the tail and move
		// the tail pointer backwards one node
		T data = tail.data;
		tail = tail.prev;
		--size;

		// If the list is now empty set the head to null
		if (isEmpty())
			head = null;

		// Do a memory clean of the node that was just removed
		else
			tail.next = null;

		// Return the data that was in the last node we just removed
		return data;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
