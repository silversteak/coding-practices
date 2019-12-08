package com.geeksforgeeks.dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {

	// Normal Recursion
	public static int fib(int n) {
		if(n == 0 || n == 1)
			return n;
		else
			return fib(n-1) + fib(n-2);

	}

	//Memoization (Top Down Approach)
	public static int fibMemo(int n, int memo[]) {
		if(memo[n] == -1) {
			int res = 0;
			if(n == 0 || n == 1)
				res = n;
			else 
				res = fibMemo(n-1, memo) + fibMemo(n-2, memo);		
			memo[n] = res;
		}
		return memo[n];
	}

	//Bottom Up Approch
	public static int fibBottom(int n) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, 0);
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i<= n; i++)
			dp[i] = dp[i-1] + dp[i-2];

		return dp[n];
	}




	public static void main(String[] args) {
		int n = 8;
		int memo[] = new int[n+1];
		Arrays.fill(memo,-1);
		System.out.println(fib(n));
		System.out.println(fibMemo(n, memo));
		System.out.println(fibBottom(n));

	}

}
