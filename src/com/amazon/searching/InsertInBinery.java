package com.amazon.searching;

public class InsertInBinery {
	public int searchInsert(int[] nums, int target) {
		// use binary search
		int low = 0, high = nums.length-1;
		int res = 0;
		while(low <= high){

			int mid = low + (high-low)/2;
			if(nums[mid] == target){
				return mid;
			}
			else if(nums[mid] < target){
				res = mid+1;
				low = mid+1;
			}else{
				high = mid-1;
				//res = mid;
			}
		}

		return res;

	}
}
