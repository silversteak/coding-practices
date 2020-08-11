package com.amazon.stacks;

import java.util.Stack;

public class BracketRequiredToBalance {


	/*
	 *  if c == '('\
	 *		if empty or top of stack == 2
	 *			push(2)
	 *		else
	 *			pop();
	 *			ans++;
	 *			push(2);
	 */

	public int minInsertions(String S) {
		
		if(S.length() == 0) {
			return -1;
		}

		int ans = 0;
		Stack<Integer> stk = new Stack<>();

		for(char ch : S.toCharArray()) {

			if(ch == '(') {
				if(stk.isEmpty() || stk.peek() == 2) {
					stk.push(2);
				}else {
					ans++;
					stk.pop();
					stk.push(2);
				}

			}else {
				if(stk.isEmpty()) {
					stk.push(1);
					ans++;
				}else if(stk.peek() == 1)
					stk.pop();
				else if(stk.peek() == 2) {
					stk.pop();
					stk.push(1);
				}

			}
		}

		while(!stk.isEmpty()) {
			ans += stk.pop();
		}

		return ans;

	}

}
