package com.amazon;

import java.util.LinkedList;
import java.util.List;

public class StringMultiplication {

	public static String multiply(String nums1, String nums2) {
		int n1 = nums1.length(), n2 = nums2.length();
		
		int product[] = new int[n1+n2];
		
		for(int i = n2-1; i >= 0; i--) {
			for(int j = n1 - 1; j >=0; j--) {
				int a = nums2.charAt(i) - '0';
				int b = nums1.charAt(j) - '0';
				int mul = a * b;
				product[i+j+1]+=mul;
			}
		}
		
		int carry = 0;
		for(int i = n1+n2-1; i>=0; i--) {
			int sum = (carry + product[i]);
			carry = sum/10;
			product[i] = sum%10;
		}
		
		StringBuilder br = new StringBuilder();
		
		for(int a : product) {
			br.append(a);
		}
		
		while(br.length() != 0 && br.charAt(0) == '0')
			br.deleteCharAt(0);
		
		return br.length() == 0 ? "0" : br.toString();
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("9","99"));
		
		
		LinkedList<Integer> list = new LinkedList<>();
		
	}

}
