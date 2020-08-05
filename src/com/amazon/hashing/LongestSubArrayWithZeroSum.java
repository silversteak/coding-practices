package com.amazon.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithZeroSum {

	int maxLen(int nums[], int n){
		 
        int sum = 0;
        int k = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        
        //hash.put(0,1);
        int max = 0; 
        for(int i = 0; i < n; i++){
            sum += nums[i];
            
            if(nums[i] == 0 && max == 0) 
                max = 1; 
            
            if(sum == 0)
                max = i + 1;
    
            if(!hash.containsKey(sum))
                hash.put(sum, i);
            else
                max = Math.max(max, i - hash.get(sum));            
            /*else{
                int temp = hash.get(sum);
                hash.put(sum, i - temp);
            }*/
            
        }
        
        return max;
        
    }
}
