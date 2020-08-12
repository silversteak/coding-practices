package com.amazon.searching;

import java.util.ArrayList;
import java.util.List;

public class TwoMajorityElement {

	public List<Integer> majorityElement(int[] nums) {
	       
        List<Integer> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return res;
        
        int n = nums.length;
        
        if(n == 1){
            res.add(nums[0]);
            return res;    
        }
        
        int el1 = nums[0], el2 = nums[1], c1 = 0, c2 = 0;
        
        for(int i = 2; i < n; i++){
            if(el1 == nums[i])
                c1++;
            else if(el2 == nums[i])
                c2++;
            else if(c1 == 0){
                el1 = nums[i];
                c1 = 1;
            }else if(c2 == 0){
                el2 = nums[i];
                c2 = 1;
            }else{
                c1--;
                c2--;
            }    
        }
        
        c1 = 0; 
        c2 = 0;
        for(int i = 0; i < n; i++){
            if(el1 == nums[i]) c1++;
            else if(el2 == nums[i]) c2++;
        }
        
        
        
        if(c1 > n/3) res.add(el1);
        if(c2 > n/3) res.add(el2);
        
        return res;
    }
	
}
