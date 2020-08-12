package com.amazon.searching;
class Peak
{
	// Function to find the peak element
	// a[]: input array
	// n: size of array a[]
	public int peakElement(int[] nums,int n)
	{
		if(nums.length == 0)
			return -1;

		//int n = nums.length;
		int low = 0, high = n  - 1;

		while(low <= high){

			//if(nums[low] <= nums[high]) return nums[low];

			int mid = low + (high - low)/2;
			//int next = (mid+1)%n, prev = (mid+n-1)%n;

			if ((mid == 0 || nums[mid - 1] <= nums[mid]) 
					&& (mid == n - 1 || nums[mid + 1] <= nums[mid])) 
				return mid; 

			else if(mid > 0 && nums[mid - 1] > nums[mid])
				high = mid-1;
			else 
				low = mid+1;

		}

		//if(left != nums.length && nums[left] == target) return left;

		return -1;
	}
}