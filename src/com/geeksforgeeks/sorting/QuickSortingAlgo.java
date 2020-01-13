package com.geeksforgeeks.sorting;

import java.util.Arrays;

public class QuickSortingAlgo {
	
	
	public static int count = 0;
	
	public static void quickSort(int arr[]) {
		quicksort(arr, 0, arr.length-1);
	} 
	
	
	private static void quicksort(int[] arr, int left, int right) {
		
		if(left < right) {
			int pivot = partition(arr, left, right);
			quicksort(arr, left, pivot-1);
			quicksort(arr, pivot + 1, right);
		}
		
	}


	private static int partition(int[] arr, int left, int right) {
		
		int i = left-1;
		int pivot = arr[right];
		for(int j = left; j < right; j++) {
			if(arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				//i++;
				count++;
			}
			
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = temp;
		count++;
		
		return i+1;
	}


	public static void main(String[] args) {

		int arr[] = {6,2,3,1,-1,8};//{97, 1153, 17, 999, 0};
		quickSort(arr);
		System.out.println(count);
		System.out.println(Arrays.toString(arr));
		
	}

}
