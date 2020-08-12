package com.amazon.searching;

public class SearchInRotatedArray {
	public int searchIndex(int nums[], int target, boolean flag){

		int low = 0, high = nums.length - 1;
		int res = -1;
		while(low <= high){

			int mid = low + (high-low)/2;

			if(nums[mid] == target){
				res = mid;
				if(flag)
					high = mid - 1;
				else
					low = mid + 1;

			}else if(nums[mid] < target){
				low = mid + 1;
			}else{
				high = mid - 1;
			}   
		}  
		return res;


	}





	public int[] searchRange(int[] nums, int target) {    

		if(nums == null){
			return new int[]{-1,-1};
		}

		int left = -1, right = -1;

		left = searchIndex(nums, target, true);
		right = searchIndex(nums, target, false);

		int res[] = new int[2];

		res[0] = left;
		res[1] = right;


		return res;    


	}
}
