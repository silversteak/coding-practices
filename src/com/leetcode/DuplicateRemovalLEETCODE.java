package com.leetcode;

import java.util.Stack;

import com.freecodecamp.Pair;

public class DuplicateRemovalLEETCODE {

	public static void main(String[] args) {
		
		Stack<Pair> stk = new Stack<>();
		
		String input = "deeedbbcccbdaa";
		int k = 3;
		for(char ch : input.toCharArray()) {
			if(!stk.isEmpty()) {
				if(!stk.peek().ch.equals(ch)) {
					stk.push(new Pair(ch,1));
				}
				else { 
					int count = stk.pop().count + 1;
					if(count != k)
						stk.push(new Pair(ch,count));
				}
			}else {
				stk.push(new Pair(ch,1));
			}
			
		
		}
		
		StringBuilder stringBuilder = new StringBuilder();
        while (!stk.isEmpty()) {
                stringBuilder.append(stk.pop().ch);
            }
        
        System.out.println(String.valueOf(stringBuilder.reverse()));
        
        }
	
		
	}


