package com.geeksforgeeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeHackerRank {

    public static long memo[][];

    public static long getCoinChange(Long coins[], int n, int sum){

        if(memo[sum][n] != -1)
            return memo[sum][n];

        if(sum == 0)
            memo[sum][n] = 1;
        else{

            if(n == 0 && sum > 0)
                memo[sum][n] = 0;
             else{
                 memo[sum][n] = getCoinChange(coins, n - 1, sum);

                 if(coins[n-1] <= sum)
                    memo[sum][n] += getCoinChange(coins, n - 1, (int)(sum-coins[n-1])); 
             }   

        }

        return memo[n][sum];
    }

    public static void fillArray(long memo[][]){
        for(int i = 0; i <= memo.length; i++){
            for(int j = 0; j <=memo[0].length; j++){
                memo[i][j] = -1;
            }
        }
    }

    public static long getWays(int sum, List<Long> c) {
        int n = c.size();

        Long coins[] = new Long[n];
        coins = c.toArray(coins);
        memo = new long[n+1][sum+1];

        fillArray(memo);

        getCoinChange(coins, n, sum);
        return memo[n][sum];
    }


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 4;
		List<Long> c = new ArrayList<>();
		c.add(new Long(1));
		c.add(new Long(2));
		c.add(new Long(3));
		
		getWays(sum, c);
		

	}

}
