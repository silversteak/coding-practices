package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductArray {

	public int[] productExceptSelf(int[] nums) {
		
		if(nums == null)
			return null;
		
		int len = nums.length;
		
		int leftArray[] = new int[len];
		int rightArray[] = new int[len];
		leftArray[0] = 1;
		rightArray[len-1] = 1;
		
		for(int i = 1; i < len; i++)
			leftArray[i] = leftArray[i-1] * nums[i-1];
		for(int i = len - 2; i >=0 ; i--)
			rightArray[i] = rightArray[i+1] * nums[i+1];
		
		for(int i = 0; i < len; i++)
			nums[i] = leftArray[i] * rightArray[i];
		
		return nums;
	}
	
	public static int containsDuplicate(int[] nums) {
        
		int slow = 0, fast = 0;
		int ans = nums.length;
		int len = nums.length;
		while(true) {
			slow = (slow + 1) % len;
			fast = (fast + 2) % len;
			
			if(nums[slow] == nums[fast]) {
				//ans = nums[slow];
				break;
			}
				
		}
		
		slow = 0;
		
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		
        return slow;	
    }
	
public static int containsDuplicateV1(int[] nums) {
    
		if(nums == null)
			return -1;
		
		for(int i = 0 ; i < nums.length; i++) {
			if(nums[Math.abs(nums[i])] > 0)
				nums[Math.abs(nums[i])] = -1 * nums[Math.abs(nums[i])];
			else
				return Math.abs(nums[i]);
		}
		
		return 0;
    }
	
	
	public static int findMin(int nums[]) { 
	        int l = 0, r = nums.length - 1; 
	        while (l < r) { 
	        	
	        	if(l == r)
	        		return nums[l];
	        	
	        	if(l < 0 || r > nums.length - 1 )
	        		return -1;
	        	
	            int m = l + (r - l) / 2; 

	  
	            // for the piovot element
	            if (nums[m-1] > nums[m] && nums[m] < nums[m+1]) 
	                return nums[m]; 
	  
	            
	            // If x greater, ignore left half 
	            if (nums[m-1] < nums[m] && nums[m] < nums[m+1]) 
	                l = m + 1; 
	  
	            // If x is smaller, ignore right half 
	            else if (nums[m-1] > nums[m] && nums[m] < nums[m+1])
	                	r = m - 1; 
	        } 
	 
	        return -1; 
	    } 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {3,4,5,1,2};
		int len = arr.length;
		
		System.out.println(findMin(arr));
		
		

	}

}
