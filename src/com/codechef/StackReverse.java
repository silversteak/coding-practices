package com.codechef;

import java.util.Stack;

public class StackReverse {
	
	public static void reverse(String str) {
		char [] ch = str.toCharArray();
		Stack <Character> stk = new Stack<Character>();
		for(int i = 0; i < ch.length; i++) {
			if(ch[i]!=' ')
				stk.push(ch[i]);
			else {
				while(!stk.isEmpty()) {
					System.out.print(stk.pop());
				}
				System.out.print(" ");
			}
		}		
		
	}
	
	public static void main(String[] args) {
		
		String temp= "Hello Darkness my world friend";
		
		reverse(temp);
		
		// TODO Auto-generated method stub

	}

}
