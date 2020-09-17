package com.amazon.dp;

public class MinimumNumberOfCoin {

	public long minimumNumberOfCoins(int coins[],int numberOfCoins,int value){

		long dp[] = new long [value+1];

		dp[0] = 0;

		for(int i = 1; i <= value; i++)
			dp[i] = Long.MAX_VALUE;

		for(int i = 1; i <= value; i++){
			for(int j = 0; j < numberOfCoins; j++){
				if(coins[j] <= i){
					long subRes = dp[i - coins[j]];
					if(subRes != Long.MAX_VALUE)
						dp[i] = Math.min(dp[i], subRes + 1);
				}
			}
		}

		return dp[value] == Long.MAX_VALUE ? -1 : dp[value];
	}

}
