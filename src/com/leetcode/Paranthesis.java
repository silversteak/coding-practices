package com.leetcode;

import java.util.Stack;

public class Paranthesis {

	public static String minRemoveToMakeValid(String s) {
		
		Stack<Integer> stk = new Stack<>();
		StringBuilder sb = new StringBuilder(s);
		int i = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == ')') {
				if (ch == '(') {
					stk.push(i);
				} else if (ch == ')') {
					if (!stk.isEmpty() && sb.charAt(stk.peek()) == '(') {
						stk.pop();
					}else {
						stk.push(i);
					}
				}
			}
			i++;
		}
		
		while(!stk.isEmpty()) {
			sb.deleteCharAt(stk.pop());
		}
		
		return String.valueOf(sb);
	}
	
	public static void main(String[] args) {
		
		String  s = "lee(t(c)o)de)";
		
		System.out.println(minRemoveToMakeValid(s));

	}

}
