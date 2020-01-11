package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SUM3 {
	
	 public List<List<Integer>> threeSum(int[] nums) {
		 Arrays.sort(nums);
		 List<List<Integer>> resultList = new LinkedList<>();
	     int len = nums.length;
		 for(int i = 0; i < len; i++) {	 
			 int left = i + 1;
			 int right = len - 1;
			 //resultList = find2Sum(i, left, right, nums);
			 while(left < right) {
					if(nums[i] + nums[left] + nums[right] == 0) {
						resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
					}else if (nums[i] + nums[left] + nums[right] < 0)
						left++;
					else
						right--;
				}
		 }
		 return resultList;
	 }

	private List<List<Integer>> find2Sum(int i, int left, int right, int nums[]) {
		List<List<Integer>> ans = new LinkedList<>();
		while(left < right) {
			if(nums[i] + nums[left] + nums[right] == 0) {
				ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
			}else if (nums[i] + nums[left] + nums[right] < 0)
				left++;
			else
				right--;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
