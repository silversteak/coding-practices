package com.geeksforgeeks;

public class AnagramSearch {
	
	static int MAX_CHAR = 256; 

	// A utility function to find factorial of n 
	static int fact(int n) { 
		return (n <= 1) ? 1 : n * fact(n - 1); 
	} 

	static void populateAndIncreaseCount(int[] count, char[] str){ 
		int i; 

		for (i = 0; i < str.length; ++i) 
			++count[str[i]]; 

		for (i = 1; i < MAX_CHAR; ++i) 
			count[i] += count[i - 1]; 
	} 


	static void updatecount(int[] count, char ch) 
	{ 
		int i; 
		for (i = ch; i < MAX_CHAR; ++i) 
			--count[i]; 
	} 

	static int findRank(char[] str) 
	{ 
		int len = str.length; 
		int mul = fact(len); 
		int rank = 1, i; 

		int count[] = new int[MAX_CHAR]; 
		
		populateAndIncreaseCount(count, str); 

		for (i = 0; i < len; ++i) { 
			mul /= len - i; 

			// count number of chars smaller than str[i] 
			// fron str[i+1] to str[len-1] 
			rank += count[str[i] - 1] * mul; 

			// Reduce count of characters greater than str[i] 
			updatecount(count, str[i]); 
		} 

		return rank; 
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			char str[] = "string".toCharArray(); 
			System.out.println(findRank(str)); 
		}

	}




