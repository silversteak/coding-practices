package com.geeksforgeeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {

	public static int coinChangeRecursive (int arr[], int m, int sum) {

		if(sum == 0)
			return 1; 

		if(sum < 0)
			return 0;

		if(sum > 0 && m <=0)
			return 0;

		return coinChangeRecursive(arr, m, sum-arr[m-1]) + coinChangeRecursive(arr, m-1, sum);
	}


	public static int coinChangeMemo(int arr[], int m, int sum, int memo[][]) {

		if(sum < 0 || m < 0) {
			return 0;
		}

		else {
			
			if(sum > 0 && m <= 0)
				return 0;

			else {

				if(memo[m][sum] != -1)
					return memo[m][sum];

				if(sum == 0) {
					memo[m][sum] = 1;
					return memo[m][sum];
				}
				else 
					memo[m][sum] = coinChangeMemo(arr,m,sum-arr[m-1], memo) + coinChangeMemo(arr,m-1,sum, memo); 
			}
			return memo[m][sum];		
		}

	}

	


	public static void main(String[] args) {

		int arr[] = {1,2,3};
		int m = arr.length;
		
		int amount = 4;
		
		int memo[][] = new int[m+1][5];
		for(int i = 0; i <= m;i++) {
			for(int j= 0; j <=4; j++)
				memo[i][j] = -1;
		}
		
		List<Long> c = new ArrayList<>();
		Long coins[] = new Long[c.size()];
        coins = c.toArray(coins);

		
		System.out.println(coinChangeRecursive(arr, 3, 4));
		System.out.println(coinChangeMemo(arr, 3, 4, memo));
		System.out.println(coinChangeDP(arr,amount));


	}


	private static int coinChangeDP(int[] coins, int amount) {
		
		if(coins == null || coins.length == 0)
			return 0;
		
		int m = coins.length;
		
		int dp[][] = new int[m+1][amount+1];
		
		for(int i = 0; i <= m; i++)
			dp[i][0] = 1;
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= amount; j++) {
				
				if(coins[i-1] <= j)
					dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
				else
					dp[i][j] = dp[i-1][j];
				
			}
		}
		
		return dp[m][amount];
	}

}
