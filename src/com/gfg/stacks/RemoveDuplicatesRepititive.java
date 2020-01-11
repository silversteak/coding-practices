package com.gfg.stacks;

import java.util.Stack;

public class RemoveDuplicatesRepititive {


	public static String removeDuplicates(String S) {
		if(S.length() == 0)
			return new String("");
		
		int len = S.length() - 1, i = 0;
		Stack<Character> stk = new Stack<>();
		
		while(i <= len) {
			if(stk.empty()) {
				stk.add(S.charAt(i));
				i++;
				continue;
			}
			
			if(stk.peek() == S.charAt(i)) {
				stk.pop();
				i++;
				continue;
			}else {
				stk.add(S.charAt(i));
			}
			i++;
		}
		StringBuilder sb = new StringBuilder();
		while(!stk.isEmpty()) {
			sb.insert(0,stk.pop());
		}
		//sb.reverse()
		return new String(sb.reverse());
	}
	
	public static boolean removeBackspace(String S, String R) {
		
		return duplicate(S).equalsIgnoreCase(duplicate(R));
	}
	
	public static String duplicate(String S) {
		Stack<Character> stk = new Stack<>();
		for(char ch : S.toCharArray()) {
			if(!stk.isEmpty() && ch == '#')
				stk.pop();
			else
				stk.add(ch);
		}
		StringBuilder sb = new StringBuilder();
		while(!stk.isEmpty()) {
			sb.append(stk.pop());
		}
		
		return new String(sb.reverse());
	}

	public static void main(String[] args) {
		
		String s = "ab#ca";
		String k = "aca#a";
		
		System.out.println(removeDuplicates(s));
		
		System.out.println(removeBackspace(s,k));
		
	}

}
