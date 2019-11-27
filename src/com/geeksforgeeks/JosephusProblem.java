package com.geeksforgeeks;

public class JosephusProblem {
	
	public static int solve(int n, int k) {
		if(n == 1)
			return 1;
		return (solve(n-1,k)+k-1)%n+1;
	} 
	public static void main(String[] args) {
		System.out.println(solve(10,3));
		System.out.println(solve(10,2));
		System.out.println(solve(100,2));
		System.out.println(solve(100,6));
	}
}
