package com.hackerEarth;

import java.util.Scanner;

public class THE_GREAT_KIAN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long arr[] = new long[3];
		for(int i = 0; i < t; i++) {
			arr[i%3] += sc.nextLong();
		}
			
		System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
		
	}

}
