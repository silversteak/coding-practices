package com.geeksforgeeks.sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public static void bubbleSortGreater(int arr[], int n) {
		for(int i = n - 1; i > 0 ; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void bubbleSort(int arr[], int n) {
		for(int i = n - 1; i >= 0 ; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {89, 10, 4, 6, 2, 3, -1, 5, -25, 1};
		int n = arr.length;
		System.out.println(Arrays.toString(arr));
		bubbleSortGreater(arr, n);
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr, n);
		System.out.println(Arrays.toString(arr));
	}

}
