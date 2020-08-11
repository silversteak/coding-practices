package com.amazon.arrays;

public class MountainArray_2pass_problem {

	/**
	 * 53 Maximum Subarray
121 Best Time to Buy and Sell Stock
152 Maximum Product Subarray
238 Product of Array Except Self
739 Daily Temperatures
769 Max Chunks to Make Sorted
770 Max Chunks to Make Sorted II
821 Shortest Distance to a Character
845 Longest Mountain in Array
Maximum Index problem 
Sorted subsequence of 3

	 */

	public int longestMountain(int[] A) {
		int N = A.length, res = 0;
		int[] up = new int[N], down = new int[N];
		for (int i = N - 2; i >= 0; --i) 
			if (A[i] > A[i + 1]) 
				down[i] = down[i + 1] + 1;
		for (int i = 0; i < N; ++i) {
			if (i > 0 && A[i] > A[i - 1]) 
				up[i] = up[i - 1] + 1;
			if (up[i] > 0 && down[i] > 0) 
				res = Math.max(res, up[i] + down[i] + 1);
		}
		return res;
	}
	
	  public boolean validMountainArray(int[] A) {
	        int n = A.length, i = 0, j = n - 1;
	        while (i + 1 < n && A[i] < A[i + 1]) i++;
	        while (j > 0 && A[j - 1] > A[j]) j--;
	        return i > 0 && i == j && j < n - 1;
	    }

}
