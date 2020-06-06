package com.geeksforgeeks.dynamicprogramming;

public class TwoConsecutiveNumbers {

	public static int consecutive(int arr[], int m) {
		if(m == 1) return arr[0];
		
		if(m == 2) return Math.max(arr[0], arr[1]);
		
		return Math.max(arr[m-1] + consecutive(arr, m-2), consecutive(arr, m-1));
		
	}
	
	public static int consecutiveDp(int arr[], int m) {
		
		int dp[] = new int[m+1];
		dp[0] = 0;
		dp[1] = arr[0];
		
		for(int i = 2; i <= m; i++) {
			dp[i] = Math.max(dp[i-2] + arr[i-1], dp[i-1]);
		}
		
		return dp[m];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
