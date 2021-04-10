package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class RemoveIntervals {

	public static int removeCoveredIntervals(int[][] intervals) {

		if(intervals.length <= 1)
			return 1;

		Arrays.sort(intervals, new Comparator<int []>(){
			public int compare(int o1[], int[]o2){
				return Integer.compare(o1[0], o2[0]);
			}
		});

		//Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		List<int []> list = new LinkedList<>();

		for(int []interval : intervals){

			if(list.isEmpty())
				list.add(interval);
			else if(list.get(list.size()-1)[0] <= interval[0] && list.get(list.size()-1)[1] < interval[1]){
				if(list.get(list.size()-1)[0] == interval[0]){
					list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], interval[1]);    
				}else {					
					list.add(interval);
				}
			}
		}

		return list.size();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int intervals[][] = {{1,2},{1,4},{3,4}};
		
		System.out.println(removeCoveredIntervals(intervals));
		

	}

}
