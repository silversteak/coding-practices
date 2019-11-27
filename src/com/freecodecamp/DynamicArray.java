package com.freecodecamp;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {
	
	private T[] arr;
	private int len = 0;
	private int capacity = 0;
	
	public DynamicArray() {
		this(16);
	}
	
	public DynamicArray(int capacity) {
		
		if(capacity < 0)
			throw new IllegalArgumentException("Illegal capacity ="+ capacity);
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}
	
	public int size() {
		return len;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public T get(int index) {
		return arr[index];
	}
	
	public void set(int index, T element) {
		arr[index] = element;
	}
	
	public void add(T element) {
		
		//check for the size
		if(len + 1 > capacity) {
			if(capacity == 0) capacity = 1;
			else capacity = capacity * 2;
			
			T[] new_arr =  (T[]) new Object[capacity];
			for(int i = 0; i < len; i++)
				new_arr[i] = arr[i];
			
			// copy the new array into the old array
			arr = new_arr;
		}	
		arr[len++] = element;
	}
	
	public T removeAt(int index) {
		if(index >= len || index < 0) throw new IndexOutOfBoundsException();
		T data = arr[index];
		T[] new_arr = (T[]) new Object[capacity];
		int k = 0;
		for(int i = 0 ; i < len; i++) {
			if(i == index)
				continue;
			new_arr[k++] = arr[i];
		}
		arr = new_arr;
		len = k;
		return data;
	}
	
	public int indexOf(T obj) {
		for(int i = 0; i < len; i++) {
			if(obj.equals(arr[i]))
				return i;
		}
		return -1;
	}
	
	public boolean contains(T obj) {
		return indexOf(obj) != -1;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new java.util.Iterator<T>() {
			
			int index = 0;
			
			@Override
			public boolean hasNext() {
				return index < len;
			}

			@Override
			public T next() {
				return arr[index++];
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove");
			}
			
		};
	}
	
	public String toString() {
		if(len == 0) return "[]";
		else {
			StringBuilder sb = new StringBuilder(len).append("[");
		    for (int i = 0; i < len - 1; i++) sb.append(arr[i] + ", ");
		    return sb.append(arr[len - 1] + "]").toString();
		}
	}
	
}
