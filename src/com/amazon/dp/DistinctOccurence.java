package com.amazon.dp;

public class DistinctOccurence {

	int inf = 1000000007;

	int  subsequenceCount(String S, String T)
	{
		int m = S.length(), n = T.length();

		int memo[][] = new int[m+1][n+1];
		for(int i = 0; i <=m; i++){
			for(int j = 0; j <= n; j++)
				memo[i][j] = -1;
		}

		return countDistinctSub(memo, S, T, m, n);

	}

	int countDistinctSub(int memo[][],String S,String T,int m,int n){
		if(memo[m][n] != -1)
			return memo[m][n];

		if(n == 0) return 1;

		if(m == 0) return 0;

		if(S.charAt(m-1) != T.charAt(n-1))
			memo[m][n] = countDistinctSub(memo, S, T, m-1, n);
		else
			memo[m][n] = (countDistinctSub(memo, S, T, m-1, n) + 
					countDistinctSub(memo, S, T, m-1, n-1)) % inf;

		return memo[m][n];                
	}

}
