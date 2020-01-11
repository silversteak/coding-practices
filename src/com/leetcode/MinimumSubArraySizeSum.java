package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinimumSubArraySizeSum {

	
	// 2,3,1,2,4,3
	
	public static int minSubArrayLen(int s, int[] nums) {
		int result = Integer.MAX_VALUE;
		int count1 = 0, count2 = 0;
		int left = 0, right;
		Set<Integer> myset = new HashSet<>();
		int sum = 0, len = nums.length;
		for(right = 0; right < len; right++) {
		
			sum+=nums[right];
			count1++;
			while(sum >= s && left< right) {
				sum-=nums[left];
				result = Math.min(result, right-left + 1);
				left++;
				count2++;
			}
			
		}
		
		System.out.println(count1+ " " + count2);
		
		return result == Integer.MAX_VALUE ? 0 : result ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//7
		//[2,3,1,2,4,3]
		
		
		int arr[]= {1,2,3,6,5,0,0,0,0,7,4,8,9};
		int sum = 28;
		
		System.out.println(minSubArrayLen(sum,arr));
		
		
	}

}
