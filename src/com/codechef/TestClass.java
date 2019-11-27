package com.codechef;

import java.util.Arrays;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;	
		int arr[] = new int [n+1];
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 2;
		int temp ;
		for(int i = 4 ; i <=n; i++) {
			temp=0;
			for(int j = 1; j < i; j++) {
				System.out.println(arr[j] + " " + temp + " ");
				temp = temp ^ arr[j];
			}
			System.out.println();
			System.out.println(i + "->>>>>>" + temp);
			arr[i] = temp;
		}
		
		System.out.println(Arrays.asList(arr));
		
		}
		

	}


