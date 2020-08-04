package com.amazon.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public List<String> result = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		if(n == 0)
			return result;
		generateParenthesis("", n, n);

		return result;
	}

	public void generateParenthesis(String pattern, int left, int right){

		if(left > right)
			return;

		if(left == 0 && right == 0){
			result.add(pattern);
			return;
		}


		if(left > 0){
			generateParenthesis(pattern + "(", left - 1, right);
		}

		if(right > 0){
			generateParenthesis(pattern + ")", left , right - 1);
		}

	}
}
