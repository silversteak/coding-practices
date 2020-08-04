package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheBackToSWE {

	class Node{
		int val;
		int key;
		Node prev;
		Node next;
		public Node() {}
		public Node(int val, int key) {
			this.val = val;
			this.key = key;
			this.prev = null;
			this.next = null;
		}
	}

	Map<Integer, Node> hashtable = new HashMap<>();
	Node head;
	Node tail;

	int totalItemsInCache;
	int capacity;

	public LRUCacheBackToSWE(int capacity) {
		// Create an instance of LRUCache 
		totalItemsInCache = 0;
		this.capacity = capacity;
		head = new Node();
		tail = new Node();

		head.next = tail;
		tail.prev = head;


	}

	public Integer get(int key) {
		Node node = hashtable.get(key);

		if (node == null) {
			return null;
		}

		// Item has been accessed. Move to the front of the cache
		moveToHead(node);

		return node.val;
	}

	public void put(int key, int value) {
		Node node = hashtable.get(key);

		//Item not found
		if(node == null) {
			Node newNode = new Node(key, value);

			//Enter into hashtable
			hashtable.put(key, newNode);
			//It has to move the node to the first
			addToFront(newNode);
			totalItemsInCache++;

			//Cache overflow
			if(totalItemsInCache > capacity) {
				// Least used entry or the last node
				removeLRUentry();
			}
		}else {
			node.val = value;
			//move head to tthe first
			moveToHead(node);
		}

	}


	private void moveToHead(Node node) {
		removeFromList(node);
		addToFront(node);

	}

	private void removeLRUentry() {
		Node tail = popTail();

		hashtable.remove(tail.key);
		--totalItemsInCache;
	}

	private Node popTail() {
		Node tailItem = tail.prev;
		removeFromList(tailItem);
		return tailItem;
	}

	private void removeFromList(Node node){
		Node savedPrev = node.prev;
		Node savedNext = node.next;

		savedPrev.next = savedNext;
		savedNext.prev = savedPrev;

	}
	private void addToFront(Node node) {
		node.prev = head;
		node.next = head.next;

		//head ---> head.next ----> head.next.next;
		// 	
		head.next.prev = node;
		head.next = node;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

}
