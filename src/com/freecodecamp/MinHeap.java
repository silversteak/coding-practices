package com.freecodecamp;


public class MinHeap {
	
	public final static int INF = Integer.MAX_VALUE;
	int arr[];
	int size;
	int capacity;
	
	MinHeap(int c){
		arr = new int[c];
		size = 0;
		capacity = c;
	}
	
	int left(int i) {return (2*i)+1;}
	int right(int i) {return (2*i)+2;}
	int parent(int i) {return (int) Math.floor((i-1)/2);}
	
	public void insert(int x) {
		arr[size] = x;
		size++;
		int i = size-1;
		while(i >= 0 && arr[parent(i)] > arr[i]) {
			int temp = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)] = temp;
			i = parent(i);
		}
	}
	
	public void decreasekey(int x, int i) {
		arr[i] = x;
		while(i >= 0 && arr[parent(i)] > arr[i]) {
			int temp = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)] = temp;
			i = parent(i);
		}
	}
	
	public void minHeapify(int i){
		int left = left(i), right = right(i);
		int smallest = i;
		
		if(left < size && arr[left] < arr[i])
			smallest = left;
		
		if(right < size && arr[right] < arr[smallest])
			smallest = right;
		
		if(smallest != i) {
			//swap(arr[i], arr[smallest]);
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			minHeapify(smallest);
		}
	}
	
	public int extractMin() {
		if(size == 0)
			return INF;
		if(size == 1) {
			size--;
			return arr[0];
		}
		
		int temp = arr[0];
		arr[0] = arr[size-1];
		arr[size-1] = temp;
		size--;
		minHeapify(0);
		
		return arr[size];
	}
	
	public void buildHeap() {
		for(int i = (size-2)/2; i >=0; i--) {
			minHeapify(i);
		}
	}
	
	
	
	
}
