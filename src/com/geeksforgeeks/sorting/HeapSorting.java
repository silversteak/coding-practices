package com.geeksforgeeks.sorting;

import java.util.Arrays;

public class HeapSorting {
	
	public static void maxHeapify(int arr[], int n, int i) {
		
		int largest = i, left = 2*i+1, right = 2*i+2;
		
		if(left < n && arr[left] > arr[largest])
			largest = left;
		
		if(right < n && arr[right] > arr[largest])
			largest = right;
		
		if(largest != i) {
			//Swap largest with i
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;		
			maxHeapify(arr, n, largest);
		}
		
	}
	
	public static void buildHeap(int arr[], int n) {
		for(int i = (n-2)/2; i >= 0; i--) {
			maxHeapify(arr, n, i);
		}
	}
	
	public static void heapSort(int arr[], int n) {
		for(int i = n - 1; i >= 1; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;		
			maxHeapify(arr, i, 0);
		}
	}

	public static void main(String[] args) {
		int arr[] = {4, 10, 3, 5, 1, 89, -1, 6, -25, 2} ;
		int n = arr.length;
		buildHeap(arr, n);
		System.out.println(Arrays.toString(arr));
		heapSort(arr,n);
		System.out.println(Arrays.toString(arr));
	}

}
