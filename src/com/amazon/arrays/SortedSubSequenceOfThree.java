package com.amazon.arrays;

import java.util.ArrayList;

public class SortedSubSequenceOfThree {

	ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {

		int min = 0, max = n - 1;

		int smallerArray[] = new int[n];
		smallerArray[0] = -1;
		for(int i = 1; i < n; i++){
			if(arr.get(i) <= arr.get(min)){
				min = i;
				smallerArray[i] = -1;
			}else{
				smallerArray[i] = min;
			}
		}

		int greaterArray[] = new int[n];
		greaterArray[n-1] = -1;
		for(int i = n - 2; i >= 0; i--){
			if(arr.get(i) >= arr.get(max)){
				max = i;
				greaterArray[i] = -1;
			}else{
				greaterArray[i] = max;
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		for(int i = 0; i < n; i++){
			if(greaterArray[i] != -1 && smallerArray[i] != -1){
				//System.out.println(arr.get(smallerArray[i]));
				//.System.out.println(arr.get(i));
				//System.out.println(arr.get(greaterArray[i]));
				ans.add(arr.get(smallerArray[i]));
				ans.add(arr.get(i));
				ans.add(arr.get(greaterArray[i]));
				break;
			}
		}

		return ans; 

	}

}
