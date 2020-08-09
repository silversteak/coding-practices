package com.amazon.arrays;

public class StickerThief {

	// Function to return maximum of sum without adjacent elements
	public int FindMaxSum(int arr[], int n){
		// Your code here
		int dp[] = new int[n];
		dp[0] = arr[0];

		if(n == 1)
			return dp[0];
		if(n >= 2)
			dp[1] = Math.max(arr[1], dp[0]);

		for(int i = 2; i < n; i++){
			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
		}

		return dp[n-1];
	}

}
