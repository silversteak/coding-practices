package com.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class PERFECT_PAIRS {

	static Integer sumOfDigits(int num){
        int sum = 0;
        while(num!=0){
            sum = sum + num%10;
            num = num/10;
        }
        return (Integer)sum;
    }
    
	static int PerfectMatch(int arr[], int n) { 
        // your code goes here
        Map<Integer, Integer> hash = new HashMap<>();
        
        int maxSum = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            Integer digitSum = sumOfDigits(arr[i]);
            if(!hash.containsKey(digitSum)){
                hash.put(digitSum, arr[i]);
            }else{
                maxSum = Math.max(arr[i] + hash.get(digitSum), maxSum);
                hash.put(digitSum, arr[i] + hash.get(digitSum));
            }
        }
        return maxSum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub`
		int arr[] = {55, 23, 32, 46, 88};
		System.out.println(PerfectMatch(arr, arr.length));
	
	}

}
