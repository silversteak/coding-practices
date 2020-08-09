package com.amazon.arrays;

public class ProductArrayPuzzle {

	public static long[] productExceptSelf(int arr[], int n) 
	{ 
		long leftArr[] = new long[n];
		long rightArr[] = new long[n];
		leftArr[0] = 1;
		rightArr[n-1] = 1;
		for(int i = 1; i < n; i++)
			leftArr[i] = leftArr[i-1] * arr[i-1];

		for(int i = n-2; i >=0; i--){
			rightArr[i] = rightArr[i+1] * arr[i+1];
		}

		long ans[] = new long[n];
		for(int i = 0; i < n; i++){
			ans[i] = leftArr[i] * rightArr[i];
		}

		return ans; 
	} 

}
