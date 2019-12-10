package com.geeksforgeeks.dynamicprogramming;

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

		if(sum > 0 && m <= 0)
			return 0;

		else {
			if(memo[m][sum] != -1)
				return memo[m][sum];

			if(sum == 0) {
				memo[m][sum] = 0;
				return memo[m][sum];
			}

			else 
				memo[m][sum] = coinChangeMemo(arr,m,sum-arr[m-1], memo) + coinChangeMemo(arr,m-1,sum, memo); 
		}
		return memo[m][sum];		
	}



	public static void main(String[] args) {

		int arr[] = {1,2,3};
		int m = arr.length;

		int memo[][] = new int[m+1][5];
		for(int i = 0; i <= m;i++) {
			for(int j= 0; j <=4; j++)
				memo[i][j] = -1;
		}


		System.out.println(coinChangeRecursive(arr, 3, 4));
		System.out.println(coinChangeMemo(arr, 3, 4, memo));


	}

}
