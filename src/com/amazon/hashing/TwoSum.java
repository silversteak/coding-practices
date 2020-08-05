package com.amazon.hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	// A[] : the input array of positive integers
    // N : size of the array arr[]
    // X : the required sum
    public boolean keypair(int[] A, int N, int X)
    {
        Map<Integer, Integer> hash = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            
            if(hash.containsKey(X-A[i])){
                return true;
            }else{
                hash.put(A[i], i);
            }
            
        }
        return false;
    }
	
}
