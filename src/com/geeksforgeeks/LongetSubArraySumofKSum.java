package com.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class LongetSubArraySumofKSum {

	static int longestSubArraySum(int arr[], int n, int k) { 
        
		int modArr[] = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++ ) {
			sum += arr[i];
			modArr[i] = ((sum%k)+k)%k;
		}
		
		Map<Integer, Integer> hash = new HashMap<>();
		
		int max = 0, maxLen = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(modArr[i] == 0)
				max = i+1;
			else if(!hash.containsKey(modArr[i])) {
				hash.put(modArr[i], i);
			}else {
				max = Math.max(max, i - hash.get(modArr[i]));
			}
			
		}
		return max;
		
    } 
	
	public static void main(String[] args) {
		
		int arr[] = {2, 7, 6, 1, 4, 5}; 
        int n = arr.length; 
        int k = 3; 
        longestSubArraySum(arr, n, k);

	}

}
