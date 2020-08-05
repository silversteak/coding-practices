package com.amazon.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistintElementInWindow {
	
	ArrayList<Integer> countDistinct(int A[], int n, int k){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < k; i++){
			map.put(A[i], map.getOrDefault(A[i], 0)+1);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(map.size());

		for(int i = k; i < A.length ; i++){
			if(map.get(A[i-k]) == 1) 
				map.remove(A[i-k]);
			else 
				map.put(A[i-k], map.get(A[i-k]) - 1);

			map.put(A[i], map.getOrDefault(A[i], 0)+1);

			ans.add(map.size());

		}

		return ans;
	}
}
