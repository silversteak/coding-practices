package com.codechef;

import java.util.Scanner;

public class Carptun {
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while(t>0) {
				int n = sc.nextInt(), i, j, c;
				long arr[] = new long[n];
				for(i = 0;i < n; i++)
					arr[i] = sc.nextLong();
				long d, s, output = 0;
				c = sc.nextInt();
				s = sc.nextLong();
				d = sc.nextLong();
				long dp[][] = new long[c+1][n+1];
				for(i = 1; i <= n; i++) {
					for(j = 1; j <= c; j++) {
						dp[i][j] = Math.max(dp[i][j-1] + d/s, dp[i-1][j])+arr[j-1]; 
					}
				}
				System.out.println((c-1)*dp[2][n]-dp[1][n]);
				System.out.println(output);
				
				t--;
			}

		}
		catch(Exception e) {}		
		// TODO Auto-generated method stub

	}

}
