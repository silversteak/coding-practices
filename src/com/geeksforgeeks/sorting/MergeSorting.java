package com.geeksforgeeks.sorting;

import java.util.Arrays;

public class MergeSorting {

	public static int merge(int arr[], int left, int right, int mid) {
	/*	int leftSize = mid - left + 1;
		int rightSize = right - mid;
		int leftArr[] = new int[leftSize];
		int rightArr[] = new int[rightSize];
		
		for(int i = 0; i < leftSize; i++)
			leftArr[i] = arr[left+i];
		for(int j = 0; j < rightSize; j++)
			rightArr[j] = arr[mid+1+j];*/
		
		int leftArr[] = Arrays.copyOfRange(arr, left, mid + 1);
		int rightArr[] = Arrays.copyOfRange(arr, mid+1, right + 1);
		int leftSize = leftArr.length;
		int rightSize = rightArr.length;
		int i = 0, j = 0, k = left;
		int swaps = 0;
		while(i < leftSize && j < rightSize) {
			if(leftArr[i] <= rightArr[j])
				arr[k++] = leftArr[i++];
			else {
				arr[k++] = rightArr[j++];
				swaps += (mid+1) - (left+i);
			}
		}
		
		while(i < leftSize)
			arr[k++] = leftArr[i++];
		
		while(j < rightSize)
			arr[k++] = rightArr[j++];
		
		return swaps;

	}
	
	public static int mergeSort(int arr[], int left, int right) {
		int ans = 0;
		if(left < right) {
			int mid = left + (right - left) / 2;
			ans += mergeSort(arr, left, mid);
			ans += mergeSort(arr, mid + 1, right);
			ans += merge(arr, left, right, mid);
		}
		
		return ans;
	}
	
	
	
	public static void main(String[] args) {

		int arr[] = {97, 1153, 17, 999, 0};
		System.out.println(mergeSort(arr, 0, arr.length-1));
		System.out.println(Arrays.toString(arr));
		
	}

}
