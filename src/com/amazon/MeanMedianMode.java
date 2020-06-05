package com.amazon;

import java.util.Arrays;

public class MeanMedianMode {

	public static double mean(int arr[]) {
		double sum = 0.0;
		for(int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum / arr.length;
	}
	
	 //0 1 2 3 4  
	
	public static double median(int arr[]) {
		Arrays.sort(arr);
		int n = arr.length;
		
		if(n%2!=1)
			return (double)(arr[n/2]); 
		else
			return ((double)(arr[n-1/2]) + (double)(arr[n/2]))/2; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
