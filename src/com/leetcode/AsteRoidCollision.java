package com.leetcode;

import java.util.Stack;

public class AsteRoidCollision {
	
	// 3 2 1 -1 -2 3
	
	// 1 -1 2 -2 3 -3
	
	public static int[] asteroidCollision(int[] asteroids) {
		
		if(asteroids ==  null || asteroids.length == 1)
			return asteroids;
		
		int len = asteroids.length;
		
		Stack <Integer> stk = new Stack<>();
		
		for(int i = 0; i < len ; i++) {
			int curr = asteroids[i];
			if(stk.empty())
				stk.add(curr);
			else {
				if((stk.peek() > 0 && curr > 0) || stk.peek() < 0)
					stk.add(curr);
				else if (stk.peek() > 0 && curr < 0) {
					if(stk.peek() == Math.abs(curr))
						stk.pop();
					else if(stk.peek() > Math.abs(curr)) {
						// eat the current Value
					}else if (stk.peek() < Math.abs(curr)) {
						stk.pop();
						i--;
					}
				}	
				else if (stk.peek() < 0 && curr > 0) {
					stk.add(curr);
				}
						
				}
			}
		
		int[] res = new int[stk.size()];
        for(int i = stk.size() - 1; i >= 0; i--) res[i] = stk.pop();
        return res;
			
	}	
			
			/*if(asteroids[i] > 0) {
				stk.push(asteroids[i]);
			}else if (asteroids[i] < 0 && !stk.isEmpty()) {
				if(stk.peek() == Math.abs(asteroids[i])) {
					stk.pop();
					i++;
				}else if(stk.peek() > Math.abs(asteroids[i])) {
					i++;
				}else if(stk.peek() < Math.abs(asteroids[i])) {
					stk.pop();
				}
			}
*/		
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {3, 1, -2, -3};
		
		asteroidCollision(arr);
		

	}

}
