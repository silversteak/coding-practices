package com.amazon.hashing;

public class MinWindowSubstring {
	 public String minWindow(String s2, String s1) {
	        
	        if(s1 == null || s2 == null)
	            return "";
	        
	        int hash[] = new int[256];
	        
	        for(char ch : s1.toCharArray())
	            hash[ch]++;
	        
	        int left = 0, right = 0, count = 0;
	        
	        int head = 0;
	        
	        int len = Integer.MAX_VALUE;
	        
	        while(right < s2.length()){
	            
	            if(hash[s2.charAt(right)] > 0){
	                count++;
	            }
	            
	            hash[s2.charAt(right)]--;
	            right++;
	            
	            while(count == s1.length()){
	                
	                if(hash[s2.charAt(left)] >= 0)
	                    count--;
	                
	                hash[s2.charAt(left)]++;
	                
	                if(right - left < len){
	                    len = right - left;
	                    head = left;
	                    
	                }
	                
	                left++;
	            }
	        } 
	            
	        if(len == Integer.MAX_VALUE) 
	            return "";
	        return s2.substring(head, head+len);
	         
	    }
}
