package com.geeksforgeeks.dynamicprogramming;


public class LowestCommonSubsequence {
	
	public static int lcs(String s1, String s2, int m, int n) {
		
		if(m == 0 || n  == 0)
			return 0;
		
		if(s1.charAt(m-1) == s2.charAt(n-1))
			return 1 + lcs(s1,s2,m-1,n-1);
		else
			return Math.max(lcs(s1,s2,m-1,n), lcs(s1,s2,m,n-1));
		
	}
	
	public static int lcsMemo(String s1, String s2, int m, int n, int memo[][]) {
		
		if(memo[m][n] != -1)
			return memo[m][n];
		
		if(m == 0 || n == 0)
			memo[m][n] = 0;
		else {
			if(s1.charAt(m-1) == s2.charAt(n-1))
				memo[m][n] = 1 + lcsMemo(s1,s2,m-1,n-1, memo);
			else 
				memo[m][n] = Math.max(lcsMemo(s1,s2,m-1,n, memo), lcsMemo(s1,s2,m,n-1,memo));
		}
		return memo[m][n];
		
	}
	
	public static int lcsDP(String s1, String s2, int m, int n) {
		
		int dp[][] = new int[m+1][n+1];
	/*	for(int i = 0; i <= m; i++)
			dp[i][0] = 0;
		
		for(int j = 0; j <= n; j++)
			dp[0][j] = 0;
		*/
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s1.charAt(m-1) == s2.charAt(n-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][n];
	}
	
	
	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "BACDBDCD"; 
		int m = s1.length(), n = s2.length();
		int memo[][] = new int[m+1][n+1];
		int dp[][] = new int[m+1][n+1];
		for(int i = 0; i <=m; i++) {
			for(int j = 0; j <= n; j++)
				memo[i][j] = -1;
		}
		for(int i = 0; i <=m; i++) {
			for(int j = 0; j <= n; j++)
				dp[i][j] = -1;
		}
		
		System.out.println(lcs(s1,s2,m,n));
		System.out.println(lcsMemo(s1, s2, m, n, memo));
		System.out.println(lcsDP(s1, s2, m, n));
	}


}
