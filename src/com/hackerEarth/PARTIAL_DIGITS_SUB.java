package com.hackerEarth;

import java.util.Scanner;

public class PARTIAL_DIGITS_SUB {

	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int ans [] = new int[10];
		
		while(t--> 0) {
			long input = sc.nextLong();
			boolean digits[] = new boolean[10];
			
			while(input > 0) {
				digits[(int)(input%10)] = true;
				input = input / 10;		
			}
			int max  = 0;
			for(int i = 0;i < 10; i++) {
				if(digits[i]) 
					max = Math.max(ans[i], max);
			}
			
			for(int i = 0 ; i < 10; i++) {
				if(digits[i])
					ans[i] = 1 + max;
			}			
		}
		
		int output = 0;
		for(int i = 0; i < 10 ; i++) {
			output = Math.max(output, ans[i]);
		}
		
		System.out.println(output);
		
		
		
		

	}

}
