package com.geeksforgeeks.sorting;

import java.util.Arrays;

public class InsertionSort {
	
	public static void insertionSortGreater(int arr[], int n) {
		for(int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	public static void insertionSort(int arr[], int n) {
		for(int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] < key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {89, 10, 4, 6, 2, 3, -1, 5, -25, 1};
		int n = arr.length;
		System.out.println(Arrays.toString(arr));
		insertionSortGreater(arr, n);
		System.out.println(Arrays.toString(arr));
		insertionSort(arr, n);
		System.out.println(Arrays.toString(arr));
		
	}

}
