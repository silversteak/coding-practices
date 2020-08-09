package com.amazon.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {

	static ArrayList<Integer> subarraySum(int n, int s, int[] m) {
		int prefix = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Map<Integer, Integer> hash = new HashMap<>();
		for(int i = 0; i < n; i++){
			prefix += m[i];
			if(prefix - s == 0){
				ans.add(0+1);
				ans.add(i+1);
				break;
			}
			if(hash.containsKey(prefix - s)){
				ans.add(hash.get(prefix - s)+1);
				ans.add(i+1);
				break;
			}
			hash.put(prefix, i+1);
		}
		return ans;

	}
	public static void main(String args[]) {
		int N = 5, S = 12;
		int A[] = {1,2,3,7,5};
		subarraySum(N, S, A);
	}

}
