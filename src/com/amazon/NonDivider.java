package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonDivider {
	
	public static int nonDivisibleSubset(int k, List<Integer> s) {
	    // Write your code here
	        int freq[] = new int[k];
	        Arrays.fill(freq,0);
	        for(int i = 0; i < s.size(); i++){
	            freq[s.get(i)%k]++;
	        }

	        int res = 0;

	        //Case 1: 1 element max from modulo zero 
	        res = Math.min(freq[0],1);

	        //Case 2: for k/2 ele.... so 2 k/2 mod makes one k ele
	        if(k%2==0 && freq[k/2] > 0)
	        	freq[k/2] =  Math.min(1, freq[k/2]);

	        for(int i = 1; i <= k/2; i++){
	            res += Math.max(freq[i], freq[k-i]);
	        }    

	        return res;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(7);
		list.add(2);
		list.add(4);
		
		nonDivisibleSubset(3, list);

	}

}
