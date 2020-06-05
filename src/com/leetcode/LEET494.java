package com.leetcode;

import java.util.Arrays;

public class LEET494 {
	
	public static int findTargetSumWays(int[] nums, int S) {
        // To get both 
        int memos[][] = new int[nums.length][21];
        for(int memo[] : memos){
            Arrays.fill(memo, -9999); 
        }    
            
        int ans = countWays(nums, 0, 0, S, memos); 
        
        for(int i = 0 ; i < nums.length; i++) {
        	for(int j = 0; j < 21; j++) {
        		System.out.print(memos[i][j] + " ");
        	}
        	System.out.println();
        }
        
        return ans;
    }
    
    public static int countWays(int[] nums, int i, int sum, int S, int memo[][]){
        if(i == nums.length){
            if(sum == S)
                return 1;
            else
                return 0;
        }else{
            if(memo[i][sum+10] != -9999){
                return memo[i][sum+10];
            }
            int add = countWays(nums, i+1, sum + nums[i], S, memo);
            int sub = countWays(nums, i+1, sum - nums[i], S, memo);
            memo[i][sum+10] = add + sub;
            return memo[i][sum+10];
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int nums [] = {1, 1, 1, 1, 1};
			System.out.println(findTargetSumWays(nums, 3));
	}

}
