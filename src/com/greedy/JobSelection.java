package com.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JobSelection {
	
	static class Job{
		char id;
		int deadline;
		int profit;
		public Job(char id, int deadline, int profit) {
			super();
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	

	/*
	 * JobID   Deadline  Profit
  a       2        100
  b       1        19
  c       2        27
  d       1        25
  e       3        15
Output: Following is maxi
	 * */
	
	public static List<Character>result; 
	
	public static int jobSelection(Job [] lists) {
		int count = 0;
		
		Arrays.sort(lists, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return -(o1.profit-o2.profit);
			}
		});
		
		int n = lists.length;
		
		boolean slot[] = new boolean[n];
		
		result = new ArrayList<>();
		
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			
			int j = Math.min(n, lists[i].deadline) - 1;
			while(j >= 0) {
				
				if(slot[j] == false) {
					count++;
					result.add(lists[i].id);
					max += lists[i].profit; 
					slot[j] = true;
					break;
				}
				j--;
			}
			
		}
		
		System.out.println(max);
		
		for(int i = 0; i < n; i++) {
			if(slot[i])
				System.out.print(lists[i].id + " ");
		}
		
		return count;
		
		
	}
	
	
	public static void main(String[] args) {
		
		Job []lists = {new Job('E', 3, 15),
				new Job('D', 1, 25),
				new Job('C', 1, 27),
				new Job('B', 1, 19),
				new Job('A', 2, 100)};
		
		
		System.out.println(jobSelection(lists));
		
		System.out.println(result);
		
		Integer calorie[] = new Integer[10];
		
		Arrays.sort(calorie, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
	}

}
