package com.geeksforgeeks.dynamicprogramming;

public class LCSDiffUtility {


	public static int dp[][];
	
	public static StringBuffer sb;
	
	//M X N ====== 
	/* 
	 * */
	
	public static void diffUtil(String s1, String s2, int m, int n) {
		
		// Case 1 : When both the character matches
		
		if(m > 0 && n > 0 && (s1.charAt(m-1) == s2.charAt(n-1))) {
			diffUtil(s1,s2,m-1,n-1);
			sb.append(' ').append(s1.charAt(m-1));
		}
		
		
		// Case 2 : When new addition in 2nd string
		// Check for the lookup array which one is greater
		else if(n > 0 && ( m == 0 || dp[m][n-1] >= dp[m-1][n])){
			diffUtil(s1,s2,m,n-1);
			sb.append(' ').append('+').append(s2.charAt(n-1));
		}
		
		// Case 3 : When deletion of first character from the 2nd character
		else if(m > 0 && ( n == 0 || dp[m][n-1] < dp[m-1][n])) {
			diffUtil(s1, s2, m-1, n);
			sb.append(' ').append('-').append(s1.charAt(m-1));
		}
		
	}
	
	
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
		// TODO Auto-generated method stub
		
		String s1 = "AAXDP";
		String s2 = "ADASMXDP";
		
		sb = new StringBuffer();
		
		System.out.println(lcsDP(s1, s2, s1.length(), s2.length()));
		
		System.out.println();
		
		diffUtil(s1, s2, s1.length(), s2.length());
		
		System.out.println(sb.toString());
		

	}

}
