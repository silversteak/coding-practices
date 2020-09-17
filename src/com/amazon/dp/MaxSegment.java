package com.amazon.dp;

public class MaxSegment {

	public int maxCuts(int n, int x, int y, int z, int memo[]){

		if(n < 0) return -1;

		if(n == 0) return 0;

		if(memo[n] != -1)
			return memo[n];

		int res = Math.max(Math.max(maxCuts(n-x,x,y,z, memo), maxCuts(n-y,x,y,z, memo)), maxCuts(n-z,x,y,z, memo));

		if(res != -1){
			memo[n] = res+1;
		}else
			memo[n] = res;

		return memo[n];    
	}

	public int maximizeCuts(int n, int x, int y, int z)
	{
		int dp[] = new int[n+1];
		//Arrays.fill(dp, -1);
		dp[0] = 0;
		for(int i = 1; i <= n; i++){
			dp[i] = -1;

			if(i-x >= 0) dp[i] = Math.max(dp[i], dp[i-x]);
			if(i-y >= 0) dp[i] = Math.max(dp[i], dp[i-y]);
			if(i-z >= 0) dp[i] = Math.max(dp[i], dp[i-z]);
			if(dp[i] != -1)
				dp[i] = dp[i] + 1;

		}

		return dp[n] == -1 ? 0 : dp[n];

	}

}
