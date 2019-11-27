package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
	
	public static int[] nextGreaterElement(int [] nums) {
        
		int len = nums.length;
		
		int arr[] = new int[len];
        
        Arrays.fill(arr, -1);
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < len; i++) {
        	while(!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
        		arr[stk.pop()] = nums[i];
        	}
        	stk.push(i);
        }
        
        return arr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr [] = {-1, 2,-1, 3, -6, 7};
		
		int fff [] = nextGreaterElement(arr);
		
		for(int a :fff) {
			System.out.print(a + " ");
		}
	
		
		
	}

}
