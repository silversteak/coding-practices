package com.leetcode;
/*
LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

// capacity 2 
LRUCache cache = new LRUCache( 2 );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

 */
/*
https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU
Discards the least recently used items first. This algorithm requires keeping track of what was used when, which is expensive if one wants to make sure the algorithm always discards the least recently used item. General implementations of this technique require keeping "age bits" for cache-lines and track the "Least Recently Used" cache-line based on age-bits. In such an implementation, every time a cache-line is used, the age of all other cache-lines changes. LRU is actually a family of caching algorithms with members including 2Q by Theodore Johnson and Dennis Shasha,[3] and LRU/K by Pat O'Neil, Betty O'Neil and Gerhard Weikum.[4]

The access sequence for the below example is A B C D E D F.

=> kicking out oldest 

 */

import java.util.HashMap;

/*
key,value means map 
map does not have capacity limit -> need to keep the size in check 
need to kick out the oldest => putting is also 'accessing'. with putting, 'timestamp' with serial. 
-> whenever access, update the serial to the max + 1. 
-> maintain max 

when put, if the cache full (size == capacity) -> remove the key with the smallest serial 
-> priorityqueue? or treemap with serial , and poll 

 */

/*
class LRUCache {
    Map<Integer, Integer> cache; 
    TreeMap<Integer, Integer> serial;  // serial -> key 
    int cap; 

    public LRUCache(int capacity) {
        cache = new HashMap<Integer, Integer>(); 
        serial = new TreeMap<Integer, Integer>(); 
        cap = capacity; 
        System.out.println("capacity = " + cap); 
    }

    public int get(int key) {
        if (cache.get(key) == null ) {
            out = -1; 
        } else { 
            // update the serial 
            serial.remove()
            int newserial = ( serial.size() > 0 ? serial.lastKey() + 1 : 1 ); 
            System.out.println(" new serial = " + newserial); 
            serial.put(newserial , key); 
        }
        System.out.println(" key " + key + " access value " + out ); 
        return out; 
    }

    public void put(int key, int value) {
        if (cache.size() == cap) {
            Map.Entry<Integer, Integer> old = serial.pollFirstEntry(); // remove the oldest 
            cache.remove(old.getValue());             
            System.out.println(" cap reached " + cap + " ; kicking out " + old.getValue() + " serial = " + old.getKey()); 
        }
        cache.put(key, value); 
        int newserial = ( serial.size() > 0 ? serial.lastKey() + 1 : 1 ); 
        System.out.println(" new serial = " + newserial); 
        serial.put(newserial , key); 
    }
}
 */ 

class LRUCache {
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	int capacity;
	int currentCapacity = 0;
	Node start = null;
	Node end = null;
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
		
		if(map.containsKey(key)) {
			Node node = map.get(key);
			removeNode(node);
			addHeadAtTop(node);
			return node.value;
		}
		
		
		return -1;
	}
	
	public void put(int key, int value) {
		Node node;
		if(!map.containsKey(key)) {
			node = new Node(key, value);
			++currentCapacity;
			if(currentCapacity > capacity) {
				removeNode(end);
				map.remove(end.key);
			}
			addHeadAtTop(node);
		}else {
			// Remove from the list
			node = map.get(key);
			node.value = value;
			removeNode(node);
			// Bring it to the head
			addHeadAtTop(node);
		}
	}
	
	void removeNode(Node node) {
		
		if(node.prev == null) {
			start = node.next;
		}else {
			node.prev.next = node.next;
		}
		if(node.next == null) {
			end = node.prev;
		}else {
			node.next.prev = node.prev;
		}
		
	}
	
	void addHeadAtTop(Node node) {
		
		//initialise the node
		node.prev = null;
		node.next = null;
		
		//If not null
		if(start != null) {
			node.next = start;
			start.prev = node;
		}
		//if null
		start = node;
		//only one node
		if(end == null)
			end = node;
	}
	
	
	
}
class Node {
	int key, value;
	// pointer to the previous node and next node
	Node prev;
	Node next;
	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */