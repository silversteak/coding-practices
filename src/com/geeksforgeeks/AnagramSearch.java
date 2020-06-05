package com.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class AnagramSearch {
	
	
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if(s == null || s.length() == 0)
            return result;
        
        int hash[] = new int[26];
        
        for(char ch : p.toCharArray()){
            hash[ch - 'a']++;
        }
        
        int left = 0, right = 0, n = s.length();
        int count = 0;
        while(right < n){
            
            if(hash[s.charAt(right)-'a']-- > 0){
            	//hash[s.charAt(right)-'a']--;
            	count++;
            }

            right++;
            
            if(count == p.length()){
                result.add(left);
            }
            
            if(right - left == p.length()){
            	if(hash[s.charAt(left)-'a']++ >= 0) {
            		count--;            		
            	}
            	else {
            		System.out.println(hash[s.charAt(left)-'a']);
            	}
                left++;
            }    
            
        }
        
        return result;
        
    }
	
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
			//System.out.println(findRank(str)); 
			
			List<Integer> list = findAnagrams("cbaebabacd", "abc");
			
			for(Integer el : list)
				System.out.println(el);
			
			
		}

	}




