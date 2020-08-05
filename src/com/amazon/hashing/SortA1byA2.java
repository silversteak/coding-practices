package com.amazon.hashing;

import java.util.Map;
import java.util.TreeMap;

public class SortA1byA2 {

	public static void sortA1ByA2(int A1[], int N, int A2[], int M){

		Map<Integer, Integer> map = new TreeMap<>();

		for(int i : A1){
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		//int ans[] = new int[N];
		//ans = A1;

		int index = 0;
		for(int i : A2){
			if(map.containsKey(i)){
				int count = map.get(i);
				while(count-- > 0){
					A1[index++] = i;
				}
				map.remove(i);
			}
		}

		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			int count = entry.getValue();
			while(count-- > 0){
				A1[index++] = entry.getKey();
			}
		}

		//A1 = ans;
	}

	public static void main(String args[]) {
		int N = 11, M = 4;
			int	A1[] = {2,1,2,5,7,1,9,3,6,8,8};
			int	A2[] = {2,1,8,3};
		sortA1ByA2(A1, N, A2, M);	
	}

}
