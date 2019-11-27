package com.codechef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Chhappy {

	private static Scanner sc;

	public static void main(String[] args) {
		try {
			sc = new Scanner(System.in);
			int t = sc.nextInt();
			while(t-- > 0) {
				int n = sc.nextInt();
				boolean flag = false;
				int arr[] = new int[n];
				Map<Integer, HashSet<Integer>> mymap = new HashMap<Integer, HashSet<Integer>>();
				for(int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
					--arr[i];
				}
				
				for(int i = 0; i < n;i++) {
					if(!mymap.containsKey(arr[arr[i]])) {
						HashSet<Integer> mySet = new HashSet<Integer>();
						mySet.add(arr[i]);
						mymap.put(arr[arr[i]], mySet);
					}else {
						mymap.get(arr[arr[i]]).add(arr[i]);
						if(mymap.get(arr[arr[i]]).size() >= 2)
								flag = true;
						
					}
				}
				
					if(flag) 
						System.out.println("Truly Chef");
					else
						System.out.println("Poor Chef");
				
			}

		}
		catch(Exception e) {}		
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

	}

}
