package com.freecodecamp;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {
	
	LinkedList <T> list = new LinkedList<>();
	
	// Default Constructor
	Stack(){}
	
	//First Element on the stack
	public Stack(T firstElement){
		push(firstElement);
	}
	
	// Check the empty of the stack
	public boolean isEmpty() {
		return size() == 0;
	}
	
	// Push the element
	void push(T element) {
		list.addFirst(element);
	}
	
	
	T pop() {
		if(isEmpty()) throw new java.util.EmptyStackException();
		return list.removeFirst();
	}
	
	T top() {
		if(isEmpty()) throw new java.util.EmptyStackException();
		return list.peek();
	}
	
	
	// Get the size 
	public int size() {
		return list.size();
	}
	
	public String toString() {
		if(size() == 0) return "[]";
		else {
			StringBuilder sb = new StringBuilder(size()).append("[");
		    for (int i = 0; i < size() - 1; i++) sb.append(list.get(i) + ", ");
		    return sb.append(list.get(size() - 1) + "]").toString();
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
