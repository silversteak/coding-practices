package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class DeputyChef {

	public static void main(String[] args) {
		int t;
		try {
		Scanner sc  = new Scanner(System.in);
		t = sc.nextInt();
		while(t > 0){
			int n, i, left = 0, right = 0;
			n = sc.nextInt();//Integer.parseInt(inp.readLine());
			int a[] = new int[n];//{1,1,4,1};
			int d[] = new int[n];//{3,4,2,1};
			for(i = 0; i < n;i++)
				a[i] = sc.nextInt();//(int)inp.read();
			
			for(i = 0; i < n;i++)
				d[i] = sc.nextInt();//(int)inp.read();
			int maxDef = -1;
			for(i = 0; i < n; i++) {
				left = (n+i-1)%n;
				right = (i+1)%n;
				if(d[i] <= a[left] || d[i] <= a[right] || d[i] <= (a[left] + a[right])) {
					d[i] = -1;
					//maxDef = Math.max(maxDef,d[i]);
				}else {
					maxDef = Math.max(maxDef,d[i]);
				}
				
				
			}
			
			System.out.println(maxDef);
			
		t--;
		}
		}
		catch(Exception e) {
			
		}

	}

}
