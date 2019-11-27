package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Deadlock {

	public static void main(String[] args) {
		int t;
		try {
			Scanner sc  = new Scanner(System.in);
			t = sc.nextInt();
			while(t > 0){
				int n, temp = 0, sum = 0;
				n = sc.nextInt();
				
				for(int i = 0; i < n; i++) {
					temp = sc.nextInt();
					sum = sum + temp - 1;
				}
				
				sum = sum + 1;
				
				System.out.println(sum);
			t--;
			}
	}
	catch(Exception e) {

	}

}
}
