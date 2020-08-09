package com.amazon.arrays;

import java.util.ArrayList;

public class MinMax {

	public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[]){
        ArrayList<Integer> ans = new ArrayList<>();
        if(sizeOfArray < 2){
            ans.add(-1);
            return ans;
        }
            
        int first, second;
        first = second = -1;
        
        for(int i = 0; i < sizeOfArray; i++){
            if(arr[i] > first){
                second = first;
                first = arr[i];
            }else if(arr[i] > second && arr[i] != first){
                second = arr[i];
            }
        }
        
        ans.add(first);
        ans.add(second);
        
        return ans;
        
    }
	
}
