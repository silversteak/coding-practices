package com.amazon.searching;

public class MinimumInRotatedArray {

	public int findMin(int[] nums) {
		if(nums.length == 0)
			return -1;

		int n = nums.length;
		int low = 0, high = n  - 1;

		while(low <= high){

			//if(nums[low] <= nums[high]) return nums[low];

			int mid = low + (high - low)/2;
			int next = (mid+1)%n, prev = (mid+n-1)%n;

			if(nums[prev] >= nums[mid] && nums[mid] <= nums[next])
				return nums[mid];

			else if(nums[mid] <= nums[high])
				high = mid-1;
			else if(nums[mid] >= nums[low])
				low = mid+1;

		}

		//if(left != nums.length && nums[left] == target) return left;

		return -1;
	}

}
