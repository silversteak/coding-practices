package com.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ActivitySelection {
	
	public static int selection(int [][]activity) {
		int res = 1;
		
		//Use custom comparator to sort the 2-array
		
		Arrays.sort(activity, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1] != 0 ? o1[1]-o2[1] : o1[0]-o2[0];
			}
		});
		
		int cur[] = activity[0];
		
		
		
		for(int i = 1; i < activity.length; i++) {
			int []next = activity[i];
			if(next[0] >= cur[1]) {
				res++;
				cur = next;
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int k = 3;
		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		int arr[] = new int[k];
		
		for(int i =  0; i < k; i++) {
			if(max < arr[i])
				max = arr[i];
			if(min > arr[i])
				min = arr[i];
		}
		
		
		int [][] arr1 = {{3,8},{10,11},{1,3},{2,4}};
		
		System.out.println(selection(arr1));
	}

}
