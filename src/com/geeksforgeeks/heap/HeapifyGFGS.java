package com.geeksforgeeks.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapifyGFGS {
	
	static <T> void printArray(int[] arr, int n) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < n-1; i++) {
			stringBuilder.append(arr[i]+ " ");
		}
		System.out.println(stringBuilder.append(arr[n-1]));
	}
    
	// To heapify a subtree rooted with node i which is
    // an index in arr[].Nn is size of heap
    static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
	
	
	static int deleteRoot(int arr[], int n) {
		// Get the last element
		int lastElement = arr[n-1];
		// Replace root with first element
		arr[0] = lastElement;
		// Decrease size of heap by 1
		n = n - 1;
		// heapify the root node
		heapify(arr, n, 0);
		// return the new size
		return n;
	}
	
	   static void buildHeap(int arr[], int n)
	    {
	        // Index of last non-leaf node
	        int startIdx = (n - 2)/2;
	        
	        // Perform reverse level order traversal from last non-leaf node and heapify each node
	        for(int i = startIdx; i>=0; i--)
	        {
	            heapify(arr, n, i);
	        }
	    }

	public static void kThlargestElement(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i : arr)
			pq.add(i);
		int i = 1;
		StringBuilder sb = new StringBuilder();
		while(i <= k) {
			sb.append(pq.poll() + " ");
			i++;
		}
		
		System.out.println(sb);
		
	}
	
	public static void nearlySorted(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int index = 0;
		
		for(int i = 0; i <= k; i++)
			pq.add(arr[i]);
		
		for(int i = k+1; i < arr.length; i++) {
			arr[index++] = pq.poll();
			pq.add(arr[i]);
		}
		while(!pq.isEmpty())
			arr[index++] = pq.poll();
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < arr.length - 1) {
			//sb.append(arr[i++] + " ");
		}
		
		System.out.println(sb.append(arr[i]));
		
	}
	
	public static void KthLargestStream(int arr[], int k){
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int index = 0;
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < k; i++) {
			pq.add(arr[i]);
			result.add(-1);
		}
		
		for(int i = k; i < arr.length; i++) {
			pq.add(arr[i]);
			result.add(pq.poll());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : result) {
			sb.append(i + " ");
		}
		System.out.println(sb.append(result.get(result.size()-1)));
		
		
	}
	   
	public static void main(String[] args) {
		int arr[] = { 10, 5, 3, 2, 4 };

       /* int n = arr.length;

        n = deleteRoot(arr, n);

        printArray(arr, n);*/
        
        
        kThlargestElement(arr, 3);
        
        
	}

}
