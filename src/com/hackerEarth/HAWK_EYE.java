package com.hackerEarth;

import java.util.Scanner;

public class HAWK_EYE {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int n = sc.nextInt();

		int x = sc.nextInt();
		int y = sc.nextInt();
		int p = sc.nextInt();

		long arr [][] = new long[n][n]; 

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int tb = Math.abs((i-x));
				int lr = Math.abs(j-y);

				int max = Math.max(tb, lr);

				if((p - max) < 0)
					//arr[i][j] = 0;
					System.out.print(0 + " ");
				else
					//arr[i][j] = p-max;				
					System.out.print(p-max + " ");
			}
			System.out.println();
		}

	/*	for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}*/

	}

}