package com.hackerEarth;

import java.util.Scanner;

public class BINARY {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		int ones = 0, zeros = 0, maxOne = 0, maxZero = 0;
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '1') {
				ones++;
				maxOne = Math.max(maxOne, ones); 
			}else {
				ones = 0;
			}
			
			if(input.charAt(i) == '0') {
				zeros++;
				maxZero = Math.max(maxZero, zeros); 
			}else {
				zeros = 0;
			}		
		}
		
		if(maxZero >= 6 || maxOne >= 6)
			System.out.println("Sorry, sorry!");
		else
			System.out.println("Good Luck!");
		
		
		
	}

}
