package com.amazon.arrays;

public class WaveArray {

	public static void swap(int arr[], int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void convertToWave(int arr[], int n){

		//Arrays.sort(arr);
		for(int i = 0; i < n ; i += 2){
			if(i > 0 && arr[i] < arr[i-1])
				swap(arr, i-1, i);

			if(i < n-1 && arr[i] < arr[i+1])
				swap(arr, i+1, i);
		}
	}
}
