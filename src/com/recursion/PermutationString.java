package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {

	public static List<String> ans = new ArrayList<>();
	
	public static void permute(String str, int left, int right) {
		if(left == right - 1) {
			ans.add(str);
		}else {
			
			for(int i = left; i < right; i++) {
				str = swap(str,i,left);
				permute(str, left+1, right);
				str = swap(str,i,left);
			}
			
		}
		
		
		
	}
	
	private static String swap(String str, int i, int left) {
				
		char[] strArray = str.toCharArray();
		char temp = strArray[i];
		strArray[i] = strArray[left];
		strArray[left] = temp;
		
		return String.valueOf(strArray);
			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test = "ABCD";
		permute(test, 0, test.length());
		
		for(String el : ans)
			System.out.println(el);
		
	}

}
