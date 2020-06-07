package com.geeksforgeeks.dynamicprogramming;

public class SubSetSum {
	
	/*
	 * given a target find the minimun elements required to reach the
	 * target sum
	 * */
	
	public static int subSet(int arr[], int n, int target) {
		
		if(n == 0) {
			return target == 0 ? 1 : 0;
		}	
		return subSet(arr, n-1, target) + subSet(arr, n-1, target-arr[n-1]);
		
	}
	
	public static int subSetDp(int arr[], int n, int sum) {
		
		int dp[][] = new int[n+1][sum+1];
		
		for(int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		
		for(int j = 1; j <= sum ; j++) {
			dp[0][j] = 0;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= sum; j++) {
				if(j < arr[i-1]) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j] + dp[i][j-arr[i-1]];
				}
			}
		}
		
		return dp[n][sum];
				
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
