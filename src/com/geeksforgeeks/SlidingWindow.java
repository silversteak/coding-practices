package com.geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlidingWindow {

	//Also works for the sub array with K sums

	public static int maxSumWindow(int arr[], int k) {

		int maxSum = -9999999, curr_sum = 0;

		for(int i = 0; i < k; i++)
			curr_sum += arr[i];
		maxSum = Math.max(maxSum, curr_sum);

		for(int i = k; i < arr.length; i++) {
			curr_sum +=(arr[i-arr[i-k]]);
			maxSum = Math.max(maxSum, curr_sum);
		}

		return maxSum;
	}


	public static boolean isSum(int arr[], int k, int sum) {
		int curr_sum = arr[0], e = 0; 
		for(int i = 1; i < arr.length; i++) {
			//Clean the previous element
			while(curr_sum > sum && e <i-1) {
				curr_sum -=arr[e];
				e++;
			}
			if(curr_sum == sum)
				break;
			if(i < arr.length)
				curr_sum += arr[i];
		}

		return (curr_sum == sum);
	}


	public static void NBonacci(int n, int m) {

		int arr[] = new int[m+1];
		int i, win = 0;

		for(i = 1; i < n; i++) {
			arr[i] = 0;
		}

		arr[i] = 1;
		win = arr[i];

		for(i = n+1 ; i <= m; i++) {
			arr[i] = win;
			win -= arr[i-n+1];
			win += arr[i];
		}


		StringBuilder sb = new StringBuilder(m+1).append("[");
		for (i = 1; i < m+1 - 1; i++) 
			sb.append(arr[i] + ", ");
			sb.append(arr[m+1 - 1] + "]").toString();
		
		System.out.println(sb);

	}
	
	public static void countDistinct(int arr[], int k) {
		HashMap<Integer, Integer> myMap = new HashMap<>();
		int count_dist = 0, key = 0, value = 0;
		
		List<Integer> myList = new ArrayList<>();
		
		for(int i = 0; i < k; i++) {
			if(myMap.containsKey(arr[i])) {
				value = myMap.get(arr[i]);
				myMap.put(arr[i], value+1);
			}else {
				myMap.put(arr[i], 1);
				count_dist++;
			}
		}
		myList.add(count_dist);
		
		for(int i = k; i < arr.length; i++) {
			//Remove the first element of the window;
			key = arr[i-k];
			if(myMap.get(key) == 1) {
				myMap.remove(key);
				count_dist--;
			}else {
				value = myMap.get(key);
				myMap.put(key, value-1);
			}
			key = arr[i];
			if(myMap.containsKey(key)) {
				value = myMap.get(key);
				myMap.put(key, value+1);
			}else {
				myMap.put(key, 1);
				count_dist++;
			}
			
			myList.add(count_dist);
			
		}
		
		System.out.println(myList);
		
	}
	
	
	public static void main(String[] args) {
		
		//NBonacci(5, 15);
		
		int arr[] = {1, 2, 1, 3, 4, 2, 3};
		countDistinct(arr, 4);

	}

}
