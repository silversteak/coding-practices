package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
	
	static class Pair{
		int value;
		int weight;
		Pair(int value, int weight){
			this.value = value;
			this.weight = weight;
		}
	}

	/*
	 * int[] wt = {10, 40, 20, 30}; 
        int[] val = {60, 40, 100, 120}; 
        int capacity = 50; 
	 * */
	
	public static int fractionalKnapsack(Pair [] arr, int capacity) {
		int res = 0;
		
		Arrays.sort(arr, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return -(o1.value/o1.weight - o2.value/o2.weight);
			}
		});
		
		int currentCapacity = capacity;
		
		for(int i = 0; i < arr.length; i++) {		
			if(arr[i].weight <= currentCapacity) {
				currentCapacity = currentCapacity - arr[i].weight;
				res += arr[i].value; 
			}else {
				res += (arr[i].value * (double)currentCapacity/arr[i].weight);
				break;
			}
			
		}
		
		return res;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pair[] arr = {new Pair(60, 10),new Pair(40, 40), new Pair(100, 20), new Pair(120,30)};
		int capacity = 50;
		
		System.out.println(fractionalKnapsack(arr, capacity));
		
	}

}
