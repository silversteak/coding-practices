package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class SUNPRNJL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int t;
			Scanner sc = new Scanner(System.in);
			t = sc.nextInt();
			while(t-- > 0) {
				int n = sc.nextInt();
				int k = sc.nextInt();
				int arr[] = new int[n];
				for(int i = 0;i < n; i++)
					arr[i] = sc.nextInt();
				
				for(int i =  0; i < n; i++ ) {
					HashMap<Integer , Integer> myMap = new HashMap<>();
					int s = 1;
					for(int j = i; j < n; j++ , s++ ) {
						myMap.put(arr[j], 1);
						int m = (int) Math.ceil(k/s);
						int offset = (m*s-k)/m;
						int F = calculate_F(myMap, s, offset);
					}
					
				}
					
			}
		}
		catch(Exception e) {}


	}

	private static int calculate_F(HashMap<Integer, Integer> myMap, int s, int offset) {
		
		
		// TODO Auto-generated method stub
		return 0;
	}

}
