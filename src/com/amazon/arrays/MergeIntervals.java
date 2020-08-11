package com.amazon.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
	
	static class pair
	{
		int first;
		int second;
		pair(int first, int second)
		{
			this.first = first;
			this.second = second;
		}
	}
	
	public static ArrayList<pair> overlappedInterval(ArrayList<pair> vec, int n){
		
       Collections.sort(vec, new Comparator<pair>() {
			@Override
			public int compare(pair o1, pair o2) {
				return o1.first - o2.first;
			}
		});
		
		ArrayList<pair> ans = new ArrayList<>();
		
		for(pair p : vec) {
			if(ans.isEmpty()) 
				ans.add(p);
			else {
				int size = ans.size();
				int max = ans.get(size-1).second;
				if( max >= p.first){
					ans.get(size-1).second = Math.max(p.second,max);
				}else{
				    ans.add(p);
				}
			}
		}
		return ans;
    }
}
