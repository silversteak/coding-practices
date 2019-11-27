package com.geeksforgeeks;

import java.util.Stack;

public class RARRANGEALTERNATE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Stack<Character> stk = new Stack<>();
		 stk.push('a');
		 stk.push('b');
		 stk.push('g');
		 
		 String str = String.valueOf(stk).toString();
		 System.out.println(str);
		 
		 StringBuffer str1 = new StringBuffer("");
	        
	        while(!stk.isEmpty()){
	            str1.append(stk.peek()+" ");
	            stk.pop();
	        }
	        
	        System.out.println(str1);
		 
	}

}
