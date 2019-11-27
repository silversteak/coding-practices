package com.codechef;

import java.util.Scanner;

public class SubSums {
	
	public static void printSubsequnce(String inputString, String outputString) {
			if(inputString.length() == 0) {
				System.out.println(outputString);
				return;
			}
			//printSubsequnce(inputString.substring(1), outputString + inputString.charAt(0));
			printSubsequnce(inputString.substring(1), outputString);
			printSubsequnce(inputString.substring(1), outputString + inputString.charAt(0));
	}
	
	public static void printSubsequnce(String inputString) {
		printSubsequnce(inputString, "");
	}

	public static void main(String[] args) {
			
		printSubsequnce("ABC");	
			
		}
		
		
		// TODO Auto-generated method stub

	}


