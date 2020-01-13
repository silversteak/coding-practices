package com.leetcode;

public class StringMatchingAlgo {
	
	public static final int[] primes= {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103}; 
	
	public static String shortestCompletingWord(String licensePlate, String[] words) {
		int licenseHash[] = new int[26];
		int countLicense = 0;
		String res = null;
		for(char ch : licensePlate.toLowerCase().toCharArray()) {
			
			if(ch >= 'a' && ch <= 'z') {
				licenseHash[ch - 'a']++;
				countLicense++;			
			}
			
		}
		
		for(String eachWord : words) {
			int hashClone[] = licenseHash.clone();
			int wordCount = countLicense;
			for(char ch : eachWord.toLowerCase().toCharArray()) {	
				if(ch >= 'a' && ch <= 'z') {
					if(hashClone[ch - 'a']-- > 0)
						wordCount--;
					if(wordCount == 0) {
						if(res == null || res.length() > eachWord.length())
							res = eachWord;
					}						
				}
				
		}
	}	
		return res;
	}
	
	public static String shortestWord(String licensePlate, String[] words) {
		 long charProduct = getCharProduct(licensePlate.toLowerCase());
	        String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
	        for(String word : words)
	            if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
	                    shortest = word;
	        return shortest;
	}
	
	private static long getCharProduct(String plate) {
        long product = 1L;
        for(char c : plate.toCharArray()) {
            int index = c - 'a';
            if (0 <= index && index <= 25) 
                product *= primes[index];
        }
        return product;
    }
	
	

	public static void main(String[] args) {

	}

}
