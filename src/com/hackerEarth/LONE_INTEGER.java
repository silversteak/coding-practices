package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LONE_INTEGER {

	static class FastReader{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader(){ 
			br = new BufferedReader(new InputStreamReader(System.in)); 
		} 

		String next() { 
			while (st == null || !st.hasMoreElements()){ 
				try{ 
					st = new StringTokenizer(br.readLine()); 
				}catch (IOException  e){ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() { 
			return Integer.parseInt(next()); 
		} 

		long nextLong(){ 
			return Long.parseLong(next()); 
		} 

		double nextDouble(){ 
			return Double.parseDouble(next()); 
		} 

		String nextLine(){ 
			String str = ""; 
			try{ 
				str = br.readLine(); 
			} 
			catch (IOException e) { 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 

	public static void main(String[] args) {

		FastReader in = new FastReader();
        int t = in.nextInt();

		while(t-- > 0) {
			long ans = 0;
			int n = in.nextInt();
			for(int i = 0; i < n; i++ ) {
				long temp = in.nextLong();
				ans = ans ^ temp;
			}

			if(ans > 0)
				System.out.println(ans);
			else
				System.out.println(-1);


		}

	}

}
