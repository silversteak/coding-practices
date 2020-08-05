package com.amazon.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class PairWiseSum {

	public static ArrayList<Integer>findPairs(int arr[], int n) 
	{ 
		Set<Integer> set = new HashSet<>();

		ArrayList<Integer> ans = new ArrayList<>();

		for(int el: arr){
			int temp = Math.abs(el);
			if(!set.contains(temp)){
				set.add(temp);
			}else{
				ans.add(-temp);
				ans.add(temp);
				set.remove(temp);
			}
		}

		if(ans.size() == 0)
			ans.add(0);

		return  ans;
	} 

}
