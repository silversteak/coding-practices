package com.geeksforgeeks.dynamicprogramming;

public class ShortestCommonSuperSequence {

	public static int dp[][];

	public static int lcsDP(String s1, String s2, int m, int n) {

		dp = new int[m+1][n+1];
		for(int i = 0; i <= m; i++)
			dp[i][0] = 0;

		for(int j = 0; j <= n; j++)
			dp[0][j] = 0;
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][n];
	}


	
	public static void main(String[] args) {
		String s1 = "GEEKS";
		String s2 = "GEFKY";
		
		int m = s1.length();
		int n = s2.length();
		
		int lcs = lcsDP(s1, s2, m, n);
		
		/*
		 * m - lcs + n - lcs + lcs
		 * 
		 * */
		
		System.out.println(lcs);
		
		
		System.out.println("The length of shortest common superSubsequence is " + (lcs + m - lcs + n - lcs));
		

	}

}
