package com.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class EqualDistribution {

	public static int maxDistributionChocolates(int nums[], int n, int k) {
		
		int prefix[] = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += nums[i];
			prefix[i] = sum;
		}
		
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> hash = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			int rem = prefix[i] % k;
			
			//Case 1 : when remainder is 0
			if(rem == 0)
				max = Math.max(max, prefix[i]);
			//Case 2 : when remainder is not 0 and does not exist in the map
			else if(!hash.containsKey(rem))
				hash.put(rem, i);
			//Case 3 : when remainder exists in the map;
			else {
				max = Math.max(max, i - hash.get(rem));
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 7, 6, 1, 4, 5}; 
		
        int n = arr.length; 
        int k = 3; 
       System.out.println(maxDistributionChocolates(arr, n, k));

	}

}
