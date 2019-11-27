package com.geeksforgeeks;

public class PEAK_ELEMENT {

	public static int findPeakValue(int arr[], int low, int high, int n) {
		int mid = low + (high-low)/2;
		if((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 || arr[mid+1] <= arr[mid]))
			return mid;
		else if(mid > 0 && arr[mid-1] > arr[mid])
			return findPeakValue(arr, low, mid-1, n);
		return findPeakValue(arr, mid+1, high, n);
	}
	
	public static int binarySearch(int arr[], int low , int high, int key) {
		
		if(high >= low) {
			int mid = low + (high-low)/2;
			
			if(arr[mid] == key)
				return mid;
			else if(arr[mid] < key)
				return binarySearch(arr, low, mid-1, key);
			else
				return binarySearch(arr, mid+1, high, key);
		}
		return -1;
	}
	
	public static int infiniteBinary(int arr[], int key) {
		
		if(arr[0] == key)
			return 0;
		int low = 0, high = 1;
		while(arr[high] <= key) {
			low = high;
			high = 2 * high;
		}
		return binarySearch(arr, low, high, key);
	}
	
	
	public static void main(String[] args) {
		int arr[] = {110,7,3,1,-8,-9};
		int result = findPeakValue(arr, 0, arr.length-1 ,arr.length);
		System.out.println(result);
	}

}
