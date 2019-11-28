package com.leetcode;

import java.util.Arrays;

public class BusrtBallons {
	
	 public static int findMinArrowShots(int[][] points) {
		 if(points == null || points.length == 0 || points[0].length == 0)
			 return 0;
		 int count = 1;
		 
		 /*1 , 3
		 2 , 3
		 3 , 8
		 7 , 11
		 9 , 10,
		 10 , 34*/
		 
		 Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
		 
		 int end = points[0][1];
		 
		 for(int row = 1; row < points.length; row++) {
			
			 if(points[row][0] <= end) {
				 end = Math.min(end, points[row][1]);
			 }else {
				 count++;
				 end = points[row][1];
			 }
		 }
		 return count;     
	   }
	 
	 
	public static int findMinIntervals(int[][] intervals) {
		 if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
			 return 0;
		
		 /*1 , 3
		 2 , 3
		 3 , 8
		 7 , 11
		 9 , 10,
		 10 , 34*/
		 
		 Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
		 
		 //int end = intervals[0][1];
		
		 //int count = intervals[0][1]-intervals[0][0];
		 int activity = 1;
		 
		 int time = Integer.MIN_VALUE;
		 
		 for(int row = 0; row < intervals.length; row++) {
			 if(time <= intervals[row][0]) {
				 //count += (intervals[row][1]-intervals[row][0]);
				 activity++;
				 time = intervals[row][1];
			 }
				 
		 }
		 return intervals.length - activity;     
	  
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[][] = {{1,100},{11,22}, {1,11}, {2,12}};
		
		System.out.println(findMinIntervals(arr));
		
	}

}
