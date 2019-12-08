package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class TemperatureChangeLeetCode {

	public static int[] dailyTemperatures(int[] T) {

		if(T == null || T.length == 1)
			return T;

		int arr[] = new int[T.length];

		Arrays.fill(arr, 0);
		Stack<Integer> stk = new Stack<>();

		for(int i = 0; i < T.length; i++) {
			while(!stk.isEmpty() && T[stk.peek()] < T[i]) {
				int index = stk.pop(); 
				arr[index] = Math.abs(index - i + 1);
			}
			stk.push(i);
		}

		return arr;
	}

	public static String minRemoveToMakeValid(String s) {

		if(s == null || s.length() == 0)
			return s;

		char ch[] = s.toCharArray();

		int len = ch.length;

		int count = 0;

		for(int i = 0; i < len; i++){
			if(ch[i] == '('){
				count++;
			}else if(ch[i] == ')'){
				if(count == 0)
					ch[i] = '#';
				else{
					count--;
				}   
			}
		}

		for(int i = len - 1; i>=0; i--){
			if(ch[i] == '(' && count > 0) {
				ch[i] = '#';
				count--;				
			}
		}



		return new String(ch).replace("#", "");


	}

	public static String reverseWords(String s) {

		if(s == null || s.length() == 0)
			return " ";
		
		s = " " + s; 
		
		char ch[] = s.toCharArray();
		int len = ch.length;
		char result[] = new char[len];
		int index = 0;
		for(int i = len - 1; i >=0; i--){
			if(ch[i] == ' '){
				for(int j = i + 1; j < len  && ch[j] != ' '; j++)
					result[index++] = ch[j];
				result[index++] = ' ';
			}
		}

		return new String(result).trim();

	}

	public static void main(String[] args) {
	
		String str = "a good   example";


		System.out.println(reverseWords(str));



	}

}
