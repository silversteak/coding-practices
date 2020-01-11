package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	
	public static String[] largestNumner(String nums[]) {
		
		/*Arrays.sort(nums, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String XY = o1 + o2;
				String YX = o2 + o1;
				return YX.compareTo(XY);
			}
		});*/
		
		Arrays.sort(nums,  (o1, o2) -> (o1+o2).compareTo(o2+o1));
		return nums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums [] = {3,30,34,5,9};
		String stringNums[] = new String[nums.length];
		int k = 0;
		for(int i : nums) {
			stringNums[k++] = String.valueOf(i);
		}
		
		stringNums = largestNumner(stringNums);
		StringBuffer sb = new StringBuffer();
		for(String ch : stringNums) {
			sb.append(ch);
		}
		
		String A = "A";
		String B = "B";
		
		Arrays.sort(stringNums,  (o1, o2) -> (o2+o1).compareTo(o1+o2));
		
		System.out.println(Arrays.toString(stringNums));
		
		Arrays.sort(stringNums, (o1, o2) -> {
			String XY = o1+o2;
			String YX = o2+o1;
			return XY.compareTo(YX);
		});
		
		if(sb.charAt(0) == '0')
			//return String.valueOf(0);
		
		System.out.println(Arrays.toString(stringNums));
		
		System.out.println(A.compareTo(B));
		System.out.println(B.compareTo(A));
		
		System.out.println(sb.toString());

	}

}
