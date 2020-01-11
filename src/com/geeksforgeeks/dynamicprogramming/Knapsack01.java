package com.geeksforgeeks.dynamicprogramming;

public class Knapsack01 {

	public static int knapsackRecursive(int W, int wt[], int val[], int n) {

		if(n == 0 || W == 0)
			return 0;

		/*There is 2 posibilities 
		 1. Either pick the present wt and the previous substracted wt
		 2. Dont pick the current wt just pick the previous
		 3. return the max of the two*/
		if(wt[n-1] <= W) {
			int include = knapsackRecursive(W-wt[n-1], wt, val, n-1) + val[n-1];
			int exclude = knapsackRecursive(W, wt, val, n-1);
			return Math.max(include, exclude);
		}	
		return knapsackRecursive(W, wt, val, n-1);
	}
	

	
	public static int knapsackDp(int W, int wt[], int val[], int n) {
		
		int dp[][] = new int[n+1][W+1];
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= W; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(wt[i-1] <= j)
					dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][W];
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int val[] = new int[]{60, 100, 120}; 
		int wt[] = new int[]{10, 20, 30}; 
		int  W = 50; 
		int n = val.length; 
		System.out.println(knapsackRecursive(W, wt, val, n));
		System.out.println(knapsackDp(W, wt, val, n));

	}

}
