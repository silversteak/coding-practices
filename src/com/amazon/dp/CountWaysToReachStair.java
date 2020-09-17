package com.amazon.dp;

public class CountWaysToReachStair {

	// function to count ways to reach mth stair
	int inf = 1000000007;
	long memo[];
	Long countWays(int m){
		long first = 1;
		long second = 1;
		for(int i = 1; i < m; i++){
			long temp = second;
			second = (second + first) % inf;
			first = temp;
		}

		return second;
	}

	long countWaysUtil(int m){
		if(m < 0) return 0;

		if(memo[m] != -1)
			return memo[m];


		if(m == 0) return 1;

		memo[m] = (countWaysUtil(m-1) + countWaysUtil(m-2)) % inf;

		return memo[m];

	}

}
