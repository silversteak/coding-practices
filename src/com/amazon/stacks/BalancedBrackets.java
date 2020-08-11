package com.amazon.stacks;

import java.util.Stack;

public class BalancedBrackets {

	public int minAddToMakeValid(String S) {
		int left = 0, right = 0;
		for (int i = 0; i < S.length(); ++i) {
			if (S.charAt(i) == '(') {
				right++;
			} else if (right > 0) {
				right--;
			} else {
				left++;
			}
		}
		return left + right;
	}


	public int minAddToMakeValidUsingStack(String S) {


		if(S == null || S.length() == 0)
			return 0;

		Stack<Character> stk = new Stack<>();

		for(char ch : S.toCharArray()){
			if(!stk.isEmpty() && ch == ')' && stk.peek() == '('){
				stk.pop();
			}else
				stk.add(ch);
		}

		return stk.size();
	}

}
