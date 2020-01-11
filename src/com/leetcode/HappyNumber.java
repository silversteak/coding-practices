package com.leetcode;

import java.util.HashSet;

public class HappyNumber {
	
	public static int numSquareSum(int n) 
	{ 
	    int squareSum = 0; 
	    while (n != 0) 
	    { 
	        squareSum += (n % 10) * (n % 10); 
	        n /= 10; 
	    } 
	    return squareSum; 
	} 
	
	
	public static boolean findHappy(int n) {
		
		int slow , fast;
		
		do {
			slow = numSquareSum(n);
			fast = numSquareSum(numSquareSum(n));
		}while(slow != fast);
		return slow == 1;	
	}
	
	public static boolean findHappyV2(int n) {
		
		boolean hash[] = new boolean[1000];
		hash[n] = true;
		while(true) {
			if(n == 1 || n == 0)
				return true;
			int sum = 0;
			while(n > 0) {
				sum += ((n%10) * (n%10));
				n = n/10;
			}
			
			if(hash[sum] == true)
				return false;
			else
				hash[sum] = true;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 1; i < 1000; i++) {
			if(findHappyV2(i))
				System.out.println(i);
		}
		

	}

}
